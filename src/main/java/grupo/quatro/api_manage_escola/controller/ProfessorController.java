package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Professor.Professor;
import grupo.quatro.api_manage_escola.Professor.ProfessorRepository;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;
    @Autowired
    private UsuarioCredentialsRepository usuarioCredentialsRepository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroProfessor dados) {
        repository.save(new Professor(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(dados.cpf(), dados.senha(), dados.userType()));
    }

}
