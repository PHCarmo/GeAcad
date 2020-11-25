package br.com.fatecmc.geacad.model.domain;

import java.util.Date;

public class Pessoa extends EntidadeDominio {
    private String nome;
    private String rg;
    private int cpf;
    private String email;
    private Date data_nascimento;
    private String sexo;
    
    public Pessoa() {
        super(0);
        this.nome = "";
        this.rg = "";
        this.cpf = 0;
        this.email = "";
        this.data_nascimento = new Date();
        this.sexo = "";
    }

    public Pessoa(String nome, String rg, int cpf, String email, Date data_nascimento, String sexo) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
    }

    public Pessoa(String nome, String rg, int cpf, String email, Date data_nascimento, String sexo, int id) {
        super(id);
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
}
