package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Bimestre;
import grupo.quatro.api_manage_escola.Domain.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface BoletimRepository extends JpaRepository<Boletim, BigInteger> {

    // Resgata todas as notas de um aluno

//    @Query(value = """
//        SELECT b FROM boletim b
//        WHERE b.bimestre = :bimestre AND b.aluno_id = :aluno_id
//        AND
//    """, nativeQuery = true)
    Optional<Boletim> findByBimestreAndAluno_Id(Bimestre bimestre, BigInteger aluno_id);
    List<Boletim> findAllByAluno_Id(BigInteger aluno_id);

    // Resgata todas as notas de um aluno em um dado ano
    List<Boletim> findAllByAluno_idAndAno(BigInteger aluno_id, Year ano);

    // Resgata todas as notas de um aluno em um dado ano em uma dada matéria
    List<Boletim> findAllByAluno_idAndAnoAndMateria_id(BigInteger aluno_id, Year ano, BigInteger materia_id);

    // Resgata todas as notas de um aluno em um dado ano e bimestre
    List<Boletim> findAllByAluno_idAndAnoAndBimestre(BigInteger aluno_id, Year ano, Bimestre bimestre);

    // Resgata todas as notas de uma série em um dado ano
    List<Boletim> findAllByAluno_AnoEscolarAndAno(int aluno_anoEscolar, Year ano);

    // Resgata todas as notas de uma série em um dado ano e bimestre
    List<Boletim> findAllByAluno_AnoEscolarAndAnoAndBimestre(int aluno_anoEscolar, Year ano, Bimestre bimestre);

    // Resgata todas as notas de uma série em um dado ano, bimestre e matéria
    List<Boletim> findAllByAluno_AnoEscolarAndAnoAndMateria_id(int aluno_anoEscolar, Year ano, int materia_id);
    
}
