package Main;

import java.util.Scanner;
import Main.Conexao.Conexao;
import Objects.Produto;
import Objects.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexao teste = new Conexao();
        Usuario p = new Usuario();
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você quer fazer?");
        boolean loop = true;
        while(loop){
            System.out.println("1 - cadastrar usuario\n2 - procurar usuario\n3 - cadastrar produto\n4 - procurar produto\n5 - sair");
            int entrada = sc.nextInt();
            switch(entrada){
                case 1:
                    sc.nextLine();
                    System.out.println("Informe o cpf do usuário");
                    p.setCpf(sc.nextLine());
                    System.out.println("Informe o nome do usuário");
                    p.setNome(sc.nextLine());
                    System.out.println("Informe o email do usuário");
                    p.setEmail(sc.nextLine());
                    System.out.println("Informe a senha do usuário");
                    p.setSenha(sc.nextLine());
                    p.imprimeUsuario();
                    p.Inserir(teste);
                    sc.close();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Qual o cpf da pessoa que você quer encontrar?");
                    p.procurarEu(sc.nextLine(),teste);
                    break;      
                case 3:
                    Produto produto = new Produto();
                    System.out.println("Informe o codigo do produto");                    
                    produto.setCodigo(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Informe a descrição do produto");
                    produto.setDescricao(sc.nextLine());
                    System.out.println("Informe o valor do produto");
                    produto.setValor(Double.parseDouble(sc.nextLine()));
                    produto.inserir(teste);
                    break;
                case 4:
                    Produto prod = new Produto();
                    sc.nextLine();
                    System.out.println("Qual o codigo do produto?");
                    prod.procurarEu(sc.nextLine(), teste);
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }
        sc.close();
    }   
}
                                           