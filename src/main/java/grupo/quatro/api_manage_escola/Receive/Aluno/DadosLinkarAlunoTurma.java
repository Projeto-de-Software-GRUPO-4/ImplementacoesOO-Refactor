package grupo.quatro.api_manage_escola.Receive.Aluno;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosLinkarAlunoTurma(
        @NotNull
        BigInteger id_aluno,

        @NotNull
        BigInteger id_turma

) {
}
