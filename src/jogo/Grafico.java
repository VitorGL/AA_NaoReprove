
package jogo;

import java.awt.EventQueue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Grafico {
	private BufferedImage backgroundImg;
	private BufferedImage creditoImg;
	private JLabel background;
	private JLabel background1;
	private JFrame frmSt;
	private Escolha[] escolhas = new Escolha[3];
	private Livro livro;
	boolean jogando = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafico window = new Grafico();
					window.frmSt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 public Grafico() {
		frmSt = new JFrame();
		frmSt.setTitle("Não Reprove");
		frmSt.setBounds(100, 100, 800, 600);
		frmSt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSt.getContentPane().setLayout(new CardLayout(0, 0));
		frmSt.setResizable(false);
		
		/*Carrega imagens que serao usadas durante o JFrame
		try {//Caso nao seja encontrada a imagem uma excecao eh lancada
			backgroundImg = ImageIO.read(new File("imgs/jogo.png"));
			creditoImg = ImageIO.read(new File("imgs/Creditos.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}*/
		background = new JLabel();//JLabel que contem a imagem do background
		background.setBounds(0, 0, 800, 600);
		background1 = new JLabel();//JLabel que contem a imagem do background
		background1.setBounds(0, 0, 800, 600);
		
		
		/////////////////////////////////////////
		//////////////  Paineis  ////////////////
		final JPanel mainPanel = new JPanel();
		frmSt.getContentPane().add(mainPanel, "");
		
		
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		final JPanel gamingPanel = new JPanel();
		frmSt.getContentPane().add(gamingPanel, "");
		gamingPanel.setLayout(null);
		gamingPanel.setVisible(false);
		
		final JPanel creditoPanel = new JPanel();
		frmSt.getContentPane().add(creditoPanel, "");
		creditoPanel.setLayout(null);
		creditoPanel.setVisible(false);
		
		
		/////////////////////////////////////////
		///////////////  Labels  ////////////////
		final JLabel bookNameLabel = new JLabel();
		bookNameLabel.setFont(new Font("Liberation Sans", Font.BOLD | Font.ITALIC, 12));
		bookNameLabel.setForeground(new Color(125, 125, 125));
		bookNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookNameLabel.setBounds(40, 20, 720, 100);
		gamingPanel.add(bookNameLabel);
		
		
		/////////////////////////////////////////
		///////////  Parte do Texto  ////////////
		final JTextArea historyLabel = new JTextArea();
		historyLabel.setText("historia");
		historyLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
		historyLabel.setBounds(100, 80, 600, 110);
		historyLabel.setEditable(false);
		historyLabel.setLineWrap(true);
		gamingPanel.add(historyLabel);

		
		final JButton botaoJogarNovamente = new JButton("Jogar Novamente");
		final JButton botaoJogar = new JButton("Novo jogo");
		final JButton botaoVoltar = new JButton("Voltar");
		final JButton botaoSair = new JButton("Sair");
		botaoJogar.setFont(new Font("Monospaced", Font.BOLD, 14));
		final JButton botaoEscolha1 = new JButton("Escolha 1");
		botaoEscolha1.setFont(new Font("Monospaced", Font.BOLD, 12));
		final JButton botaoEscolha2 = new JButton("Escolha 2");
		botaoEscolha2.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		botaoJogarNovamente.setBackground(new Color(0, 0, 102));
		botaoJogarNovamente.setForeground(Color.WHITE);
		botaoJogarNovamente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				livro.reiniciarHistoria();
				botaoEscolha1.setVisible(true);
				botaoEscolha2.setVisible(true);
				botaoJogarNovamente.setVisible(false);
				botaoSair.setVisible(false);
				historyLabel.setText(livro.mostrarHistoria());
				int i=0;
	            for(Escolha choice:livro.nextEvents()) {
	            	escolhas[i] = choice;
	            	i++;
	            }
	            botaoEscolha1.setText(escolhas[0].getDescription());
	            botaoEscolha2.setText(escolhas[1].getDescription());
				
				
			}
		});
		
		botaoJogarNovamente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoJogarNovamente.setBackground(new Color(0, 0, 51));
				botaoJogarNovamente.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoJogarNovamente.setBackground(new Color(0, 0, 102));
				botaoJogarNovamente.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		botaoJogarNovamente.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoJogarNovamente.setBounds(300, 230, 200, 40);
		gamingPanel.add(botaoJogarNovamente);
		botaoJogarNovamente.setVisible(false);
		botaoSair.setVisible(false);

		botaoSair.setBackground(new Color(0, 0, 102));
		botaoSair.setForeground(Color.WHITE);
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		botaoSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoSair.setBackground(new Color(51, 0, 0));
				botaoSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoSair.setBackground(new Color(102, 0, 0));
				botaoSair.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		botaoSair.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoSair.setBounds(300, 270, 200, 40);
		gamingPanel.add(botaoSair);
		botaoSair.setVisible(false);

		botaoJogar.setBackground(new Color(100, 100, 180));
		botaoJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				//gamingPanel.add(backgroundText);
				gamingPanel.add(background);
				gamingPanel.setVisible(true);
				try {
					livro = Engine.criarLivro();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bookNameLabel.setText(livro.mostrarLivroDaHistoria());
				historyLabel.setText(livro.mostrarHistoria());
				int i=0;
	            for(Escolha choice:livro.nextEvents()) {
	            	escolhas[i] = choice;
	            	i++;
	            }
	            botaoEscolha1.setText(escolhas[0].getDescription());
	            botaoEscolha2.setText(escolhas[1].getDescription());
	            
			}
		});
		botaoJogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				botaoJogar.setBackground(new Color(200, 0, 0));
				botaoJogar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoJogar.setBackground(new Color(51, 102, 255));
				botaoJogar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		botaoJogar.setBounds(200, 240, 400, 100);
		mainPanel.add(botaoJogar);
		mainPanel.add(background);
		

		botaoVoltar.setBounds(100, 420, 200, 40);
		creditoPanel.add(botaoVoltar);
		
		
		botaoVoltar.setBackground(new Color(0, 0, 102));
		botaoSair.setForeground(Color.WHITE);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creditoPanel.setVisible(false);
				mainPanel.setVisible(true);
				mainPanel.add(background);
	            
			}
		});
		botaoVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				botaoVoltar.setBackground(new Color(0, 0, 51));
				botaoVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoVoltar.setBackground(new Color(0, 0, 102));
				botaoVoltar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		botaoJogar.setBounds(200, 240, 400, 100);
		mainPanel.add(botaoJogar);
		mainPanel.add(background);
		
				
		botaoEscolha1.setForeground(Color.WHITE);

		botaoEscolha1.setBackground(new Color(40, 100, 200));
		botaoEscolha1.setBounds(80, 200, 320, 60);
		gamingPanel.add(botaoEscolha1);
		
		botaoEscolha1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!livro.isTheEnd()){
					if(livro.proximoEvento(0)){
						historyLabel.setText(livro.mostrarHistoria());
						int i=0;
			            for(Escolha choice:livro.nextEvents()) {
			            	escolhas[i] = choice;
			            	i++;
			            }
			            botaoEscolha1.setText(escolhas[0].getDescription());
			            botaoEscolha2.setText(escolhas[1].getDescription());
					}
				}

			}
		});
		
		botaoEscolha1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoEscolha1.setBackground(new Color(20, 50, 100));
				botaoEscolha1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoEscolha1.setBackground(new Color(40, 100, 200));
				botaoEscolha1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseReleased(MouseEvent arg0) {

			    if(livro.isTheEnd()){
						botaoEscolha1.setVisible(false);
						botaoEscolha2.setVisible(false);
						botaoJogarNovamente.setVisible(true);
						botaoSair.setVisible(true);
			    }
			}
		});
		
		
		botaoEscolha2.setForeground(Color.WHITE);
		botaoEscolha2.setBackground(new Color(200, 50, 20));
		botaoEscolha2.setBounds(400, 200, 320, 60);
		gamingPanel.add(botaoEscolha2);
		
		botaoEscolha2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!livro.isTheEnd()){
					if(livro.proximoEvento(1)){
						historyLabel.setText(livro.mostrarHistoria());
						int i=0;
			            for(Escolha choice:livro.nextEvents()) {
			            	escolhas[i] = choice;
			            	i++;
			            }
			            botaoEscolha1.setText(escolhas[0].getDescription());
			            botaoEscolha2.setText(escolhas[1].getDescription());
					}
				}
			}
		});
		botaoEscolha2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				botaoEscolha2.setBackground(new Color(100, 25, 10));
				botaoEscolha2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				botaoEscolha2.setBackground(new Color(200, 50, 20));
				botaoEscolha2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseReleased(MouseEvent arg0) {

			    if(livro.isTheEnd()){
						botaoEscolha1.setVisible(false);
						botaoEscolha2.setVisible(false);
						botaoJogarNovamente.setVisible(true);
						botaoSair.setVisible(true);
			    }
			}
		});
	
	}
}

