package alurat4.conversor.app;

import java.util.Scanner;

import alurat4.conversor.model.Moedas;
import alurat4.conversor.service.CotacaoMoedaService;

public class TesteProgram {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma das opições de conversão de moedas abaixa");
		System.out.printf("BRL-USD: De Reais a Dólares %n" + "BRL-EUR: De Reais a Euros%n"
				+ "BRL-GBP: De Reais a Libras Esterlinas%n" + "BRL-ARS: De Reais a Peso Argentino%n"
				+ "BRL-CLP: De Reais a Peso Chileno%n" + "USD-BRL: De Dólares a Reais%n" + "EUR-BRL: De Euros a Reais%n"
				+ "GBP-BRL: De Libras Esterlinas a Reais%n" + "ARS-BRL: De Peso Argentino a Reais%n"
				+ "CLP-BRL: De Peso Chileno a Reais%n");
		CotacaoMoedaService cms = new CotacaoMoedaService();
		System.out.println("Digite a opção escolhida");
		String conversaoMoedas = sc.nextLine();
		if(!conversaoMoedas.equalsIgnoreCase("")){
			Moedas moedas = cms.buscaCotacao(conversaoMoedas);
			System.out.println(moedas.toString()); 
		}else {
			System.out.println("Moeda não informada");
		}
		
		sc.close();
	}
}
