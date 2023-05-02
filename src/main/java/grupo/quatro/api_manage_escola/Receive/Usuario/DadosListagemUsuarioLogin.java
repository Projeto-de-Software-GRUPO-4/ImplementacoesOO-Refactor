package grupo.quatro.api_manage_escola.Receive.Usuario;

import grupo.quatro.api_manage_escola.Domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosListagemUsuarioLogin {
    //Professor
//    java.math.BigInteger id, String nome, String dataDeNascimento, BigInteger cpf, int diaDePagamento, int cargaHorariaDiaria, double salarioHora, List<DadosListagemTurma> turmas

    //Aluno
//    BigInteger id, String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar, Optional<DadosListagemTurma> turma

    private BigInteger id;
    private String nome;

    private String dataDeNascimento;

    private BigInteger cpf;

    private int diaDePagamento;

    private UserType userType;


}
