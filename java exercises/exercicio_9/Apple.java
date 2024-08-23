package exercicio_9;

import java.util.Scanner;

public class Apple {

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

    int numApple =  scanner.nextInt();

    if(numApple < 12){

         double price = numApple * 1.30;

         System.out.println("O preço das maçãs é: " + price);

    }
    }
    
}
