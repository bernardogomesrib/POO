package Entity;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import DB.ProdutoDao;

public class Produto {
    private long cod;
    private double preco;
    private String nome;
    private ImageIcon imagem;
    private int quantidade;
    private Blob blob;
    private static Connection connection;
    
    public void setConnection(Connection connectio) {
        connection = connectio;
    }
    public Blob getBlob() {
        return blob;
    }
    public void setBlob(Blob blob) {
        try {    
            this.blob = blob;
            InputStream in = this.blob.getBinaryStream();
            BufferedImage bufferedImage = ImageIO.read(in);
            Image image = (Image) bufferedImage;
            this.imagem = new ImageIcon(image);            
            ProdutoDao.setTextos(true);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            //e.printStackTrace();
            System.out.println("Erro com imagem nula");
            ProdutoDao.setTextos(true);
        }

    }
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
       if (imagem == null){
        this.imagem = imagem;
        this.blob = null;
       }else{
        this.imagem = imagem;
        Image img = this.imagem.getImage();
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bi, "png", baos);
            byte[] imageInByte = baos.toByteArray();
            try {
                this.blob = connection.createBlob();
                this.blob.setBytes(1, imageInByte);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    


       }
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
  

}
