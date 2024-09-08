package org.example;

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

}
