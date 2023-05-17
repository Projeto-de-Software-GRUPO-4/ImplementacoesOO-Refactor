package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Receive.Aluno.DadosAtualizacaoAluno;
import grupo.quatro.api_manage_escola.Receive.Aluno.DadosCadastroAluno;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Repository.AlunoRepository;
import grupo.quatro.api_manage_escola.Respond.Aluno.DadosListagemAluno;
import grupo.quatro.api_manage_escola.Service.BoletimService;
import grupo.quatro.api_manage_escola.States.AlunoAprovacaoState;
import grupo.quatro.api_manage_escola.States.AlunoAprovadoState;
import grupo.quatro.api_manage_escola.States.AlunoReprovadoState;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
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

    private double mensalidade;

    private boolean suspended;

    private boolean expelled;

    private boolean status_aprovacao;

    @Transient
    private AlunoAprovacaoState aprovacaoState = new AlunoReprovadoState();


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Set<Boletim> boletim;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Ocorrencia> ocorrencias;

    public Aluno(String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento,
                 Responsavel responsavel, double mensalidade) {
        super(nome, cpf, dataDeNascimento, diaDePagamento);
        this.responsavel = responsavel;
        this.mensalidade = mensalidade;
        this.id = cpf;
        this.status_aprovacao = false;
        this.aprovacaoState = new AlunoReprovadoState();
    }

    public Aluno(DadosCadastroAluno dados) {
        this(dados.getNome(), new BigInteger(dados.getCpf()), dados.getDataDeNascimento(), dados.getDiaDePagamento(),
                new Responsavel(dados.getResponsavel()), dados.getMensalidade());
    }

    public Aluno(DadosListagemAluno dados) {
        this(dados.getNome(), dados.getCpf(), dados.getDataDeNascimento(), dados.getDiaDePagamento(),
                dados.getResponsavel(), dados.getMensalidade());
    }

    public void updateInfo(DadosAtualizacaoAluno dados) {
        if (dados.getNome() != null) super.nome = dados.getNome();
        if (dados.getDiaDePagamento() != 0) super.diaDePagamento = dados.getDiaDePagamento();
        if (dados.getResponsavel() != null) this.responsavel.updateInfo(dados.getResponsavel());
        if (dados.getMensalidade() != 0) this.mensalidade = dados.getMensalidade();
    }

    public Optional<DadosListagemTurma> getTurmaId() {
        if (turma != null) {
            return Optional.of(new DadosListagemTurma(turma.getId(), turma.getAnoEscolar(), turma.getLetra()));
        } else {
            return Optional.empty();
        }
    }

    public void suspender() {
        this.suspended = !this.suspended;
    }

    @Override
    public void excluir() {
        super.excluir();
        this.expelled = true;
        this.turma = null;
        this.anoEscolar = 0;
    }

    public void setState(AlunoAprovacaoState state) {
        this.aprovacaoState = state;

        if (this.aprovacaoState.getClass() == AlunoAprovadoState.class) {
            this.status_aprovacao = true;
        } else if (this.aprovacaoState.getClass() == AlunoReprovadoState.class) {
            this.status_aprovacao = false;
        }

    }

    public void checkState(Boletim boletim, BoletimService boletimService, AlunoRepository alunoRepository) {

        aprovacaoState.checkState(boletim, boletimService, alunoRepository);
        this.setState(aprovacaoState);

    }


}
