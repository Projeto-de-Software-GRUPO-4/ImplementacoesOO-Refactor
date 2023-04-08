package grupo.quatro.api_manage_escola.Materia;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Materia {

    @Id
    private BigInteger id;

    private String titulo;
}
