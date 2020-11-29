package br.com.fatecmc.geacad.model.domain;

public class Disciplina extends EntidadeDominio {
    private String nome;
    private int carga_horaria;
    private String ementa;
    private String objetivo;
    private String bibliografia;
    private int semestre_recomendado;
    private Curso curso;
    private Professor professor;

    public Disciplina() {
        super(0);
        this.nome = "";
        this.carga_horaria = 0;
        this.ementa = "";
        this.objetivo = "";
        this.bibliografia = "";
        this.semestre_recomendado = 0;
        this.curso = new Curso();
        this.professor = new Professor();
    }

    public Disciplina(String nome, int carga_horaria, String ementa, String objetivo,
            String bibliografia, int semestre_recomendado, Curso curso, Professor professor) {
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.ementa = ementa;
        this.objetivo = objetivo;
        this.bibliografia = bibliografia;
        this.semestre_recomendado = semestre_recomendado;
        this.curso = curso;
        this.professor = professor;
    }

    public Disciplina(String nome, int carga_horaria, String ementa, String objetivo,
            String bibliografia, int semestre_recomendado, Curso curso, Professor professor, int id) {
        super(id);
        this.nome = nome;
        this.carga_horaria = carga_horaria;
        this.ementa = ementa;
        this.objetivo = objetivo;
        this.bibliografia = bibliografia;
        this.semestre_recomendado = semestre_recomendado;
        this.curso = curso;
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getSemestre_recomendado() {
        return semestre_recomendado;
    }

    public void setSemestre_recomendado(int semestre_recomendado) {
        this.semestre_recomendado = semestre_recomendado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
    
}
