package org.grupo4.implementacoesoo.SuspenderAluno;


import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/suspend/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
public class SuspenderAlunoRotasAPI {

    @Autowired
    SuspenderAlunoFacade suspenderAlunoFacade = new SuspenderAlunoFacade();

    @PostMapping
    @ResponseBody
    public ResponseMessage suspenderAluno(@RequestBody SuspenderAlunoDTO suspenderAlunoDTO) {
        return suspenderAlunoFacade.suspenderAluno(suspenderAlunoDTO);
    }

}
