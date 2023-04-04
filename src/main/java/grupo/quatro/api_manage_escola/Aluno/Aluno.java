package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Responsavel.Responsavel;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@AttributeOverride(name="id", column = @Column(name="numeroDeMatricula"))
public class Aluno extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroDeMatricula;

    @ManyToOne
    @JoinColumn(name="turma_id", insertable = false, updatable = false)
    private Turma turma;

    @Embedded
    private Responsavel responsavel;
    private int anoEscolar;

    public Aluno(DadosCadastroAluno dados) {
        super(dados.nome(), dados.cpf(), dados.dataDeNascimento(), dados.diaDePagamento());
        this.responsavel = new Responsavel(dados.responsavel());
        this.anoEscolar = dados.anoEscolar();
    }
}
