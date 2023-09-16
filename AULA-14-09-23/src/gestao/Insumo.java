package gestao;

import java.util.Scanner;

public class Insumo {
	private String nome;
	private int quantidade;
	private double valorUnitario;
	
	
	public Insumo(Scanner sc) {
		sc.nextLine();
		System.out.println("Qual o nome do insumo?");
		this.nome = sc.nextLine();
		System.out.println("Qual a quantidade do insumo?");
		this.quantidade = sc.nextInt();
		System.out.println("Qual o valor unitario do insumo?");
		this.valorUnitario = sc.nextDouble();
	}
	public double getValorUnitario() {
		return this.valorUnitario;
	}
	public int getQuantidade() {
		return this.quantidade;
	}
	public String getNome() {
		return this.nome;
	}
	public double valorPorAluno(int alunos) {
		return this.valorUnitario*this.quantidade*alunos;
	}
	
}
