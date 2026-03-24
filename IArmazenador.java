public interface IArmazenador {
    boolean inserir(Aluno aluno);
    boolean remover(String nome);
    Aluno[] listar();
}