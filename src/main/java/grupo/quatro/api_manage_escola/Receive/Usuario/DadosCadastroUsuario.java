package grupo.quatro.api_manage_escola.Receive.Usuario;

import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Receive.Responsavel.DadosResponsavel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosCadastroUsuario {
    @NotNull
    @NotBlank
    String nome;

    @NotNull
    @Pattern(regexp = "\\d{11}")
    String cpf;

    @NotNull
    @NotBlank
    String dataDeNascimento;

    @NotNull
    int diaDePagamento;

    @NotNull
    @NotBlank
    String senha;

    @NotNull
    @Valid UserType userType;
}
