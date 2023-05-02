package grupo.quatro.api_manage_escola.Service;

import grupo.quatro.api_manage_escola.Domain.Usuario;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import grupo.quatro.api_manage_escola.Respond.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LogInAdminService {

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;

//    Message login(DadosLogin dados) {
//        Optional<UsuarioCredentials> usuarioCredentialsOptional = credentialsRepository.findById(dados.id());
//
//        if (usuarioCredentialsOptional.isPresent()) {
//            UsuarioCredentials usuarioCredentials = usuarioCredentialsOptional.get();
//            if
//        } else {
//
//        }
//
//        Message message;
//
//    }


}
