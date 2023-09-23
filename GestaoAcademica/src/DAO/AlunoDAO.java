package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.Connectionn;
import Identities.Aluno;

public class AlunoDAO {
    public static Connectionn con;
    public static void inicializar(Connectionn conn){
        con = conn;
    }
    public static int insert(Aluno aluno){
        String sql = "INSERT INTO aluno values(0,?,?);";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setString(1, aluno.getNome());
            prep.setString(2, aluno.getCurso());
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int atualiza(Aluno aluno){
        String sql = "UPDATE aluno SET nome = ?,curso =? WHERE id =?;";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setInt(3, aluno.getId());
            prep.setString(1, aluno.getNome());
            prep.setString(2, aluno.getCurso());
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static int delete(Aluno aluno){
        String sql = "DELETE from aluno WHERE id =?;";
        try {
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            prep.setInt(1, aluno.getId());
            
            return prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static ResultSet alunos(){
        String sql = "SELECT * FROM aluno";
        try{
            PreparedStatement prep = con.getConexao().prepareStatement(sql);
            return prep.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        ResultSet r = null;
        return r;
    }
    public static Aluno procura(int id){
        String sql = "SELECT * FROM aluno WHERE id = ?";
        PreparedStatement prep = null;
        ResultSet r = null;
        int idd = 0;
        String nome = null;
        String curso = null;
        try{
            prep = con.getConexao().prepareStatement(sql);
            prep.setInt(1, id);
            r = prep.executeQuery();
            while(r.next()){
                idd = Integer.parseInt(r.getString(1));
                nome = r.getString(2);
                curso = r.getString(3);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return new Aluno(idd,nome,curso);
    }
}
