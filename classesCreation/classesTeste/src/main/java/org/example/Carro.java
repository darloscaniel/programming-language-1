package org.example;

public class Carro {

    private String modelo;
    private String marca;
    private String cor;
    private String placa;

    public Carro(String modelo, String marca, String cor, String placa) {

        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;

    }

    public String ligar(){

        return ("VRUM VRUM");

    }

    public String acelerar(){

        return ("VRUM VRUM!!!!!!!!!");

    }

    public String freiar(){

        return ("!!!!!!!!!!");
    }

    public String desligar(){
        return ("DESLIGADO!");
    }
}
