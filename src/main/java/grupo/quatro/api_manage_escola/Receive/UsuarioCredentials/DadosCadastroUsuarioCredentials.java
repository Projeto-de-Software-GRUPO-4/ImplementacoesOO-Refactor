package grupo.quatro.api_manage_escola.Receive.UsuarioCredentials;

import grupo.quatro.api_manage_escola.Domain.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
