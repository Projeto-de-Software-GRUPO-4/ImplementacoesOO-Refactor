package org.grupo4.implementacoesoo.AdicionarAtualizarUsuario;

import org.grupo4.implementacoesoo.Domain.Turma;

import java.util.ArrayList;

public class AdicionarProfessorDTO extends AdicionarDTO {

    public AdicionarProfessorDTO() {
        super();
    }


    private String senha;
    private double salarioHora;
    private Long cargaHoraria;
    private ArrayList<Turma> turmas;

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

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
