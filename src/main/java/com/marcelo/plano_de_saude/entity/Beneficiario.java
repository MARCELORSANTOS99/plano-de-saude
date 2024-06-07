package com.marcelo.plano_de_saude.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Beneficiario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String telefone;
	

	private Date dataNascimento;
	
	private Date dataInclusao;
	
	private Date dataAtualizacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Documento> documentos;
	
	
	

}
