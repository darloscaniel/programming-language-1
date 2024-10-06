package org.example.classtest.models;

public class Bandeira {
    private String pais;
    private String cor;
    private String descricao;


    public Bandeira(String pais, String cor, String descricao) {
        this.pais = pais;

        this.cor = cor;

        this.descricao = descricao;
    }

    public Bandeira(String pais, String cor) {
    }

    public String mostrarDescricao(){

        return ("descricao da bandeira do " + pais + ":" + descricao);

    }

    public String balancar(){
        return ("BALANÇANDO...");
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
