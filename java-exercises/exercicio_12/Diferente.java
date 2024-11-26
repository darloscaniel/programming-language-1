package exercicio_12;

import java.util.Scanner;

public class Diferente {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int integer1 =  scanner.nextInt();
        int integer2 = scanner.nextInt();

        if (integer1>integer2){

            System.out.println("O maior número é: " + integer1);

        }else{

            System.out.println("O maior número é: " + integer2);
        }

    }
    
}

