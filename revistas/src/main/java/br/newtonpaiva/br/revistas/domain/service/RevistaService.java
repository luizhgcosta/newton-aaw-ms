package br.newtonpaiva.br.revistas.domain.service;

import java.util.List;

import br.newtonpaiva.br.revistas.domain.entity.Revista;

public interface RevistaService {
	
	Revista getById(String id);
	
	List<Revista> getRevistas();
	
	Revista create(Revista revista);
	
	Revista update(String id, Revista revista);
	
	void deleteById(String id);

}
