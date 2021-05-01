package com.demomvc.curso.boot.service;

import java.util.List;

import com.demomvc.curso.boot.domain.Modelo;

public interface ModeloService {
	
	void salvar(Modelo modelo);
	
	void editar(Modelo modelo);
	
	void excluir(Long id);
	
	Modelo buscarPorId(Long id);
	
	List<Modelo> buscarTodos();

}
