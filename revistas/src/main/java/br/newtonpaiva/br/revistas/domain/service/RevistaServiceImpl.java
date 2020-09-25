package br.newtonpaiva.br.revistas.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.newtonpaiva.br.revistas.common.exception.NotFoundException;
import br.newtonpaiva.br.revistas.domain.entity.Revista;
import br.newtonpaiva.br.revistas.domain.repo.RevistaRepository;

@Service
public class RevistaServiceImpl implements RevistaService {

	@Autowired
	private RevistaRepository repo;
	
	@Override
	public Revista getById(String id) {
		
		Optional<Revista> resultado = repo.findById(id);
		
		if (resultado.isEmpty()) {
			
			throw new NotFoundException(String.format("%s com ID [%s] não encontrado.", "Revista", id));
			
		}
		
		return resultado.get();
	}

	@Override
	public List<Revista> getRevistas() {
		
		return repo.findAll();
	}

	@Override
	public Revista create(Revista revista) {
		
		revista.setCreated(LocalDateTime.now());
		revista.setModified(LocalDateTime.now());
		
		repo.save(revista);
		
		return revista;
	}

	@Override
	public Revista update(String id, Revista revista) {
		
		Revista atual = getById(id);
		
		atual.setTitulo(revista.getTitulo());
		atual.setAutor(revista.getAutor());
		atual.setEditora(revista.getEditora());
		atual.setDataDePublicacao(revista.getDataDePublicacao());
		atual.setStatus(revista.getStatus());
		atual.setModified(LocalDateTime.now());
		
		repo.save(atual);
		
		return atual;
	}

	@Override
	public void deleteById(String id) {
		
		getById(id);
		
		repo.deleteById(id);
		
	}

	

}
