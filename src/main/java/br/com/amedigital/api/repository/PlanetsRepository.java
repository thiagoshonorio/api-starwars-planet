package br.com.amedigital.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.amedigital.api.documents.Planets;

/**
 * @author THIAGO
 *
 */

public interface PlanetsRepository extends MongoRepository<Planets, String> {

	Planets findByNome(String nome);

}
