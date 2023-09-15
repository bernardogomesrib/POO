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

		for (int i = 0;i<quantidadeAlunos;i++) {
			print(i+1+"º aluno");
			this.addAluno(new Aluno(leitor));
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
