package alurat4.conversor.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/home.png")));
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("Sistemas de cambio");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnCambio = new JButton("");
		btnCambio.setBackground(Color.LIGHT_GRAY);
		btnCambio.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCambio.setToolTipText("Cambio");
		btnCambio.setIcon(new ImageIcon(Principal.class.getResource("/img/btCambio.png")));
		btnCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambio cambio = null;
				try {
					cambio = new Cambio();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cambio.setVisible(true);
			}
		});
		
		JButton btnCambio_1 = new JButton("");
		btnCambio_1.setBackground(new Color(0, 191, 255));
		btnCambio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GalaoLitro galaoLitro = null;
				try {
					galaoLitro = new GalaoLitro();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				galaoLitro.setVisible(true);
			}
		});
		btnCambio_1.setIcon(new ImageIcon(Principal.class.getResource("/img/btGalLitro.jpg")));
		btnCambio_1.setToolTipText("Cambio");
		btnCambio_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = null;
				try {
					sobre = new Sobre();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				sobre.setVisible(true);
			}
		});
		btnSobre.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/Sobre.jpg")));
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/Sobre.jpg")));
		btnSobre.setToolTipText("Sobre");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(123)
					.addComponent(btnCambio, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnCambio_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(449, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(588)
							.addComponent(btnSobre, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(136)
							.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)))
					.addGap(116))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(163)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCambio)
						.addComponent(btnCambio_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(147)
					.addComponent(btnSobre)
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
