package com.project.comudem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.comudem.entity.Movimiento;

public interface IMovimientoDao extends JpaRepository<Movimiento, Long> {

	@Query("select m from Movimiento m where m.idAsociado = :idAsociado")
	  Optional<Movimiento> findByIdAsociado(@Param("idAsociado") long idAsociado);
	
	List<Movimiento> findAllByIdAsociado(long idAsociado);
}
