package com.marcelo.plano_de_saude.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    @Temporal(TemporalType.TIMESTAMP)
	private Calendar dataNascimento;
	
    @Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Instant dataInclusao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Instant dataAtualizacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Documento> documentos;
	
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
