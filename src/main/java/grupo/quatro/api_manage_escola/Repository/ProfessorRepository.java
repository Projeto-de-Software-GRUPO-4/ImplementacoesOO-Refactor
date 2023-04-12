package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

//public interface ProfessorRepository extends JpaRepository<Professor, String> {
//}
public interface ProfessorRepository extends JpaRepository<Professor, BigInteger> {

//    Optional<Professor> findByCpf(String cpf);

}
