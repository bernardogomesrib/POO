package entity;

import javax.swing.ImageIcon;

public class Produto {
    private long cod;
    private double preco;
    private String nome;
    private ImageIcon imagem;
    private int quantidade;
    public long getCod() {
        return cod;
    }
    public void setCod(long cod) {
        this.cod = cod;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ImageIcon getImagem() {
        return imagem;
    }
    public void setImagem(ImageIcon imagem) {
        this.imagem = imagem;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    

}
