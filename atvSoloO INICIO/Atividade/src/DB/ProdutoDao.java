package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Tela.newTela;
import entity.Produto;

public class ProdutoDao {
    private static PreparedStatement prep;
    private static ResultSet rs;
    private static Connection con;
    public static void intialize(){
        con = new Conexao().getConexao();
    }
    public static void cadastraProduto(){
        Produto p = newTela.getProd();
        
    }
}
