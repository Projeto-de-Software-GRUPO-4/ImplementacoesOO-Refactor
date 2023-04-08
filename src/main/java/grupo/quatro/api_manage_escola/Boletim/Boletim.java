package grupo.quatro.api_manage_escola.Boletim;




import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Bimestre.Bimestre;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.math.BigInteger;

@Entity
public class Boletim {

    //        bimestre enum(1, 2, 3, 4),
//        materia_id tinyint,
//        foreign key (aluno_id) references aluno.id,
//        foreign key (materia_id) references materias.id,
//        primary key (id)
//        );
    @Id
    BigInteger id;


    @OneToOne(mappedBy = "boletim")
    private Aluno aluno;

    String ano;

    Bimestre bimestre;


}
