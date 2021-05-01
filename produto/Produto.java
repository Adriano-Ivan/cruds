package com.demomvc.curso.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUTOS")
public class Produto extends AbstractEntity<Long> {
	
	// DECLARAÇÕES DE ATRIBUTO
	@NotBlank(message = "O nome do produto é obrigatório.")
	@Size(max = 70, message = "O nome do produto deve conter no máximo {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 70)
	private String nome;
	
	@NotNull(message = "Selecione a marca referente ao produto.")
	@OneToOne
	@JoinColumn(name = "id_marca_fk")
	private Marca marca;
	
	@NotNull(message = "Selecione o modelo referente ao produto.")
	@OneToOne
	@JoinColumn(name = "id_modelo_fk")
	private Modelo modelo;
	
	// MÉTODOS GETTERS E SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	
}
