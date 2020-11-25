package br.com.fatecmc.geacad.model.domain;

public class Turma extends EntidadeDominio {
    private String descricao;
    private Curso curso;

    public Turma() {
        super(0);
        this.descricao = "";
        this.curso = new Curso();
    }

    public Turma(String descricao, Curso curso) {
        this.descricao = descricao;
        this.curso = curso;
    }

    public Turma(String descricao, Curso curso, int id) {
        super(id);
        this.descricao = descricao;
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
    
}
