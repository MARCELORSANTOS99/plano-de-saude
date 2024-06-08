package com.marcelo.plano_de_saude.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.plano_de_saude.dto.BeneficiarioDTO;
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
	
	@Autowired
    private ModelMapper modelMapper;
	
	
	public Beneficiario salvar(BeneficiarioDTO beneficiarioDTO) {
		
		Beneficiario beneficiario = modelMapper.map(beneficiarioDTO, Beneficiario.class);
		
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
	
	public Beneficiario update(Long id, BeneficiarioDTO beneficiarioRequest) {
        Optional<Beneficiario> optionalBeneficiario = beneficiarioRepository.findById(id);
        if (optionalBeneficiario.isPresent()) {
            Beneficiario existingBeneficiario = optionalBeneficiario.get();
            Instant dataInclusaoBeneficiario = existingBeneficiario.getDataInclusao();
            BeanUtils.copyProperties(beneficiarioRequest, existingBeneficiario, "id", "dataInclusao");
            existingBeneficiario.setDataInclusao(dataInclusaoBeneficiario);
            
            
            
            return beneficiarioRepository.save(existingBeneficiario);
        } else {
            throw new RuntimeException("Beneficiario not found with id " + id);
        }
    }

}
