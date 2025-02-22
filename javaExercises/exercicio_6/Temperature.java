package exercicio_6;

import java.util.Scanner;

public class Temperature{

    private double celsius;
    private double fahrenheit;


    public Temperature(float fah){

        this.fahrenheit = fah;

    }

    public double convert(){
        celsius = fahrenheit / 2.12;
        return(celsius);
    }

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        Temperature grau = new Temperature( scanner.nextFloat());
        

        System.out.println("A temperatura convertida é: " + grau.convert());

    }
    
}