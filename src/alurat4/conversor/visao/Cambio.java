package alurat4.conversor.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import alurat4.conversor.model.Moedas;
import alurat4.conversor.service.CotacaoMoedaService;

public class Cambio extends JFrame {

	private JPanel contentPane;
	private JTextField textFValor;
	private JTextField textFMoedaDeSaida;
	private JTextField textFTotalCambiado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cambio frame = new Cambio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Throwable
	 */
	public Cambio() throws Throwable {
		CotacaoMoedaService cms = new CotacaoMoedaService();
		Moedas moedas = null;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cambio.class.getResource("/img/cambio.png")));
		setTitle("Cambio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JComboBox CBSelecaoMoedas = new JComboBox();
		CBSelecaoMoedas.setFont(new Font("Verdana", Font.PLAIN, 12));
		CBSelecaoMoedas.setToolTipText("Selecione as moedas");
		CBSelecaoMoedas.setModel(new DefaultComboBoxModel(new String[] { "<Selecione uma das opções>",
				"BRL-USD De Reais a Dólares.", "BRL-EUR De Reais a Euros.", "BRL-GBP De Reais a Libras Esterlinas.",
				"BRL-ARS De Reais a Peso Argentino.", "BRL-CLP De Reais a Peso Chileno.", "USD-BRL De Dólares a Reais.",
				"EUR-BRL De Euros a Reais.", "GBP-BRL De Libras Esterlinas a Reais.",
				"ARS-BRL De Peso Argentino a Reais.", "CLP-BRL De Peso Chileno a Reais." }));

		JLabel lblEscolherConvercao = new JLabel("Selecione as moedas para cambio");
		lblEscolherConvercao.setFont(new Font("Verdana", Font.PLAIN, 12));

		JLabel lblInformeValorDoCambio = new JLabel("Valor para ser convertido");
		lblInformeValorDoCambio.setFont(new Font("Verdana", Font.PLAIN, 12));

		textFValor = new JTextField();
		/*if(!CBSelecaoMoedas.getSelectedItem().equals("<Selecione uma das opções>")) {
			System.out.println("Estou aqui");
			textFValor.setEditable(true);
		}else {
			textFValor.setEditable(false);	
		}*/
		textFValor.setColumns(10);

		textFMoedaDeSaida = new JTextField();
		textFMoedaDeSaida.setEditable(false);
		textFMoedaDeSaida.setColumns(10);
		
		JLabel lblMoedaDeSaida = new JLabel("Cota\u00E7\u00E3o  da moeda de saida");
		lblMoedaDeSaida.setFont(new Font("Verdana", Font.PLAIN, 12));

		JButton btnExecutarConversao = new JButton("Converte");
		btnExecutarConversao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CBSelecaoMoedas.getSelectedItem().equals("<Selecione uma das opções>")) {
					JOptionPane.showMessageDialog(null, "Opção invalida selecione uma das opções abaixo", null, WIDTH);
				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-USD De Reais a Dólares.")) {
					String conversaoMoedas = "BRL-USD";
					
					try {
						Moedas moedas = cms.buscaCotacao(conversaoMoedas);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textFValor.setEditable(true);
					textFMoedaDeSaida.setText(String.valueOf(moedas.getBid()));
					Double valor = Double.parseDouble(textFValor.getText());
					textFTotalCambiado.setText(String.valueOf(valor * moedas.getBid()));

				}
			}
		});
		btnExecutarConversao.setFont(new Font("Verdana", Font.BOLD, 12));

		JLabel lblValorTotalDa = new JLabel("Valor Total da Convers\u00E3o:");
		lblValorTotalDa.setFont(new Font("Verdana", Font.PLAIN, 12));

		textFTotalCambiado = new JTextField();
		textFTotalCambiado.setEditable(false);
		textFTotalCambiado.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblValorTotalDa, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addGap(67)
										.addComponent(
												textFTotalCambiado, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
										.addGap(272))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblMoedaDeSaida, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(67))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblEscolherConvercao, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(34))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblInformeValorDoCambio, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(89)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(CBSelecaoMoedas, 0, 218, Short.MAX_VALUE)
														.addGap(275))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
																.addComponent(textFMoedaDeSaida, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
																.addComponent(textFValor, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnExecutarConversao,
																				GroupLayout.PREFERRED_SIZE, 221,
																				Short.MAX_VALUE)))
														.addGap(272)))))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(21)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblEscolherConvercao)
						.addComponent(CBSelecaoMoedas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblInformeValorDoCambio)
						.addComponent(textFValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFMoedaDeSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMoedaDeSaida))
				.addGap(42).addComponent(btnExecutarConversao).addGap(53)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFTotalCambiado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(lblValorTotalDa,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(252, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
