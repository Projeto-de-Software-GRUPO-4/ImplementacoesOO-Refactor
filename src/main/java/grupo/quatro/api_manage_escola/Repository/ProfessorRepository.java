package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Respond.Professor.DadosListagemProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

//public interface ProfessorRepository extends JpaRepository<Professor, String> {
//}
public interface ProfessorRepository extends JpaRepository<Professor, BigInteger> {

//    Optional<Professor> findByCpf(String cpf);
    List<Professor> findAllByActiveTrue();



}
