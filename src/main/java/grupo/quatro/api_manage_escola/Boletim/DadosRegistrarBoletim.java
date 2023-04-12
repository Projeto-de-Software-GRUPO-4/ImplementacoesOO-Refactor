package grupo.quatro.api_manage_escola.Boletim;

import grupo.quatro.api_manage_escola.Bimestre.Bimestre;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;
import java.time.Year;

public record DadosRegistrarBoletim(

        @NotNull
        BigInteger aluno_id,

        @NotNull
        int materia_id,

        @NotNull
        Year ano,

        @NotNull
        Bimestre bimestre,

        Long nota
) {
}
