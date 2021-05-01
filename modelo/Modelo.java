package com.demomvc.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("Serial")
@Entity
@Table(name = "MODELOS")
public class Modelo extends AbstracEntity<Long> {
	
	@Size(min = 3, max = 60, message = "Escreva o nome do modelo")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@Size(min = 3, max = 300, message = "A descrição do modelo tem que ser feita")
	@Column(name = "descricao", nullable = false, unique = true, length = 300)
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
