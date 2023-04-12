package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosListagemProfessorLogin;
import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
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
    public DadosListagemProfessorLogin login(@Valid @RequestBody DadosLogin dados) {
        Optional<UsuarioCredentials> credentialsOptional = credentialsRepository.findById(dados.id());

        DadosListagemProfessorLogin returnObj = null;

        if (credentialsOptional.isPresent()) {

            UsuarioCredentials credentials = credentialsOptional.get();

            if (credentials.getSenha().equals(dados.senha())) {
                Professor professor = professorRepository.findById(new BigInteger(dados.id())).orElse(null);
                returnObj = new DadosListagemProfessorLogin(professor);
            }

        }

        return returnObj;

    }
}
