package org.example;

public class Passaro {

    private String especie;
    private String nome;
    private double tamanho;

    public Passaro(String especie, String nome, double tamanho){
        this.especie = especie;
        this.nome = nome;
        this.tamanho = tamanho;
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

}
