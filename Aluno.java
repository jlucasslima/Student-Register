/**
 * Classe Aluno: Representa a entidade estudante no sistema.
 * Estende a classe Pessoa para reaproveitar atributos como nome e idade.
 */
public class Aluno extends Pessoa {
    private String ra;    // Registro Acadêmico
    private String curso; // Curso matriculado

    public Aluno(String nome, int idade, String ra, String curso) {
        // Chama o construtor da classe pai (Pessoa)
        super(nome, idade);
        this.ra = ra;
        this.curso = curso;
    }

    public String getRa() { return ra; }
    public String getCurso() { return curso; }

    /**
     * Sobrescrita do método toString para exibição formatada na UI.
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + " | Idade: " + idade + " | RA: " + ra + " | Curso: " + curso;
    }
}