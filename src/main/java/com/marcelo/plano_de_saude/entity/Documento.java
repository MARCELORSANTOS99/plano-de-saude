package com.marcelo.plano_de_saude.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	
	private Instant dataInclusao;
	
	private Instant dataAtualizacao;
	
	@JsonIgnore
	@ManyToOne
	private Beneficiario beneficiario;
	
	@PrePersist
    protected void onCreate() {
		dataInclusao = Instant.now();
        dataAtualizacao = Instant.now();
    }
	
	@PreUpdate
    protected void onUpdate() {
        dataAtualizacao = Instant.now();
    }

	

}
