package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Respond.Professor.DadosListagemProfessor;
import grupo.quatro.api_manage_escola.Service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cadastro(@RequestBody @Valid DadosCadastroProfessor dados) {
        professorService.salvar(dados);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        professorService.atualizar(dados);
    }

    @GetMapping("/{id}")
    public DadosListagemProfessor resgatarProfessor(@PathVariable BigInteger id) {
        return (DadosListagemProfessor) professorService.resgatar(id);
    }
    @GetMapping("/all")
    public List<DadosListagemProfessor> resgatarTodosAlunos() {
        return professorService.resgatarTodos();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        professorService.deletar(id);

    }

    @PostMapping("/adicionar_a_turma")
    @Transactional
    public void linkarATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        professorService.linkarATurma(dados);
    }

    @DeleteMapping("/remover_da_turma")
    void deslinkarATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        professorService.deslinkarATurma(dados);
    }


}