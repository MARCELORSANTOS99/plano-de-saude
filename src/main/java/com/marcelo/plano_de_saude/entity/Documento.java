package com.marcelo.plano_de_saude.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Documento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tipoDocumento;
	
	private String descricao;
	
	private Date dataInclusao;
	
	private Date dataAtualizacao;
	
	@ManyToOne
	private Beneficiario beneficiario;

	

}
