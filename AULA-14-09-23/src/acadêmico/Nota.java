package acadêmico;

import java.util.Scanner;

public class Nota {
	private double valor;
	private int peso;
	
	public Nota(Scanner leitor) {
		print("Qual e a nota?");
		this.setValor(leitor.nextDouble());
		print("Qual é o peso?");
		this.setPeso(leitor.nextInt());
	}
	public static void print(String s) {
		System.out.println(s);
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
