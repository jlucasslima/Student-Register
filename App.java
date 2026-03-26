import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // Solicita o tamanho do banco de dados ao usuário
        String inputQtde = JOptionPane.showInputDialog("Forneça a quantidade de alunos: ");
        
        if (inputQtde == null || inputQtde.trim().isEmpty()) {
            System.exit(0);
        }

        try {
            int qtde = Integer.parseInt(inputQtde);
            CadastroAlunos ca = new CadastroAlunos(qtde);
            
            // Injeção de dependência: define qual interface usar (Gráfica)
            IMenu menu = new MenuGrafico();
            menu.exibirMenu(ca);
            
        } catch (NumberFormatException e) {
            // Tratamento de erro caso o usuário não digite um número
            JOptionPane.showMessageDialog(null, "Erro: A quantidade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}