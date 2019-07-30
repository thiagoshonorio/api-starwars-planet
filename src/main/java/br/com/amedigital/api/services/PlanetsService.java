package br.com.amedigital.api.services;

import java.util.List;

import br.com.amedigital.api.documents.Planets;
import br.com.amedigital.api.transfer.SwapiPlanetTransfer;

/**
 * @author THIAGO
 *
 */

public interface PlanetsService {

	List<Planets> listarTodos();

	List<SwapiPlanetTransfer> listarSwapi();

	Planets listarPorId(String id);

	Planets listarPorNome(String nome);

	Planets inserir(Planets planets);

	Planets atualizar(Planets planets);

	void remover(String id);

}
