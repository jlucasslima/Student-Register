public interface IArmazenador {
    boolean inserir(Aluno aluno);
    boolean remover(String ra);
    Aluno[] listar();
}