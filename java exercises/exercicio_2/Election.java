//algoritmo 2

import java.util.Scanner;

public class Election{

    private float totalVotes;
    private float nullVotes;
    private float whiteVotes;
    private float validVotes;


    public Election(float total, float nullV, float white, float valid){

        this.totalVotes = total;
        this.nullVotes = nullV;
        this.whiteVotes = white;
        this.validVotes = valid;

    }

    public float nullPercentage(){

        return (nullVotes / totalVotes * 100); 

    }

    public float whitePercentage(){

        return (whiteVotes / totalVotes * 100); 

    }

    public float validPercentage(){

        return (validVotes / totalVotes * 100);

    }

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        Election sjc =  new Election(scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());
        
        System.out.println("Total: " + sjc.totalVotes);
        System.out.println("White Votes: " + sjc.whitePercentage() + "%");
        System.out.println("Null Votes: " + sjc.nullPercentage() + "%");
        System.out.println("Valid Votes: " + sjc.validPercentage() + "%");
        

    }



}