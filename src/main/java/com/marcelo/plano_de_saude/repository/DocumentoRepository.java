package com.marcelo.plano_de_saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marcelo.plano_de_saude.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
