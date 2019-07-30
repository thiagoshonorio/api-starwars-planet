/**
 * 
 */
package br.com.amedigital.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amedigital.api.documents.Planets;
import br.com.amedigital.api.responses.Responses;
import br.com.amedigital.api.services.PlanetsService;
import br.com.amedigital.api.transfer.SwapiPlanetTransfer;

/**
 * @author THIAGO
 *
 */

@RestController
@RequestMapping(path = "/api/starwars/planets")
public class PlanetsController {

	@Autowired
	private PlanetsService planetsService;

	@GetMapping
	public ResponseEntity<Responses<List<Planets>>> listarTodos() {
		return ResponseEntity.ok(new Responses<List<Planets>>(this.planetsService.listarTodos()));
	}

	@GetMapping(path = "swapi")
	public ResponseEntity<Responses<List<SwapiPlanetTransfer>>> listarSwapi() {
		return ResponseEntity.ok(new Responses<List<SwapiPlanetTransfer>>(this.planetsService.listarSwapi()));
	}


	@GetMapping(path = "id/{id}")
	public Planets listarPorId(@PathVariable(value = "id") String id) {
		return this.planetsService.listarPorId(id);
	}

	@GetMapping(path = "nome/{nome}")
	public Planets listarPorNome(@PathVariable(value = "nome") String nome) {
		return this.planetsService.listarPorNome(nome);
	}

	@PostMapping
	public ResponseEntity<Responses<Planets>> inserir(@Valid @RequestBody Planets planets, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<Planets>(erros));
		}

		Planets planet = new Planets.Builder().setId(planets.getId()).setNome(planets.getNome())
				.setClima(planets.getClima()).setTerreno(planets.getTerreno()).build();

		return ResponseEntity.ok(new Responses<Planets>(this.planetsService.inserir(planet)));
	}

	@PutMapping(path = "atualizar/{id}")
	public ResponseEntity<Responses<Planets>> atualizar(@PathVariable(name = "id") String id,
			@Valid @RequestBody Planets planets, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Responses<Planets>(erros));
		}
		planets.setId(id);
		return ResponseEntity.ok(new Responses<Planets>(this.planetsService.atualizar(planets)));
	}

	@DeleteMapping(path = "deletar/{id}")
	public ResponseEntity<Responses<Integer>> remover(@PathVariable(name = "id") String id) {
		this.planetsService.remover(id);
		return ResponseEntity.ok(new Responses<Integer>(1));

	}

}
