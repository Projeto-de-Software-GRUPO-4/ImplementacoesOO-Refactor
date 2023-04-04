package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
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
@RequestMapping("/login/aluno")
public class LogInAlunoController extends LogInController {

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    public Optional<Aluno> login(@Valid @RequestBody DadosLogin dados) {
        Optional<UsuarioCredentials> credentialsOptional = credentialsRepository.findById(dados.id());

        Optional<Aluno> returnObj = Optional.empty();

        if (credentialsOptional.isPresent()) {
            UsuarioCredentials credentials = credentialsOptional.get();

            if (credentials.getSenha().equals(dados.senha())) {
                returnObj = alunoRepository.findById(new BigInteger(credentials.getId()));
            }

        }

        return returnObj;

    }
}
