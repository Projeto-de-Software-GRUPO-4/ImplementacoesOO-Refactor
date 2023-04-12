package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

//@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {

}
