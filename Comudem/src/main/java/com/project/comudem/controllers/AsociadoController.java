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

import com.project.comudem.dao.IAsociadoDao;
import com.project.comudem.entity.Asociado;

@RestController
@RequestMapping("/comudem")
public class AsociadoController {

	@Autowired
	private IAsociadoDao asociadoDao;
	
	
	@GetMapping("/asociados")
	public List<Asociado> getUsuarios() {
		return asociadoDao.findAll();
	}
	
	
	@PostMapping("/asociados")
	public ResponseEntity<?> registrarUsuario(@RequestBody Asociado asociado){
		asociadoDao.save(asociado);
		return new ResponseEntity<>(HttpStatus.CREATED);  
	}
	
	
	@PutMapping("/asociados/{idAsociado}")
	public ResponseEntity<?> actualizarUsuario(@RequestBody Asociado asociadoUpdate,@PathVariable long idAsociado){
		
		try {
			Asociado usuarioU = new Asociado();
			usuarioU.setApellido(asociadoUpdate.getApellido());
			usuarioU.setCorreo(asociadoUpdate.getCorreo());
			usuarioU.setNombre(asociadoUpdate.getNombre());
			usuarioU.setIdAsociado(idAsociado);
			asociadoDao.deleteById(idAsociado);
			asociadoDao.save(usuarioU);
		}
		catch (Exception e) {
		
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/asociados/{idAsociado}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable long idAsociado){
		try {
			asociadoDao.deleteById(idAsociado);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
