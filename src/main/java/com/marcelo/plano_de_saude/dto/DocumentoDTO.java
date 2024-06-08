package com.marcelo.plano_de_saude.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DocumentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    
    @NotBlank(message = "O tipo do documento é obrigatório")
    private String tipo;
    
    @NotBlank(message = "Insira pelo um número de telefone")
    private String numero;
    

}
