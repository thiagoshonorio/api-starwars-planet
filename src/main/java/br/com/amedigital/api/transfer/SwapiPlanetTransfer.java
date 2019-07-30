package br.com.amedigital.api.transfer;

/**
 * @author THIAGO
 *
 */


public class SwapiPlanetTransfer {
	
	private Long id;
	private String nome;
	private String clima;
	private String terreno;
	private int qtd_films;

	public SwapiPlanetTransfer() {
		// CONSTRUTOR
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getQtd_films() {
		return qtd_films;
	}

	public void setQtd_films(int qtd_films) {
		this.qtd_films = qtd_films;
	}
	
	public static class Builder {
		
		private Long id;
		private String nome;
		private String clima;
		private String terreno;
		private Integer qtd_films;

		public Builder() {
		}
		
		public Builder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder setClima(String clima) {
			this.clima = clima;
			return this;
		}
		
		public Builder setTerreno(String terreno) {
			this.terreno = terreno;
			return this;
		}
		
		public Builder setQtd_films(Integer qtd_films) {
			this.qtd_films = qtd_films;
			return this;
		}
		
		public SwapiPlanetTransfer build() {
			SwapiPlanetTransfer planet = new SwapiPlanetTransfer();
			planet.setId(this.id);
			planet.setNome(this.nome);
			planet.setClima(this.clima);
			planet.setTerreno(this.terreno);
			planet.setQtd_films(this.qtd_films);
			return planet;
		}
	}
}
