package grupo.quatro.api_manage_escola.Professor;

import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name="professores")
@Entity(name="Professor")
//@AttributeOverride(name="id", column = @Column(name="id"))
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@NoArgsConstructor
public class Professor extends Usuario {

    @Id
    private String id;

    private String areaEnsino;

    private int cargaHorariaDiaria;

    private double salarioHora;

    // O valor do mapped by precisa ser o nome do atributo
    @ManyToMany(mappedBy = "professores")
    Set<Turma> turmas;
    public Professor(DadosCadastroProfessor dados) {
        super(dados.nome(), dados.cpf(), dados.dataDeNascimento(), dados.diaDePagamento());
        this.areaEnsino = dados.areaEnsino();
        this.cargaHorariaDiaria = dados.cargaHorariaDiaria();
        this.salarioHora = dados.salarioHora();
        this.turmas = new HashSet<Turma>();
        this.id = dados.cpf();
    }

}
