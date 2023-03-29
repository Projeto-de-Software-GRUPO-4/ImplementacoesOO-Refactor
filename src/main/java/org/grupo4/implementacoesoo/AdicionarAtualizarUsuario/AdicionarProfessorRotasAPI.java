package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/professor", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdicionarProfessorRotasAPI {
    @Autowired
    private AdicionarUsuarioFacade adicionarUsuarioFacade;

    @Autowired
    private AtualizarUsuarioFacade atualizarUsuarioFacade;

    @PostMapping
    @ResponseBody
    public ResponseMessage adicionarProfessor(@RequestBody AdicionarProfessorDTO adicionarProfessorDTO) {
        return adicionarUsuarioFacade.adicionarProfessor(adicionarProfessorDTO);
    }

    @PutMapping
    @ResponseBody
    public ResponseMessage atualizarProfessor(@RequestBody AdicionarProfessorDTO adicionarProfessorDTO) {
        return atualizarUsuarioFacade.atualizarProfessor(adicionarProfessorDTO);
    }
    //    @PutMapping("/{tarefaId}")
//    @ResponseBody
//    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
//                               @RequestBody TarefaDTO tarefaDTO) {
//        return loginFacade.atualizar(tarefaDTO, tarefaId);
//    }
//
//    @GetMapping
//    @ResponseBody
//    public List<TarefaDTO> getAll() {
//        return loginFacade.getAll();
//    }
//
//    @DeleteMapping("/{tarefaId}")
//    @ResponseBody
//    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
//        return loginFacade.delete(tarefaId);
//    }
}