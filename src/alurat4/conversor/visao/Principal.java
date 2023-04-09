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
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 48, 48));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("Sistema Multiconversor");
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnCambio = new JButton("");
		btnCambio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCambio.setBorder(null);
		btnCambio.setBounds(new Rectangle(0, 0, 48, 48));
		btnCambio.setBackground(SystemColor.control);
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
		btnCambio_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCambio_1.setBorder(null);
		btnCambio_1.setBounds(new Rectangle(0, 0, 48, 48));
		btnCambio_1.setBackground(SystemColor.control);
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
		btnCambio_1.setToolTipText("converso Litro/Galão");
		btnCambio_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBackground(SystemColor.control);
		btnSobre.setBorder(null);
		btnSobre.setBounds(new Rectangle(0, 0, 28, 28));
		btnSobre.setAutoscrolls(true);
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
		btnSobre.setSelectedIcon(new ImageIcon(Principal.class.getResource("/img/Sobre Icone.jpg")));
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/Sobre Icone.jpg")));
		btnSobre.setToolTipText("Sobre");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(376)
					.addComponent(btnSobre)
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(113))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCambio_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCambio, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(324, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnCambio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCambio_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(216, Short.MAX_VALUE)
					.addComponent(btnSobre, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
