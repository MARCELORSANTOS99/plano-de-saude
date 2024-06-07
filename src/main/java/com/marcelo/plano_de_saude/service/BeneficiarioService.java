package com.marcelo.plano_de_saude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.plano_de_saude.entity.Beneficiario;
import com.marcelo.plano_de_saude.entity.Documento;
import com.marcelo.plano_de_saude.repository.BeneficiarioRepository;
import com.marcelo.plano_de_saude.repository.DocumentoRepository;

@Service	
public class BeneficiarioService {
	
	@Autowired
	BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	
	public Beneficiario salvar(Beneficiario beneficiario) {
		
		if (!beneficiario.getDocumentos().isEmpty()) {
            documentoRepository.saveAll(beneficiario.getDocumentos());
        }
		
		return beneficiarioRepository.save(beneficiario);
	}
	
	public List<Beneficiario> buscarTodos() {
		return beneficiarioRepository.findAll();
	}

	public List<Documento> buscarTodosDocumentosPorBeneficiario(Long idBeneficiario) {

		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(idBeneficiario);
				
		return beneficiario.get().getDocumentos();
	}

	public void deletar(Long idBeneficiario) {

		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(idBeneficiario);
		
		beneficiarioRepository.delete(beneficiario.get());

		
	}

	public Beneficiario findBeneficiario(Long idBeneficiario) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(idBeneficiario);
		
		return beneficiario.get();
	}

}
