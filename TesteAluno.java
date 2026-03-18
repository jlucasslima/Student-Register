public class TesteAluno {
    public static void main(String[] args) {
        System.out.println("=== Teste da Classe Aluno e Cadastro ===");
        
        CadastroAlunos cadastro = new CadastroAlunos(5);
        
        Aluno a1 = new Aluno("Ana Maria de Souza", 20, "RA123", 3);
        Aluno a2 = new Aluno("Pedro Henrique do Carmo", 22, "RA456", 5);
        Aluno a3 = new Aluno("Joao Lucas", 21, "RA123", 4); 
        
        cadastro.inserir(a1);
        cadastro.inserir(a2);
        cadastro.inserir(a3); // Falha intencional pelo RA duplicado
        
        System.out.println("\nListando após inserções:");
        cadastro.listar();
        
        cadastro.remover("RA123");
        
        System.out.println("\nListando após remoção:");
        cadastro.listar();
    }
}