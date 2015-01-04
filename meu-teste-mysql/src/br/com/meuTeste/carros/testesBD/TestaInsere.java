package br.com.meuTeste.carros.testesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.meuTeste.carros.ConnectionFactory;
import br.com.meuTeste.carros.dao.CarroDAO;
import br.com.meuTeste.carros.model.Carro;

public class TestaInsere {

	public static void main(String[] args) throws Exception {
		Carro carro = new Carro();
		
		carro.setAno("1999");
		carro.setMarca("VolksVagen");
		carro.setNome("GOL g4");
		
		CarroDAO carroDAO = new CarroDAO();
		
		carroDAO.Adiciona(carro);
		
		
		
		String sql = "select * from carros";
		
		Connection connection;
		
		connection = new ConnectionFactory().getConnection();

		PreparedStatement stmt = connection.prepareStatement(sql);
		
		System.out.println(stmt.execute());
		stmt.close();
		
	}

}
