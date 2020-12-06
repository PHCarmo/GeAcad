package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Professor extends Pessoa {
    private double salario;
    private String titulacao;
    private int id_pessoa;
    
    public Professor() {
        super();
        this.salario = 0.0;
        this.titulacao = "";
        this.id_pessoa = 0;
    }

    public Professor(double salario, String titulacao, int id_pessoa) {
        this.salario = salario;
        this.titulacao = titulacao;
        this.id_pessoa = id_pessoa;
    }

    public Professor(double salario, String titulacao, int id_pessoa, String nome,
            String rg, String cpf, String email, Date data_nascimento, String sexo) {
        super(nome, rg, cpf, email, data_nascimento, sexo);
        this.salario = salario;
        this.titulacao = titulacao;
        this.id_pessoa = id_pessoa;
    }

    public Professor(double salario, String titulacao, int id_pessoa, String nome,
            String rg, String cpf, String email, Date data_nascimento, String sexo, int id) {
        super(nome, rg, cpf, email, data_nascimento, sexo, id);
        this.salario = salario;
        this.titulacao = titulacao;
        this.id_pessoa = id_pessoa;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
}
