package org.example;

public class Flor {
    private String especie;
    private String cor;
    private double tamanho;

    public Flor(String especie, String cor, double tamanho){

        this.cor = cor;
        this.especie = especie;
        this.tamanho = tamanho;

    }

    public String florescer(){

        return ("FLOR");

    }

    public String produzirOX(){
        return ("o2 o2");

    }

    public String produzirPolen(){
        return ("atraindo abelhas");
    }


}
