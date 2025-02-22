package org.example;

public class Camisa {
    private String tamanho;
    private String cor;
    private String tipo;

    public Camisa(String tamanho, String cor, String tipo) {

        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;

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


}
