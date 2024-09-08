package org.example;

public class Caderno {

    private String tamanho;
    private String cor;
    private int numPaginas;
    private String tipo;

    public Caderno(String tamanho, String cor, int numPaginas, String tipo){

        this.tamanho = tamanho;
        this.cor = cor;
        this.numPaginas = numPaginas;
        this.tipo = tipo;

    }

    public String escrever(){
        return ("Texto escrito: ");
    }

    public String tirarPagina(){

        return ("Número de Páginas do caderno: " +(numPaginas = numPaginas-1));

    }

    public String trocarCapa(){

        return ("Capa trocada!");

    }


}
