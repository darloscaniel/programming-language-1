//Algoritmo 3

import java.util.Scanner;

public class Salary {

private float value;
private float aliquot;
    
public Salary(float salary, float percentage){

    this.value = salary;
    this.aliquot = percentage;

}

public float newSalary(){

    return (value + (aliquot /100) * value );
}

    public static void main (String[] Args){

        Scanner scanner = new Scanner(System.in);

        Salary payment = new Salary( scanner.nextFloat(),  scanner.nextFloat());

        System.out.println("Salário Anterior: " + payment.value);
        System.out.println("Novo Salário: " + payment.newSalary());
        
    }
}
