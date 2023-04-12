package grupo.quatro.api_manage_escola.Controllers;


import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosLinkarAlunoTurma;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

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
        Aluno aluno = (Aluno) alunoRepository.save(new Aluno(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(aluno.getId().toString(), dados.senha(), dados.userType()));

    }

    //TODO
//    @GetMapping
//    public List<DadosListagemAluno> listar() {
//        return alunoRepository.findAllByActiveTrue().stream().map(DadosListagemAluno::new).toList();
//    }

    @GetMapping("/{id}")
    public DadosListagemAluno listarSpecificAluno(@PathVariable BigInteger id) {
        return new DadosListagemAluno(alunoRepository.findById(id).orElse(null));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = (Aluno) alunoRepository.getReferenceById(dados.id());
        aluno.updateInfo(dados);
    }

    @PutMapping("/{id}/status_suspensao")
    @Transactional
    public void suspender_desuspender(@PathVariable BigInteger id) {
        Aluno aluno = (Aluno) alunoRepository.getReferenceById(id);
        aluno.suspender();
    }

//    @PostMapping("/registrar_ocorrencia")
//    @Transactional
//    public void registrarOcorrencia(DadosRegistrarOcorrencia dados) {
//        Aluno aluno = alunoRepository.getReferenceById(dados.id_aluno());
//        System.out.println(aluno.getNome());
//        aluno.getOcorrencias().add(new Ocorrencia(dados));
//        alunoRepository.save(aluno);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        Aluno aluno = (Aluno) alunoRepository.getReferenceById(id);
        aluno.excluir();
    }

    @PutMapping("/matricular_turma")
    @Transactional
    void matricular_turma(@RequestBody @Valid DadosLinkarAlunoTurma dados) {
        Aluno aluno = (Aluno) alunoRepository.getReferenceById(dados.id_aluno());
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        aluno.setTurma(turma);
    }
}
