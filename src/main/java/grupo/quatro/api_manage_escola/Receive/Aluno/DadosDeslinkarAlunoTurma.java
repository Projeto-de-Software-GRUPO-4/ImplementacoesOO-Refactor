package grupo.quatro.api_manage_escola.Receive.Aluno;

import grupo.quatro.api_manage_escola.Receive.Usuario.DadosDeslinkarUsuarioTurma;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosDeslinkarAlunoTurma extends DadosDeslinkarUsuarioTurma {
    @NotNull
    @Override
    public BigInteger getId_usuario() {
        return super.getId_usuario();
    }

    @NotNull
    @Override
    public BigInteger getId_turma() {
        return super.getId_turma();
    }
}
