package com.project.comudem.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.comudem.dao.INominaDao;
import com.project.comudem.entity.Nomina;

@RestController
@RequestMapping("/comudem")
public class NominaController {

	@Autowired
	private INominaDao nominaDao;
	
	@GetMapping("/cuentanomina/{cuenta}")
	public Optional<Nomina> verificarNomina(@PathVariable long cuenta) {
		 return nominaDao.findById(cuenta);
	}
	
	@PostMapping("/cuentanomina/{cuenta}")
	public ResponseEntity<?> crearNomina(@PathVariable long cuenta, @RequestBody Nomina nominaP){
		
		try {
			Nomina nomina=new Nomina();
			nomina.setCuenta(cuenta);
			nomina.setEmpresa(nominaP.getEmpresa());
			nomina.setIdEmpresa(nominaP.getIdEmpresa());
			nominaDao.save(nomina);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}


