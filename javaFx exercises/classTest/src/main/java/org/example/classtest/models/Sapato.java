package org.example.classtest.models;

public class Sapato {

    private double tamanho;
    private String cor;
    private String tipo;
    private String marca;
    private double preco;

    public Sapato(double tamanho, String cor, String tipo, String marca, double preco) {

        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
        this.marca = marca;

    }

    public int aplicarDesconto(int desconto){

        return (desconto);

    }

    public String mostrarPreco(){

        return("O preço do sapato "+ marca + "é" + preco);

    }

    public int trocarTamanho(int novoTamanho){

        this.tamanho = novoTamanho;
        return novoTamanho;

    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
