package Identities;

import java.util.Scanner;

public class Curso {
    private int id;
    private String nome;
    private String descricao;
    public Curso(){}
     public Curso(Scanner sc,int parametro){
        if(parametro == 0){
            System.out.println("Nome do curso:");
            this.nome = sc.nextLine();
            System.out.println("Descrição do curso:");
            this.descricao = sc.nextLine();
        }else{
            System.out.println("Id do curso:");
            this.id = Integer.parseInt(sc.nextLine());
            this.nome = null;
            this.descricao = null;
        }
    }
    public Curso(  int id,  String nome,  String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao =  descricao;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
