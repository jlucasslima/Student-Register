public class NomePessoa extends Texto {
    public NomePessoa(String nome) {
        super(nome);
    }

    public String getNomeBiblio() {
        if (valor == null || valor.trim().isEmpty()) return "";
        
        String[] partes = valor.trim().split(" ");
        if (partes.length == 1) {
            return partes[0].toUpperCase();
        }
        
        String ultimoNome = partes[partes.length - 1].toUpperCase();
        StringBuilder resto = new StringBuilder();
        
        for (int i = 0; i < partes.length - 1; i++) {
            resto.append(partes[i]).append(" ");
        }
        
        return ultimoNome + ", " + resto.toString().trim();
    }
}