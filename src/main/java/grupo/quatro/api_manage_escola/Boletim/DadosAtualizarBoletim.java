package grupo.quatro.api_manage_escola.Boletim;

import grupo.quatro.api_manage_escola.Bimestre.Bimestre;
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
