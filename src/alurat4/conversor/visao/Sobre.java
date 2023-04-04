package alurat4.conversor.visao;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalExclusionType;

public class Sobre extends JFrame {

	private JPanel contentSobre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sobre() {
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setResizable(false);
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		contentSobre = new JPanel();
		FlowLayout fl_contentSobre = (FlowLayout) contentSobre.getLayout();
		fl_contentSobre.setAlignOnBaseline(true);
		contentSobre.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentSobre);
	}

}
