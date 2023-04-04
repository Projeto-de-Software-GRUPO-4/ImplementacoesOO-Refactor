package grupo.quatro.api_manage_escola.UsuarioCredentials;

import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosCadastroUsuarioCredentials(
        @NotNull
        @NotBlank
        String id,

        @NotNull
        @NotBlank
        String senha,

        @NotNull
        @NotBlank
        UserType userType
) {
}
