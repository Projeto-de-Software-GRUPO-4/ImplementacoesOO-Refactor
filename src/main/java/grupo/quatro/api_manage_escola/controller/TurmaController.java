package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Professor.Professor;
import grupo.quatro.api_manage_escola.Professor.ProfessorRepository;
import grupo.quatro.api_manage_escola.Turma.*;
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

    @Autowired
    ProfessorRepository professorRepository;

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
    @PostMapping("/adicionar_professor")
    @Transactional
    void alocarProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
        Professor professor = professorRepository.findById(dados.id_professor()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().add(professor);
        turmaRepository.save(turma);
    }

    @DeleteMapping("/remover_professor")
    @Transactional
    void removerProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
        Professor professor = professorRepository.findById(dados.id_professor()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().remove(professor);
        turmaRepository.save(turma);

    }

}
