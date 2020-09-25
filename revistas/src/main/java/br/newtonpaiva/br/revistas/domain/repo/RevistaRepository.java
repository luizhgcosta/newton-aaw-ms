package br.newtonpaiva.br.revistas.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.newtonpaiva.br.revistas.domain.entity.Revista;

@Repository
public interface RevistaRepository extends MongoRepository<Revista, String> {
	
	public List<Revista> findByTitulo(String titulo);

}
