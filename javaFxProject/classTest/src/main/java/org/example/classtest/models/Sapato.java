package org.example.classtest.models;

public class Sapato {

    private double tamanho;
    private String cor;
    private String tipo;
    private int id_sapato;

    public Sapato(double tamanho, String cor, String tipo, int id_sapato) {

        this.tamanho = tamanho;
        this.cor = cor;
        this.tipo = tipo;
        this.id_sapato = id_sapato;
    }

    public Sapato(double tamanho, String cor, String tipo) {

            this.tamanho = tamanho;
            this.cor = cor;
            this.tipo = tipo;
    }

    public int aplicarDesconto(int desconto){

        return (desconto);

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

    public int getId_sapato() {
        return id_sapato;
    }

    public void setId_sapato(int id_sapato) {
        this.id_sapato = id_sapato;
    }
}
