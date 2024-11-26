package exercicio_8;

import java.util.Scanner;

public class PositiveNegative {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        float num =  scanner.nextFloat();

        if(num<0){
            System.out.println("O numero é negativo!");
        }else{
            System.out.println("O número é positivo");
        }

    }
    
}
