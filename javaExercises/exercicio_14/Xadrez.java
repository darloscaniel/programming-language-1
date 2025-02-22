package exercicio_14;

import java.util.Scanner;

public class Xadrez {

    private int start;
    private int end;
 
    public Xadrez(int start, int end){

        this.start = start;
		this.end = end;

    }

    public int stopwatch() {
		if (start < end) {
			return end - start;
        }else {
			return end - start + 24;
		}
	}

    public static void main(String[] Args) {

		Scanner scanner = new Scanner(System.in);
        
		Xadrez game = new Xadrez(scanner.nextInt(), scanner.nextInt());

		System.out.println("O jogo teve a duração de " + game.stopwatch() + " Horas");
	}

}

