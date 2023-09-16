package financeiro;

import java.util.Scanner;

public class SalarioLiquido {
    public static void print(String s){
        System.out.println(s);
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		print("Qual o nome do funcionário?");
		String Nome = sc.nextLine();
		print("Qual é o cargo?");
		String cargo = sc.nextLine();
		print("Qual é o horario de trabalho?");
		String horario = sc.nextLine();
		print("Qual é o salário base?");
		double salariobase = sc.nextDouble();
		Funcionario fun = new Funcionario(Nome, cargo, horario, salariobase);
		fun.relatorio();
	
		sc.close();
	}
	

}
