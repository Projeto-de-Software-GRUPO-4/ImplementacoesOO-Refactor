package grupo.quatro.api_manage_escola.Materia;

import grupo.quatro.api_manage_escola.Boletim.Boletim;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Set<Boletim> boletim;
}
