package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAlunoLogin;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class LogInAlunoService {

    @Autowired
    AlunoRepository alunoRepository;


    public DadosListagemAlunoLogin login(DadosLogin dados) {
        Aluno aluno = alunoRepository.getReferenceById(new BigInteger(dados.id()));

        return new DadosListagemAlunoLogin(aluno);

    }
}
