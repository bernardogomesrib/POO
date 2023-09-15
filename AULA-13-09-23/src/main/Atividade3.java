package main;
import java.util.Scanner;
public class Atividade3 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		if (ler.nextDouble()%2 == 0) {
			print("Par");
		}else {
			print("Impar");
		}
		ler.close();

	}
	public static void print(String var) {
		System.out.println(var);
	}
}
