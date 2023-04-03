package grupo.quatro.api_manage_escola.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@MappedSuperclass
public class Usuario {
    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private int diaDePagamento;

    public Usuario(String nome, String cpf, String dataDeNascimento, int diaDePagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.diaDePagamento = diaDePagamento;
        this.dataDeNascimento = dataDeNascimento;
    }
}

