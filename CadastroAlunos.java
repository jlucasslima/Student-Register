public class CadastroAlunos implements Armazenador {
    private Aluno[] alunos;
    private int totalAlunos;

    public CadastroAlunos(int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.totalAlunos = 0;
    }

    private boolean existeRA(String ra) {
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getRa().equals(ra)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean inserir(Aluno aluno) {
        if (totalAlunos >= alunos.length) {
            System.out.println("Cadastro cheio!");
            return false;
        }
        if (existeRA(aluno.getRa())) {
            System.out.println("Erro: Aluno com RA " + aluno.getRa() + " já cadastrado.");
            return false;
        }
        alunos[totalAlunos] = aluno;
        totalAlunos++;
        System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso!");
        return true;
    }

    @Override
    public boolean remover(String ra) {
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getRa().equals(ra)) {
                for (int j = i; j < totalAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[totalAlunos - 1] = null;
                totalAlunos--;
                System.out.println("Aluno com RA " + ra + " removido com sucesso!");
                return true;
            }
        }
        System.out.println("Erro: Aluno com RA " + ra + " não encontrado.");
        return false;
    }

    @Override
    public void listar() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("--- Lista de Alunos ---");
        for (int i = 0; i < totalAlunos; i++) {
            System.out.println(alunos[i].toString());
        }
        System.out.println("-----------------------");
    }
}