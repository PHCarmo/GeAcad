package br.com.fatecmc.geacad.model.domain;

public class Curso extends EntidadeDominio {
    private String nome;
    private String turno;
    private String descricao;
    private int duracao;

    public Curso() {
        super(0);
        this.nome = "";
        this.turno = "";
        this.descricao = "";
        this.duracao = 0;
    }

    public Curso(String nome, String turno, String descricao, int duracao) {
        this.nome = nome;
        this.turno = turno;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Curso(String nome, String turno, String descricao, int duracao, int id) {
        super(id);
        this.nome = nome;
        this.turno = turno;
        this.descricao = descricao;
        this.duracao = duracao;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
