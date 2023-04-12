package grupo.quatro.api_manage_escola.Receive.Turma;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroTurma(
        @NotNull
        int anoEscolar,

        @NotNull
        @Pattern(regexp = "^[A-Z]$")
        String letra
) {
}
