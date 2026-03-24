
/**
 * Write a description of class CadastroAluno here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArmazenadorArray implements IArmazenador {
    
    // Armazenador de alunos
    Aluno[] arm;
    
    ArmazenadorArray(int qtde){
        arm = new Aluno[qtde];
    }

    /**
     * inserir - insere um aluno na estrutura de dados
     *
     * @param  a - objeto aluno a ser inserido no armazenador
     * @return boolean  true - com sucesso, false - falha na inserção
     */
    public boolean inserir(Aluno a){
        // TODO
        
        return true;
    }
    

    /**
     * remover - insere um aluno na estrutura de dados
     *
     * @param  ra - String representando o ra do aluno
     * @return boolean  true - com sucesso, false - falha na remoção
     */
    public boolean remover (String ra){
        // TODO
        
        return true;
    }
    
}