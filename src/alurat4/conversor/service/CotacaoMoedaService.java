package alurat4.conversor.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import alurat4.conversor.model.Moedas;

public class CotacaoMoedaService {
	public Moedas buscaCotacao(String conversaoMoedas) throws Exception {
		Object moeda = null;
		String url = "https://economia.awesomeapi.com.br/json/last/";
        String baseCurrency = conversaoMoedas;

        try {
            URL apiUrl = new URL(url+baseCurrency);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();
            while ((line = input.readLine()) != null) {
                response.append(line);
            }
            input.close();
            ObjectMapper mapper = new ObjectMapper();
           
            JSONObject jsonObj = new JSONObject(response.toString());
            JSONObject quotes = jsonObj.getJSONObject(baseCurrency.replace("-", ""));
            moeda = mapper.readValue(quotes.toString(), Moedas.class);
          
            return (Moedas) moeda;
        

        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
}