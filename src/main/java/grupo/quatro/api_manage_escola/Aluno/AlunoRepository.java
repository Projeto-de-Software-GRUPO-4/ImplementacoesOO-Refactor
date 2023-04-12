package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Usuario.Usuario;
import grupo.quatro.api_manage_escola.Usuario.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;


public interface AlunoRepository extends JpaRepository<Aluno, BigInteger>  {

    List<DadosListagemAluno> findAllByActiveTrue();
}