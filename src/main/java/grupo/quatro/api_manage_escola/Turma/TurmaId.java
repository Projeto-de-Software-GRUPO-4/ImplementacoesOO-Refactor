package grupo.quatro.api_manage_escola.Turma;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class TurmaId implements Serializable {
    private String letra;

    private int anoEscolar;

    // default constructor

    public TurmaId(String letra, int anoEscolar) {
        this.letra = letra;
        this.anoEscolar = anoEscolar;
    }

    // equals() and hashCode()
}