package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class TurmaProfessorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void deleteByProfessorId(BigInteger professorId) {
        Query query = entityManager.createNativeQuery("DELETE FROM turma_professor WHERE professor_id = ?");
        query.setParameter(1, professorId);
        query.executeUpdate();
    }


    public List<Turma> getByProfessorId(BigInteger professorId) {
        Query query = entityManager.createNativeQuery("SELECT t.* FROM turma t INNER JOIN turma_professor tp ON t.id = tp.turma_id WHERE tp.professor_id = ?", Turma.class);
        query.setParameter(1, professorId);
        return query.getResultList();
    }

}
