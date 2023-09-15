package acadêmico;

import java.util.ArrayList;
import java.util.Scanner;

public class UnidadeCurricular {
	String nome;
	ArrayList<Aluno>alunos = new ArrayList<Aluno>();
	
	public UnidadeCurricular() {
		Scanner leitor = new Scanner(System.in);
		print("qual o nome da unidade Curricular?");
		this.setNome(leitor.nextLine());
		print("Quantos alunos serão lidos?");
		int quantidadeAlunos = leitor.nextInt();
		int[] peso = new int[3];
		print("qual o peso da primeira nota?");
		peso[0] = leitor.nextInt();
		print("qual o peso da segunda nota?");
		peso[1] = leitor.nextInt();
		print("qual o peso da terceira nota?");
		peso[2] = leitor.nextInt();
		
		for (int i = 0;i<quantidadeAlunos;i++) {
			print(i+1+"º aluno");
			this.addAluno(new Aluno(leitor,peso));
		}		
		leitor.close();
	}
	
	
	public static void print(String s) {
		System.out.println(s);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
}
