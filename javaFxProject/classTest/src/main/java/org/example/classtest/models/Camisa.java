package org.example.classtest.models;

public class Camisa {
    private String tamanho;
    private String cor;
    private String tipo;
    private int id_camisa;

    public Camisa(String tamanho, String cor, String tipo, int id_camisa) {

        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
        this.id_camisa = id_camisa;

    }

    public int getId_camisa() {
        return id_camisa;
    }

    public void setId_camisa(int id_camisa) {
        this.id_camisa = id_camisa;
    }

    public String vestir(){

        return ("Camisa " + tipo + "Vestida!");

    }

    public String tirar(){

        return ("Camisa " + tipo + "Tirada!");
    }

    public String lavar(){
        return ("Camisa " + tipo + "Lavada!");
    }


    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
