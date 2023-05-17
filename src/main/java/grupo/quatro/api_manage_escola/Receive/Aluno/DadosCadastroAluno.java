package grupo.quatro.api_manage_escola.Receive.Aluno;


import grupo.quatro.api_manage_escola.Receive.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosCadastroUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosCadastroAluno extends DadosCadastroUsuario {

        @Valid
        protected DadosResponsavel responsavel;

        protected double mensalidade;

}
