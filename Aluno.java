public class Aluno extends Pessoa {
    private String ra;
    private int semestre;

    public Aluno(String nome, int idade, String ra, int semestre) {
        super(nome, idade);
        this.ra = ra;
        this.semestre = semestre;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return super.toString() + " | RA: " + ra + " | Semestre: " + semestre;
    }
}