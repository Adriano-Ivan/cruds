package com.demomvc.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomvc.curso.boot.domain.Produto;
import com.demomvc.curso.boot.util.PaginacaoUtil;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {

/*	public PaginacaoUtil<Produto> buscaPaginada(int pagina, String direcao) {
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho; // 0*5=0 1*5=5 2*5=10  Cálculo para paginação no DataGrid
		List<Produto> produtos = getEntityManager()
				.createQuery("select c from Produto c order by c.nome " + direcao, Produto.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, produtos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Produto", Long.class)
				.getSingleResult();
	}


*/
	

}
