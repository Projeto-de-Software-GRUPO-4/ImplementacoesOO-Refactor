package grupo.quatro.api_manage_escola.controller;

import java.util.List;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.UsuarioCredentials.DadosCadastroUsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<DadosListagemAluno> listar() {
        return alunoRepository.findAll().stream().map(DadosListagemAluno::new).toList();
    }
}
