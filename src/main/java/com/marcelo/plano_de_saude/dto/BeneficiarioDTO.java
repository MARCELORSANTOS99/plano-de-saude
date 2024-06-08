package com.marcelo.plano_de_saude.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BeneficiarioDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "Insira pelo um número de telefone")
	private String telefone;
	
	@NotNull(message = "A data de nascimento é obrigatória")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	private Calendar dataNascimento;

	private List<DocumentoDTO> documentos;
	
}
