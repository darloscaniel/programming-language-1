package org.example.classtest.models;

public class Caderno {
    private String cor;
    private int paginas;
    private String texto;
    private int id_caderno;


    public Caderno(String cor, int paginas, String texto, int id_caderno) {
        this.cor = cor;
        this.paginas = paginas;
        this.texto = texto;
        this.id_caderno = id_caderno;
    }

    public int getId_caderno() {
        return id_caderno;
    }

    public void setId_caderno(int id_caderno) {
        this.id_caderno = id_caderno;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Caderno(String cor, int paginas) {
        this.cor = cor;
        this.paginas = paginas;
        this.texto = "";
    }

    public void escrever(String texto) {
        this.texto += texto + "\n";
    }

    public int removerPagina() {
        if (paginas > 0) {
            paginas--;
        }
        return paginas;
    }

    public String getTexto() {
        return texto;
    }

    public int getPaginas() {
        return paginas;
    }
}
