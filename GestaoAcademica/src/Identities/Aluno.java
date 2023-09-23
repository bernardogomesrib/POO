package Identities;

import java.util.Scanner;

public class Aluno {
    private int id;
    private String nome;
    private String curso;
    public Aluno(){}
    public Aluno(Scanner sc,int parametro){
        if(parametro == 0){
            System.out.println("Nome do aluno:");
            this.nome = sc.nextLine();
            System.out.println("Curso do aluno:");
            this.curso = sc.nextLine();
        }else{
            System.out.println("Id do aluno:");
            this.id = Integer.parseInt(sc.nextLine());
            this.nome = null;
            this.curso = null;
        }
    }
    public Aluno(int id,String nome,String curso){
        this.curso = curso;
        this.id = id;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
