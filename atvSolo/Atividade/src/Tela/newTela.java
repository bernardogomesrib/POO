package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import DB.Conexao;
import DB.ProdutoDao;
import Entity.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class newTela extends JFrame {

	private static JPanel contentPane;
	private static JTextField tf_cod;
	private static JTextField tf_nome;
	private static JTextField tf_quantidade;
	private static JTextField tf_preco;
	private static JTextField tf_imagem;
	private static JLabel lb_imagem;
	private static Produto prod;

	public static Produto getProd() {
		return prod;
	}

	public static void setProd(Produto prod) {
		newTela.prod = prod;
	}

	public static JTextField getTf_cod() {
		return tf_cod;
	}

	public static JTextField getTf_nome() {
		return tf_nome;
	}

	public static JTextField getTf_quantidade() {
		return tf_quantidade;
	}

	public static JTextField getTf_preco() {
		return tf_preco;
	}

	public static JTextField getTf_imagem() {
		return tf_imagem;
	}

	public static JLabel getLb_imagem() {
		return lb_imagem;
	}

	private JButton btCadastrar;
	private JButton btBuscar;
	private JButton brAtualizar;
	private JButton btExcluir;
	private static JButton bt_delImg;

	public static JButton getBt_delImg() {
		return bt_delImg;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newTela frame = new newTela();
					frame.setVisible(true);
					Conexao conn = new Conexao();
					ProdutoDao.intialize(conn.getConexao());
					prod = new Produto();
					prod.setConnection(conn.getConexao());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 316, 628, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COD");
		lblNewLabel.setBounds(49, 76, 46, 14);
		contentPane.add(lblNewLabel);
		
		tf_cod = new JTextField();
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(tf_cod.getText());
				if(!tf_cod.getText().equals("")){
					prod.setCod(Long.parseLong(tf_cod.getText()));
				}
				

			}
		});
		
		tf_cod.setBounds(105, 73, 208, 20);
		contentPane.add(tf_cod);
		tf_cod.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(49, 101, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tf_nome = new JTextField();
		tf_nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setNome(tf_nome.getText());
				System.out.println(prod.getNome());
			}
		});
		tf_nome.setBounds(105, 98, 208, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(28, 126, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		tf_quantidade = new JTextField();
		tf_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					System.out.println(prod.getQuantidade());
					if(!tf_quantidade.getText().equals("")){
						prod.setQuantidade(Integer.parseInt(tf_quantidade.getText()));
					}
					
					
				}catch(Exception a){
					a.printStackTrace();
				}
				
			}
		});
		tf_quantidade.setBounds(105, 123, 86, 20);
		contentPane.add(tf_quantidade);
		tf_quantidade.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(38, 151, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tf_preco = new JTextField();
		tf_preco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					System.out.println(prod.getPreco());
					if(!tf_preco.getText().equals("")){
						prod.setPreco(Double.parseDouble(tf_preco.getText()));
					}
					
					
				} catch (Exception i) {
					i.printStackTrace();
				}
			}
		});
		tf_preco.setBounds(105, 148, 86, 20);
		contentPane.add(tf_preco);
		tf_preco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Imagem");
		lblNewLabel_4.setBounds(38, 176, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tf_imagem = new JTextField();
		tf_imagem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{					
					prod.setImagem(new ImageIcon(tf_imagem.getText()));
                    lb_imagem.setIcon(prod.getImagem());
					bt_delImg.setVisible(true);
				}catch(Exception z){
					prod.setImagem(null);
					lb_imagem.setIcon(null);
					bt_delImg.setVisible(false);
				}
			}
		});

		tf_imagem.setBounds(105, 173, 208, 20);
		contentPane.add(tf_imagem);
		tf_imagem.setColumns(10);
		
		JButton bt_procurar = new JButton("Procurar Imagem no computador");
		bt_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png","PNG");
				fileChooser.setFileFilter(filter);

				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					long fileSizeInBytes = selectedFile.length();
					long fileSizeInKB = fileSizeInBytes / 1024;

					if (fileSizeInKB > 64) {
						// O arquivo é muito grande
						JOptionPane.showMessageDialog(null, "O arquivo selecionado é muito grande. Por favor, selecione um arquivo menor de 64KB.");
					} else {
						// O arquivo está dentro do limite de tamanho
						// Continue com o processamento do arquivo
						String path = fileChooser.getSelectedFile().getPath();
                    tf_imagem.setText(path);
					prod.setImagem(new ImageIcon(path));
                    lb_imagem.setIcon(prod.getImagem());
					bt_delImg.setVisible(true);
					}
				}
            }
			
		});
		bt_procurar.setBounds(105, 200, 208, 23);
		contentPane.add(bt_procurar);
		
		bt_delImg = new JButton("Excluir imagem");
		bt_delImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_imagem.setText("");
				lb_imagem.setIcon(null);
				bt_delImg.setVisible(false);
				try {
					prod.setImagem(null);
				} catch (Exception zz) {
					System.out.println(zz.getLocalizedMessage());
				}				
            }
			
		});
		bt_delImg.setBounds(105, 230, 208, 23);
		contentPane.add(bt_delImg);
		bt_delImg.setVisible(false);



		lb_imagem = new JLabel("");
		lb_imagem.setBounds(358, 11, 244, 300);
		contentPane.add(lb_imagem);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.cadastraProduto()==1){
					JOptionPane.showMessageDialog(null, "Produto Cadastrado");
					ProdutoDao.setTextos(false);
				}else{
					JOptionPane.showMessageDialog(null, "Algum erro ocorreu");
				}
			}
		});
		btCadastrar.setBounds(6, 355, 89, 23);
		contentPane.add(btCadastrar);
		
		btBuscar = new JButton("Buscar");
		btBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDao.buscarProduto();
			}
		});
		btBuscar.setBounds(105, 355, 89, 23);
		contentPane.add(btBuscar);
		
		brAtualizar = new JButton("Atualizar");
		brAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.atualizaProduto() == 1){
					JOptionPane.showMessageDialog(null, "Produto atualizado");
				}else{
					JOptionPane.showMessageDialog(null, "Produto não atualizado");
				}
			}
		});
		brAtualizar.setBounds(204, 355, 89, 23);
		contentPane.add(brAtualizar);
		
		btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.deletaProduto() == 1){
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
				}else{
					JOptionPane.showMessageDialog(null, "Produto não foi deletado.");
				}
			}
		});
		btExcluir.setBounds(303, 355, 89, 23);
		contentPane.add(btExcluir);
	}
}
