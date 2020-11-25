package br.com.fatecmc.geacad.model.domain;

public class Professor extends Pessoa {
    private String nome;
    private String titulacao;
    
    public Professor() {
        this.nome = "";
        this.titulacao = "";
    }
    
    public Professor(String nome, String titulacao) {
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public Professor(String nome, String titulacao, int id) {
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
