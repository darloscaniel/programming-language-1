package org.example.classtest.models;

public class Carro {

    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private int id_carro;



    public Carro(String modelo, String marca, String cor, String placa, int id_carro) {

        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.id_carro = id_carro;
    }

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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }
}
