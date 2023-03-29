package org.grupo4.implementacoesoo.SuspenderAluno;

public class SuspenderAlunoDTO {

    String id;
    boolean suspenso;

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
