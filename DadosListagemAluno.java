package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.Responsavel.Responsavel;
import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigInteger;

public record DadosListagemAluno(String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getDiaDePagamento(), aluno.getAnoEscolar());
    }

}
