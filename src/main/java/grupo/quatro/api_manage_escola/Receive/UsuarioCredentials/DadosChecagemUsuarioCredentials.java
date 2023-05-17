package grupo.quatro.api_manage_escola.Receive.UsuarioCredentials;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosChecagemUsuarioCredentials(
        @NotNull
        String usuario_id,

        @NotNull
        String senhaTentativa


){
}
