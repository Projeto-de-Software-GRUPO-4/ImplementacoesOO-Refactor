package grupo.quatro.api_manage_escola.Receive.Aluno;

import grupo.quatro.api_manage_escola.Receive.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosAtualizacaoUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosAtualizacaoAluno extends DadosAtualizacaoUsuario {

        @Valid
        protected DadosResponsavel responsavel;

        protected int anoEscolar;

}
