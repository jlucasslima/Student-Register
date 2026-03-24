import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String inputQtde = JOptionPane.showInputDialog("Forneça a quantidade de alunos: ");
        
        if (inputQtde == null || inputQtde.trim().isEmpty()) {
            System.exit(0);
        }

        try {
            int qtde = Integer.parseInt(inputQtde);
            CadastroAlunos ca = new CadastroAlunos(qtde);
            
            IMenu menu = new MenuGrafico();
            menu.exibirMenu(ca);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro: A quantidade deve ser um número inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}