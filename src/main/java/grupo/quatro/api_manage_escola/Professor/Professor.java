package grupo.quatro.api_manage_escola.Professor;

import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashSet;
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

}
