package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, BigInteger> {

    // Lista todas as ocorrências de um dado aluno
    List<Ocorrencia> findAllByAluno_id(BigInteger id);
}
