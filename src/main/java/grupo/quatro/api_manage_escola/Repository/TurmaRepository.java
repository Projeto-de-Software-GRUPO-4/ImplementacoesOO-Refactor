package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TurmaRepository extends JpaRepository<Turma, BigInteger> {
}
