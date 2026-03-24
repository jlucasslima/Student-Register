import java.util.Scanner;

/**
 * Write a description of class MenuTexto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuTexto implements IMenu {
 public int criarMenu(String opcoes[]){
        int opcao;
        
        // monta menui
        String itens = "";
        for (int i = 0; i < opcoes.length; i++){
            itens = itens + "\n" + opcoes[i];
            
        }
        
        itens = itens + "\n\nSelecione a opcao: ";
         // Cria um objeto da classe Scanner, para leitura pelo teclado
        Scanner sc = new Scanner(System.in);

        // Mostra msg na console
        System.out.print(itens);
        
        // Faz a leitura pelo teclado
        String s = sc.nextLine();
        
        // Fecha dispositivo de entrada
        sc.close();

        opcao = Integer.parseInt(s);
        return opcao;
    }

}