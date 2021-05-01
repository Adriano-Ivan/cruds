package com.demomvc.curso.boot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.dao.ModeloDao;
import com.demomvc.curso.boot.domain.Modelo;

@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	private ModeloDao dao;
	
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Modelo modelo) {
		dao.save(modelo);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void editar(Modelo modelo) {
		dao.update(modelo);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Modelo buscarPorId(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Modelo> buscarTodos() {
		return dao.findAll();
	}


}
