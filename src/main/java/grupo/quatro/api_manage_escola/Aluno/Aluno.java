package grupo.quatro.api_manage_escola.Aluno;

import grupo.quatro.api_manage_escola.Professor.DadosCadastroProfessor;
import grupo.quatro.api_manage_escola.Responsavel.Responsavel;
import grupo.quatro.api_manage_escola.Turma.Turma;
import grupo.quatro.api_manage_escola.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
//@Table(name = "alunos")
//@Entity(name = "Aluno")
@Getter
@Setter
@NoArgsConstructor
public class Aluno extends Usuario {

    @ManyToOne
    @JoinColumn(name="turma_id", insertable = false, updatable = false)
    private Turma turma;

    @Embedded
    private Responsavel responsavel;
    private int anoEscolar;

    public Aluno(DadosCadastroAluno dados) {
        super(dados.nome(), new BigInteger(dados.cpf()), dados.dataDeNascimento(), dados.diaDePagamento());
        this.responsavel = new Responsavel(dados.responsavel());
        this.anoEscolar = dados.anoEscolar();
//        this.numeroDeMatricula = this.getId();
    }
}
