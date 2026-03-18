public interface Armazenador {
    boolean inserir(Aluno aluno);
    boolean remover(String ra);
    void listar();
}