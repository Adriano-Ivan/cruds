package com.demomvc.curso.boot.dao;

import java.util.List;

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.util.PaginacaoUtil;

public interface ProdutoDao {

	void save(Produto produto);
	void update(Produto produto);
	void delete(Long id);
	Produto findById(Long id);
	List<Produto> findAll();
	//PaginacaoUtil<Produto> buscaPaginada(int pagina, String direcao);
}
