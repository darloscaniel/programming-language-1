package exercicio_10;

import java.util.Scanner;

public class TestResult {

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        int n1 =  scanner.nextInt();
        int n2 =  scanner.nextInt();

        float m = (n1+n2)/2;

        if(m >= 6){
            System.out.println("Aprovado");
            System.out.println(m);
        }else{
            System.out.println("Reprovado");
            System.out.println(m);

        }
    }
    
}
