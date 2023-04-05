package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Turma.DadosCadastroTurma;
import grupo.quatro.api_manage_escola.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Turma.TurmaRepository;
import grupo.quatro.api_manage_escola.UsuarioCredentials.UsuarioCredentials;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaRepository turmaRepository;

    @PostMapping
    @Transactional
    void cadastrar(@RequestBody @Valid DadosCadastroTurma dados) {
        Turma turma = turmaRepository.save(new Turma(dados));
    }

    @GetMapping
    public List<DadosListagemTurma> listar() {
        return turmaRepository.findAll().stream().map(DadosListagemTurma::new).toList();
    }

//    @PostMapping("/adicionar_professor")
//    @Transactional
//    void alocarProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
//
//    }

}
