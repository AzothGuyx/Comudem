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

import com.project.comudem.dao.IMovimientoDao;
import com.project.comudem.entity.Movimiento;

@RestController
@RequestMapping("/comudem")
public class MovimientoController {
	
	@Autowired
	private IMovimientoDao movimientoDao;
	
	@GetMapping("/asociados/{idAsociado}/movimientos")
	public List<Movimiento> movimientosUsuario(@PathVariable long idAsociado){
		
			return movimientoDao.findAllByIdAsociado(idAsociado);
	
	}
	
	@PostMapping("/asociados/{idAsociado}/movimientos")
	public ResponseEntity<?> crearMovimiento(@PathVariable long idAsociado,@RequestBody Movimiento movimientoPost){
		
		try {
			Movimiento movimiento= new Movimiento();
			movimiento.setIdAsociado(idAsociado);
			movimiento.setFecha(movimientoPost.getFecha());
			movimiento.setIdMovimiento(movimientoPost.getIdMovimiento());
			movimiento.setCantidad(movimientoPost.getCantidad());
			movimiento.setTipo(movimientoPost.getTipo());
			
			movimientoDao.save(movimiento);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	

}
