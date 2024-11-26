package exercicio_17;

import java.util.Scanner;

public class Semestre {

    private float prova1;
	private float exercicio1;
	private float exercicio2;
	private float api;
	private float extra;
	private float substituta;

	public Semestre(float prova1, float exercicio1, float exercicio2, float api, float extra, float substituta) {
		this.prova1 = prova1;
		this.exercicio1 = exercicio1;
		this.exercicio2 = exercicio2;
		this.api = api;
		this.extra = extra;
		this.substituta = substituta;
	}

	public double nota() {
		
		return (prova1 * 0.6 + ((exercicio1 + exercicio2) / 2) * 0.4) * 0.5

			
				+ (Math.max(((prova1 * 0.6 + ((exercicio1 + exercicio2) / 2) * 0.4) - 5.9), 0)

					/ ((prova1 * 0.6 + ((exercicio1 + exercicio2) / 2) * 0.4) - 5.9)) * (api * 0.5)
				+ extra + (substituta * 0.2);

	}

	public static void main(String[] Args) {

        Scanner scanner = new Scanner(System.in);
	
		Semestre Media = new Semestre(scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat(), scanner.nextFloat());
	
		System.out.println("A média final será de " + Media.nota());
		System.out.println("============================");
		System.out.println("Valores informados:");
		System.out.println("- Prova 1: " + Media.prova1);
		System.out.println("- Exercicio 1: " + Media.exercicio1);
		System.out.println("- Exercicio 2: " + Media.exercicio2);
		System.out.println("- API: " + Media.api);
		System.out.println("- Extra: " + Media.extra);
		System.out.println("- Substituta: " + Media.substituta);

	}

    
}
