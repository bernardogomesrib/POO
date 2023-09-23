package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DB.Connectionn;
import Identities.Curso;

public class CursoDAO {
     public static Connectionn con;
    public static void inicializar(Connectionn conn){
        con = conn;
    }
    public static int insert(Curso curso){
        String sql = "INSERT INTO curso values(?,?,?);";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setInt(1, curso.getId());
            prep.setString(2, curso.getNome());
            prep.setString(3, curso.getDescricao());
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int atualiza(Curso curso){
        String sql = "UPDATE curso SET nome = ?,descricao =? WHERE id =?;";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setInt(3, curso.getId());
            prep.setString(1, curso.getNome());
            prep.setString(2, curso.getDescricao());
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int delete(Curso curso){
        String sql = "DELETE from curso WHERE id =?;";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setInt(1, curso.getId());
            
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static ResultSet cursos(){
        String sql = "SELECT * FROM curso";
        try{
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            return prep.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        ResultSet r = null;
        return r;
    }
    public static Curso procura(int id){
        String sql = "SELECT * FROM curso WHERE id = ?";
        PreparedStatement prep = null;
        ResultSet r = null;
        int idd = 0;
        String nome = null;
        String descricao = null;
        try{
            prep = con.getConexao().prepareStatement(sql);
            prep.setInt(1, id);
            r = prep.executeQuery();
            while(r.next()){
                idd = Integer.parseInt(r.getString(1));
                nome = r.getString(2);
                descricao = r.getString(3);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Curso(idd,nome,descricao);
    }

}
