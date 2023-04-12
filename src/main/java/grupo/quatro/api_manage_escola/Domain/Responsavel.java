package grupo.quatro.api_manage_escola.Domain;

import grupo.quatro.api_manage_escola.Receive.Responsavel.DadosResponsavel;
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

    public Responsavel(DadosResponsavel dados) {
        this.nomeResponsavel = dados.nome();
        this.telefoneResponsavel = dados.telefone();
        this.cpfResponsavel = dados.cpf();
    }

    public void updateInfo(DadosResponsavel dados) {
        if (dados.nome() != null) this.nomeResponsavel = dados.nome();
        if (dados.cpf() != null) this.cpfResponsavel = dados.cpf();
        if (dados.telefone() != null) this.telefoneResponsavel = dados.telefone();

    }

}
