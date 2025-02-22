package org.example;

import java.util.Scanner;

public class Menu {

    public static void main(String[] Args){

    Scanner scanner = new Scanner(System.in);

    int option;
    boolean run = true;

        while(run) {
        System.out.println("Escolha a operação que deseja realizar:");
        System.out.println("[1] Soma de Frações");
        System.out.println("[2] Subtração de Frações");
        System.out.println("[3] Divisão de Frações");
        System.out.println("[4] Multiplicação de Frações");
        System.out.println("[0] Fechar");

        option = scanner.nextInt();

        switch (option){

            case 1:{
                
                System.out.println("Para atribuir os valores da fração, Digite primeiro o numerador e depois o denominador!");

                System.out.println("Digite a Primeira fração da soma: ");
                Fracao fracao1 = new Fracao(scanner.nextInt(), scanner.nextInt());
                System.out.println("Digite a Segunda fração da soma: ");
                Fracao fracao2 = new Fracao(scanner.nextInt(), scanner.nextInt());

                Fracao soma = fracao1.somar(fracao2);
                System.out.println("Resultado: " + soma);
                break;
            }

            case 2:{
                System.out.println("Para atribuir os valores da fração, Digite primeiro o numerador e depois o denominador!");

                System.out.println("Digite a Primeira fração da subtração: ");
                Fracao fracao1 = new Fracao(scanner.nextInt(), scanner.nextInt());
                System.out.println("Digite a Segunda fração da subtração: ");
                Fracao fracao2 = new Fracao(scanner.nextInt(), scanner.nextInt());

                Fracao subtracao = fracao1.subtrair(fracao2);
                System.out.println("Resultado: " + subtracao);
                break;
            }

            case 3:{
                System.out.println("Para atribuir os valores da fração, Digite primeiro o numerador e depois o denominador!");

                System.out.println("Digite a Primeira fração da divisão: ");
                Fracao fracao1 = new Fracao(scanner.nextInt(), scanner.nextInt());
                System.out.println("Digite a Segunda fração da divisão: ");
                Fracao fracao2 = new Fracao(scanner.nextInt(), scanner.nextInt());

                Fracao divisao = fracao1.dividir(fracao2);
                System.out.println("Resultado: " + divisao);
                break;
            }

            case 4:{
                System.out.println("Para atribuir os valores da fração, Digite primeiro o numerador e depois o denominador!");

                System.out.println("Digite a Primeira fração da multiplicação: ");
                Fracao fracao1 = new Fracao(scanner.nextInt(), scanner.nextInt());
                System.out.println("Digite a Segunda fração da multiplicação: ");
                Fracao fracao2 = new Fracao(scanner.nextInt(), scanner.nextInt());

                Fracao multiplicacao = fracao1.multiplicar(fracao2);
                System.out.println("Resultado: " + multiplicacao);
                break;
            }

            case 0: {
                run = false;
                break;
            }

            default: {
                System.out.println("Opção inválida. Tente novamente.");
                break;
            }

        }
    }
    }
}
