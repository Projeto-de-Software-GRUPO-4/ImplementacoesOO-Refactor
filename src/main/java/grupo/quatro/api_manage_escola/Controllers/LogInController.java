package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.Usuario.UsuarioRepository;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class LogInController <T> {

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;


    UsuarioRepository usuarioRepository;
    public abstract T login(@Valid @RequestBody DadosLogin dados);

//    @Autowired
//    ProfessorRepository professorRepository;

//    @Autowired
//    AlunoRepository alunoRepository;


//        Optional<UsuarioCredentials> credentialsObj = credentialsRepository.findById(dados.id());
//    @PostMapping("/login/aluno")
//    public Optional<Usuario> login(@Valid @RequestBody DadosLogin dados) {
//
//        Optional<UsuarioCredentials> credentialsObject = credentialsRepository.findById(dados.id());
//
//        Optional<Usuario> returnObject;
//
//        if (credentialsObject.isPresent()) {
//
//            UsuarioCredentials credentials = credentialsObject.get();
//
//            switch (credentials.getUserType()) {
//                case Professor -> returnObject = professorRepository.findById(dados.id()).stream().map(Usuario::new);
//            }
//
//        }
//
//        return alunoRepository.findById(dados.id());
////        if (credentials.isPresent()) {
////            return usuarioRepository.findById(dados.id());
////        }
//    }
}
