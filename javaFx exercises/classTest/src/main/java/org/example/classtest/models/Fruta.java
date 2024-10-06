package org.example.classtest.models;

public class Fruta {

    private String tipo;
    private String tamanho;
    private String nome;

    public Fruta(String tipo, String tamanho, String nome) {

        this.tipo = tipo;
        this.tamanho = tamanho;
        this.nome = nome;

    }

    public String amadurecer(){

        return ("desverdeando...");

    }

    public String apodrecer(){

        return ("PODRE!");

    }

    public String semear(){

        return ("Arvore");

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
