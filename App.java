import javax.swing.JOptionPane;
/**
 * Write a description of class App here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class App {
    public static void main(String args[]) {
        int qtde = Integer.parseInt(JOptionPane.showInputDialog("Forneça a quantidade de alunos: "));

        CadastroAlunos ca = new CadastroAlunos(qtde);

        IMenu mn = new MenuGrafico(); 
        //IMenu mn = new MenuTexto(); 

        String [] itensMenu = {"1 - inserir", "2 - remover", "3 - listar", "4 - sair"};

        int opcao = 0;
        
        do {
            opcao = mn.criarMenu(itensMenu);

        } while(opcao != 4);

    }
}