package br.com.amedigital.api.transfer;

/**
 * @author THIAGO
 *
 */


public class PlanetsTransfer {

	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int qtd_films;
	
	public PlanetsTransfer(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public static class Builder{
		private String id;
		private String nome;
		private String clima;
		private String terreno;
		private int qtd_films;
		
		public Builder() {
		}
		
		public Builder setId(String id) {
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
		
		public PlanetsTransfer build() {
			PlanetsTransfer planetTransfer = new PlanetsTransfer();
			planetTransfer.setId(this.id);
			planetTransfer.setNome(this.nome);
			planetTransfer.setClima(this.clima);
			planetTransfer.setTerreno(this.terreno);
			planetTransfer.setQtd_films(this.qtd_films);
			return planetTransfer;
		}
	}
}
