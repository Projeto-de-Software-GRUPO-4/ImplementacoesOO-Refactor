package grupo.quatro.api_manage_escola.Commands;

import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.LogIn.DadosLogin;
import org.springframework.http.ResponseEntity;

public interface LoginCommand {

    public ResponseEntity execute(DadosLogin dados);

    UserType getUserType();
}
