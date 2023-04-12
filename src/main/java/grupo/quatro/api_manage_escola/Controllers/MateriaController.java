package grupo.quatro.api_manage_escola.Controllers;

import grupo.quatro.api_manage_escola.Materia.Materia;
import grupo.quatro.api_manage_escola.Materia.MateriaRepository;
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
    List<Materia> getTodasAsMaterias() {
        return repository.findAll();
    }

}
