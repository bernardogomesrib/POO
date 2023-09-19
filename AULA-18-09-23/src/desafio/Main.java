package desafio;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Conexao cn = new Conexao();
		
		boolean def = true;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		while(def) {
			switch (sc.nextInt()) {
			case 1: {
				System.out.println("caso 1");
				count = 0;
				break;
			}
			case 2: {
				System.out.println("caso 2");
				count = 0;
				break;
			}
			case 3: {
				System.out.println("caso 3");
				count = 0;
				break;
			}
			default:
				System.out.println("Entrada errada... você tem mais "+(2-count)+" chances");
				count ++;				
				if (count == 3) {
					def = false;
				}
			}
		}
		
		System.out.println("Fim do programa");
		sc.close();
	}

}
