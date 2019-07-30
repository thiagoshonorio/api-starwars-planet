package br.com.amedigital.api.repository;

import java.util.List;

import br.com.amedigital.api.transfer.SwapiPlanetTransfer;

/**
 * @author THIAGO
 *
 */


public interface SwapiPlanetRepository {
	public List<SwapiPlanetTransfer> listarTudo();

	public SwapiPlanetTransfer listarPorNome(String name);
}
