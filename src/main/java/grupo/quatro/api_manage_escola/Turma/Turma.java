package grupo.quatro.api_manage_escola.Turma;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Professor.Professor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "turmas")
@Entity(name = "Turma")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Turma {
    private String letra;
    private int anoEscolar;

    @Id
    private String id = letra.concat(Integer.toString(anoEscolar));

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private Set<Aluno> alunos;

    @ManyToMany
            @JoinTable(
                    name="turma_professor",
                    joinColumns = @JoinColumn(name = "turma_id"),
                    inverseJoinColumns = @JoinColumn(name = "professor_id")
            )
    Set<Professor> professores;

}
