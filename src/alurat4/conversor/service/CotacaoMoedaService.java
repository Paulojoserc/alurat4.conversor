package alurat4.conversor.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import alurat4.conversor.model.Moedas;


public class CotacaoMoedaService  {
	
public Moedas buscaCotacao(String conversaoMoedas) throws Exception {
	Moedas moeda = null;
	HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/json/last/"+conversaoMoedas);
	
	try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
			CloseableHttpResponse response = httpClient.execute(request)) {

		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity);
			Gson gson = new Gson();
			moeda = gson.fromJson(result, Moedas.class);
		}

	}

	return moeda;
}
	
}  