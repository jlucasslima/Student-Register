public class Pessoa {
    protected NomePessoa nomePessoa;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nomePessoa = new NomePessoa(nome);
        this.idade = idade;
    }

    public String getNome() {
        return nomePessoa.getValor();
    }

    public String getNomeBiblio() {
        return nomePessoa.getNomeBiblio();
    }

    public int getIdade() {
        return idade;
    }
}