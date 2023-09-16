package financeiro;
import java.util.Scanner;

import acadêmico.Aluno;
public class Desconto {
	public static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		String n;
		String c;
		double v;
		double d;
		Scanner ler = new Scanner(System.in);
		print("Qual o nome do aluno?");
		n = ler.nextLine();
		print("Qual o nome do curso?");
		c = ler.nextLine();
		print("Qual o valor da mensalidade?");
		v = ler.nextDouble();
		print("qual o valor do desconto em porcentagem?(sem o simbolo de %)");
		d = ler.nextDouble();
		d /= 100;
				
		Aluno aluno = new Aluno(n,c,v,d);
		aluno.getRelatorio();
		ler.close();
		
		
	}

}
