package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Receive.Ocorrencia.DadosRegistrarOcorrencia;
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
//id bigint auto_increment,
//        aluno_id bigint,
//        descricao text,
//        foreign key (aluno_id) references aluno.id,
//        primary key (id)
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String descricao;

    private BigInteger aluno_id;

    @ManyToOne
    @JoinColumn(name="aluno_id", insertable = false, updatable = false)
    private Aluno aluno;

    public Ocorrencia(String descricao, BigInteger aluno_id) {
        this.descricao = descricao;
        this.aluno_id = aluno_id;
    }

    public Ocorrencia(DadosRegistrarOcorrencia ocorrencia) {
        this(ocorrencia.descricao(), ocorrencia.id_aluno());
    }


}
