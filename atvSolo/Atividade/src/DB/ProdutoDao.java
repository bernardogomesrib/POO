package DB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Entity.Produto;
import Tela.newTela;

public class ProdutoDao {
    private static PreparedStatement prep;
    private static ResultSet rs;
    private static Connection con;
    private static Produto p;
    public static void intialize(Connection connection){
        
        con = connection;
    }
    public static int cadastraProduto(){
        p = newTela.getProd();
        String query = "insert into produto values(?,?,?,?,?)";
        try {
            prep = con.prepareStatement(query);
            prep.setLong(1, p.getCod());
            prep.setString(2, p.getNome());
            prep.setInt(3, p.getQuantidade());
            prep.setDouble(4, p.getPreco());
            prep.setBlob(5, p.getBlob());
            return prep.executeUpdate();
        } catch (SQLException e) {
     
            e.printStackTrace();
        }
        return 0;
    }
    public static int buscarProduto(){
        p = newTela.getProd();
        int sum = 0;
        String query = "select * from produto where cod = '"+p.getCod()+"'";
        try {
            prep = con.prepareStatement(query);
            rs = prep.executeQuery();
            while(rs.next()){
                p.setCod(rs.getLong("cod"));
                p.setNome(rs.getString("nome"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getDouble("preco"));
                try {
                    p.setBlob(rs.getBlob("img"));    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                sum+=1;
            }
        } catch (SQLException e) {
     
            e.printStackTrace();
        }
        
        return sum;
    }
    public static void setTextos(Boolean prod){
        p = newTela.getProd();
        if(prod){
            newTela.getTf_cod().setText(""+p.getCod());
            newTela.getTf_nome().setText(p.getNome());
            newTela.getTf_quantidade().setText(""+p.getQuantidade());
            newTela.getTf_preco().setText(""+p.getPreco());
            newTela.getLb_imagem().setIcon(p.getImagem());
            if(p.getImagem() == null){
                newTela.getBt_delImg().setVisible(false);
            }else{
                newTela.getBt_delImg().setVisible(true);
            }
            
        }else{
            newTela.getTf_cod().setText("");
            newTela.getTf_nome().setText("");
            newTela.getTf_quantidade().setText("");
            newTela.getTf_preco().setText("");
            newTela.getTf_imagem().setText("");
            newTela.getLb_imagem().setIcon(null);
        }
    }
    public static int atualizaProduto(){
        p = newTela.getProd();
        String query = "UPDATE produto SET img =?, nome =?, quantidade = ?, preco = ? WHERE cod = ?;";
        try {
            prep = con.prepareStatement(query);            
            prep.setBlob(1, p.getBlob());
            prep.setString(2, p.getNome());
            prep.setInt(3, p.getQuantidade());
            prep.setDouble(4, p.getPreco());            
            prep.setLong(5, p.getCod());
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int deletaProduto(){
        try {
            p = newTela.getProd();
            String query = "delete from produto where cod = '"+p.getCod()+"'";
            prep = con.prepareStatement(query);
            if(JOptionPane.showConfirmDialog(null, "quer realmente apagar o produto?")==0){
                return prep.executeUpdate();
            }
            
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
        }
        return 0;
    }
}
