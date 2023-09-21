package Objects;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.Conexao.Conexao;

public class Produto {
    private int codigo;
    private double valor;
    private String descricao;
    
    public void inserir(Conexao conexao){
        String sql ="insert into produto(codigo,descricao,valor) values(?,?,"+this.getValor()+");";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);            
            statement.setString(1,String.valueOf(this.getCodigo()));
            statement.setString(2,this.getDescricao());            
            if (statement.executeUpdate()>0){
                System.out.println("inserido com sucesso!");
            }else{
                System.out.println("infelizmente não consegui inserir o bixin");
            }
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }
    public void imprimeEu(){
        System.out.println("Codigo: "+this.getCodigo()+
        "\nValor: "+this.getValor()+
        "\nDescrição: "+this.getDescricao());
    }
    public void procurarEu(String codigo, Conexao conexao){
        this.setCodigo(getCodigo());
        String sql ="select * from produto where codigo = '"+codigo+"';";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);            
            ResultSet result = statement.executeQuery();
            while (result.next()){
                System.out.println("chegou aqui");
                this.setCodigo(Integer.parseInt(result.getString(1)));
                System.out.println("chegou aquii");
                this.setDescricao(result.getString(2));
                System.out.println("chegou aquiii");
                this.setValor(Double.parseDouble(result.getString(3)));
            }
            this.imprimeEu();
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public double getValor() {
        return valor;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
