package com.demomvc.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demomvc.curso.boot.dao.ProdutoDao;
import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.util.PaginacaoUtil;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired 
	private ProdutoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Produto produto) {
		dao.save(produto);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Produto produto) {
		dao.update(produto);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Produto buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Produto> buscarTodos() { 
		return dao.findAll();
	}

	/*
	@Override
	public PaginacaoUtil <Produto> buscarPorPagina(int pagina, String direcao) {
		
		return dao.buscaPaginada(pagina, direcao);
	}
	*/
}
