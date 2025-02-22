package org.example.classtest.models;

public class Flor {
    private String especie;
    private String cor;
    private double tamanho;
    private int id_flor;



    public Flor(String especie, String cor, double tamanho, int id_flor) {

        this.cor = cor;
        this.especie = especie;
        this.tamanho = tamanho;
        this.id_flor = id_flor;

    }

    public Flor(String especie, String cor, double tamanho) {
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

    public int getId_flor() {
        return id_flor;
    }

    public void setId_flor(int id_flor) {
        this.id_flor = id_flor;
    }
}
