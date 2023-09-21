package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Main.Conexao.Conexao;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public String printSenha(){
        return "*".repeat(getSenha().length());
    }
    public void imprimeUsuario(){
        System.out.println("CPF:"+this.getCpf()+
        "\nEmail: "+this.getEmail()+
        "\nNome: "+this.getNome()+
        "\nSenha: "+this.printSenha());
    }
    public void Inserir(Conexao teste){
        String sql ="insert into usuario(cpf,nome,email,senha) values(?,?,?,?);";
        try {
            PreparedStatement statement = teste.getConexao().prepareStatement(sql);
            statement.setString(1,this.getCpf());
            statement.setString(2,this.getNome());
            statement.setString(3, this.getEmail());
            statement.setString(4, this.getSenha());
            if (statement.executeUpdate()>0){
                System.out.println("inserido com sucesso!");
            }else{
                System.out.println("infelizmente não consegui inserir o bixin");
            }
        } catch (SQLException e) {            
            e.printStackTrace();
        }


    }
    public void procurarEu(String cpf,Conexao teste){
        String sql ="select * from usuario where cpf = '"+cpf+"';";
        try {
            PreparedStatement statement = teste.getConexao().prepareStatement(sql);            
            ResultSet result = statement.executeQuery();
            while (result.next()){
                this.setCpf(result.getString(1));
                this.setNome(result.getString(2));
                this.setEmail(result.getString(3));
                this.setSenha(result.getString(4));
            }
            this.imprimeUsuario();           
            
            
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }
}
