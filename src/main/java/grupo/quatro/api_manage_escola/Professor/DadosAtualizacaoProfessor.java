package grupo.quatro.api_manage_escola.Professor;

import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigInteger;

public record DadosAtualizacaoProfessor (
    @NotNull
    BigInteger id,

    String nome,

    String areaEnsino,

    int diaDePagamento,
    int cargaHorariaDiaria,
    double salarioHora


) {
}
