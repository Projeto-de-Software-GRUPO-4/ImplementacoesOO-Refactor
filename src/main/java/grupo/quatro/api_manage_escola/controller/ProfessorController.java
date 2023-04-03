package grupo.quatro.api_manage_escola.controller;

import grupo.quatro.api_manage_escola.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Professor.Professor;
import grupo.quatro.api_manage_escola.Professor.ProfessorRepository;
import grupo.quatro.api_manage_escola.Turma.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody DadosCadastroProfessor dados) {

//        Set<Turma> emptySet = new HashSet<Turma>();

        repository.save(new Professor(dados));

    }

}
