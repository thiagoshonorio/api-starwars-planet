/**
 * 
 */
package br.com.amedigital.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.amedigital.api.documents.Planets;
import br.com.amedigital.api.repository.PlanetsRepository;
import br.com.amedigital.api.repository.SwapiPlanetRepository;
import br.com.amedigital.api.services.PlanetsService;
import br.com.amedigital.api.transfer.SwapiPlanetTransfer;

/**
 * @author THIAGO
 *
 */

@Service
public class PlanetsServicesImpl implements PlanetsService {

	@Autowired
	private PlanetsRepository planetsRepository;

	@Autowired
	private SwapiPlanetRepository swapiPlanetRepository;

	@Override
	public List<Planets> listarTodos() {
		return this.planetsRepository.findAll();
	}

	@Override
	public Planets listarPorId(String id) {
		return this.planetsRepository.findById(id).orElse(null);
	}

	@Override
	public Planets listarPorNome(String nome) {
		return planetsRepository.findByNome(nome);
		// return Optional.ofNullable(planetsRepository.findByNome(nome));
		// return this.planetsRepository.findById(nome).orElse(null);
	}

	@Override
	public Planets inserir(Planets planets) {
		// metodo para salvar no banco
		// return this.planetsRepository.save(planets);
		SwapiPlanetTransfer swapiPlanetTransfer = swapiPlanetRepository.listarPorNome(planets.getNome());

		Planets procurar = this.listarPorNome(planets.getNome());

		if (procurar != null) {
			procurar.setQtd_films(planets.getQtd_films());
			procurar.setClima(planets.getClima());
			procurar.setTerreno(planets.getTerreno());
			planetsRepository.save(procurar);
			return procurar;
		}

		if (swapiPlanetTransfer != null) {
			planets.setQtd_films(swapiPlanetTransfer.getQtd_films());
		}

		planetsRepository.save(planets);

		return planets;
	}

	@Override
	public Planets atualizar(Planets planets) {
		// metodo para atualizar no banco
		return this.planetsRepository.save(planets);
	}

	@Override
	public void remover(String id) {
		// metodo para remover no banco
		this.planetsRepository.deleteById(id);

	}

	
	public List<SwapiPlanetTransfer> listarSwapi() {
		return this.swapiPlanetRepository.listarTudo();
	}

}
