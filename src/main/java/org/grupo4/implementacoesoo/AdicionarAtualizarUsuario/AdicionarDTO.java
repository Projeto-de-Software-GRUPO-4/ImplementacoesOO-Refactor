package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

public class AdicionarDTO {
    private String nome;
    private String cpf;
    private String dataNasc;
    private long payDay;

    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public long getPayDay() {
        return payDay;
    }

    public void setPayDay(long payDay) {
        this.payDay = payDay;
    }
}
