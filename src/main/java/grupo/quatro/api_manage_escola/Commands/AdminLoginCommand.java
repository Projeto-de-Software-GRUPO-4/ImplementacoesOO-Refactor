package grupo.quatro.api_manage_escola.Commands;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Respond.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AdminLoginCommand implements LoginCommand {


    public AdminLoginCommand() {};


    @Override
    public ResponseEntity execute(DadosLogin dados) {
        Message message = new Message();
        message.setMessage("Admin " + dados.id() + " logado com sucesso.");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
