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
        super(dados.getNome(), new BigInteger(dados.getCpf()), dados.getDataDeNascimento(), dados.getDiaDePagamento());
        this.responsavel = new Responsavel(dados.getResponsavel());
        this.anoEscolar = dados.getAnoEscolar();
        this.id = new BigInteger(dados.getCpf());
    }

    public void updateInfo(DadosAtualizacaoAluno dados) {
        if (dados.getNome() != null) super.nome = dados.getNome();
        if (dados.getDiaDePagamento() != 0) super.diaDePagamento = dados.getDiaDePagamento();
        if (dados.getResponsavel() != null) this.responsavel.updateInfo(dados.getResponsavel());
    }

    public DadosListagemTurma getTurmaId() {
        return new DadosListagemTurma(turma.getId(), turma.getAnoEscolar(), turma.getLetra());
    }

    public void suspender() {
        this.suspended = !this.suspended;
    }


}
