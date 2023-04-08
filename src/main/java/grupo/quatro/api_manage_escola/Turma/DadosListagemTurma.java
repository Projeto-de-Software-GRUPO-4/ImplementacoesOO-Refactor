package grupo.quatro.api_manage_escola.Turma;

import java.math.BigInteger;

public record DadosListagemTurma(BigInteger id, int anoEscolar, String letra) {
    public DadosListagemTurma(Turma turma) {
        this(turma.getId(), turma.getAnoEscolar(), turma.getLetra());
    }

}
