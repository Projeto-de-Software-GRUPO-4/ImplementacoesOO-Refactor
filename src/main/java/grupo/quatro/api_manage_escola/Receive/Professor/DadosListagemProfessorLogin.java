package grupo.quatro.api_manage_escola.Receive.Professor;


import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Domain.UserType;
import grupo.quatro.api_manage_escola.Receive.Turma.DadosListagemTurma;
import grupo.quatro.api_manage_escola.Receive.Usuario.DadosListagemUsuarioLogin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
public class DadosListagemProfessorLogin extends DadosListagemUsuarioLogin {

//    BigInteger id, String nome, String dataDeNascimento, BigInteger cpf, int diaDePagamento, int cargaHorariaDiaria, double salarioHora, List<DadosListagemTurma> turmas

   private int cargaHorariaDiaria;
   private double salarioHora;
   private List<DadosListagemTurma> turmas;

   private BigInteger materia_id;
    public DadosListagemProfessorLogin(Professor professor) {
//        this(professor.getId(), professor.getNome(), professor.getDataDeNascimento(), professor.getCpf(), professor.getDiaDePagamento(), professor.getCargaHorariaDiaria(), professor.getSalarioHora(), professor.getTurmasId());
        super(professor.getId(), professor.getNome(), professor.getDataDeNascimento(), professor.getCpf(), professor.getDiaDePagamento(), UserType.Professor);
        this.cargaHorariaDiaria = professor.getCargaHorariaDiaria();
        this.salarioHora = professor.getSalarioHora();
        this.turmas = professor.getTurmasId();
        this.materia_id = professor.getMateria().getId();
    }


}
