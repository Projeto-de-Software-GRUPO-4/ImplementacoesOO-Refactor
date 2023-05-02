package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosDeslinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Respond.Professor.DadosListagemProfessor;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import grupo.quatro.api_manage_escola.Service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    @Autowired
    ProfessorService professorService;


    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroProfessor dados) {
        try {
            professorService.salvar(dados);
            Message message = new Message("Professor " + dados.getCpf()  + " cadastrado com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        try {
            return new ResponseEntity<>(professorService.atualizar(dados), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity resgatarProfessor(@PathVariable BigInteger id) {

        try {
            return new ResponseEntity<>(professorService.resgatar(id), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/all")
    public List<DadosListagemProfessor> resgatarTodosAlunos() {
        return professorService.resgatarTodos();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable BigInteger id) {
        try {
            professorService.deletar(id);
            Message message = new Message("Professor deletado com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/adicionar_a_turma")
    @Transactional
    public ResponseEntity linkarATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        try {
            professorService.linkarATurma(dados);
            Message message = new Message("Professor vinculado à turma com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remover_da_turma")
    public ResponseEntity deslinkarATurma(@RequestBody @Valid DadosDeslinkarUsuarioTurma dados) {

        try {
            professorService.deslinkarATurma(dados);
            Message message = new Message("Professor desvinculado da turma com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/minhas_turmas/{id}")
    public ResponseEntity resgatarTurmas(@PathVariable BigInteger id) {
        try {
            return new ResponseEntity<>(professorService.resgatarTurmasDoProfessor(id), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

    }


}