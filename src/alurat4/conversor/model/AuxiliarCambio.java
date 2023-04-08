package alurat4.conversor.model;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import alurat4.conversor.service.CotacaoMoedaService;

public class AuxiliarCambio {
	CotacaoMoedaService cms = new CotacaoMoedaService();
	Moedas moedas = new Moedas();
	public String pegaConversao;
	public String mensagem;
	public int escolha;

	public Double converVerdader() throws Throwable {
		if (!pegaConversao.equalsIgnoreCase("")) {
			Moedas moedas = cms.buscaCotacao(pegaConversao);
			return moedas.getBid();

		} else {
			System.out.println("Moeda não informada");
		}
		return moedas.getBid();

	}

	public String limparCampo() {
		String tex = null;

		return tex;
	}

	public int finalizarSistema() {
		int cancelar = JOptionPane.showConfirmDialog(null, "Você realmente que Finalizar o programa?", mensagem,
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (cancelar == 0) {
			JOptionPane.showMessageDialog(null, "Obrigado por ultilizar nosso sistema");
			return cancelar;
		} else {
			return cancelar;
		}

	}

	public int escolher() {

		return escolha = JOptionPane.showConfirmDialog(null, "Deseja continuar?");

	}
	
	
}