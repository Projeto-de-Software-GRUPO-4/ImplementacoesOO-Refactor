package grupo.quatro.api_manage_escola.Professor;


import java.math.BigInteger;
import java.util.List;

public record DadosListagemProfessorLogin(
        BigInteger id, String nome, String dataDeNascimento, BigInteger cpf, String areaEnsino, int diaDePagamento, int cargaHorariaDiaria, double salarioHora, List<BigInteger> turmasId
) {

    public DadosListagemProfessorLogin(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getDataDeNascimento(), professor.getCpf(), professor.getAreaEnsino(), professor.getDiaDePagamento(), professor.getCargaHorariaDiaria(), professor.getSalarioHora(), professor.getTurmasId());
    }


}
