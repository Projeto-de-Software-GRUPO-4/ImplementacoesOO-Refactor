package grupo.quatro.api_manage_escola.Repository;

import grupo.quatro.api_manage_escola.Domain.UsuarioCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioCredentialsRepository extends JpaRepository<UsuarioCredentials, String> {
}
