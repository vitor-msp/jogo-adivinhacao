package adivinhacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JogoAdivinhacao extends JFrame {

	private JPanel contentPane;
	private JTextField textTentativa;
	private static int numeroCorreto = (int) (Math.random() * 100);
	private static int tentativasRestantes = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogoAdivinhacao frame = new JogoAdivinhacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JogoAdivinhacao() {
		setTitle("Jogo da Adivinha\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 201);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("");
		lblResult.setForeground(Color.WHITE);
		lblResult.setBounds(15, 91, 317, 14);
		contentPane.add(lblResult);
		
		JLabel lblTentRest = new JLabel("10 tentativa(s) restante(s)");
		lblTentRest.setForeground(Color.WHITE);
		lblTentRest.setBounds(15, 116, 317, 14);
		contentPane.add(lblTentRest);
		
		textTentativa = new JTextField();
		textTentativa.setBounds(70, 60, 86, 20);
		contentPane.add(textTentativa);
		textTentativa.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Fa\u00E7a sua tentativa:");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(15, 35, 119, 14);
		contentPane.add(lblTitulo);
		
		JButton btnTestar = new JButton("Testar");
		btnTestar.setBackground(Color.WHITE);
		btnTestar.setForeground(Color.BLUE);
		btnTestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tentativasRestantes > 0) {
					int tentativa = 0;
					try {						
						tentativa = Integer.parseInt(textTentativa.getText());
						if(tentativa < 0 || tentativa > 100) {
							throw new Exception();
						}
					}catch(Exception erro) {
						lblResult.setText("Você deve digitar um número inteiro entre 0 e 100!");
						return;						
					}
					tentativasRestantes--;
					if(tentativa == numeroCorreto) {
						lblResult.setText("Acertou! XD");
					}else {
						String texto = tentativa > numeroCorreto ? "maior" : "menor" ;
						lblResult.setText("Errou! Entrada " + texto + " que o esperado.");
						lblTentRest.setText(tentativasRestantes + " tentativa(s) restante(s)");
					}
				}else {
					lblResult.setText("Você esgotou suas tentativas! ;(");
				}
			}
		});
		btnTestar.setBounds(166, 57, 89, 23);
		contentPane.add(btnTestar);
		
		JLabel lblDescricao = new JLabel("Adivinhe o n\u00FAmero aleat\u00F3rio gerado entre 0 e 100");
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(15, 10, 317, 14);
		contentPane.add(lblDescricao);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setForeground(Color.BLUE);
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(243, 128, 89, 23);
		contentPane.add(btnSair);
	}

}
