package grupo.quatro.api_manage_escola.Controllers;


import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        try {
            alunoService.salvar(dados);
            Message message = new Message("Aluno cadastrado" + dados.getCpf() + " com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity resgatarAluno(@PathVariable BigInteger id) {
        try {
            return new ResponseEntity<>(alunoService.resgatar(id), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/all")
    public List<DadosListagemAluno> resgatarTodosAlunos() {
        return alunoService.resgatarTodos();
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        try {
            return new ResponseEntity<>(alunoService.atualizar(dados), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/status_suspensao")
    @Transactional
    public ResponseEntity suspender_desuspender(@PathVariable BigInteger id) {
        try {
            alunoService.suspender(id);
            Message message = new Message("Status de suspensão do aluno " + id + " alterado com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        try {
            alunoService.deletar(id);
            Message message = new Message("Aluno deletado com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/matricular_a_turma")
    @Transactional
    ResponseEntity matricularATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        try {
            alunoService.linkarATurma(dados);
            Message message = new Message("Aluno matriculado à turma com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/desmatricular_a_turma")
    @Transactional
    ResponseEntity desmatricularATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        try {
            alunoService.deslinkarATurma(dados);
            Message message = new Message("Aluno desmatriculado da turma com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}
