package grupo.quatro.api_manage_escola.Respond.Usuario;

import grupo.quatro.api_manage_escola.Domain.Turma;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosListagemUsuario {
    protected BigInteger id;
    protected String nome;
    protected BigInteger cpf;
    protected String dataDeNascimento;
    protected int diaDePagamento;
}
