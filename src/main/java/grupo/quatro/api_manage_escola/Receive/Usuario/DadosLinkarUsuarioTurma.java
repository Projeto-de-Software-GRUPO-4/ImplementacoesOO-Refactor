package grupo.quatro.api_manage_escola.Receive.Usuario;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosLinkarUsuarioTurma(
        @NotNull
        BigInteger id_usuario,

        @NotNull
        BigInteger id_turma
) {
}
