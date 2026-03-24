
/**
 * Write a description of class TestaAluno here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestaAluno {
    public static void main(String args[]) {
        Aluno a = new Aluno("Ze da Silva Pereira Antunes", 22, "RA123456", "Engenharia Civil", 3);

        System.out.println(a);
        System.out.println("Nome bibliografico: " + a.getNomeBiblio());
    }
}