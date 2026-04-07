package modelo;

/**
 * Representa um texto genérico no sistema.
 */
public class Texto {
    protected String valor;

    public Texto(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}