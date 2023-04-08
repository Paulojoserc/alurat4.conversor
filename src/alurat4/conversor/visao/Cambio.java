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

import Atxy2k.CustomTextField.RestrictedTextField;
import alurat4.conversor.model.AuxiliarCambio;
import alurat4.conversor.model.Moedas;
import alurat4.conversor.service.CotacaoMoedaService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cambio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@SuppressWarnings("unchecked")
	public Cambio() throws Throwable {
		CotacaoMoedaService cms = new CotacaoMoedaService();
		AuxiliarCambio ac = new AuxiliarCambio();
		// Moedas moedas = new Moedas();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cambio.class.getResource("/img/cambio.png")));
		setTitle("Cambio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 320);
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
		
		textFValor.setColumns(10);

		textFMoedaDeSaida = new JTextField();
		textFMoedaDeSaida.setEditable(false);
		textFMoedaDeSaida.setColumns(10);

		JLabel lblMoedaDeSaida = new JLabel("Cota\u00E7\u00E3o  da moeda de saida");
		lblMoedaDeSaida.setFont(new Font("Verdana", Font.PLAIN, 12));

		JButton btnExecutarConversao = new JButton("Converte");
		btnExecutarConversao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyCode() == evt.VK_ENTER) {
					btnExecutarConversao.requestFocus();
				}
			}

		});
		btnExecutarConversao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuxiliarCambio ax = new AuxiliarCambio();
				textFValor.requestFocus();
				if (CBSelecaoMoedas.getSelectedItem().equals("<Selecione uma das opções>")) {
					JOptionPane.showMessageDialog(null, "É preciso slecionar uma das opções abaixo");
					textFValor.requestFocus();
				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-USD De Reais a Dólares.")) {
					ac.pegaConversao = "BRL-USD";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-EUR De Reais a Euros.")) {
					ac.pegaConversao = "BRL-EUR";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-GBP De Reais a Libras Esterlinas.")) {
					ac.pegaConversao = "BRL-GBP";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-ARS De Reais a Peso Argentino.")) {
					ac.pegaConversao = "BRL-ARS";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("BRL-CLP De Reais a Peso Chileno.")) {
					ac.pegaConversao = "BRL-CLP";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("USD-BRL De Dólares a Reais.")) {
					ac.pegaConversao = "USD-BRL";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("EUR-BRL De Euros a Reais.")) {
					ac.pegaConversao = "EUR-BRL";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("GBP-BRL De Libras Esterlinas a Reais.")) {
					ac.pegaConversao = "GBP-BRL";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("ARS-BRL De Peso Argentino a Reais.")) {
					ac.pegaConversao = "ARS-BRL";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (CBSelecaoMoedas.getSelectedItem().equals("CLP-BRL De Peso Chileno a Reais.")) {
					ac.pegaConversao = "CLP-BRL";

					textFValor.setEditable(true);
					try {
						textFMoedaDeSaida.setText(String.valueOf(ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Double valor = Double.parseDouble(textFValor.getText());
					try {
						textFTotalCambiado.setText(String.valueOf(valor * ac.converVerdader()));
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(null, "Opção invalida. ", null, WIDTH);
				}
				ax.escolher();
				// Sim
				if (ax.escolha == JOptionPane.YES_OPTION) {

					textFValor.setText(ax.limparCampo());
					textFTotalCambiado.setText(ax.limparCampo());
					textFMoedaDeSaida.setText(ax.limparCampo());
					// não fecha a janela direto
				} else if (ax.escolha == JOptionPane.NO_OPTION) {

					setVisible(false);
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					// cancelar da opções de cancelar ou continuar
				} else if (ax.escolha == JOptionPane.CANCEL_OPTION) {

					ax.finalizarSistema();
					if (ax.finalizarSistema() == 0) {
						setVisible(false);
						setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					} else {
						// setVisible(true);
						textFValor.setText(ax.limparCampo());
						textFTotalCambiado.setText(ax.limparCampo());
						textFMoedaDeSaida.setText(ax.limparCampo());
					}

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
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
								.createSequentialGroup()
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
												.addComponent(CBSelecaoMoedas, 0, 218, Short.MAX_VALUE).addGap(3))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(textFMoedaDeSaida, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
												.addComponent(textFValor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														221, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnExecutarConversao, GroupLayout.PREFERRED_SIZE,
																221, Short.MAX_VALUE)))))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblValorTotalDa, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addGap(67).addComponent(textFTotalCambiado, GroupLayout.DEFAULT_SIZE, 221,
												Short.MAX_VALUE)))
						.addGap(295)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(19)
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
				.addGap(42).addComponent(btnExecutarConversao).addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFTotalCambiado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(lblValorTotalDa,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(289, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		/* Uso da biblioteca Atxy2k para limitar os campo a receber apenas numeros */
		RestrictedTextField validar = new RestrictedTextField(textFValor);
		validar.setOnlyNums(true);
	}

	protected char[] converVerdader() {
		// TODO Auto-generated method stub
		return null;
	}
}
