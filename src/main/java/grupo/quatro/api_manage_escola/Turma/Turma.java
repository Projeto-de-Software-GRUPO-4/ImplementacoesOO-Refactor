package grupo.quatro.api_manage_escola.Turma;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Professor.Professor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Entity(name = "Turma")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Turma {
    private String letra;
    private int anoEscolar;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private Set<Aluno> alunos;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST, CascadeType.MERGE
            })
            @JoinTable(
                    name="turma_professor",
                    joinColumns = @JoinColumn(name = "turma_id"),
                    inverseJoinColumns = @JoinColumn(name = "professor_id")
            )
    Set<Professor> professores;

    public Turma(DadosCadastroTurma dados) {
        this.anoEscolar = dados.anoEscolar();
        this.letra = dados.letra();
    }

}
