package visao;

import controle.CadastroAlunos;
import modelo.Aluno;
import javax.swing.*;
import java.awt.*;

public class MenuGrafico implements IMenu {

    @Override
    public void exibirMenu(CadastroAlunos cadastro) {
        String textoMenu = "SISTEMA DE CADASTRO\n\n"
                         + "1 - Inserir novo aluno\n"
                         + "2 - Remover aluno\n"
                         + "3 - Listar alunos (Tabela)\n"
                         + "4 - Atualizar aluno\n"
                         + "5 - Salvar arquivo\n"
                         + "6 - Ler arquivo\n"
                         + "7 - Sair\n\n"
                         + "Escolha uma opção:";

        while (true) {
            String op = JOptionPane.showInputDialog(null, textoMenu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);
            if (op == null || op.equals("7")) break;

            switch (op) {
                case "1":
                    JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
                    JTextField ra = new JTextField();
                    JTextField nome = new JTextField();
                    JTextField idade = new JTextField();
                    JTextField curso = new JTextField();
                    
                    panel.add(new JLabel("RA:")); panel.add(ra);
                    panel.add(new JLabel("Nome:")); panel.add(nome);
                    panel.add(new JLabel("Idade:")); panel.add(idade);
                    panel.add(new JLabel("Curso:")); panel.add(curso);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Novo Aluno", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            if (cadastro.buscar(ra.getText().trim()) != null) {
                                JOptionPane.showMessageDialog(null, "RA já cadastrado!");
                            } else {
                                Aluno novo = new Aluno(nome.getText().trim(), Integer.parseInt(idade.getText().trim()), ra.getText().trim(), curso.getText().trim());
                                cadastro.inserir(novo);
                                JOptionPane.showMessageDialog(null, "Aluno inserido!");
                            }
                        } catch (Exception e) { JOptionPane.showMessageDialog(null, "Dados inválidos!"); }
                    }
                    break;

                case "2":
                    String raRem = JOptionPane.showInputDialog("RA para remover:");
                    if (raRem != null && cadastro.remover(raRem)) JOptionPane.showMessageDialog(null, "Removido!");
                    else if (raRem != null) JOptionPane.showMessageDialog(null, "Não encontrado.");
                    break;

                case "3":
                    Aluno[] lista = cadastro.listar();
                    String[] colunas = {"RA", "Nome (Biblio)", "Idade", "Curso"};
                    String[][] dados = new String[lista.length][4];
                    for (int i = 0; i < lista.length; i++) {
                        dados[i][0] = lista[i].getRa();
                        dados[i][1] = lista[i].getNomeBiblio();
                        dados[i][2] = "" + lista[i].getIdade();
                        dados[i][3] = lista[i].getCurso();
                    }
                    JTable tabela = new JTable(dados, colunas);
                    JOptionPane.showMessageDialog(null, new JScrollPane(tabela), "Lista de Alunos", JOptionPane.PLAIN_MESSAGE);
                    break;

                case "4":
                    String raAlt = JOptionPane.showInputDialog("RA para atualizar:");
                    Aluno al = cadastro.buscar(raAlt);
                    if (al != null) {
                        String nCurso = JOptionPane.showInputDialog("Novo curso:", al.getCurso());
                        if (nCurso != null) {
                            al.setCurso(nCurso);
                            JOptionPane.showMessageDialog(null, "Atualizado!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                    }
                    break;

                case "5":
                    String arqSalvar = JOptionPane.showInputDialog("Nome do arquivo para SALVAR (ex: banco.txt):");
                    if (arqSalvar != null && !arqSalvar.trim().isEmpty()) {
                        try { cadastro.salvarEmArquivo(arqSalvar); JOptionPane.showMessageDialog(null, "Salvo!"); }
                        catch (Exception e) { JOptionPane.showMessageDialog(null, "Erro ao salvar."); }
                    }
                    break;

                case "6":
                    String arqLer = JOptionPane.showInputDialog("Nome do arquivo para LER (ex: banco.txt):");
                    if (arqLer != null && !arqLer.trim().isEmpty()) {
                        try { cadastro.lerDeArquivo(arqLer); JOptionPane.showMessageDialog(null, "Lido!"); }
                        catch (Exception e) { JOptionPane.showMessageDialog(null, "Erro ao ler. Arquivo não encontrado."); }
                    }
                    break;
            }
        }
    }
}