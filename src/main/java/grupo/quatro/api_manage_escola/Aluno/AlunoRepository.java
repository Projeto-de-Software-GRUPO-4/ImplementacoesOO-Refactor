package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Usuario.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

//public interface AlunoRepository extends JpaRepository<Aluno, Long> {
//
//}

public interface AlunoRepository extends JpaRepository<Aluno, BigInteger> {

}