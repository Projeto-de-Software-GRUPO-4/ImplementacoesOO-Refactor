package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Domain.Boletim;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Set<Boletim> boletim;

    @OneToOne(mappedBy = "materia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Professor professor;


//    @OneToOne(mappedBy = "materia", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Professor professor;
}
