/**
 * Especialização da classe Texto para lidar com nomes próprios.
 */
public class NomePessoa extends Texto {
    public NomePessoa(String nome) {
        super(nome);
    }

    /**
     * Converte o nome para formato de citação (ÚLTIMO NOME, Resto do Nome).
     */
    public String getNomeBiblio() {
        if (valor == null || valor.trim().isEmpty()) return "";
        
        String[] partes = valor.trim().split(" ");
        if (partes.length == 1) {
            return partes[0].toUpperCase();
        }
        
        // Pega o último elemento do array e coloca em caixa alta
        String ultimoNome = partes[partes.length - 1].toUpperCase();
        StringBuilder resto = new StringBuilder();
        
        // Reconstrói o restante do nome
        for (int i = 0; i < partes.length - 1; i++) {
            resto.append(partes[i]).append(" ");
        }
        
        return ultimoNome + ", " + resto.toString().trim();
    }
}