package grupo.quatro.api_manage_escola.Responsavel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosResponsavel(
        @NotNull
        @NotBlank
        String nome,

        @NotNull
        @NotBlank
        String telefone,

        @NotNull
        @Pattern(regexp = "\\d{11}")
        String cpf
) {
}
