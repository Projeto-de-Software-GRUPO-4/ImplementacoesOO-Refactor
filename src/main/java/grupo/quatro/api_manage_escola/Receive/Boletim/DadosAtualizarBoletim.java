package grupo.quatro.api_manage_escola.Receive.Boletim;

import grupo.quatro.api_manage_escola.Domain.Bimestre;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosAtualizarBoletim (

        @NotNull
        BigInteger id,

        int materia_id,

        Long nota,

        Bimestre bimestre
){
}
