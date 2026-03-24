import javax.swing.JOptionPane;

public class MenuGrafico implements IMenu {

    @Override
    public void exibirMenu(CadastroAlunos cadastro) {
        String textoMenu = "1 - inserir\n"
                         + "2 - remover\n"
                         + "3 - listar\n"
                         + "4 - sair\n\n"
                         + "Selecione a opcao:";

        boolean executando = true;

        while (executando) {
            String opcaoStr = JOptionPane.showInputDialog(null, textoMenu, "Entrada", JOptionPane.QUESTION_MESSAGE);

            if (opcaoStr == null) {
                break;
            }

            switch (opcaoStr) {
                case "1":
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
                    if (nome != null && !nome.trim().isEmpty()) {
                        try {
                            int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:"));
                            String ra = JOptionPane.showInputDialog("Digite o RA do aluno:");
                            String curso = JOptionPane.showInputDialog("Digite o curso do aluno:");
                            
                            Aluno novoAluno = new Aluno(nome, idade, ra, curso);
                            
                            if (cadastro.inserir(novoAluno)) {
                                JOptionPane.showMessageDialog(null, "Aluno inserido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Atenção: A lista de alunos está cheia!", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Erro: A idade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case "2":
                    // AQUI MUDOU: Agora pede o RA!
                    String raRemover = JOptionPane.showInputDialog("Digite o RA do aluno para remover:");
                    if (raRemover != null && !raRemover.trim().isEmpty()) {
                        if (cadastro.remover(raRemover)) {
                            JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Aluno não encontrado na lista.");
                        }
                    }
                    break;

                case "3":
                    Aluno[] lista = cadastro.listar();
                    if (lista.length == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado no momento.");
                    } else {
                        StringBuilder sb = new StringBuilder("Lista de Alunos Cadastrados:\n\n");
                        for (Aluno a : lista) {
                            sb.append("- ").append(a.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;

                case "4":
                    executando = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite de 1 a 4.");
            }
        }
    }
}