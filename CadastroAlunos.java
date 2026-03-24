public class CadastroAlunos {
    private IArmazenador armazenador;

    public CadastroAlunos(int qtde) {
        this.armazenador = new ArmazenadorArray(qtde);
    }

    public boolean inserir(Aluno aluno) {
        return armazenador.inserir(aluno);
    }

    public boolean remover(String nome) {
        return armazenador.remover(nome);
    }

    public Aluno[] listar() {
        return armazenador.listar();
    }
}