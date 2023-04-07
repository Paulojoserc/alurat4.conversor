package alurat4.conversor.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import alurat4.conversor.model.AuxiliarCambio;

public class GalaoLitro extends JFrame {

	protected static final MouseEvent MPG = null;
	private JPanel contentPane;
	private JTextField textFieldUnidadeEntrada;
	private JTextField textFieldSaida;
	private JTextField textFieldUnidadeEntraAbreviada;
	private JTextField textFieldUnidadeSaidaAbreviada;

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
		setTitle("Litro para Galão");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GalaoLitro.class.getResource("/img/galLitro.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 250);
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
		
		JLabel lblValorTotal = new JLabel("Valor toral da unidade convertidas:");
		lblValorTotal.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		textFieldSaida = new JTextField();
		textFieldSaida.setEnabled(false);
		textFieldSaida.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldSaida.setColumns(10);
		
		JButton btnConverteUnidade = new JButton("Converte");
		btnConverteUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha;
				do {								
				if(CBSelecaoUnidade.getSelectedItem().equals("<Selecione uma das opções>")) {
				JOptionPane.showMessageDialog(null, "Opção invalida selecione uma das opções abaixo", null, WIDTH);
				}else if(CBSelecaoUnidade.getSelectedItem().equals("MPG-KML Milhas por galão para Quilômetros por litro.")) {
					textFieldUnidadeEntraAbreviada.setText("MPG");
					textFieldUnidadeSaidaAbreviada.setText("KML");
					
					Double unidaEntrada =  Double.parseDouble(textFieldUnidadeEntrada.getText());
					Double valorSaida = unidaEntrada/2.352;
					NumberFormat df = NumberFormat.getNumberInstance();
		            df.setMaximumFractionDigits(2);
		            df.setMinimumFractionDigits(2);
					textFieldSaida.setText(String.valueOf(df.format(valorSaida)));
					
				}else {
					textFieldUnidadeEntraAbreviada.setText("KML");
					textFieldUnidadeSaidaAbreviada.setText("MPG");
					Double unidaEntrada =  Double.parseDouble(textFieldUnidadeEntrada.getText());
					Double valorSaida = unidaEntrada*2.352;
					NumberFormat df = NumberFormat.getNumberInstance();
		            df.setMaximumFractionDigits(2);
		            df.setMinimumFractionDigits(2);
					textFieldSaida.setText(String.valueOf(df.format(valorSaida)));
				}
				escolha = JOptionPane.showConfirmDialog(
				        null, 
				        "Deseja continuar?"
				        );
				if(escolha == JOptionPane.YES_OPTION) {
				    System.out.println("Clicou em Sim");
				}
				else if(escolha == JOptionPane.NO_OPTION) {
					GalaoLitro frame = new GalaoLitro();
					frame.dispose();
					//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				}
				else if(escolha == JOptionPane.CANCEL_OPTION) {
				   AuxiliarCambio ax = new AuxiliarCambio();
				   textFieldUnidadeEntrada.setText(ax.limparGalaoLitro());
				   textFieldSaida.setText(ax.limparGalaoLitro());
				   textFieldUnidadeEntraAbreviada.setText(ax.limparGalaoLitro());
				   textFieldUnidadeSaidaAbreviada.setText(ax.limparGalaoLitro());
				}
			}while(escolha==JOptionPane.NO_OPTION);
			}
		});
		
		JLabel lblDeEntrda = new JLabel("De");
		lblDeEntrda.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblDeSaida = new JLabel("De");
		lblDeSaida.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		textFieldUnidadeEntraAbreviada = new JTextField();
		textFieldUnidadeEntraAbreviada.setBorder(null);
		textFieldUnidadeEntraAbreviada.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldUnidadeEntraAbreviada.setEnabled(false);
		textFieldUnidadeEntraAbreviada.setColumns(8);
		
		textFieldUnidadeSaidaAbreviada = new JTextField();
		textFieldUnidadeSaidaAbreviada.setBorder(null);
		textFieldUnidadeSaidaAbreviada.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldUnidadeSaidaAbreviada.setEnabled(false);
		textFieldUnidadeSaidaAbreviada.setColumns(8);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(353, Short.MAX_VALUE)
					.addComponent(btnConverteUnidade, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(234))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblValorTotal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUnidadeEntrada, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldSaida)
						.addComponent(textFieldUnidadeEntrada, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(lblDeEntrda))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblDeSaida, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(textFieldUnidadeSaidaAbreviada, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addGap(57))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnidadeEntrada)
						.addComponent(textFieldUnidadeEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeEntrda))
					.addGap(4)
					.addComponent(btnConverteUnidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorTotal)
						.addComponent(textFieldSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUnidadeSaidaAbreviada, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeSaida, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		/*Uso da biblioteca Atxy2k para limitar os campo a receber apenas numeros*/
		RestrictedTextField validar = new RestrictedTextField(textFieldUnidadeEntrada);
		validar.setOnlyNums(true);
	}
	
}
