package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Turma extends EntidadeDominio {
    private String descricao;
    private Date data_inicio;
    private Curso curso;

    public Turma() {
        super(0);
        this.descricao = "";
        this.data_inicio = new Date();
        this.curso = new Curso();
    }

    public Turma(String descricao, Date data_inicio, Curso curso) {
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.curso = curso;
    }

    public Turma(String descricao, Date data_inicio, Curso curso, int id) {
        super(id);
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    
}
