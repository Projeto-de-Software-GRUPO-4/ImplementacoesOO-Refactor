package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Domain.Materia;
import grupo.quatro.api_manage_escola.Repository.MateriaRepository;
import grupo.quatro.api_manage_escola.Respond.Materia.DadosListagemMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaRepository repository;

    @GetMapping
    List<DadosListagemMateria> getTodasAsMaterias() {

        return repository.findAll().stream().map(DadosListagemMateria::new).toList();
    }

}
