package grupo.quatro.api_manage_escola.Usuario;

import grupo.quatro.api_manage_escola.Professor.Professor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Getter
@NoArgsConstructor
@MappedSuperclass
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected BigInteger id;

    protected String nome;
    protected String dataDeNascimento;
    protected BigInteger cpf;
    protected int diaDePagamento;

    public Usuario(String nome, BigInteger cpf, String dataDeNascimento, int diaDePagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.diaDePagamento = diaDePagamento;
        this.dataDeNascimento = dataDeNascimento;
        this.id = cpf;
    }

    public Usuario(Professor professor) {
    }
}

