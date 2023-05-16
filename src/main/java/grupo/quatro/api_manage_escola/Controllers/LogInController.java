package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Commands.AdminLoginCommand;
import grupo.quatro.api_manage_escola.Commands.AlunoLoginCommand;
import grupo.quatro.api_manage_escola.Commands.LoginCommand;
import grupo.quatro.api_manage_escola.Commands.ProfessorLoginCommand;
import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
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
        if (credentialsOptional.isEmpty()) {
            message.setMessage("Usuário não encontrado.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            UsuarioCredentials usuario = credentialsOptional.get();

            if (!dados.senha().equals(usuario.getSenha())) {
                message.setMessage("Senha incorreta.");
                return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
            }

            UserType userType = usuario.getUserType();
            LoginCommand command;

            if (userType == UserType.Admin) {
                command = new AdminLoginCommand();
            } else if (userType == UserType.Professor) {
                command = new ProfessorLoginCommand(logInProfessorService);
            } else {
                command = new AlunoLoginCommand(logInAlunoService);
            }

            return command.execute(dados);


        }

    }
}
