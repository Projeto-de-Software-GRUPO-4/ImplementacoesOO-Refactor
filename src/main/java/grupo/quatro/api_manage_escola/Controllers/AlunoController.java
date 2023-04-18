package grupo.quatro.api_manage_escola.Controllers;


import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosLinkarAlunoTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosLinkarUsuarioTurma;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Repository.TurmaRepository;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import grupo.quatro.api_manage_escola.Service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    @Transactional
    void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        alunoService.salvar(dados);
    }

    @GetMapping("/{id}")
    public DadosListagemAluno resgatarAluno(@PathVariable BigInteger id) {
        return (DadosListagemAluno) alunoService.resgatar(id);
    }

    @GetMapping("/all")
    public List<DadosListagemAluno> resgatarTodosAlunos() {
        return alunoService.resgatarTodos();
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        alunoService.atualizar(dados);
    }

    @PutMapping("/{id}/status_suspensao")
    @Transactional
    public void suspender_desuspender(@PathVariable BigInteger id) {
        alunoService.suspender(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        alunoService.deletar(id);
    }

    @PutMapping("/matricular_a_turma")
    @Transactional
    void matricularATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        alunoService.linkarATurma(dados);
    }

    @PutMapping("/desmatricular_a_turma")
    @Transactional
    void desmatricularATurma(@RequestBody @Valid DadosLinkarUsuarioTurma dados) {
        alunoService.deslinkarATurma(dados);
    }
}
