package org.grupo4.implementacoesoo.SuspenderAluno;

import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.grupo4.implementacoesoo.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class SuspenderAlunoFacade {

    public ResponseMessage suspenderAluno(SuspenderAlunoDTO suspenderAlunoDTO) {

        AlunoRepository alunoRepository = new AlunoRepository();
        System.out.println(suspenderAlunoDTO.getId());

        Aluno aluno = alunoRepository.getInfo(suspenderAlunoDTO.getId());
//        aluno.setNome(adicionarAlunoDTO.getNome());
//        aluno.setMensalidade(adicionarAlunoDTO.getMensalidade());
//        aluno.setSerie(adicionarAlunoDTO.getSerie());
//        aluno.setTurno(adicionarAlunoDTO.getTurno());
//        aluno.setCpf(adicionarAlunoDTO.getCpf());
//        aluno.setDataNasc(adicionarAlunoDTO.getDataNasc());
//        aluno.setPayDay(adicionarAlunoDTO.getPayDay());
//
//        AlunoRepository alunoRepository = new AlunoRepository();
//        boolean results = alunoRepository.saveInfo(aluno);


        aluno.setSuspenso(suspenderAlunoDTO.isSuspenso());
        System.out.println(aluno.toJSON());

        boolean results = alunoRepository.saveInfo(aluno);

        ResponseMessage responseMessage = new ResponseMessage();

        if (results) {
            responseMessage.setCode(200);
            responseMessage.setMessage("Status de aluno atualizado com sucesso");
        } else {
            responseMessage.setCode(400);
            responseMessage.setMessage("Não foi possível atualizar status de aluno");
        }

        return responseMessage;


    }

}
