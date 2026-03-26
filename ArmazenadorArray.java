/**
 * Implementação concreta de IArmazenador.
 * Gerencia os dados dos alunos na memória utilizando um Array (Vetor) de tamanho fixo.
 */
public class ArmazenadorArray implements IArmazenador {
    private Aluno[] alunos;
    private int indice; // Controla a quantidade atual e a próxima posição vazia

    public ArmazenadorArray(int tamanhoMaximo) {
        this.alunos = new Aluno[tamanhoMaximo];
        this.indice = 0;
    }

    @Override
    public boolean inserir(Aluno aluno) {
        // Verifica se ainda há espaço disponível no array
        if (indice < alunos.length) {
            alunos[indice] = aluno;
            indice++;
            return true;
        }
        return false; // Retorna falso se a capacidade máxima for atingida
    }

    @Override
    public boolean remover(String ra) {
        // Percorre os elementos ativos buscando pelo RA informado
        for (int i = 0; i < indice; i++) {
            // CORREÇÃO: Agora a comparação é feita de forma exata pelo RA (ignorando maiúsculas/minúsculas)
            if (alunos[i].getRa().equalsIgnoreCase(ra)) {
                
                // Algoritmo de deslocamento (shift left): 
                // Puxa todos os elementos à direita do removido uma posição para a esquerda
                for (int j = i; j < indice - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                
                // Limpa a última posição que ficou duplicada após o deslocamento
                alunos[indice - 1] = null;
                indice--; // Atualiza o contador de alunos ativos
                return true;
            }
        }
        return false; // Retorna falso se o RA não for encontrado
    }

    @Override
    public Aluno[] listar() {
        // Cria um novo array apenas com o tamanho exato dos alunos cadastrados (sem as posições nulas)
        Aluno[] alunosCadastrados = new Aluno[indice];
        for (int i = 0; i < indice; i++) {
            alunosCadastrados[i] = alunos[i];
        }
        return alunosCadastrados;
    }
}