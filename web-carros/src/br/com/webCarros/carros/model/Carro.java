package br.com.webCarros.carros.model;

import javax.validation.constraints.NotNull;

public class Carro {
	
	//NotNull é o BeanValidator desse atributo
	private Long id;
	@NotNull(message="Campo nome deve ser preenchido")
	private String nome;
	@NotNull(message="Campo ano deve ser preenchido")
	private String ano;
	@NotNull(message="Campo marca deve ser preenchido")
	private String marca;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
