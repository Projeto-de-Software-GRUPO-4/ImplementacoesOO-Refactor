package grupo.quatro.api_manage_escola.Receive.Professor;

import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosAtualizacaoProfessor extends DadosAtualizacaoUsuario {

    protected int cargaHorariaDiaria;
    protected double salarioHora;

}
