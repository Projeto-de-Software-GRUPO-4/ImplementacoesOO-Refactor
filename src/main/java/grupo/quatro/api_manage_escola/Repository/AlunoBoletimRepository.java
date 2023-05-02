package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.AlunoBoletim;
import grupo.quatro.api_manage_escola.Domain.Bimestre;
import grupo.quatro.api_manage_escola.Domain.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoBoletimRepository {

    @PersistenceContext
    private EntityManager entityManager;
    public List<AlunoBoletim> getNotasAlunosTurma(Year boletimYear, int materia_id) {
        Query query = entityManager.createNativeQuery("""
            SELECT
            aluno.id as id,
            aluno.nome as nome,
            boletim.nota as nota,
            boletim.bimestre as bimestre
            FROM aluno
            INNER JOIN boletim
            WHERE aluno.id = boletim.aluno_id
            AND aluno.active = 1
            AND boletim.ano = ?
            AND materia_id = ?
        """);

        query.setParameter(1, boletimYear);
        query.setParameter(2, materia_id);

        List<Object[]> results = query.getResultList();

        List<AlunoBoletim> notas = new ArrayList<>();
        for (Object[] row : results) {
            AlunoBoletim alunoBoletim = new AlunoBoletim();
            alunoBoletim.setId((String) row[0]);
            alunoBoletim.setNome((String) row[1]);
            alunoBoletim.setNota((Double) row[2]);
            alunoBoletim.setBimestre((String) row[3]);
            notas.add(alunoBoletim);
        }

        return notas;

    }
}
