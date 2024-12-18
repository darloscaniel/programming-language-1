package org.example.classtest.models;

public class Oculos {

    private String cor;
    private String tipo;
    private String material;
    private int id_oculos;

    public Oculos(String cor, String tipo, String material, int id_oculos) {

        this.cor = cor;
        this.tipo = tipo;
        this.material = material;
        this.id_oculos = id_oculos;

    }

    public Oculos(String cor, String tipo, String material) {

            this.cor = cor;
            this.tipo = tipo;
            this.material = material;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getId_oculos() {
        return id_oculos;
    }

    public void setId_oculos(int id_oculos) {
        this.id_oculos = id_oculos;
    }
}
