package br.com.amedigital.api.consuming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.jayway.jsonpath.JsonPath;

import br.com.amedigital.api.PlanetsStarwarsApiApplication;
import br.com.amedigital.api.repository.SwapiPlanetRepository;
import br.com.amedigital.api.transfer.SwapiPlanetTransfer;

/**
 * @author THIAGO
 *
 */


@Component
public class SwapiPlanetConsuming implements SwapiPlanetRepository {
	private static final Logger LOG = LoggerFactory.getLogger(PlanetsStarwarsApiApplication.class);
	private Map<Long, SwapiPlanetTransfer> mapSwapi = new HashMap<>();

	@Override
	@Cacheable("planets")
	public List<SwapiPlanetTransfer> listarTudo() {
		try {
			carregarFilms();
		} catch (ClientProtocolException e) {
			LOG.error("Erro", e);
		} catch (IOException e) {
			LOG.error("Erro", e);
		}
		return new ArrayList<SwapiPlanetTransfer>(mapSwapi.values());
	}

	@Override
	public SwapiPlanetTransfer listarPorNome(String name) {
		return this.mapSwapi.values().stream().filter(a -> a.getNome().equalsIgnoreCase(name)).findAny().orElse(null);
	}

	public void carregarFilms() throws ClientProtocolException, IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet("https://swapi.co/api/films/");
		getRequest.addHeader("accept", "application/json");
		getRequest.addHeader("Content-Type", "application/json");
		HttpResponse response = httpClient.execute(getRequest);

		// Verificar se vai ter erro na requisição
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode != 200) {
			throw new RuntimeException("Erro Code HTTP : " + statusCode);
		}

		HttpEntity httpEntity = response.getEntity();
		String apiOutput = EntityUtils.toString(httpEntity);

		//PEGA UMA LISTA DE URLS DOS PLANETAS QUE APARECE NO FILME RESULTANTE DO JSON
		List<String> listURIPlanets = JsonPath.parse(apiOutput).read("$.results[*].planets[*]");
		//CARREGA A FUNÇÃO CARREGAR PLANETAS PARA CONTAR 
		//A QUANTIDADE DE URLS ASSIM APRESENTAR O QTD DE FILMES QUE O PLANETA APARECEU
		carregarPlanetas(listURIPlanets); 

	}

	private void carregarPlanetas(List<String> listURIPlanets) throws ParseException, IOException {

		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet getRequest;
		HttpResponse response;
		int statusCode;
		String apiOutput;
		//FOR PARA PEGAR TODOS OS IDS DA API SWAPI PARA CONTAR O QTD_FILMS
		for (String urlPlanets : listURIPlanets) {

			Long id = Long
					.parseLong(urlPlanets.substring("https://swapi.co/api/planets/".length(), urlPlanets.length() - 1));

			getRequest = new HttpGet(urlPlanets);
			getRequest.addHeader("accept", "application/json");
			getRequest.addHeader("Content-Type", "application/json");

			response = httpClient.execute(getRequest);
			
			// Verificar se vai ter erro na requisição
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Erro Code HTTP :  " + statusCode);
			}

			HttpEntity httpEntity = response.getEntity();
			apiOutput = EntityUtils.toString(httpEntity);
			//VARAVEIS PARA PEGAR O NOME, CLIMA E TERRENO DO PLANETA
			String name = JsonPath.parse(apiOutput).read("$.name");
			String clima = JsonPath.parse(apiOutput).read("$.climate");
			String terreno = JsonPath.parse(apiOutput).read("$.terrain");
			if (!mapSwapi.containsKey(id)) {
				//MONTAR O OBJETO swapiPlanetTransfer 
				SwapiPlanetTransfer swapiPlanetTransfer = new SwapiPlanetTransfer.Builder().setId(id).setNome(name)
						.setClima(clima).setTerreno(terreno).setQtd_films(1).build();
				mapSwapi.put(id, swapiPlanetTransfer); //GRAVA NA LISTA O OBJETO
			} else {
				SwapiPlanetTransfer swapiPlanetTransfer = mapSwapi.get(id);
				swapiPlanetTransfer.setQtd_films(swapiPlanetTransfer.getQtd_films() + 1); //ADICIONA MAIS UM SE EXISTIR O ID NA LISTA

			}

		}
	}

}
