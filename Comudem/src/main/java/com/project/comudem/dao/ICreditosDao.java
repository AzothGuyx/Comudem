package com.project.comudem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.comudem.entity.Credito;

public interface ICreditosDao extends JpaRepository<Credito, Long>{

	List<Credito> findAllByIdAsociado(long idAsociado);
}
