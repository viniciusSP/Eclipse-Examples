package br.com.webCarros.carros.testesBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.webCarros.carros.ConnectionFactory;
import br.com.webCarros.carros.model.Carro;

public class CriaDadosBD {
	private Connection connection;

	public CriaDadosBD() throws Exception {

		this.connection = new ConnectionFactory().getConnection();
	}

	String sql = "Insert into carros" + "(nome,ano,marca)" + "values (?,?,?)";

	PreparedStatement stmt = connection.prepareStatement(sql);

	public static void main(String[] args) throws Exception {

		Carro carro = new Carro();
		carro.setAno("1999");
		carro.setMarca("VolksVagen");
		carro.setNome("Gol g4");
		
	
	}
	

}
