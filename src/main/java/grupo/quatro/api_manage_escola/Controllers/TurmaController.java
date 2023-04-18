package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosCadastroTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosLinkarProfessorTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
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

    @GetMapping("/all")
    public List<DadosListagemTurma> listar() {
        return turmaRepository.findAll().stream().map(DadosListagemTurma::new).toList();
    }

    @GetMapping("/{anoEscolar}")
    public List<DadosListagemTurma> listarTurmasDeAnoEscolar(@PathVariable int anoEscolar) {
        return turmaRepository.findAllByAnoEscolar(anoEscolar).stream().map(DadosListagemTurma::new).toList();
    }
    @GetMapping
    public DadosListagemTurma listarTurmaEspecifica(@RequestBody @Valid DadosCadastroTurma dados) {
        return new DadosListagemTurma(turmaRepository.findByAnoEscolarAndLetra(dados.anoEscolar(), dados.letra()));
    }


    @PostMapping("/adicionar_professor")
    @Transactional
    void alocarProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
        Professor professor = (Professor) professorRepository.findById(dados.id_professor()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().add(professor);
        turmaRepository.save(turma);
    }

    @DeleteMapping("/remover_professor")
    @Transactional
    void removerProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
        Professor professor = (Professor) professorRepository.findById(dados.id_professor()).orElse(null);
        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
        turma.getProfessores().remove(professor);
        turmaRepository.save(turma);

    }

}
