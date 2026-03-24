public class TestaAluno {
    public static void main(String[] args) {
        Aluno a = new Aluno("Ze da Silva Pereira Antunes", 22, "RA123456", "Engenharia");
        
        System.out.println(a);
        System.out.println("Nome bibliografico: " + a.getNomeBiblio());
    }
}