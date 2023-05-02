package grupo.quatro.api_manage_escola.Domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class AlunoBoletim {

    private String id;
    private String nome;
    private double nota;
    private String bimestre;


}
