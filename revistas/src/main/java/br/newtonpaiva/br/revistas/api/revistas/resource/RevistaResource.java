package br.newtonpaiva.br.revistas.api.revistas.resource;

import br.newtonpaiva.br.revistas.api.revistas.request.RevistaRequest;
import br.newtonpaiva.br.revistas.api.revistas.response.RevistaResponse;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/v1/revistas")
public interface RevistaResource {

	//GET Busca lista de revistas existentes
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RevistaResponse>> getAll();
	
	//GET Busca revista por ID
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RevistaResponse> getById(@PathVariable Optional<String> id);
	
	//POST Criar nova revista
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RevistaResponse> create(@Valid @RequestBody Optional<RevistaRequest> request);
	
	//PUT Atualizar revista existente por ID
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RevistaResponse> update(@PathVariable Optional<String> id, @RequestBody Optional<RevistaRequest> request);
	
	//DELETE Deletar revista por ID
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Optional<String> id);
	
}
