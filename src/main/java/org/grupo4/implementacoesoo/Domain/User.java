package org.grupo4.implementacoesoo.Domain;

import org.json.simple.JSONObject;

public abstract class User {
    protected String nome;
    protected String cpf;
    protected String dataNasc;
    protected long payDay;

    abstract JSONObject toJSON();

    public User() {
        this.nome = "DEFAULT";
        this.cpf = "0";
        this.dataNasc = "XX/XX/XXXX";
    }
    public User(String nome, String cpf, String dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    // Getters e setters
    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String getDataNasc() {
        return this.dataNasc;
    }

    public long getPayDay() {
        return this.payDay;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setPayDay(long payDay) {
        this.payDay = payDay;
    }

}