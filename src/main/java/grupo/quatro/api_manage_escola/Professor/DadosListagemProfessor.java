package grupo.quatro.api_manage_escola.Professor;

import java.math.BigInteger;

public record DadosListagemProfessor(String nome, String dataDeNascimento, BigInteger cpf, String areaEnsino, int diaDePagamento, int cargaHorariaDiaria, double salarioHora) {
    public DadosListagemProfessor(Professor professor) {
        this(professor.getNome(), professor.getDataDeNascimento(), professor.getCpf(), professor.getAreaEnsino(), professor.getDiaDePagamento(), professor.getCargaHorariaDiaria(), professor.getSalarioHora());
    }

}
