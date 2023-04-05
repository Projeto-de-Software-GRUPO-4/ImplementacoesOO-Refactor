package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
