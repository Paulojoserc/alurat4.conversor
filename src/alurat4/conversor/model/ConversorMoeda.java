package alurat4.conversor.model;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import alurat4.conversor.exceptions.MoedaNaoEncontradaEx;



public class ConversorMoeda {
	 static String WEB_SERVICE = "https://economia.awesomeapi.com.br/json/last/";
	    static int CODIGO_SUCESSO= 200;

	    public static ConversorMoeda getServicoDeCotacao(String codigoMoeda) throws Exception{
	        String urlParaChamada = WEB_SERVICE + codigoMoeda;


	            URL url = new URL(urlParaChamada);
	            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
	            conexao.connect();

	            if(conexao.getResponseCode()!=CODIGO_SUCESSO){
	                throw new MoedaNaoEncontradaEx("Tipo de moeda não encontrada.");
	            }
	            JsonParser jp = new JsonParser();
	            JsonElement root = jp.parse(new InputStreamReader(conexao.getInputStream()));
	            JsonObject jsonPrimario = root.getAsJsonObject();
	            JsonObject jsonSecundario =(JsonObject) jsonPrimario.get(codigoMoeda.replace("-",""));

	            Gson gson = new Gson();

	            ConversorMoeda resposta = gson.fromJson(jsonSecundario, ConversorMoeda.class);

	            conexao.disconnect();

	            return resposta;

	    }
}
