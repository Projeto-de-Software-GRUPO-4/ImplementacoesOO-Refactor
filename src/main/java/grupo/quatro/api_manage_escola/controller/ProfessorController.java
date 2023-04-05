package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Professor.*;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private UsuarioCredentialsRepository usuarioCredentialsRepository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroProfessor dados) {
        Professor professor = professorRepository.save(new Professor(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(dados.cpf(), dados.senha(), dados.userType()));
    }

    @GetMapping
    public List<DadosListagemProfessor> listar() {
        return professorRepository.findAll().stream().map(DadosListagemProfessor::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        Professor professor = professorRepository.getReferenceById(dados.id());
        professor.updateInfo(dados);
    }

}
