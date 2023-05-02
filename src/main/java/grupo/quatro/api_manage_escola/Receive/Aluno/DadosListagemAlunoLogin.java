package grupo.quatro.api_manage_escola.Receive.Aluno;

import grupo.quatro.api_manage_escola.Domain.Aluno;
import grupo.quatro.api_manage_escola.Domain.Turma;
import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosListagemUsuarioLogin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Optional;

@Getter
@Setter
public class DadosListagemAlunoLogin extends DadosListagemUsuarioLogin {

//    BigInteger id, String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento, int anoEscolar, Optional<DadosListagemTurma> turma
    private int anoEscolar;
    private Optional<DadosListagemTurma> turma;

    public DadosListagemAlunoLogin(Aluno aluno) {
        super(aluno.getId(), aluno.getNome(), aluno.getDataDeNascimento(), aluno.getCpf(), aluno.getDiaDePagamento(), UserType.Aluno);
        this.anoEscolar = aluno.getAnoEscolar();
        this.turma = aluno.getTurmaId();
        //        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getDataDeNascimento(), aluno.getDiaDePagamento(), aluno.getAnoEscolar(), aluno.getTurmaId());
    }
}
