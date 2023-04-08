package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Turma.DadosListagemTurma;

import java.math.BigInteger;
import java.util.Optional;

public record DadosListagemAlunoLogin(
        BigInteger id, String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar, DadosListagemTurma turma
) {

    public DadosListagemAlunoLogin(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getDiaDePagamento(), aluno.getAnoEscolar(), aluno.getTurmaId());
    }
}
