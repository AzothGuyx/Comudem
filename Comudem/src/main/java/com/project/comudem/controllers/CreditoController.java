package com.project.comudem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comudem.dao.ICreditosDao;
import com.project.comudem.entity.Credito;


@RestController
@RequestMapping("/comudem")
public class CreditoController {
	
	@Autowired
	private ICreditosDao creditoDao;
	
	
	@GetMapping("/asociados/{idAsociado}/creditos")
	public List<Credito> creditosUsuario(@PathVariable long idAsociado){
		return creditoDao.findAllByIdAsociado(idAsociado);
		
	}
	
	
	@PostMapping("/asociados/{idAsociado}/creditos")
	public ResponseEntity<?> crearCredito(@PathVariable long idAsociado,@RequestBody Credito creditoPost){
		
		try {
			Credito credito= new Credito();
			credito.setIdAsociado(idAsociado);
			credito.setBanco(creditoPost.getBanco());
			credito.setMonto(creditoPost.getMonto());
			credito.setIdBanco(creditoPost.getIdBanco());
			credito.setIdCredito(creditoPost.getIdCredito());
			creditoDao.save(credito);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
