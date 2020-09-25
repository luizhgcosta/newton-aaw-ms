package br.newtonpaiva.br.revistas.api.revistas.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With
public class RevistaRequest {

	private String id;
	
	@NotBlank
	private String titulo;
	
	private String autor;
	
	@NotBlank
	private String editora;
	
	@NotNull
	private LocalDateTime dataDePublicacao;
	
	@NotNull
	private Integer status;
	
}
