package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

    private static String url = "jdbc:mysql://localhost:3306/";
    private static String user = "root";
    private static String pass = "";

    private static Connection conectar;

    public Conexao() {
        try {
            if (conectar ==  null) {
                conectar = DriverManager.getConnection(url, user, pass);
                
                System.out.println("Banco de dados conectado com sucesso!");
                PreparedStatement prep = conectar.prepareStatement("CREATE DATABASE IF NOT EXISTS produtos DEFAULT CHARACTER SET = 'utf8mb4'");
                prep.execute();
                prep = conectar.prepareStatement("USE produtos");
                prep.execute();
                prep = conectar.prepareStatement("CREATE Table IF NOT EXISTS produto(cod BIGINT PRIMARY KEY,nome VARCHAR(50) not NULL,quantidade int not NULL,preco DECIMAL(13,2) not NULL,img BLOB)");
                prep.execute();
            } else {
                System.out.println("Banco de dados conectado com sucesso!");
            }
        } catch (SQLException erro_conectar_banco) {
            System.out.println("Erro ao conectar no banco de dados!\n" + erro_conectar_banco.getMessage());
        }
    }

    public Connection getConexao() {
        return conectar;
    }

    public void finalizarConexao() {
        try {
            conectar.close();
        } catch (SQLException e) {          
            e.printStackTrace();
        }
    }
    
}