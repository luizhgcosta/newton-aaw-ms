package br.newtonpaiva.br.revistas.api.revistas.response;

import java.time.LocalDateTime;

import br.newtonpaiva.br.revistas.domain.entity.Revista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class RevistaResponse {

	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private LocalDateTime dataDePublicacao;
	
	private Integer status;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public RevistaResponse(Revista revista) {
		this.id = revista.getId(); 
		this.titulo = revista.getTitulo();
		this.autor = revista.getAutor();
		this.editora = revista.getEditora();
		this.dataDePublicacao = revista.getDataDePublicacao();
		this.status = revista.getStatus();
		this.created = revista.getCreated();
		this.modified = revista.getModified();
	}
	
}
