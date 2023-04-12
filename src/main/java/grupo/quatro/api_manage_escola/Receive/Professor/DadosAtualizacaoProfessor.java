package grupo.quatro.api_manage_escola.Receive.Professor;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosAtualizacaoProfessor (
    @NotNull
    BigInteger id,

    String nome,


    int diaDePagamento,
    int cargaHorariaDiaria,
    double salarioHora


) {
}
