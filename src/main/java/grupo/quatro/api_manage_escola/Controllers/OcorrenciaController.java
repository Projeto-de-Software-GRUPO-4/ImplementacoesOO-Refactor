package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Receive.Ocorrencia.DadosListagemOcorrencia;
import grupo.quatro.api_manage_escola.Receive.Ocorrencia.DadosRegistrarOcorrencia;
import grupo.quatro.api_manage_escola.Domain.Ocorrencia;
import grupo.quatro.api_manage_escola.Repository.OcorrenciaRepository;
import grupo.quatro.api_manage_escola.Respond.Message;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaRepository repository;

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping("/registrar")
    @Transactional
    ResponseEntity registrar(@RequestBody @Valid DadosRegistrarOcorrencia dados) {
        try {
            Ocorrencia ocorrencia = repository.save(new Ocorrencia(dados));
            Aluno aluno = alunoRepository.getReferenceById(dados.id_aluno());
            ocorrencia.setAluno(aluno);
            Message message = new Message("Ocorrência cadastrada com sucesso.");
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public List<DadosListagemOcorrencia> listarOcorrenciasPorAluno(@PathVariable BigInteger id) {
        return repository.findAllByAluno_id(id).stream().map(DadosListagemOcorrencia::new).toList();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        repository.deleteById(id);
    }
}
