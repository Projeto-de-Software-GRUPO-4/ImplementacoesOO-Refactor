package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.Responsavel.Responsavel;
import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
