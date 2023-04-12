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

    private int cargaHorariaDiaria;

    private double salarioHora;

    // O valor do mapped by precisa ser o nome do atributo
    @ManyToMany(mappedBy = "professores")
    Set<Turma> turmas;
    public Professor(DadosCadastroProfessor dados) {
        super(dados.nome(), new BigInteger(dados.cpf()), dados.dataDeNascimento(), dados.diaDePagamento());
        this.cargaHorariaDiaria = dados.cargaHorariaDiaria();
        this.salarioHora = dados.salarioHora();
        this.turmas = new HashSet<Turma>();
        this.id = new BigInteger(dados.cpf());
    }

    public List<DadosListagemTurma> getTurmasId() {
        return turmas.stream().map(DadosListagemTurma::new).toList();
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
        if (dados.diaDePagamento() != 0) super.diaDePagamento = dados.diaDePagamento();
        if (dados.cargaHorariaDiaria() != 0) this.cargaHorariaDiaria = dados.cargaHorariaDiaria();
        if (dados.salarioHora() != 0) this.salarioHora = dados.salarioHora();
    }

}
