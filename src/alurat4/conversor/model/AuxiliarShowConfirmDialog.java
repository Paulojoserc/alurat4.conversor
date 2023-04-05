package alurat4.conversor.model;

import javax.swing.JOptionPane;

public class AuxiliarShowConfirmDialog {
	public void menuEscolhaSaida(){
        int escolha = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
        switch (escolha){
            case JOptionPane.YES_OPTION:
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                System.exit(0);
                break;

            case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "Programa Concluído!");
                System.exit(0);
                break;
        }
    }
}
