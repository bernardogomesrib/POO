package main;
import java.util.Scanner;

public class Atividade2 {

	public static void main(String[] args) {		
		Scanner ler = new Scanner(System.in);
		println("qual numero?");
		double num = ler.nextDouble();
		println(Math.pow(num, 2)+"");
		ler.close();
		
	}
	public static void println(String valores) {
		System.out.println(valores);
	}
	
	
}
