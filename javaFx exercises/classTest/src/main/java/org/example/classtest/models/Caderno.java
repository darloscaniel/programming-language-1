package org.example.classtest.models;

public class Caderno {
    private String cor;
    private int paginas;
    private String texto;

    public Caderno(String cor, int paginas) {
        this.cor = cor;
        this.paginas = paginas;
        this.texto = "";
    }

    public void escrever(String texto) {
        this.texto += texto + "\n";
    }

    public boolean removerPagina() {
        if (paginas > 0) {
            paginas--;
            return true;
        }
        return false;
    }

    public String getTexto() {
        return texto;
    }

    public int getPaginas() {
        return paginas;
    }
}
