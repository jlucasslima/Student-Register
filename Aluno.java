public class Aluno extends Pessoa {
    private String ra;
    private String curso;

    public Aluno(String nome, int idade, String ra, String curso) {
        super(nome, idade);
        this.ra = ra;
        this.curso = curso;
    }

    public String getRa() {
        return ra;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | Idade: " + idade + " | RA: " + ra + " | Curso: " + curso;
    }
}