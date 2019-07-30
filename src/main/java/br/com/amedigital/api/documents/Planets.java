package br.com.amedigital.api.documents;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author THIAGO
 *
 */

@Document
public class Planets {

	@Id
	private String id;
	@Indexed(unique = true)
	private String nome;
	private String clima;
	private String terreno;
	private int qtd_films;

	public Planets() {
		// CONSTRUTOR
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome não pode ser vazio")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Clima não pode ser vazio")
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	@NotEmpty(message = "Terreno não pode ser vazio")
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

		public Builder() {
		}

		private String id;
		private String nome;
		private String clima;
		private String terreno;
		private int qtd_films;

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

		public Planets build() {
			Planets planet = new Planets();
			planet.setId(this.id);
			planet.setNome(this.nome);
			planet.setClima(this.clima);
			planet.setTerreno(this.terreno);
			planet.setQtd_films(this.qtd_films);
			return planet;
		}
	}

}
