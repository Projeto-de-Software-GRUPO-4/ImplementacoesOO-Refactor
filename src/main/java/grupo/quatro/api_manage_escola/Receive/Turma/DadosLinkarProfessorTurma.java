package grupo.quatro.api_manage_escola.Receive.Turma;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosLinkarProfessorTurma(
    @NotNull
    BigInteger id_professor,

    @NotNull
    BigInteger id_turma
) {
}
