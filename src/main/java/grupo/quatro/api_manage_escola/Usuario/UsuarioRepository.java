package grupo.quatro.api_manage_escola.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigInteger;
import java.util.ArrayList;

//@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {

}
