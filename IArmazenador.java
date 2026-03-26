/**
 * Interface que define o contrato para o armazenamento de alunos.
 * Aplica o Princípio da Inversão de Dependência (SOLID), permitindo que 
 * o sistema não dependa de uma implementação específica (como Array ou Banco de Dados).
 */
public interface IArmazenador {
    
    // Tenta inserir um aluno e retorna true se houver sucesso
    boolean inserir(Aluno aluno);
    
    // Busca um aluno pelo RA (identificador único) e o remove do armazenamento
    boolean remover(String ra);
    
    // Retorna um vetor contendo todos os alunos atualmente cadastrados
    Aluno[] listar();
}