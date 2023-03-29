package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.Professor;
import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.grupo4.implementacoesoo.Domain.Turma;
import org.grupo4.implementacoesoo.Repository.AlunoRepository;
import org.grupo4.implementacoesoo.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class AtualizarUsuarioFacade {
    public ResponseMessage atualizarProfessor(AdicionarProfessorDTO adicionarProfessorDTO) {

        ResponseMessage responseMessage = new ResponseMessage();


        Professor professor = new Professor();
        professor.setNome(adicionarProfessorDTO.getNome());
        professor.setCpf(adicionarProfessorDTO.getCpf());
        professor.setCargaHoraria(adicionarProfessorDTO.getCargaHoraria());
        professor.setSalarioHora(adicionarProfessorDTO.getSalarioHora());
        professor.setPayDay(adicionarProfessorDTO.getPayDay());
        professor.setDataNasc(adicionarProfessorDTO.getDataNasc());

        ProfessorRepository professorRepository = new ProfessorRepository();
        professorRepository.saveInfo(professor);
        boolean results = professorRepository.saveCredentials(adicionarProfessorDTO);

        if (results == true) {
            responseMessage.setCode(200);
            responseMessage.setMessage("Professor atualizado com sucesso");
        } else {
            responseMessage.setCode(400);
            responseMessage.setMessage("Não foi possível atualizar o usuário professor");
        }

        return responseMessage;
    }

    public ResponseMessage atualizarAluno(AdicionarAlunoDTO adicionarAlunoDTO) {

        ResponseMessage responseMessage = new ResponseMessage();


        Aluno aluno = new Aluno();

        aluno.setNome(adicionarAlunoDTO.getNome());
        aluno.setMensalidade(adicionarAlunoDTO.getMensalidade());
        aluno.setSerie(adicionarAlunoDTO.getSerie());
        aluno.setTurno(adicionarAlunoDTO.getTurno());
        aluno.setCpf(adicionarAlunoDTO.getCpf());
        aluno.setDataNasc(adicionarAlunoDTO.getDataNasc());
        aluno.setPayDay(adicionarAlunoDTO.getPayDay());

        AlunoRepository alunoRepository = new AlunoRepository();
        boolean results = alunoRepository.saveInfo(aluno);

        if (results) {
            responseMessage.setCode(200);
            responseMessage.setMessage("Aluno atualizado com sucesso");
        } else {
            responseMessage.setCode(400);
            responseMessage.setMessage("Não foi possível atualizar o usuário aluno");
        }

        return responseMessage;
    }
}
