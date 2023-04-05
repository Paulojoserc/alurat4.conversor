package alurat4.conversor.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import alurat4.conversor.model.AuxiliarShowConfirmDialog;

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
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

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
		textFieldSaida.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldSaida.setColumns(10);
		
		JButton btnConverteUnidade = new JButton("Converte");
		btnConverteUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AuxiliarShowConfirmDialog au = new AuxiliarShowConfirmDialog();
				
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
				int i = JOptionPane.showConfirmDialog(
				        null, 
				        "Deseja continuar?"
				        );
				if(i == JOptionPane.YES_OPTION) {
				    System.out.println("Clicou em Sim");
				}
				else if(i == JOptionPane.NO_OPTION) {
				    System.out.println("Clicou em Não");
				}
				else if(i == JOptionPane.CANCEL_OPTION) {
				    System.out.println("Clicou em Cancel");
				}
			
			}
		});
		
		JLabel lblDeEntrda = new JLabel("De");
		lblDeEntrda.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel lblDeSaida = new JLabel("De");
		lblDeSaida.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		textFieldUnidadeEntraAbreviada = new JTextField();
		textFieldUnidadeEntraAbreviada.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldUnidadeEntraAbreviada.setEnabled(false);
		textFieldUnidadeEntraAbreviada.setColumns(8);
		
		textFieldUnidadeSaidaAbreviada = new JTextField();
		textFieldUnidadeSaidaAbreviada.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldUnidadeSaidaAbreviada.setEnabled(false);
		textFieldUnidadeSaidaAbreviada.setColumns(8);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(453, Short.MAX_VALUE)
					.addComponent(btnConverteUnidade, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(234))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldUnidadeSaidaAbreviada, 0, 0, Short.MAX_VALUE)
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, 521, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
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
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeEntrda))
					.addGap(4)
					.addComponent(btnConverteUnidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorTotal)
						.addComponent(textFieldSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUnidadeSaidaAbreviada, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeSaida, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(392, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
