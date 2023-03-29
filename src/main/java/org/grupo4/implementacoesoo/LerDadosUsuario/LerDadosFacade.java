package org.grupo4.implementacoesoo.LerDadosUsuario;

import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.Professor;
import org.grupo4.implementacoesoo.Repository.AlunoRepository;
import org.grupo4.implementacoesoo.Repository.ProfessorRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class LerDadosFacade {

    public JSONObject lerDadosAluno(LerDadosDTO lerDadosDTO) {
        AlunoRepository alunoRepository = new AlunoRepository();

        Aluno aluno = alunoRepository.getInfo(lerDadosDTO.getId());

        return aluno.toJSON();
    }

    public JSONObject lerDadosProfessor(LerDadosDTO lerDadosDTO) {
        ProfessorRepository professorRepository = new ProfessorRepository();

        Professor professor = professorRepository.getInfo(lerDadosDTO.getId());

        return professor.toJSON();
    }



}
