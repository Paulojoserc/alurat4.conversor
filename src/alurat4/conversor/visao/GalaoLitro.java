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
		setIconImage(Toolkit.getDefaultToolkit().getImage(GalaoLitro.class.getResource("/img/galLitro.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 480);
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
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUnidadeEntrada, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
						.addComponent(lblValorTotal, GroupLayout.PREFERRED_SIZE, 296, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConverteUnidade, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldSaida, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDeSaida, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldUnidadeEntrada, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDeEntrda)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(textFieldUnidadeSaidaAbreviada, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
					.addGap(129))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(147)
					.addComponent(CBSelecaoUnidade, 0, 350, Short.MAX_VALUE)
					.addGap(148))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(CBSelecaoUnidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnidadeEntrada)
						.addComponent(textFieldUnidadeEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeEntrda)
						.addComponent(textFieldUnidadeEntraAbreviada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(btnConverteUnidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorTotal)
						.addComponent(textFieldSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeSaida, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUnidadeSaidaAbreviada, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(278, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
