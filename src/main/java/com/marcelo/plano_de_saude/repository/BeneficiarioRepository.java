package com.marcelo.plano_de_saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.plano_de_saude.entity.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long>{

}
