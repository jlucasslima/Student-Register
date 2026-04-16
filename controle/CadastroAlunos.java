package controle;

import armazenamento.IArmazenador;
import modelo.Aluno;
import java.io.*;

public class CadastroAlunos {
    private IArmazenador armazenador;

    public CadastroAlunos(IArmazenador armazenador) {
        this.armazenador = armazenador;
    }

    private int acharIndicePorRa(String ra) {
        int i = 0;
        while (true) {
            Object obj = armazenador.buscar(i);
            if (obj == null) break;
            if (((Aluno) obj).getRa().equalsIgnoreCase(ra)) return i;
            i++;
        }
        return -1;
    }

    public void inserir(Aluno a) { armazenador.adicionar(a); }

    public boolean remover(String ra) {
        int idx = acharIndicePorRa(ra);
        if (idx != -1) {
            return armazenador.remover(idx) != null;
        }
        return false;
    }

    public Aluno buscar(String ra) {
        int idx = acharIndicePorRa(ra);
        if (idx != -1) {
            return (Aluno) armazenador.buscar(idx);
        }
        return null;
    }

    public Aluno[] listar() {
        int cont = 0;
        while(armazenador.buscar(cont) != null) cont++;
        
        Aluno[] lista = new Aluno[cont];
        for (int i = 0; i < cont; i++) {
            lista[i] = (Aluno) armazenador.buscar(i);
        }
        return lista;
    }

    public void salvarEmArquivo(String nome) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nome));
        for (Aluno a : listar()) {
            writer.write(a.getRa() + ";" + a.getNome() + ";" + a.getIdade() + ";" + a.getCurso());
            writer.newLine();
        }
        writer.close();
    }

    public void lerDeArquivo(String nome) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nome));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] p = linha.split(";");
            if (p.length == 4) {
                if (buscar(p[0]) == null) {
                    inserir(new Aluno(p[1], Integer.parseInt(p[2]), p[0], p[3]));
                }
            }
        }
        reader.close();
    }
}