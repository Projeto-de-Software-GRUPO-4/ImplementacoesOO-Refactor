package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosCadastroTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosLinkarProfessorTurma;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    TurmaService turmaService;

    @PostMapping
    @Transactional
    ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTurma dados) {
        try {
            turmaService.salvar(dados);
            Message message = new Message("Turma " + dados.anoEscolar() + dados.letra() + " cadastrada com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/all")
    public List<DadosListagemTurma> listar() {
        return turmaService.listar();
    }

    @GetMapping("/{anoEscolar}")
    public List<DadosListagemTurma> listarTurmasDeAnoEscolar(@PathVariable int anoEscolar) {
        return turmaService.listarTurmasDeAnoEscolar(anoEscolar);
    }
    @PostMapping("/resgatar")
    public DadosListagemTurma listarTurmaEspecifica(@RequestBody @Valid DadosCadastroTurma dados) {
        return turmaService.listarTurmaEspecifica(dados);
    }


//    @PostMapping("/adicionar_professor")
//    @Transactional
//    void alocarProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
//        Professor professor = (Professor) professorRepository.findById(dados.id_professor()).orElse(null);
//        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
//        turma.getProfessores().add(professor);
//        turmaRepository.save(turma);
//    }
//
//    @DeleteMapping("/remover_professor")
//    @Transactional
//    void removerProfessor(@RequestBody @Valid DadosLinkarProfessorTurma dados) {
//        Professor professor = (Professor) professorRepository.findById(dados.id_professor()).orElse(null);
//        Turma turma = turmaRepository.findById(dados.id_turma()).orElse(null);
//        turma.getProfessores().remove(professor);
//        turmaRepository.save(turma);
//
//    }

}
