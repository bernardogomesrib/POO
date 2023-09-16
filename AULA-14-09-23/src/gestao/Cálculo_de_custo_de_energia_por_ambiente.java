package gestao;

import java.util.ArrayList;
import java.util.Scanner;

public class Cálculo_de_custo_de_energia_por_ambiente {

	public static void main(String[] args) {
		ArrayList<DispositivoGrupo> dispositivosdoambiente = new ArrayList<DispositivoGrupo>();
		System.out.println("quantos dispositivos diferentes serão postos?");
		Scanner sc = new Scanner(System.in);
		for (int i = sc.nextInt();i>1;i--) {
			sc.nextLine();
			System.out.println("Qual o nome do dispositivo?");
			String nome = sc.nextLine();
			System.out.println("Qual a quantidade dele no ambiente?");
			int quantidade = sc.nextInt();
			System.out.println("Qual é a potêcia do dispositivo?");
			double potencia = sc.nextDouble();
			System.out.println("Quantas horas foram usadas o dispositivo?");
			double horasUsadas = sc.nextDouble();
			dispositivosdoambiente.add(new DispositivoGrupo(nome, quantidade, potencia, horasUsadas));
		}
		double somaPotenciageral= 0;
		for (DispositivoGrupo dispositivos:dispositivosdoambiente) {
			System.out.println("Dispositivo: "+dispositivos.getNome());
			System.out.println("Consumo individual: "+dispositivos.getConsumoIndividual());
			System.out.println("Consumo grupal: "+dispositivos.getConsumoGrupal());
			somaPotenciageral +=dispositivos.getConsumoGrupal();			
		}
		System.out.println("Soma das potências no ambiente é:"+String.format("%.0f", somaPotenciageral));
		sc.close();
	}

}
