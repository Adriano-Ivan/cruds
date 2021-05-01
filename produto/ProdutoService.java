package com.demomvc.curso.boot.service;

import java.util.List;

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.util.PaginacaoUtil;

public interface ProdutoService {
	
	void salvar(Produto produto);
	void editar(Produto produto);
	void excluir(Long id);
	Produto buscarPorId(Long id);
	List<Produto> buscarTodos();
	//PaginacaoUtil<Produto> buscarPorPagina(int pagina, String direcao);
}
