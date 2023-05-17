package grupo.quatro.api_manage_escola.Receive.UsuarioCredentials;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuarioCredentials(
        @NotNull
        String usuario_id,

        @NotNull
        String novaSenha,

        @NotNull
        String tentativaSenha


){
}
