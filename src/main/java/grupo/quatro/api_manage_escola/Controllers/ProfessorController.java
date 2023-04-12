package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Repository.ProfessorRepository;
import grupo.quatro.api_manage_escola.Repository.UsuarioCredentialsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;
    @Autowired
    private UsuarioCredentialsRepository usuarioCredentialsRepository;

    @PostMapping
    @Transactional
    public void cadastro(@RequestBody @Valid DadosCadastroProfessor dados) {
        repository.save(new Professor(dados));
        usuarioCredentialsRepository.save(new UsuarioCredentials(dados.cpf(), dados.senha(), dados.userType()));
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        Professor professor = (Professor) repository.getReferenceById(dados.id());
        professor.updateInfo(dados);
    }

    // TODO
//    @GetMapping
//    public List<DadosListagemProfessor> listar() {
//        return repository.findAll().stream().map(DadosListagemProfessor::new).toList();
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable BigInteger id) {
        Professor professor = (Professor) repository.getReferenceById(id);
        professor.excluir();
    }

}