
/**
 * Write a description of interface IArmazenador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IArmazenador {
    /**
     * inserir - insere um aluno na estrutura de dados
     *
     * @param  a - objeto aluno a ser inserido no armazenador
     * @return boolean  true - com sucesso, false - falha na inserção
     */
    public boolean inserir(Aluno a);

    /**
     * remover - insere um aluno na estrutura de dados
     *
     * @param  ra - String representando o ra do aluno
     * @return boolean  true - com sucesso, false - falha na remoção
     */
    public boolean remover (String ra);
    
}