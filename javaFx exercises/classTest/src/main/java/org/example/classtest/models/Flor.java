package org.example.classtest.models;

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


    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
}
