package grupo.quatro.api_manage_escola.Receive.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosAtualizacaoUsuario {
    @NotNull
    protected BigInteger id;

    protected String nome;
    protected int diaDePagamento;
}
