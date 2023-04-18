package grupo.quatro.api_manage_escola.Respond.Aluno;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Responsavel;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosListagemAluno extends DadosListagemUsuario {

    private int anoEscolar;

    private Responsavel reponsavel;

    private boolean suspenso;

    public DadosListagemAluno(DadosListagemAluno dados) {
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.cpf = dados.getCpf();
        this.dataDeNascimento = dados.getDataDeNascimento();
        this.diaDePagamento = dados.getDiaDePagamento();
        this.anoEscolar = dados.getAnoEscolar();
        this.reponsavel = dados.getReponsavel();
        this.suspenso = dados.isSuspenso();
    };

    public DadosListagemAluno(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        this.dataDeNascimento = aluno.getDataDeNascimento();
        this.diaDePagamento = aluno.getDiaDePagamento();
        this.anoEscolar = aluno.getAnoEscolar();
        this.reponsavel = aluno.getResponsavel();
        this.suspenso = aluno.isSuspended();
    }
}
