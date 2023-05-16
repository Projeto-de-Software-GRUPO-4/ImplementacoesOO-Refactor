package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosListagemProfessorLogin;
import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class LogInProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;

    public DadosListagemProfessorLogin login(DadosLogin dados) {

        Professor professor = professorRepository.getReferenceById(new BigInteger(dados.id()));

        return new DadosListagemProfessorLogin(professor);

    }
}
