package org.example;

public class Bandeira {
    private String pais;
    private String formato;
    private String cor;
    private String tipo;
    private String descricao;


    public Bandeira(String pais, String formato, String cor, String tipo, String descricao) {
        this.pais = pais;
        this.formato = formato;
        this.cor = cor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String mostrarDescricao(){

        return ("descricao da bandeira do " + pais + ":" + descricao);

    }

    public String calcularArea(int altura, int largura){

        return ("A área da bandeira é: " + (altura*largura));

    }

    public String balancar(){
        return ("BALANÇANDO...");
    }
}
