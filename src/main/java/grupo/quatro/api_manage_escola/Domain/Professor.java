package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Receive.Professor.DadosAtualizacaoProfessor;
import grupo.quatro.api_manage_escola.Receive.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
//@Table(name="professores")
//@Entity(name="Professor")
@Getter
@Setter
@NoArgsConstructor
public class Professor extends Usuario {

//    @Id
//    private String id;

    private int cargaHorariaDiaria;

    private double salarioHora;

    private String telefone;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "materia_id")
    private Materia materia;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @MapsId("materia_id")
////    @JoinColumn(name="materia_id")
//    private Materia materia;

    // O valor do mapped by precisa ser o nome do atributo
    @ManyToMany(mappedBy = "professores")
    Set<Turma> turmas;

    public Professor(
            String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento,
            int cargaHorariaDiaria, double salarioHora, String telefone
    ) {
        super(nome, cpf, dataDeNascimento, diaDePagamento);
        this.cargaHorariaDiaria = cargaHorariaDiaria;
        this.salarioHora = salarioHora;
        this.turmas = new HashSet<Turma>();
        this.telefone = telefone;
        this.id = cpf;
    }
    public Professor(DadosCadastroProfessor dados) {
        this(dados.getNome(), new BigInteger(dados.getCpf()), dados.getDataDeNascimento(), dados.getDiaDePagamento(),
                dados.getCargaHorariaDiaria(), dados.getSalarioHora(), dados.getTelefone());
    }

    public List<DadosListagemTurma> getTurmasId() {
        return turmas.stream().map(DadosListagemTurma::new).toList();
    }

    public void updateInfo(DadosAtualizacaoProfessor dados) {
        if (dados.getNome() != null) super.nome = dados.getNome();
        if (dados.getDiaDePagamento() != 0) super.diaDePagamento = dados.getDiaDePagamento();
        if (dados.getCargaHorariaDiaria() != 0) this.cargaHorariaDiaria = dados.getCargaHorariaDiaria();
        if (dados.getSalarioHora() != 0) this.salarioHora = dados.getSalarioHora();
        if (dados.getTelefone() != null) this.telefone = dados.getTelefone();
    }

}
