package grupo.quatro.api_manage_escola.Receive.Professor;

import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosCadastroProfessor extends DadosCadastroUsuario {

        @NotNull
        protected int diaDePagamento;
        protected int cargaHorariaDiaria;
        protected double salarioHora;


}
