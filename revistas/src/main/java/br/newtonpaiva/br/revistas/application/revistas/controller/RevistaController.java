package br.newtonpaiva.br.revistas.application.revistas.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.br.revistas.api.revistas.request.RevistaRequest;
import br.newtonpaiva.br.revistas.api.revistas.resource.RevistaResource;
import br.newtonpaiva.br.revistas.api.revistas.response.RevistaResponse;
import br.newtonpaiva.br.revistas.common.exception.NotFoundException;
import br.newtonpaiva.br.revistas.domain.entity.Revista;
import br.newtonpaiva.br.revistas.domain.service.RevistaService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated
public class RevistaController implements RevistaResource {

	@Autowired
	private RevistaService revistaService;
	
	@Override
	public ResponseEntity<List<RevistaResponse>> getAll() {
		
		log.info("GET revistas");
		
		List<Revista> lista = revistaService.getRevistas();
		
		List<RevistaResponse> response = new ArrayList<RevistaResponse>();
		
		lista.forEach(revista -> {
			response.add(new RevistaResponse(revista));
		});
		
		return ResponseEntity.ok(response);
		
	}

	@Override
	public ResponseEntity<RevistaResponse> getById(Optional<String> id) {
		
		log.info("GET revista por ID: {}", id);
		
		Revista revista = revistaService.getById(id.get());
		
		if (revista == null) {
			
			throw new NotFoundException(id.get());
			
		}
		
		return ResponseEntity.ok(new RevistaResponse(revista));
		
	}

	@Override
	public ResponseEntity<RevistaResponse> create(Optional<RevistaRequest> request) {

		log.info("POST revista: {}", request);
		
		Revista revista = new Revista().withId(UUID.randomUUID().toString()).withAutor(request.get().getAutor()).withTitulo(request.get().getTitulo()).withEditora(request.get().getEditora()).withDataDePublicacao(request.get().getDataDePublicacao()).withStatus(request.get().getStatus());
		
		revista.setCreated(LocalDateTime.now());
		revista.setModified(LocalDateTime.now());
		
		revistaService.create(revista);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new RevistaResponse(revista));
	
	}

	@Override
	public ResponseEntity<RevistaResponse> update(Optional<String> id, Optional<RevistaRequest> request) {

		log.info("PUT revista por ID: {} {}", id, request);
		
		Revista revista = new Revista().withAutor(request.get().getAutor()).withTitulo(request.get().getTitulo()).withEditora(request.get().getEditora()).withDataDePublicacao(request.get().getDataDePublicacao()).withStatus(request.get().getStatus());
		
		revistaService.update(id.get(), revista);
				
		return ResponseEntity.status(HttpStatus.OK).body(new RevistaResponse(revista));
	
	}

	@Override
	public ResponseEntity<Void> deleteById(Optional<String> id) {
		
		revistaService.deleteById(id.get());
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	
	}

}
