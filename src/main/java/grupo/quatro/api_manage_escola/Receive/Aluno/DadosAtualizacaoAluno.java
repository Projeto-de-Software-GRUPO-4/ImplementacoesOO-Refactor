package grupo.quatro.api_manage_escola.Receive.Aluno;

import grupo.quatro.api_manage_escola.Receive.Responsavel.DadosResponsavel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosAtualizacaoAluno(

        @NotNull
        BigInteger id,

        String nome,
        @Valid
        DadosResponsavel responsavel,

        int diaDePagamento,

        int anoEscolar
) {
}
