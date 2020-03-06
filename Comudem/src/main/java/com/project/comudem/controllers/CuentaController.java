package com.project.comudem.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;


import com.project.comudem.dao.ICuentaDao;
import com.project.comudem.entity.Cuenta;

@RestController
@RequestMapping("/comudem")
public class CuentaController {
	
	@Autowired
	private ICuentaDao cuentaDao;
	
	
	@GetMapping("/cuentas")
	public List<Cuenta> getUsuarios() {
		return cuentaDao.findAll();
	}
	
	
	@PostMapping("/cuentas")
	public ResponseEntity<?> registrarUsuario(@RequestBody Cuenta cuenta){
		cuentaDao.save(cuenta);
		return new ResponseEntity<>(HttpStatus.CREATED);  
	}
	
	
	@PutMapping("/cuentas/{idCuenta}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Cuenta cuentaUpdate,@PathVariable long idCuenta){
		
		try {
			Cuenta cuentaU = new Cuenta();
			cuentaU.setIdCuenta(idCuenta);
			cuentaU.setDinero(cuentaUpdate.getDinero());;
			cuentaU.setCuentaActiva(cuentaUpdate.isCuentaActiva());
			cuentaU.setAsociado(cuentaUpdate.getAsociado());
			cuentaDao.deleteById(idCuenta);
			cuentaDao.save(cuentaU);
		}
		catch (Exception e) {
		
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cuentas/{idCuenta}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable long idCuenta){
		try {
			cuentaDao.deleteById(idCuenta);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
