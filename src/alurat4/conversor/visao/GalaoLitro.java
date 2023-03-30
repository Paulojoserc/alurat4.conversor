package alurat4.conversor.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GalaoLitro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUnidadeEntrada;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GalaoLitro frame = new GalaoLitro();
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
	public GalaoLitro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GalaoLitro.class.getResource("/img/galLitro.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JComboBox CBSelecaoUnidade = new JComboBox();
		CBSelecaoUnidade.setModel(new DefaultComboBoxModel(new String[] {"<Selecione uma das opções>", "MPG-KML Milhas por galão para Quilômetros por litro.", "KML-MPG Quilômetros por litro para Milhas por galão."}));
		
		JLabel lblUnidadeEntrada = new JLabel("Informe o unidade de entrada:");
		lblUnidadeEntrada.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		textFieldUnidadeEntrada = new JTextField();
		textFieldUnidadeEntrada.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldUnidadeEntrada.setColumns(10);
		
		JLabel lblRecebeEntrada = new JLabel("");
		lblRecebeEntrada.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblValorTotal = new JLabel("Valor toral da unidade:");
		lblValorTotal.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JLabel lblValorDESaida = new JLabel("");
		lblValorDESaida.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnConverteUnidade = new JButton("Converte");
		btnConverteUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CBSelecaoUnidade.getSelectedItem().equals("<Selecione uma das opções>")) {
				JOptionPane.showMessageDialog(null, "Opção invalida selecione uma das opções abaixo", null, WIDTH);
				}else if(CBSelecaoUnidade.getSelectedItem().equals("MPG-KML Milhas por galão para Quilômetros por litro.")) {
					
				}	
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUnidadeEntrada, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValorTotal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(135)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConverteUnidade, GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
							.addGap(74))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldUnidadeEntrada, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(49))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRecebeEntrada, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
									.addGap(50))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblValorDESaida, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
									.addGap(76))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnidadeEntrada)
						.addComponent(textFieldUnidadeEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRecebeEntrada))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConverteUnidade)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorTotal)
						.addComponent(lblValorDESaida)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(98, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
