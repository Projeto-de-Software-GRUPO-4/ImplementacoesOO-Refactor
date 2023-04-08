package grupo.quatro.api_manage_escola.Ocorrencia;

import grupo.quatro.api_manage_escola.Aluno.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//id bigint auto_increment,
//        aluno_id bigint,
//        descricao text,
//        foreign key (aluno_id) references aluno.id,
//        primary key (id)
public class Ocorrencia {

    @Id
    private BigInteger id;

    private String descricao;

    private BigInteger aluno_id;

    @ManyToOne
    @JoinColumn(name="aluno_id", insertable = false, updatable = false)
    private Aluno aluno;


}