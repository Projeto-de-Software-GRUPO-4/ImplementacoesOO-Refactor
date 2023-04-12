package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAlunoLogin;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
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
@RequestMapping("/login/aluno")
public class LogInAlunoController extends LogInController {

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    public DadosListagemAlunoLogin login(@Valid @RequestBody DadosLogin dados) {
        Optional<UsuarioCredentials> credentialsOptional = credentialsRepository.findById(dados.id());

        DadosListagemAlunoLogin returnObj = null;

        if (credentialsOptional.isPresent()) {
            UsuarioCredentials credentials = credentialsOptional.get();

            if (credentials.getSenha().equals(dados.senha())) {
                Aluno aluno = alunoRepository.findById(new BigInteger(credentials.getId())).orElse(null);
                returnObj = new DadosListagemAlunoLogin(aluno);
            }

        }

        return returnObj;

    }
}
