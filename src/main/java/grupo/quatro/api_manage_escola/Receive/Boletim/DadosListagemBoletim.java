package grupo.quatro.api_manage_escola.Receive.Boletim;

import grupo.quatro.api_manage_escola.Domain.Bimestre;
import grupo.quatro.api_manage_escola.Domain.Boletim;

import java.math.BigInteger;
import java.time.Year;

public record DadosListagemBoletim (

        BigInteger id,
    BigInteger aluno_id,
    Year ano,
    Bimestre bimestre,
    int materia_id,

    Double nota
) {

    public DadosListagemBoletim(Boletim boletim) {
        this(boletim.getId(), boletim.getAluno_id(), boletim.getAno(), boletim.getBimestre(), boletim.getMateria_id(), boletim.getNota());
    }

}
