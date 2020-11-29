package br.com.fatecmc.geacad.model.domain;

public class Aluno extends EntidadeDominio {
    private String status;
    private String ra;
    private Turma turma;
    private Pessoa pessoa;

    public Aluno() {
        super(0);
        this.status = "";
        this.ra = "";
        this.turma = new Turma();
        this.pessoa = new Pessoa();
    }
    
    public Aluno(String status, String ra, Turma turma, Pessoa pessoa) {
        this.status = status;
        this.ra = ra;
        this.turma = turma;
        this.pessoa = pessoa;
    }

    public Aluno(String status, String ra, Turma turma, Pessoa pessoa, int id) {
        super(id);
        this.status = status;
        this.ra = ra;
        this.turma = turma;
        this.pessoa = pessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
