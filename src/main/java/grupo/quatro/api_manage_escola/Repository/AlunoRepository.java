package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;


public interface AlunoRepository extends JpaRepository<Aluno, BigInteger>  {

    List<Aluno> findAllByActiveTrue();

    
}