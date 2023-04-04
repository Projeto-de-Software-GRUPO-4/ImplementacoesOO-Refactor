package grupo.quatro.api_manage_escola.controller;


import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.Aluno.DadosCadastroAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/aluno")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    void cadastrar(DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }
}
