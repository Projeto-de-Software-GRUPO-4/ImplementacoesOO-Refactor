package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Repository.UsuarioRepository;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class LogInController <T> {

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;


    UsuarioRepository usuarioRepository;
    public abstract T login(@Valid @RequestBody DadosLogin dados);

}
