package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.UsuarioCredentials.DadosAtualizarUsuarioCredentials;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Service.UsuarioCredentialsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credentials")
public class UsuarioCredentialsController {

    @Autowired
    UsuarioCredentialsService credentialsService;

    @PutMapping("/me")
    @Transactional
    public ResponseEntity atualizarSenha(@RequestBody @Valid DadosAtualizarUsuarioCredentials dados) {
        try {
            UsuarioCredentials credentials = credentialsService.atualizar(dados);
            return new ResponseEntity<>(credentials, HttpStatus.OK);


        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }



}
