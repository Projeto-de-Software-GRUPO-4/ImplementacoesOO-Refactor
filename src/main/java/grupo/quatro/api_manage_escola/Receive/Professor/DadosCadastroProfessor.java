package grupo.quatro.api_manage_escola.Receive.Professor;

import grupo.quatro.api_manage_escola.Domain.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(
        @NotNull
        @NotBlank
        String nome,
        @NotNull
        @NotBlank
        String dataDeNascimento,
        @NotNull
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotNull
        int diaDePagamento,
        int cargaHorariaDiaria,
        double salarioHora,

        @NotNull
        @NotBlank
        String senha,

        @NotNull
        @Valid UserType userType
) {
}
