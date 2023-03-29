package org.grupo4.implementacoesoo.Domain;

import org.json.simple.JSONObject;

public class Administrador extends User {
    protected String id;
    protected String senha;

    public Administrador() {super();}
    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    @Override
    JSONObject toJSON() {
        return null;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {return senha;}
}
