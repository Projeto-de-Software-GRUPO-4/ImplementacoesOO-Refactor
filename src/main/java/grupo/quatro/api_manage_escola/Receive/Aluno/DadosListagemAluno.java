package grupo.quatro.api_manage_escola.Receive.Aluno;

import grupo.quatro.api_manage_escola.Domain.Aluno;

import java.math.BigInteger;

public record DadosListagemAluno(BigInteger id, String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar) {
//    public DadosListagemAluno(Aluno aluno) {
//        this(aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getDiaDePagamento(), aluno.getAnoEscolar());
//    }

    public DadosListagemAluno(DadosListagemAluno dados) {
        this(dados.id(),dados.nome(), dados.cpf(), dados.dataDeNascimento(), dados.diaDePagamento(), dados.anoEscolar());
    };

    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getDiaDePagamento(), aluno.getAnoEscolar());
    }
}
