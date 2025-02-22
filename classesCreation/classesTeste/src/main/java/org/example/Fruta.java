package org.example;

public class Fruta {

    private String tipo;
    private String tamanho;
    private String nome;

    public Fruta(String tipo, String tamanho, String nome) {

        this.tipo = tipo;
        this.tamanho = tamanho;
        this.nome = nome;

    }

    public String amadurecer(){

        return ("desverdeando...");

    }

    public String apodrecer(){

        return ("PODRE!");

    }

    public String semear(){

        return ("Arvore");

    }

}
