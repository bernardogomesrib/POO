package main;

import java.util.Scanner;

public class Atividade4 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int num = ler.nextInt();
		for (int i = 0; i <=num;i++) {
			if (i%2==0) {
				print(i+"");
			}
		}
		ler.close();
	}
	public static void print(String var) {
		System.out.println(var);
	}

}
