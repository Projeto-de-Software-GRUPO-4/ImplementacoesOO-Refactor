package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MateriaRepository extends JpaRepository<Materia, BigInteger> {
}
