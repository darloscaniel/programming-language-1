import java.util.Scanner;

public class Car{

    private float totalPrice;
    private float distPrice;
    private float tax;


    public Car(float total, float dist, float taxation){

        this.distPrice  = dist;
        this.tax = taxation;
        this.totalPrice = total;

    }

    public float calcPrice(){

        return(totalPrice + (totalPrice * (distPrice/100)) + (totalPrice * (tax/100)));

    }

    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        Car carroNovo = new Car( scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());

        System.out.println("O Preço do carro é: "+ carroNovo.calcPrice());

    }

}