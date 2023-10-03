package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connectionn {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String pass = "";

    private static Connection conectar;

    //contrutor da classe, verifica se o objeto conexao é nulo, se sim, estabelece a conexao através do DriverManager, se não, retorna a conexão existente
    public Connectionn() {
        try {
            if (conectar == null) {
                conectar = DriverManager.getConnection(url, user, pass);
                System.out.println("Conectado");
                //depois de conectar eu entro crio e entro no banco de dados
                PreparedStatement prep = conectar.prepareStatement("CREATE DATABASE IF NOT EXISTS gestaoacademica;");
                prep.execute();
                prep = conectar.prepareStatement("use gestaoacademica ;");
                prep.execute();
                //depois de criar e entrar no banco de dados eu crio as tabelas para usar
                prep = conectar.prepareStatement("CREATE TABLE if not exists Aluno(id int NOT NULL PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255) NOT NULL,curso VARCHAR(255) NOT NULL);");
                prep.execute();
                prep = conectar.prepareStatement("CREATE TABLE if NOT exists Curso(id int NOT NULL PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(255),descricao VARCHAR(255));");
                prep.execute();
            } else {
                System.out.println("Conectado");
            }

        } catch (SQLException erro_conectar_banco) {
            System.out.println("Falha ao conectar com o banco de dados!\n" + erro_conectar_banco.getMessage());
        }
    }

    //método para retornar a conexão
    public Connection getConexao() {
        return conectar;
    }

    //método sem retorno para finalizar a conexão
    public void finalizar_conexao() {
        try {
            conectar.close();
        } catch (SQLException erro_finalizar_conexao){
            System.out.println("Falha ao finalizar conexão com o banco de dados!\n" + erro_finalizar_conexao.getMessage());
        }
    }
    
}
