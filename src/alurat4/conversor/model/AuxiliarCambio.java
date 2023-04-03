package alurat4.conversor.model;

import alurat4.conversor.service.CotacaoMoedaService;

public class AuxiliarCambio {
	CotacaoMoedaService cms = new CotacaoMoedaService();
	Moedas moedas = new Moedas();
	public String pegaConversao;
	
	public Double converVerdader() throws Throwable {
	if(!pegaConversao.equalsIgnoreCase("")){
		Moedas moedas = cms.buscaCotacao(pegaConversao);
		return moedas.getBid(); 
		
	}else {
		System.out.println("Moeda não informada");
	}
	return moedas.getBid();
	
}
}