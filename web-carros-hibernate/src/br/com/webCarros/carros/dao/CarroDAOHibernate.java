package br.com.webCarros.carros.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.webCarros.carros.model.Carro;

@Repository
public class CarroDAOHibernate implements CarroDAO {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public void adiciona(Carro carro) {
		manager.persist(carro);
	}
	@Override
	public void altera(Carro carro) {
		manager.merge(carro);
	}
	@Override
	public List<Carro> lista() {
		return manager.createQuery("select t from carros t").getResultList();
		
	}
	@Override
	public Carro buscaPorId(Long id) {
		return manager.find(Carro.class, id);
	}
	@Override
	public void remove(Carro carro) {
		Carro tarefaARemover = buscaPorId(carro.getId());
		manager.remove(tarefaARemover);
	}
}
