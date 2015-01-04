package br.com.webCarros.carros.dao;

import java.util.List;

import br.com.webCarros.carros.model.Carro;

public interface CarroDAO {

	List<Carro> lista();
	void adiciona(Carro t);
	void altera(Carro t);
	void remove(Carro t);
	Carro buscaPorId(Long id);
}
