package br.com.fatecmc.geacad.model.domain;

public class Professor extends EntidadeDominio {
    private double salario;
    private String titulacao;
    private Pessoa pessoa;
    
    public Professor() {
        super(0);
        this.salario = 0.0;
        this.titulacao = "";
        this.pessoa = new Pessoa();
    }
    
    public Professor(double salario, String titulacao, Pessoa pessoa) {
        this.salario = salario;
        this.titulacao = titulacao;
        this.pessoa = pessoa;
    }

    public Professor(double salario, String titulacao, Pessoa pessoa, int id) {
        super(id);
        this.salario = salario;
        this.titulacao = titulacao;
        this.pessoa = pessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
