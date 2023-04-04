package grupo.quatro.api_manage_escola.controller;


import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    UsuarioCredentialsRepository usuarioCredentialsRepository;

    @PostMapping
    @Transactional
    void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        Aluno aluno = alunoRepository.save(new Aluno(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(aluno.getId().toString(), dados.senha(), dados.userType()));

    }
}
