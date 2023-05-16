package grupo.quatro.api_manage_escola.Respond.AlunoBoletim;

import grupo.quatro.api_manage_escola.Domain.AlunoBoletim;
import grupo.quatro.api_manage_escola.Domain.Bimestre;
import grupo.quatro.api_manage_escola.Domain.Boletim;

public record DadosListagemAlunoBoletim(
        String id,
        String nome,
        Double nota,
        String bimestre

) {

    public DadosListagemAlunoBoletim(AlunoBoletim dados) {
        this(dados.getId(), dados.getNome(), dados.getNota(), dados.getBimestre());
    }

}
