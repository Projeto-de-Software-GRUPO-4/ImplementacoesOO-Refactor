package grupo.quatro.api_manage_escola.Responsavel;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Responsavel {
    private String nomeResponsavel;
    private String telefoneResponsavel;
    private String cpfResponsavel;

}
