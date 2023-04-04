package grupo.quatro.api_manage_escola.Professor;

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
        @NotBlank
        String areaEnsino,
        @NotNull
        int diaDePagamento,
        int cargaHorariaDiaria,
        double salarioHora
) {
}
