package org.example;

import java.util.Scanner;

public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            System.out.println("O denominador da fração não pode ser zero!");
        }
        this.denominador = denominador;
        this.numerador = numerador;

    }

    public int calcularMDC(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return calcularMDC(b, a % b);
    }

    public Fracao simplificar() {
        int mdc = calcularMDC(numerador, denominador);
        numerador /= mdc;
        denominador /= mdc;

        return new Fracao(numerador, denominador);
    }

    public Fracao somar(Fracao outraFracao) {
        int novoNumerador = this.numerador * outraFracao.denominador + outraFracao.numerador * this.denominador;
        int novoDenominador = this.denominador * outraFracao.denominador;

        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);
        return (novaFracao.simplificar());

    }

    public Fracao subtrair(Fracao outraFracao) {
        int novoNumerador = this.numerador * outraFracao.denominador - outraFracao.numerador * this.denominador;
        int novoDenominador = this.denominador * outraFracao.denominador;

        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);
        return (novaFracao.simplificar());

    }

    public Fracao dividir (Fracao outraFracao) {
        int novoNumerador = this.numerador * outraFracao.denominador;
        int novoDenominador = this.denominador * outraFracao.numerador;

        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);
        return (novaFracao.simplificar());

    }

    public Fracao multiplicar(Fracao outraFracao) {

        int novoNumerador = this.numerador * outraFracao.numerador;
        int novoDenominador = this.denominador * outraFracao.denominador;

        Fracao novaFracao = new Fracao(novoNumerador, novoDenominador);
        return (novaFracao.simplificar());

    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

}

