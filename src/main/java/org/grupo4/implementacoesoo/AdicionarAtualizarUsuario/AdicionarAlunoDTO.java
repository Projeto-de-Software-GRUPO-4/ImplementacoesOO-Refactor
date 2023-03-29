package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.Responsavel;

import java.util.ArrayList;

public class AdicionarAlunoDTO extends AdicionarDTO {

    public AdicionarAlunoDTO() {
        super();
    }
    private ArrayList<Responsavel> responsaveis = new ArrayList<>();
    private long serie;
    private String ensino;
    private String turno;
    private String mensalidade;

    public ArrayList<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(ArrayList<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
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

}
