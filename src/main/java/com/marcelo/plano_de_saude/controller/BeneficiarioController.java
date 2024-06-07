package com.marcelo.plano_de_saude.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.plano_de_saude.entity.Beneficiario;
import com.marcelo.plano_de_saude.entity.Documento;
import com.marcelo.plano_de_saude.service.BeneficiarioService;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {
	
	@Autowired
	BeneficiarioService beneficiarioService;
	
	
	@GetMapping("/{idBeneficiario}")
	public ResponseEntity<List<Documento>> buscarTodosDocumentosPorBeneficiario(@PathVariable Long idBeneficiario) {
			
		return ResponseEntity.ok(beneficiarioService.buscarTodosDocumentosPorBeneficiario(idBeneficiario));
		
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Beneficiario>> buscarTodos() {
			
		return ResponseEntity.ok(beneficiarioService.buscarTodos());
		
	}
	
	@GetMapping(path = "/buscar/{id}")
	public ResponseEntity<Beneficiario> buscar(@PathVariable Long id) {
		
					
		return ResponseEntity.ok(beneficiarioService.findBeneficiario(id));
		
	}
	
	
	@PostMapping
	public Beneficiario salvar(@RequestBody Beneficiario beneficiario) {
		
		return beneficiarioService.salvar(beneficiario);
	}
	
	@DeleteMapping("/{idBeneficiario}")
	public ResponseEntity<Beneficiario> deletar(@PathVariable Long idBeneficiario) {
		
		try {
		
			beneficiarioService.deletar(idBeneficiario);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();

		}
		
			
		
	}
	
	@PutMapping(path = "/{idBeneficiario}")
	public ResponseEntity<?> editar(@RequestBody Beneficiario beneficiarioRequest, @PathVariable Long idBeneficiario){
		
		try {
			
			System.out.println("Recebido PUT para ID: " + idBeneficiario);
	        System.out.println("Corpo da solicitação: " + beneficiarioRequest);
			
			Beneficiario beneficiario = beneficiarioService.findBeneficiario(idBeneficiario);
			
			if(beneficiario != null) {
				
				BeanUtils.copyProperties(beneficiarioRequest, beneficiario, "id");
				beneficiarioService.salvar(beneficiario);
				 return ResponseEntity.ok(beneficiario);				 
			}
			 
			 
		}catch (Exception e) {
			e.printStackTrace(); // Log da exceção para depuração
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a solicitação");
		}
		
		return ResponseEntity.notFound().build();
			
	}

}
