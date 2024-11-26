package exercicio_11;

import java.util.Scanner;

public class Vote {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         
        int atual =  scanner.nextInt();
        int nasc =  scanner.nextInt();

        int idade = atual - nasc;

        if (idade >= 16){

            System.out.println("Pode votar");
        }else{

            System.out.println("Não pode votar");
        }

    }
    
}
