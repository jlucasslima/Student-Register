package modelo;

/**
 * Classe Aluno: Representa a entidade estudante no sistema.
 */
public class Aluno extends Pessoa {
    private String ra;    // Registro Acadêmico (Matrícula)
    private String curso; // Curso matriculado

    public Aluno(String nome, int idade, String ra, String curso) {
        super(nome, idade);
        this.ra = ra;
        this.curso = curso;
    }

    public String getRa() { return ra; }
    
    // RA geralmente não muda, mas os outros dados sim
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "RA: " + ra + " | Nome: " + getNome() + " | Idade: " + idade + " | Curso: " + curso;
    }
}