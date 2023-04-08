package grupo.quatro.api_manage_escola.Professor;

import grupo.quatro.api_manage_escola.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
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

    private String areaEnsino;

    private int cargaHorariaDiaria;

    private double salarioHora;

    // O valor do mapped by precisa ser o nome do atributo
    @ManyToMany(mappedBy = "professores")
    Set<Turma> turmas;
    public Professor(DadosCadastroProfessor dados) {
        super(dados.nome(), new BigInteger(dados.cpf()), dados.dataDeNascimento(), dados.diaDePagamento());
        this.areaEnsino = dados.areaEnsino();
        this.cargaHorariaDiaria = dados.cargaHorariaDiaria();
        this.salarioHora = dados.salarioHora();
        this.turmas = new HashSet<Turma>();
        this.id = new BigInteger(dados.cpf());
    }

    public List<DadosListagemTurma> getTurmasId() {
        return turmas.stream().map(turma -> new DadosListagemTurma(turma)).toList();
    }

//    @NotNull
//    BigInteger id,
//
//    String nome,
//
//    String areaEnsino,
//
//    int diaDePagamento,
//    int cargaHorariaDiaria,
//    double salarioHora

    public void updateInfo(DadosAtualizacaoProfessor dados) {
        if (dados.nome() != null) super.nome = dados.nome();
        if (dados.areaEnsino() != null) this.areaEnsino = dados.areaEnsino();
        if (dados.diaDePagamento() != 0) super.diaDePagamento = dados.diaDePagamento();
        if (dados.cargaHorariaDiaria() != 0) this.cargaHorariaDiaria = dados.cargaHorariaDiaria();
        if (dados.salarioHora() != 0) this.salarioHora = dados.salarioHora();
    }

}
