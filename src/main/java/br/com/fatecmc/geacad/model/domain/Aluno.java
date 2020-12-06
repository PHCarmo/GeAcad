package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Aluno extends Pessoa {
    private String status;
    private String ra;
    private Turma turma;
    private int id_pessoa;

    public Aluno() {
        super();
        this.status = "";
        this.ra = "";
        this.turma = new Turma();
        this.id_pessoa = 0;
    }

    public Aluno(String status, String ra, Turma turma, int id_pessoa) {
        this.status = status;
        this.ra = ra;
        this.turma = turma;
        this.id_pessoa = id_pessoa;
    }

    public Aluno(String status, String ra, Turma turma, int id_pessoa, String nome,
            String rg, String cpf, String email, Date data_nascimento, String sexo) {
        super(nome, rg, cpf, email, data_nascimento, sexo);
        this.status = status;
        this.ra = ra;
        this.turma = turma;
        this.id_pessoa = id_pessoa;
    }

    public Aluno(String status, String ra, Turma turma, int id_pessoa, String nome,
            String rg, String cpf, String email, Date data_nascimento, String sexo, int id) {
        super(nome, rg, cpf, email, data_nascimento, sexo, id);
        this.status = status;
        this.ra = ra;
        this.turma = turma;
        this.id_pessoa = id_pessoa;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
}
