package grupo.quatro.api_manage_escola.Professor;

import grupo.quatro.api_manage_escola.Usuario.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

//public interface ProfessorRepository extends JpaRepository<Professor, String> {
//}

public interface ProfessorRepository extends JpaRepository<Professor, BigInteger> {

    Optional<Professor> findByCpf(String cpf);

}
