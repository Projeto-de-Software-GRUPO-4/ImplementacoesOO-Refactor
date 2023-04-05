package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import grupo.quatro.api_manage_escola.LogIn.Login;
import grupo.quatro.api_manage_escola.Professor.Professor;
import grupo.quatro.api_manage_escola.Professor.ProfessorRepository;
import grupo.quatro.api_manage_escola.UserType.UserType;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import grupo.quatro.api_manage_escola.Usuario.UsuarioRepository;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class LogInController <T> {

    @Autowired
    UsuarioCredentialsRepository credentialsRepository;

    @Autowired
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
