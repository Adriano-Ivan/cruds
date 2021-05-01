package com.demomvc.curso.boot.dao;

import java.util.List;
import com.demomvc.curso.boot.domain.Modelo;

public interface ModeloDao {
	
	void save(Modelo modelo);
	
	void update(Modelo modelo);
	
	void delete(Long id);
	
	Modelo findById(Long id);
	
	List<Modelo> findAll();
	
}
