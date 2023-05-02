package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosListagemAlunoLogin;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosListagemProfessorLogin;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosListagemUsuarioLogin;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Service.LogInAlunoService;
import grupo.quatro.api_manage_escola.Service.LogInProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;

    @Autowired
    LogInAlunoService logInAlunoService;

    @Autowired
    LogInProfessorService logInProfessorService;

//    Message message = new Message("Aluno desmatriculado da turma com sucesso.");
//            return new ResponseEntity<>(message, HttpStatus.OK);
//} catch (Exception e) {
//        Message message = new Message(e.getMessage());
//        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);



    @PostMapping
    public ResponseEntity login(@Valid @RequestBody DadosLogin dados) {

        Optional<UsuarioCredentials> credentialsOptional = credentialsRepository.findById(dados.id());

        Message message = new Message();
        if (!credentialsOptional.isPresent()) {
            message.setMessage("Usuário não encontrado.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            UsuarioCredentials usuario = credentialsOptional.get();

            if (!dados.senha().equals(usuario.getSenha())) {
                message.setMessage("Senha incorreta.");
                return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
            }

            UserType userType = usuario.getUserType();

            DadosListagemUsuarioLogin dadosLogin = new DadosListagemUsuarioLogin();

            if (userType == UserType.Admin) {
                dadosLogin.setUserType(UserType.Admin);
                message.setMessage("Admin " + dados.id() + " logado com sucesso.");
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else if (userType == UserType.Professor) {
                dadosLogin.setUserType(UserType.Professor);
                dadosLogin = logInProfessorService.login(dados);
            } else if (userType == UserType.Aluno) {
                dadosLogin.setUserType(UserType.Aluno);
                dadosLogin = logInAlunoService.login(dados);
            }

            return new ResponseEntity<>(dadosLogin, HttpStatus.OK);


        }

    }
}
