package grupo.quatro.api_manage_escola.Aluno;


import grupo.quatro.api_manage_escola.Responsavel.DadosResponsavel;
import grupo.quatro.api_manage_escola.UserType.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(
        @NotNull
        @NotBlank
        String nome,

        @NotNull
        @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull
        @NotBlank
        String dataDeNascimento,

        @Valid
        DadosResponsavel responsavel,

        @NotNull
        int diaDePagamento,

        @NotNull
        int anoEscolar,

        @NotNull
        @NotBlank
        String senha,

        @NotNull
        @Valid UserType userType

) {}
