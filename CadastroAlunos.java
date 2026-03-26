/**
 * Classe controladora que faz a ponte entre a interface do usuário (Menu) 
 * e a camada de dados (Armazenador).
 */
public class CadastroAlunos {
    // Depende da abstração (Interface) e não de uma implementação concreta
    private IArmazenador armazenador;

    /**
     * Construtor que inicializa o armazenamento em memória (Array)
     * com a capacidade máxima definida pelo usuário.
     */
    public CadastroAlunos(int qtde) {
        this.armazenador = new ArmazenadorArray(qtde);
    }

    // Repassa a chamada de inserção para a camada de dados
    public boolean inserir(Aluno aluno) {
        return armazenador.inserir(aluno);
    }

    // Repassa a chamada de remoção buscando pelo RA
    public boolean remover(String ra) {
        return armazenador.remover(ra);
    }

    // Solicita a lista atualizada de alunos
    public Aluno[] listar() {
        return armazenador.listar();
    }
}