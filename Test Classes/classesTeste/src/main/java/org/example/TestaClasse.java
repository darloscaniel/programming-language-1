package org.example;

import java.util.Scanner;

public class TestaClasse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bandeira bandeira = new Bandeira("Brasil", "Retângulo", "Verde, Amarelo, Azul", "Bandeira Nacional", "Bandeira da Republica Federativa do Brasil");
        Caderno caderno = new Caderno("200x275", "vermelho", 96, "arame");
        Camisa camisa = new Camisa("G", "Azul", "Polo");
        Carro carro = new Carro("Cruze", "chevrolet", "preto", "1234-abc");
        Flor flor = new Flor("Orquidea", "roxo", 15);
        Fruta fruta = new Fruta("Cítrica", "média", "Laranja");
        Mamifero mamifero = new Mamifero("Gato", "Dentro de casa", 45);
        Oculos oculos = new Oculos("preto", "óculos para miopia", "plástico", true);
        Passaro passaro = new Passaro("Calopsita", "jaopaulo", 14.76);
        Sapato sapato = new Sapato(40, "preto", "social", "Democrata", 235.99);

        int option;

        do {
            System.out.println("===========================================================");
            System.out.println("                      TESTAR MÉTODOS                       ");
            System.out.println(" [1]  Mostrar Descrição da Bandeira                        ");
            System.out.println(" [2]  Calcular área da Bandeira                            ");
            System.out.println(" [3]  Escrever no Caderno                                  ");
            System.out.println(" [4]  Tirar Página do Caderno                              ");
            System.out.println(" [5]  Vestic Camisa                                        ");
            System.out.println(" [6]  Tirar Camisa                                         ");
            System.out.println(" [7]  Ligar Carro                                          ");
            System.out.println(" [8]  Acelerar Carro                                       ");
            System.out.println(" [9]  Florescer (Classe FLor)                              ");
            System.out.println(" [10] Produzir Polen (Classe Flor)                         ");
            System.out.println(" [11] Amadurecer Fruta                                     ");
            System.out.println(" [12] Apodrecer Fruta                                      ");
            System.out.println(" [13] Comer (Classe Mamifero)                              ");
            System.out.println(" [14] Dormir (Classe Mamifero)                             ");
            System.out.println(" [15] Limpar Óculos                                        ");
            System.out.println(" [16] Trocar lentes do Óculos                              ");
            System.out.println(" [17] Cantar (Classe Pássaro)                              ");
            System.out.println(" [18] Voar (Classe Pássaro)                                ");
            System.out.println(" [19] Mostrar Preço do Sapato                              ");
            System.out.println(" [20] Trocar Tamanho do Sapato                             ");
            System.out.println(" [0]  Encerrar testes                                      ");
            System.out.println("===========================================================");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println(bandeira.mostrarDescricao());
                    break;
                case 2:
                    System.out.println(bandeira.calcularArea(scanner.nextInt(), scanner.nextInt()));
                    break;
                case 3:
                    System.out.println(caderno.escrever());
                    break;
                case 4:
                    System.out.println(caderno.tirarPagina());
                    break;
                case 5:
                    System.out.println(camisa.vestir());
                    break;
                case 6:
                    System.out.println(camisa.tirar());
                    break;
                case 7:
                    System.out.println(carro.ligar());
                    break;
                case 8:
                    System.out.println(carro.acelerar());
                    break;
                case 9:
                    System.out.println(flor.florescer());
                    break;
                case 10:
                    System.out.println(flor.produzirPolen());
                    break;
                case 11:
                    System.out.println(fruta.amadurecer());
                    break;
                case 12:
                    System.out.println(fruta.apodrecer());
                    break;
                case 13:
                    System.out.println(mamifero.comer());
                    break;
                case 14:
                    System.out.println(mamifero.dormir());
                    break;
                case 15:
                    System.out.println(oculos.limpar());
                    break;
                case 16:
                    System.out.println(oculos.trocarLentes());
                    break;
                case 17:
                    System.out.println(passaro.cantar());
                    break;
                case 18:
                    System.out.println(passaro.voar());
                    break;
                case 19:
                    System.out.println(sapato.mostrarPreco());
                    break;
                case 20:
                    System.out.println(sapato.trocarTamanho(scanner.nextInt()));
                    break;
                case 0:
                    System.out.println("Encerrando testes...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 0);
        scanner.close();
    }
}
