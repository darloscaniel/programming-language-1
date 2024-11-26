package org.example.classtest.models;

public class Bandeira {
    private String pais;
    private String cor;
    private String descricao;
    private int id_bandeira;

    // Construtor com todos os parâmetros
    public Bandeira(String pais, String cor, String descricao, int id_bandeira) {
        this.pais = pais;
        this.cor = cor;
        this.descricao = descricao;
        this.id_bandeira = id_bandeira;
    }

    // Construtor com apenas dois parâmetros (pais e cor)
    public Bandeira(String pais, String cor) {
        this.pais = pais;
        this.cor = cor;
    }

    // Construtor padrão
    public Bandeira() {
        // Inicialização vazia ou padrão
    }

    // Construtor com 3 parâmetros (pais, cor, descricao) sem o id_bandeira
    public Bandeira(String pais, String cor, String descricao) {
        this.pais = pais;
        this.cor = cor;
        this.descricao = descricao;
    }

    // Método para exibir a descrição
    public String mostrarDescricao() {
        return "Descrição da bandeira do " + pais + ": " + descricao;
    }

    // Método de exemplo
    public String balancar() {
        return "BALANÇANDO...";
    }

    // Métodos getters e setters
    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_bandeira() {
        return this.id_bandeira;
    }

    public void setId_bandeira(int id_bandeira) {
        this.id_bandeira = id_bandeira;
    }
}
