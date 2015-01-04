package br.com.webCarros.carros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//Anotação necessária para dizer que essa classe é uma tabela 
@Entity
public class Carro {
	
	
	
	@Id // Campo ID
	@GeneratedValue // Auto-Increment do BD
	private Long id;
	//NotNull é o BeanValidator desse atributo
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
