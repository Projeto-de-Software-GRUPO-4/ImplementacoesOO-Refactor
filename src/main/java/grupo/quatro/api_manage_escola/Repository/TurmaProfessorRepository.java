package grupo.quatro.api_manage_escola.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class TurmaProfessorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void deleteByProfessorId(BigInteger professorId) {
        Query query = entityManager.createNativeQuery("DELETE FROM turma_professor WHERE professor_id = ?");
        query.setParameter(1, professorId);
        query.executeUpdate();
    }

}
