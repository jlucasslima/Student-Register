/**
 * Classe para armazenar dados de uma pessoa (nome e idade). Utiliza a classe NomePessoa por composicao.
 * 
 * @author Julio Arakaki 
 * @version 1.0 2026/03/23
 */
public class Pessoa {

    // Atributos
    private NomePessoa nome; // Nome de pessoa como composicao (classe NomePessoa)
    private int idade;

    /** 
     * Construtor: constroi objeto Pessoa utilizando como nome a classe NomePessoa
     * 
     * @param nome String com o nome da pessoa que será armazenado
     * @param idade int com a idade da pessoa que será armazenado
     */
    Pessoa(String nome, int idade){

        // Cria objeto da classe NomePessoa
        this.nome = new NomePessoa(nome);

        this.idade = idade;
    }

    public String getNomeBiblio(){
        return(nome.getNomeBiblio());
    }
    
    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return this.nome.toString() + "\nIdade: " + idade;
    }

}
