package br.newtonpaiva.br.revistas.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@Data
@With
@NoArgsConstructor
public class Revista {
	
	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private LocalDateTime dataDePublicacao;
	
	private Integer status;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
}
