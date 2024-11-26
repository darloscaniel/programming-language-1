package org.example.classtest.models;

public class Passaro {

    private String especie;
    private String nome;
    private double tamanho;
    private int id_passaro;

    public Passaro(String especie, String nome, double tamanho, int id_passaro) {
        this.especie = especie;
        this.nome = nome;
        this.tamanho = tamanho;
        this.id_passaro = id_passaro;
    }

    public String comer(){

       return ("Nham nham");

    }

    public String cantar(){

        if (especie.equals("galinha")) {
            return("cocoricó");
        }else{
            return("piu piu");
        }
    }

    public String voar(){

        if (especie.equals("galinha")) {
            return ("galinha nao voa");
        }else{
            return ("voando");
        }
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public int getId_passaro() {
        return id_passaro;
    }

    public void setId_passaro(int id_passaro) {
        this.id_passaro = id_passaro;
    }
}
