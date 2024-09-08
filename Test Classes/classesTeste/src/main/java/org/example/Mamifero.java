package org.example;

public class Mamifero {

    private String especie;
    private String habitat;
    private double tamanho;

    public Mamifero(String especie, String habitat, double tamanho) {

        this.especie = especie;
        this.habitat = habitat;
        this.tamanho = tamanho;

    }

    public String comer(){
        return ("nham nham");
    }

    public String dormir(){
        return ("zzzzzzzz");
    }

    public String envelhecer(){
        return ("velho");
    }
}

