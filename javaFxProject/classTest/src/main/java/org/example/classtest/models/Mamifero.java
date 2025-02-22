package org.example.classtest.models;

public class Mamifero {

    private String especie;
    private String habitat;
    private double tamanho;
    private int id_mamifero;

    public Mamifero(String especie, String habitat, double tamanho, int id_mamifero) {

        this.especie = especie;
        this.habitat = habitat;
        this.tamanho = tamanho;
        this.id_mamifero = id_mamifero;

    }

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getId_mamifero() {
        return id_mamifero;
    }

    public void setId_mamifero(int id_mamifero) {
        this.id_mamifero = id_mamifero;
    }
}

