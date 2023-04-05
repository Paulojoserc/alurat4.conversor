package alurat4.conversor.visao;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;
import java.awt.Desktop;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblInformaçãoDaVer = new JLabel("MultiConversor - Ver 1.0");
		lblInformaçãoDaVer.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblInformaçãoDaVer.setBounds(36, 11, 217, 14);
		contentPanel.add(lblInformaçãoDaVer);
		
		JLabel lblAutor = new JLabel("@Author Paulo Costa");
		lblAutor.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblAutor.setBounds(36, 44, 217, 14);
		contentPanel.add(lblAutor);
		
		JLabel lblWebService = new JLabel("Web Service:");
		lblWebService.setToolTipText("Web Service consumida no cambio");
		lblWebService.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblWebService.setBounds(36, 69, 90, 14);
		contentPanel.add(lblWebService);
		
		JLabel lblEnderecoWebService = new JLabel("https://docs.awesomeapi.com.br/");
		lblEnderecoWebService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://docs.awesomeapi.com.br/api-de-moedas");
			}
		});
		lblEnderecoWebService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEnderecoWebService.setForeground(SystemColor.textHighlight);
		lblEnderecoWebService.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblEnderecoWebService.setBounds(136, 70, 217, 14);
		contentPanel.add(lblEnderecoWebService);
	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
