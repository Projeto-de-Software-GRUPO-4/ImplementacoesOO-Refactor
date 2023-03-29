package org.grupo4.implementacoesoo.Domain;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class Aluno extends User {


    private ArrayList<Responsavel> responsaveis = new ArrayList<>();

    private long serie;
    private String ensino;
    private String turno;
//    private int numeroDeMatricula = NumeroMatricula.numeroCreator();
    private long numeroDeMatricula = 1232343;
    private String mensalidade;
    private boolean suspenso;


    public Aluno() {
        super();
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
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

    public long getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public void setNumeroDeMatricula(long numeroDeMatricula) {
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void addResponsavel(Responsavel responsavel) {
        responsaveis.add(responsavel);
    }

    public ArrayList getResponsaveis() {
        return responsaveis;
    }

    public JSONArray getResponsaveisAsJSON() {
        JSONArray arr = new JSONArray();

        for (Responsavel resp : responsaveis) {
            JSONObject respJSON = new JSONObject();
            respJSON.put("nome", resp.getNome());
            respJSON.put("telefone", resp.getTelefone());
            arr.add(respJSON);
        }

        return arr;
    }

    @Override
    public String toString() {
        String returnString = "Nome: " + nome + "\nCPF: " + cpf + "\nData de Nasc: " + dataNasc + "\nData de pagamento: " + super.payDay + "\nMensalidade: " + mensalidade +
                "\nNúmero de matrícula: " + numeroDeMatricula + "\nTurno: " + turno + "\nSérie: " + serie + "\nEnsino: " + ensino + "\nSuspenso: " + suspenso + "\nResponsavel1: "
                + responsaveis.get(0).getNome();
        return returnString;
    }


    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("nome", nome);
        jsonObj.put("cpf", cpf);
        jsonObj.put("dataNasc", dataNasc);
        jsonObj.put("payDay", payDay);
        jsonObj.put("mensalidade", mensalidade);
        jsonObj.put("numeroDeMatricula", numeroDeMatricula);
        jsonObj.put("turno", turno);
        jsonObj.put("serie", serie);
        jsonObj.put("ensino", ensino);
        jsonObj.put("suspenso", suspenso);
        jsonObj.put("responsaveis", getResponsaveisAsJSON());

        return jsonObj;
    }


    public boolean getSuspenso(){
        return suspenso;
    }

    public void setSuspenso(boolean suspenso) {
        this.suspenso = suspenso;
    }



}

