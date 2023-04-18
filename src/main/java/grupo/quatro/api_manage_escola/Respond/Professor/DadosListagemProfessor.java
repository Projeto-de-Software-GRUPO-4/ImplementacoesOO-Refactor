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
    protected int cargaHoraria;
    protected double salarioHora;

    public DadosListagemProfessor(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.dataDeNascimento = professor.getDataDeNascimento();
        this.cpf = professor.getCpf();
        this.diaDePagamento = professor.getDiaDePagamento();
        this.cargaHoraria = professor.getCargaHorariaDiaria();
        this.salarioHora = professor.getSalarioHora();
    }

    public DadosListagemProfessor(DadosListagemProfessor dados) {
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.dataDeNascimento = dados.getDataDeNascimento();
        this.cpf = dados.getCpf();
        this.diaDePagamento = dados.getDiaDePagamento();
        this.cargaHoraria = dados.getCargaHoraria();
        this.salarioHora = dados.getSalarioHora();
    }

}
