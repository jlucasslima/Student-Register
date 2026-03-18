public class Texto {
    private String txt;

    public Texto(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public int getQtdePalavras() {
        if (txt == null || txt.trim().isEmpty()) {
            return 0;
        }
        return txt.trim().split("\\s+").length;
    }

    public String inverterTexto() {
        return new StringBuilder(txt).reverse().toString();
    }

    @Override
    public String toString() {
        return txt;
    }
}