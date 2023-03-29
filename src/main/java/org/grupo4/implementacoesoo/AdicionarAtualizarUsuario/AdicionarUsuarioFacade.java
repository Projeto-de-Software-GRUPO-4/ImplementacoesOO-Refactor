package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.Professor;
import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.grupo4.implementacoesoo.Domain.Turma;
import org.grupo4.implementacoesoo.Repository.AlunoRepository;
import org.grupo4.implementacoesoo.Repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdicionarUsuarioFacade {

    public ResponseMessage adicionarProfessor(AdicionarProfessorDTO adicionarProfessorDTO) {

        ResponseMessage responseMessage = new ResponseMessage();


        Professor professor = new Professor();
        professor.setNome(adicionarProfessorDTO.getNome());
        professor.setCpf(adicionarProfessorDTO.getCpf());
        professor.setCargaHoraria(adicionarProfessorDTO.getCargaHoraria());
        professor.setSalarioHora(adicionarProfessorDTO.getSalarioHora());
        professor.setPayDay(adicionarProfessorDTO.getPayDay());
        professor.addTurma(new Turma("000"));

        ProfessorRepository professorRepository = new ProfessorRepository();
        professorRepository.saveInfo(professor);
        boolean results = professorRepository.saveCredentials(adicionarProfessorDTO);

        if (results == true) {
            responseMessage.setCode(200);
            responseMessage.setMessage("Professor criado com sucesso");
        } else {
            responseMessage.setCode(400);
            responseMessage.setMessage("Não foi possível criar o usuário professor");
        }

        return responseMessage;
    }

    public ResponseMessage adicionarAluno(AdicionarAlunoDTO adicionarAlunoDTO) {

        ResponseMessage responseMessage = new ResponseMessage();


        Aluno aluno = new Aluno();

        aluno.setNome(adicionarAlunoDTO.getNome());
        aluno.setMensalidade(adicionarAlunoDTO.getMensalidade());
        aluno.setSerie(adicionarAlunoDTO.getSerie());
        aluno.setTurno(adicionarAlunoDTO.getTurno());
        aluno.setCpf(adicionarAlunoDTO.getCpf());
        aluno.setDataNasc(adicionarAlunoDTO.getDataNasc());
        aluno.setPayDay(adicionarAlunoDTO.getPayDay());
//        aluno.addResponsavel();

        AlunoRepository alunoRepository = new AlunoRepository();
        alunoRepository.saveInfo(aluno);

        boolean results = alunoRepository.saveCredentials(adicionarAlunoDTO);

        if (results) {
            responseMessage.setCode(200);
            responseMessage.setMessage("Aluno criado com sucesso");
        } else {
            responseMessage.setCode(400);
            responseMessage.setMessage("Não foi possível criar o usuário aluno");
        }

        return responseMessage;
    }


}
