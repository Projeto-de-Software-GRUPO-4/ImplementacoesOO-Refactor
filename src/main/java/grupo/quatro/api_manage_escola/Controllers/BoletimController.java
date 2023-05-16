package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.AlunoBoletim;
import grupo.quatro.api_manage_escola.Domain.Bimestre;
import grupo.quatro.api_manage_escola.Domain.Boletim;
import grupo.quatro.api_manage_escola.Receive.Boletim.DadosAtualizarBoletim;
import grupo.quatro.api_manage_escola.Receive.Boletim.DadosListagemBoletim;
import grupo.quatro.api_manage_escola.Receive.Boletim.DadosRegistrarBoletim;
import grupo.quatro.api_manage_escola.Repository.AlunoBoletimRepository;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Repository.BoletimRepository;
import grupo.quatro.api_manage_escola.Respond.Message;
import grupo.quatro.api_manage_escola.Service.BoletimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/boletim")
public class BoletimController {

    @Autowired
    BoletimRepository repository;

    @Autowired
    BoletimService boletimService;

    @Autowired
    AlunoBoletimRepository alunoBoletimRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @PostMapping("/registrar")
    @Transactional
    ResponseEntity registrar(@RequestBody @Valid DadosRegistrarBoletim dados) {
        try {
            Message message = boletimService.registrar(dados);
            Aluno aluno = alunoRepository.getReferenceById(dados.aluno_id());
            Boletim boletim = new Boletim(dados);
            aluno.checkState(boletim, boletimService, alunoRepository);

            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/aluno/{aluno_id}")
    List<DadosListagemBoletim> listarNotasAluno(@PathVariable BigInteger aluno_id) {
//        return alunoRepository.findAllByActiveTrue().stream().map(DadosListagemAluno::new).toList();
        return repository.findAllByAluno_Id(aluno_id).stream().map(DadosListagemBoletim::new).toList();
    }


    @GetMapping("/aluno/{aluno_id}/{ano}")
    List<DadosListagemBoletim> listarNotasAluno(@PathVariable BigInteger aluno_id, @PathVariable Year ano) {
            return repository.findAllByAluno_idAndAno(aluno_id, ano).stream().map(DadosListagemBoletim::new).toList();
    }

    @GetMapping("/aluno/{aluno_id}/{ano}/bimestre/{bimestre}")
    List<DadosListagemBoletim> listarNotasAluno(@PathVariable BigInteger aluno_id, @PathVariable Year ano,
                                                @PathVariable Bimestre bimestre) {
        return repository.findAllByAluno_idAndAnoAndBimestre(aluno_id, ano, bimestre).stream().map(DadosListagemBoletim::new).toList();
    }

    @GetMapping("/aluno/{aluno_id}/{ano}/materia/{materia_id}")
    List<DadosListagemBoletim> listarNotasAluno(@PathVariable BigInteger aluno_id, @PathVariable Year ano,
                                   @PathVariable int materia_id) {
        return repository.findAllByAluno_idAndAnoAndMateria_id(aluno_id, ano, new BigInteger(String.valueOf(materia_id))).stream().map(DadosListagemBoletim::new).toList();
    }


    @GetMapping("/alunos/{anoEscolar}/{ano}")
    List<DadosListagemBoletim> listarNotasTodosAlunos(@PathVariable int anoEscolar, @PathVariable Year ano) {
        return repository.findAllByAluno_AnoEscolarAndAno(anoEscolar, ano).stream().map(DadosListagemBoletim::new).toList();
    }

    @GetMapping("/alunos/{anoEscolar}/{ano}/bimestre/{bimestre}")
    List<DadosListagemBoletim> listarNotasTodosAlunos(@PathVariable int anoEscolar, @PathVariable Year ano, @PathVariable Bimestre bimestre) {
        return repository.findAllByAluno_AnoEscolarAndAnoAndBimestre(anoEscolar, ano, bimestre).stream().map(DadosListagemBoletim::new).toList();
    }

    @GetMapping("/alunos/{anoEscolar}/{ano}/materia/{materia_id}")
    List<DadosListagemBoletim> listarNotasTodosAlunos(@PathVariable int anoEscolar, @PathVariable Year ano,
                                                      @PathVariable int materia_id) {
        return repository.findAllByAluno_AnoEscolarAndAnoAndMateria_id(anoEscolar, ano, materia_id).stream().map(DadosListagemBoletim::new).toList();
    }

//    @PutMapping("/alterar")
//    @Transactional
//    void alterar(@RequestBody @Valid DadosAtualizarBoletim dados) {
//        Boletim boletim = repository.getReferenceById(dados.id());
//        boletim.updateInfo(dados);
//    }

    @GetMapping("/materia/{materia_id}/ano/{ano}")
    ResponseEntity listarNotasDeUmaTurma(@PathVariable int materia_id, @PathVariable Year ano) {
        try {
            return new ResponseEntity<>(boletimService.listarNotasDeUmaTurma(materia_id, ano), HttpStatus.OK);
        } catch (Exception e) {
            Message message = new Message(e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
