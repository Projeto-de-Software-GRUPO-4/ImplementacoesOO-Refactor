package grupo.quatro.api_manage_escola.LogIn;

import java.math.BigInteger;

public record DadosResponseLogin(
        BigInteger id, String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar
) {
}
