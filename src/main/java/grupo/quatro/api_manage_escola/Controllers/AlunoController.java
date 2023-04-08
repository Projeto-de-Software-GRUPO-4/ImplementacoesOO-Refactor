package grupo.quatro.api_manage_escola.Controllers;


import grupo.quatro.api_manage_escola.Aluno.*;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Turma.TurmaRepository;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    UsuarioCredentialsRepository usuarioCredentialsRepository;

    @Autowired
    TurmaRepository turmaRepository;

    @PostMapping
    @Transactional
    void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        Aluno aluno = alunoRepository.save(new Aluno(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(aluno.getId().toString(), dados.senha(), dados.userType()));

    }
    
    @GetMapping
    public List<DadosListagemAluno> listar() {
        return alunoRepository.findAllByActiveTrue().stream().map(DadosListagemAluno::new).toList();
    }

    @GetMapping("/{id}")
    public DadosListagemAluno listarSpecificAluno(@PathVariable BigInteger id) {
        return new DadosListagemAluno(alunoRepository.findById(id).orElse(null));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id());
        aluno.updateInfo(dados);
    }

    @PutMapping("/{id}/status_suspensao")
    @Transactional
    public void suspender_desuspender(@PathVariable BigInteger id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.suspender();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        Aluno aluno = alunoRepository.getReferenceById(id);
        aluno.excluir();
    }

    @PutMapping("/matricular_turma")
    @Transactional
    void alocarProfessor(@RequestBody @Valid DadosLinkarAlunoTurma dados) {
        Aluno aluno = alunoRepository.getReferenceById(dados.id_aluno());
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        aluno.setTurma(turma);
    }
}
