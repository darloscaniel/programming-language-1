package exercicio_15;

import java.util.Scanner;

public class Func {

        private float HrsTrab;
        private float ValHora;
    
        public Func(float HrsTrab, float ValHora) {
            this.HrsTrab = HrsTrab;
            this.ValHora = ValHora;
        }
    
        public double ValSal() {
            
            if (HrsTrab > 160) {
                return 160 * ValHora + (((HrsTrab - 160) * ValHora) * 0.5);
            }
   
            
            else {
                return HrsTrab * ValHora;
            }
        }
    
        public static void main(String[] Args) {

            Scanner scanner = new Scanner(System.in);

            Func SalLiq = new Func(scanner.nextFloat(), scanner.nextFloat());
            System.out.println("O salário total do colaborador será de R$"+ String.format("%.2f",SalLiq.ValSal()));
        }
    }
    

