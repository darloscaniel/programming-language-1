package exercicio_5;

import java.util.Scanner;

public class Payment {

    private float salary;
    private float comission;
    private int carSale;
    private float saleValue;

    public Payment( float pay, float com, int sale, float value){

    
        this.salary = pay;
        this.comission = com;
        this.carSale = sale;
        this.saleValue = value;

    }


    public double calcPayment(){

        return(salary + (comission * carSale) + (saleValue * 0.05));
        
    }
    
    public static void main (String[] Args){

        Scanner scanner = new Scanner(System.in);

        Payment pagamento = new Payment( scanner.nextFloat(),  scanner.nextFloat(),  scanner.nextInt() ,  scanner.nextFloat());
        System.out.println("O Salário é: " + pagamento.calcPayment());

    }
    
}
