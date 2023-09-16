package gestao;

import java.util.ArrayList;
import java.util.Scanner;

public class Cálculodecustodeinsumosporaulaprática {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		ArrayList<Insumo> insumos =  new ArrayList<>();
		System.out.println("Qual a quantidade de alunos na prática?");
		Scanner sc = new Scanner(System.in);
		int alunos = sc.nextInt();
		System.out.println("Qual a quantidade de insumos diferentess na prática?");
		for (int i = sc.nextInt();i>=1;i--) {
			insumos.add(new Insumo(sc));
		}
		double somadecustos=0;
		for (Insumo ins:insumos) {
			System.out.println("Nome do insumo: "+ins.getNome());
			System.out.println("Quantidade do insumo: "+ins.getQuantidade());
			System.out.println("Valor unitario do insumo: "+ins.getValorUnitario());
			System.out.println("Valor total para a quantidade de alunos: "+ins.valorPorAluno(alunos));
			somadecustos += ins.valorPorAluno(alunos);
		}
		System.out.println("Valor total de todos os insumos pela considerando a\r\n"
				+ "quantidade de alunos: "+somadecustos);
		
			
		
	}

}
