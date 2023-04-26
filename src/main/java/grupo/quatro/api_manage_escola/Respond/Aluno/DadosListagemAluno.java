package grupo.quatro.api_manage_escola.Respond.Aluno;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Responsavel;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Optional;

@Getter
@Setter
public class DadosListagemAluno extends DadosListagemUsuario {

    private int anoEscolar;

    private Responsavel responsavel;

    private boolean suspenso;

    private Optional<DadosListagemTurma> turma;

    private double mensalidade;


    public DadosListagemAluno(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        this.dataDeNascimento = aluno.getDataDeNascimento();
        this.diaDePagamento = aluno.getDiaDePagamento();
        this.anoEscolar = aluno.getAnoEscolar();
        this.responsavel = aluno.getResponsavel();
        this.suspenso = aluno.isSuspended();
        this.turma = aluno.getTurmaId();
        this.mensalidade = aluno.getMensalidade();
    }
}
