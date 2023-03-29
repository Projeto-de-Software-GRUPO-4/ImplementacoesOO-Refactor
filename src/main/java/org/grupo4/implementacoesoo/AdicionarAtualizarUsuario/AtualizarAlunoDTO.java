package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.Responsavel;
import org.grupo4.implementacoesoo.Domain.Turma;

import java.util.ArrayList;

public class AtualizarAlunoDTO {
    private ArrayList<Responsavel> responsaveis = new ArrayList<>();

    private long serie;
    private String ensino;
    private String turno;
    private String mensalidade;
    private boolean suspenso;

    public ArrayList<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void addResponsavel(Responsavel responsavel) {
        responsaveis.add(responsavel);
    }

    public long getSerie() {
        return serie;
    }

    public void setSerie(long serie) {
        this.serie = serie;
    }

    public String getEnsino() {
        return ensino;
    }

    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public boolean isSuspenso() {
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }
}
