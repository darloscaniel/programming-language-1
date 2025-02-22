
import java.util.Scanner;

public class Age {

    private int years;
    private int months;
    private int days;

    public Age (int years, int months, int days){

        this.years = years;
        this.months = months;
        this.days = days;
    }


    public int convert(){


        return (days + (months * 30) + (years * 365));
        

    }

        public static void main (String[] args){

            Scanner scanner = new Scanner(System.in);


            Age person1 = new Age(scanner.nextInt(), scanner.nextInt(),scanner.nextInt());


            System.out.println("Total de dias: " + person1.convert());

        }

}



