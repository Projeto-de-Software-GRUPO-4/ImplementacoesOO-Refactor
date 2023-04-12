package grupo.quatro.api_manage_escola.Ocorrencia;

import java.math.BigInteger;

public record DadosListagemOcorrencia(

        BigInteger id_aluno,

        String descricao
) {

    public DadosListagemOcorrencia(DadosListagemOcorrencia dados) {
        this(dados.id_aluno, dados.descricao());
    }

    public DadosListagemOcorrencia(Ocorrencia ocorrencia) {
        this(ocorrencia.getAluno_id(), ocorrencia.getDescricao());
    }
}
