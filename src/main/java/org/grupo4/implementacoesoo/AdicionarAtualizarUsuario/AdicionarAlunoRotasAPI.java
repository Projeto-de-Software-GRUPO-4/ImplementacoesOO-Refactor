package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdicionarAlunoRotasAPI {
    @Autowired
    private AdicionarUsuarioFacade adicionarUsuarioFacade;

    @Autowired
    private AtualizarUsuarioFacade atualizarUsuarioFacade;

    @PostMapping
    @ResponseBody
    public ResponseMessage adicionarAluno(@RequestBody AdicionarAlunoDTO adicionarAlunoDTO) {
        return adicionarUsuarioFacade.adicionarAluno(adicionarAlunoDTO);
    }

    @PutMapping
    @ResponseBody
    public ResponseMessage atualizarAluno(@RequestBody AdicionarAlunoDTO adicionarAlunoDTO) {
        return atualizarUsuarioFacade.atualizarAluno(adicionarAlunoDTO);
    }


}
