public class TestePessoa {
    public static void main(String[] args) {
        System.out.println("=== Teste da Classe Pessoa ===");
        Pessoa p = new Pessoa("Carlos Eduardo da Silva", 25);
        
        System.out.println(p.toString());
        System.out.println("Nome Invertido: " + p.getNomePessoa().getNomeInvertido());
        System.out.println("Nome Bibliografia: " + p.getNomePessoa().getNomeBiblio());
    }
}