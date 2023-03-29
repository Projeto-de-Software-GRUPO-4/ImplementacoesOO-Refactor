package org.grupo4.implementacoesoo.LerDadosUsuario;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
public class LerDadosAlunoRotasAPI {
    @Autowired
    private LerDadosFacade lerDadosFacade;


    @PostMapping
    @ResponseBody
    public JSONObject lerDados(@RequestBody LerDadosDTO lerDadosDTO) {
        return lerDadosFacade.lerDadosAluno(lerDadosDTO);
    }



}