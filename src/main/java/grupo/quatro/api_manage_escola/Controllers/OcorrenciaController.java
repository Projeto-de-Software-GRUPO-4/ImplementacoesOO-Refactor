package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Aluno.AlunoRepository;
import grupo.quatro.api_manage_escola.Ocorrencia.DadosListagemOcorrencia;
import grupo.quatro.api_manage_escola.Ocorrencia.DadosRegistrarOcorrencia;
import grupo.quatro.api_manage_escola.Ocorrencia.Ocorrencia;
import grupo.quatro.api_manage_escola.Ocorrencia.OcorrenciaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    void registrar(@RequestBody @Valid DadosRegistrarOcorrencia dados) {
        Ocorrencia ocorrencia = repository.save(new Ocorrencia(dados));
        Aluno aluno = (Aluno) alunoRepository.getReferenceById(dados.id_aluno());
        ocorrencia.setAluno(aluno);
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
