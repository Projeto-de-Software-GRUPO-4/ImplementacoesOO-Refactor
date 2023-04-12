package grupo.quatro.api_manage_escola.Boletim;




import grupo.quatro.api_manage_escola.Aluno.Aluno;
import grupo.quatro.api_manage_escola.Bimestre.Bimestre;
import grupo.quatro.api_manage_escola.Materia.Materia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.Year;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;

    private BigInteger aluno_id;

    private int materia_id;

    @ManyToOne
    @JoinColumn(name = "materia_id", insertable = false, updatable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name="aluno_id", insertable = false, updatable = false)
    private Aluno aluno;


    Year ano;

    Bimestre bimestre;

    Long nota;

    public Boletim(DadosRegistrarBoletim dados) {
        this.aluno_id = dados.aluno_id();
        this.materia_id = dados.materia_id();
        this.nota = dados.nota();
        this.bimestre = dados.bimestre();
        this.ano = dados.ano();
    }

    public void updateInfo(DadosAtualizarBoletim dados) {
        if (dados.materia_id() != 0) this.materia_id = dados.materia_id();
        if (dados.nota() != null && dados.nota() >= 0 && dados.nota() <= 10) this.nota = dados.nota();
        if (dados.bimestre() != null) this.bimestre = dados.bimestre();
    }


}
