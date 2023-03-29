package org.grupo4.implementacoesoo.Domain;

import java.io.Serializable;
import java.util.HashMap;

public class Responsavel {
    private String nome;
    private String telefone;

    public Responsavel(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
