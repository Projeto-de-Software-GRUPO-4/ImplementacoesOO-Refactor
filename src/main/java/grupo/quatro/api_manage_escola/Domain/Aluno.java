package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
//@Table(name = "alunos")
//@Entity(name = "Aluno")
@Getter
@Setter
@NoArgsConstructor
public class Aluno extends Usuario {

    @ManyToOne
    @JoinColumn(name="turma_id", insertable = false, updatable = true)
    private Turma turma;

    @Embedded
    private Responsavel responsavel;
    private int anoEscolar;

    private boolean suspended;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Set<Boletim> boletim;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Ocorrencia> ocorrencias;

    public Aluno(DadosCadastroAluno dados) {
        super(dados.nome(), new BigInteger(dados.cpf()), dados.dataDeNascimento(), dados.diaDePagamento());
        this.responsavel = new Responsavel(dados.responsavel());
        this.anoEscolar = dados.anoEscolar();
        this.id = new BigInteger(dados.cpf());
    }

    public void updateInfo(DadosAtualizacaoAluno dados) {
        if (dados.nome() != null) super.nome = dados.nome();
        if (dados.diaDePagamento() != 0) super.diaDePagamento = dados.diaDePagamento();
        if (dados.responsavel() != null) this.responsavel.updateInfo(dados.responsavel());
    }

    public DadosListagemTurma getTurmaId() {
        return new DadosListagemTurma(turma.getId(), turma.getAnoEscolar(), turma.getLetra());
    }

    public void suspender() {
        this.suspended = !this.suspended;
    }


}
