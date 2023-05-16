package grupo.quatro.api_manage_escola.Respond.Boletim;

import grupo.quatro.api_manage_escola.Domain.Boletim;

import java.math.BigInteger;
import java.time.Year;

public record DadosListagemBoletim (
    BigInteger aluno_id,
    int materia_id,
    Double nota,
    Year ano
){

    public DadosListagemBoletim(Boletim dados) {
        this(dados.getAluno_id(), dados.getMateria_id(), dados.getNota(), dados.getAno());
    }

}
