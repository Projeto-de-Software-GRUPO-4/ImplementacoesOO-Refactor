package grupo.quatro.api_manage_escola.Ocorrencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosRegistrarOcorrencia (
        @NotNull
        BigInteger id_aluno,

        @NotNull
        @NotBlank
        String descricao

) {


}
