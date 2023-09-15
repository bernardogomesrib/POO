package acadêmico;

import java.util.Scanner;

public class CalculoMulta {
    public static void print(String s){
        System.out.println(s);
    }
    public static void main(String[] args){
        print("Qual é o nome do aluno?");
        Scanner sc = new Scanner(System.in);
        String Nome = sc.nextLine();
        print("Qual é o curso do aluno?");
        String Curso = sc.nextLine();
        print("Quantos livros emprestados o aluno tem?");
        int qntLivros = sc.nextInt();
        print("Quantos dias está atrasada a entrega dos livros?");
        int diasAtrasado = sc.nextInt();
        Aluno aluno = new Aluno(Nome, Curso, diasAtrasado, qntLivros);
        aluno.multa();
        sc.close();
    }
    
}
