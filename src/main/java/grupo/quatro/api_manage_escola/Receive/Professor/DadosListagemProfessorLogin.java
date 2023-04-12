package grupo.quatro.api_manage_escola.Receive.Professor;


import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;

import java.math.BigInteger;
import java.util.List;

public record DadosListagemProfessorLogin(
        BigInteger id, String nome, String dataDeNascimento, BigInteger cpf, int diaDePagamento, int cargaHorariaDiaria, double salarioHora, List<DadosListagemTurma> turmas
) {

    public DadosListagemProfessorLogin(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getDataDeNascimento(), professor.getCpf(), professor.getDiaDePagamento(), professor.getCargaHorariaDiaria(), professor.getSalarioHora(), professor.getTurmasId());
    }


}
