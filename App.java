import controle.CadastroAlunos;
import visao.IMenu;
import visao.MenuGrafico;
import visao.MenuTexto;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Classe principal que inicia o sistema.
 */
public class App {
    public static void main(String[] args) {
        
        // 1. Pergunta inicial para definir o modo de operação
        Object[] opcoesModo = {"Interface Gráfica", "Modo Texto (Console)"};
        int escolhaModo = JOptionPane.showOptionDialog(null, 
                "Selecione como deseja executar o sistema:", 
                "Seleção de Interface", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, opcoesModo, opcoesModo[0]);

        if (escolhaModo == -1) {
            System.exit(0); // Usuário fechou a janela
        }

        IMenu menu;
        int qtde = 0;

        // 2. Configura a injeção de dependência dependendo da escolha
        if (escolhaModo == 0) { // MODO GRÁFICO
            String inputQtde = JOptionPane.showInputDialog(null, "Para iniciar, defina a capacidade máxima de alunos:", "Configuração Inicial", JOptionPane.QUESTION_MESSAGE);
            if (inputQtde == null || inputQtde.trim().isEmpty()) System.exit(0);
            
            try {
                qtde = Integer.parseInt(inputQtde.trim());
                if (qtde <= 0) {
                    JOptionPane.showMessageDialog(null, "A capacidade deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: A capacidade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            menu = new MenuGrafico();

        } else { // MODO TEXTO
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== CONFIGURAÇÃO INICIAL ===");
            System.out.print("Para iniciar, defina a capacidade máxima de alunos: ");
            String inputQtde = scanner.nextLine().trim();
            
            try {
                qtde = Integer.parseInt(inputQtde);
                if (qtde <= 0) {
                    System.out.println("[ERRO] A capacidade deve ser maior que zero.");
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] A capacidade deve ser um número inteiro.");
                System.exit(0);
            }
            
            menu = new MenuTexto();
        }

        // 3. Inicia o sistema propriamente dito
        CadastroAlunos ca = new CadastroAlunos(qtde);
        menu.exibirMenu(ca); // O polimorfismo resolve qual exibirMenu() será chamado
    }
}