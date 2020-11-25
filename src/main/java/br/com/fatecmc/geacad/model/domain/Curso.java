package br.com.fatecmc.geacad.model.domain;

public class Curso extends EntidadeDominio {
    private String nome;
    private String turno;
    private String descricao;

    public Curso() {
        super(0);
        this.nome = "";
        this.turno = "";
        this.descricao = "";
    }

    public Curso(String nome, String turno, String descricao) {
        this.nome = nome;
        this.turno = turno;
        this.descricao = descricao;
    }

    public Curso(String nome, String turno, String descricao, int id) {
        super(id);
        this.nome = nome;
        this.turno = turno;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
