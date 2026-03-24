public class ArmazenadorArray implements IArmazenador {
    private Aluno[] alunos;
    private int indice;

    public ArmazenadorArray(int tamanhoMaximo) {
        this.alunos = new Aluno[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public boolean inserir(Aluno aluno) {
        if (indice < alunos.length) {
            alunos[indice] = aluno;
            indice++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remover(String nome) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i].getNome().equalsIgnoreCase(nome)) {
                for (int j = i; j < indice - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[indice - 1] = null;
                indice--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Aluno[] listar() {
        Aluno[] alunosCadastrados = new Aluno[indice];
        for (int i = 0; i < indice; i++) {
            alunosCadastrados[i] = alunos[i];
        }
        return alunosCadastrados;
    }
}