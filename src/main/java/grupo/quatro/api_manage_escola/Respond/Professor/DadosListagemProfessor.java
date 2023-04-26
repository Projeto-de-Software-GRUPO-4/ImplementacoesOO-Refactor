package grupo.quatro.api_manage_escola.Respond.Professor;

import grupo.quatro.api_manage_escola.Domain.Professor;
import grupo.quatro.api_manage_escola.Respond.Usuario.DadosListagemUsuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class DadosListagemProfessor extends DadosListagemUsuario {


//    String nome, String dataDeNascimento, BigInteger cpf, int diaDePagamento, int cargaHorariaDiaria, double salarioHora
    protected int cargaHorariaDiaria;
    protected double salarioHora;

    protected String telefone;

    public DadosListagemProfessor(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.dataDeNascimento = professor.getDataDeNascimento();
        this.cpf = professor.getCpf();
        this.diaDePagamento = professor.getDiaDePagamento();
        this.cargaHorariaDiaria = professor.getCargaHorariaDiaria();
        this.salarioHora = professor.getSalarioHora();
        this.telefone = professor.getTelefone();
    }

}
