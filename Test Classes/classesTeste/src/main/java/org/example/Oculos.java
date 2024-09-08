package org.example;

public class Oculos {

    private String cor;
    private String tipo;
    private String material;
    private boolean grau;

    public Oculos(String cor, String tipo, String material, boolean grau) {

        this.cor = cor;
        this.tipo = tipo;
        this.material = material;
        this.grau = grau;

    }

    public String limpar(){

        return ("óculos limpo!");
    }

    public String ajustar(){

        return ("óculos ajustado");
    }

    public String trocarLentes(){

        return ("lentes novas!");

    }
}
