import javax.swing.JOptionPane;

/**
 * Write a description of class MenuGrafico here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuGrafico implements IMenu {
    
    public int criarMenu(String opcoes[]){
        int opcao;
        
        // monta menu
        String itens = "";
        for (int i = 0; i < opcoes.length; i++){
            itens = itens + "\n" + opcoes[i];
            
        }
        
        itens = itens + "\n\nSelecione a opcao: ";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(itens));
        return opcao;
    }
}