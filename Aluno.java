/**
 * Classe para armazenar dados de um aluno, onde nome e idade (por heranca). 
 * Utiliza a classe Pessoa por herança (vide extends).
 * 
 * @author Julio Arakaki 
 * @version 1.0 2026/03/23
 */
public class Aluno extends Pessoa {
    // Atributos do aluno    
    String ra;
    String curso;
    int semestre;
    
    //Disciplinas [] disc;

    /** 
     * Construtor: constroi objeto Aluno recebendo os parametros como parametros.  
     * Obs: os parametros nome e idade, são passados para a classe pai (Pessoa)
     * 
     * @param nome String nome do aluno
     * @param idade int idade do aluno
     * @param ra String ra do aluno
     * @param curso String curso do aluno
     * @param semestre int semestre em que o aluno esta matriculado
     */    
    Aluno(String nome, int idade, String ra, String curso, int semestre){
        // Envia para a classe pai: "aciona" o construtor da classe pai (Pessoa)
        super(nome, idade);
        
        // Dadows locais (soemnte do aluno)
        this.ra = ra;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getNomeBiblio(){
        return super.getNomeBiblio();
    }
    
    
    /**
     * Retorna os atributos como string
     */
    public String toString(){
        return super.toString() + "\nra: " + ra + "\nCurso: " + curso + "\nSemestre: " + semestre;
    }
}
