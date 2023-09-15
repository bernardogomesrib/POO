package main;

import java.util.Scanner;

public class Atividade5 {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int num = ler.nextInt();
		for (int i = 1; i <=num;i++) {
			if (i%2==0) {
				print(i+"");
			}
		}
		ler.close();
		System.out.printf("A quantidade de números informados foi: %.0f",Math.floor(num/2));
	}
	public static void print(String var) {
		System.out.println(var);
	}
}
