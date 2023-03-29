package org.grupo4.implementacoesoo.Domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Professor extends User {
    private double salarioHora;
    private Long cargaHoraria;
    private ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Professor() {
        super();
    }
    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public Long getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Long cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList getTurmas() {
        return turmas;
    }

    public JSONArray getTurmasAsJSON() {
        JSONArray arr = new JSONArray();

        for (Turma turma : turmas) {
            JSONObject respJSON = new JSONObject();
            respJSON.put("nome", turma.getNome());
            arr.add(respJSON);
        }

        return arr;
    }
    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    @Override
    public String toString() {
        String returnString = "Nome: " + nome + "\nCPF: " + cpf + "\nData de Nasc: " + dataNasc + "\nData de pagamento: " + super.payDay +
                "\nCarga Horária: " + cargaHoraria + "\nSalário hora:" + salarioHora;
        return returnString;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("nome", nome);
        jsonObj.put("cpf", cpf);
        jsonObj.put("dataNasc", dataNasc);
        jsonObj.put("payDay", payDay);
        jsonObj.put("cargaHoraria", cargaHoraria);
        jsonObj.put("salarioHora", salarioHora);

        return jsonObj;
    }
}
