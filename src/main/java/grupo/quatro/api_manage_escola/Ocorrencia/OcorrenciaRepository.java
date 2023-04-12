package grupo.quatro.api_manage_escola.Ocorrencia;

import grupo.quatro.api_manage_escola.Professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, BigInteger> {

    // Lista todas as ocorrências de um dado aluno
    List<Ocorrencia> findAllByAluno_id(BigInteger id);
}
