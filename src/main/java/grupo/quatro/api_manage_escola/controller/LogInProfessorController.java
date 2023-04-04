package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Professor.Professor;
import grupo.quatro.api_manage_escola.Professor.ProfessorRepository;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/login/professor")
public class LogInProfessorController extends LogInController {

    @Autowired
    ProfessorRepository professorRepository;

    @PostMapping
    public Optional<Professor> login(@Valid @RequestBody DadosLogin dados) {
        Optional<UsuarioCredentials> credentialsOptional = credentialsRepository.findById(dados.id());

        Optional<Professor> returnObj = Optional.empty();

        if (credentialsOptional.isPresent()) {

            UsuarioCredentials credentials = credentialsOptional.get();

            if (credentials.getSenha().equals(dados.senha())) {
                returnObj = professorRepository.findByCpf(dados.id());

            }

        }

        return returnObj;

    }
}
