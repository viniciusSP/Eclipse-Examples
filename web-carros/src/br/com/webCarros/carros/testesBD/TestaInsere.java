package br.com.webCarros.carros.testesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webCarros.carros.ConnectionFactory;
import br.com.webCarros.carros.dao.CarroDAO;
import br.com.webCarros.carros.model.Carro;

public class TestaInsere {

	private static CarroDAO dao;

	@Autowired
	public TestaInsere(CarroDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) throws Exception {
		Carro carro = new Carro();

		carro.setAno("1999");
		carro.setMarca("VolksVagen");
		carro.setNome("GOL g4");


		dao.Adiciona(carro);

		String sql = "select * from carros";

		Connection connection;

		connection = new ConnectionFactory().getConnection();

		PreparedStatement stmt = connection.prepareStatement(sql);

		System.out.println(stmt.execute());
		stmt.close();

	}

}
