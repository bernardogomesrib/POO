package acadêmico;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
	private ArrayList<Nota> notas = new ArrayList<Nota>();
	private String Nome;
	private String curso;
	private int diasAtrasado;
	private int qntLivros;
	
	
	public Aluno(String Nome,String curso,int diasAtrasado,int qntLivros){
		this.curso = curso;
		this.diasAtrasado = diasAtrasado;
		this.qntLivros = qntLivros;
	}
	public void multa(){
		double mult = this.diasAtrasado*this.qntLivros;
		print("o aluno "+this.Nome+" do curso "+this.curso+" está devendo R$"+String.format("%.2f por ficar %d dias atrasado",mult,this.diasAtrasado));
	}
	public Aluno(Scanner leitor,int[]peso) {
		leitor.nextLine();
		print("Qual é o nome do aluno?");
		this.setNome(leitor.nextLine());
		for(int i = 0; i<3;i++) {
			print(i+1+"ª nota");
			this.addNota(new Nota(leitor,peso[i]));
		}
		
	}
	public static void print(String s) {
		System.out.println(s);
	}
	
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public void addNota(Nota novanota) {
		this.notas.add(novanota);
	}
	public double getMedia() {
		double media = 0;
		int soma = 0;
		
		for (Nota nota:this.notas) {
			media+= nota.getPeso()*nota.getValor();
			soma+=nota.getPeso();
		}
		media = media/soma;
		return media;
	}
	
}
