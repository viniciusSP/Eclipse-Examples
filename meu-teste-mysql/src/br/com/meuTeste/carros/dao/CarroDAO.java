package br.com.meuTeste.carros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.meuTeste.carros.ConnectionFactory;
import br.com.meuTeste.carros.model.Carro;

public class CarroDAO {
	private Connection connection;

	public CarroDAO() throws Exception {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void Adiciona(Carro carro) throws SQLException {

		String sql = "Insert into carros " + "(nome, ano, marca)"
				+ "VALUES (?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, carro.getNome());
		stmt.setString(2, carro.getAno());
		stmt.setString(3, carro.getMarca());

		stmt.execute();
		stmt.close();
	}

	public List<Carro> listaCarros() throws SQLException {
		ArrayList<Carro> arrayCarros = new ArrayList<Carro>();
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from carros");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Carro carro = new Carro();

			carro.setId(rs.getLong("id"));
			carro.setAno(rs.getString("ano"));
			carro.setMarca(rs.getString("marca"));
			carro.setNome(rs.getString("nome"));
			arrayCarros.add(carro);

		}

		rs.close();
		stmt.close();
		return arrayCarros;
	}

	public void deletaCarro(Integer idCarro) throws SQLException {
		PreparedStatement stmt = this.connection
				.prepareStatement("delete from carros where id = ?");

		if (idCarro.equals(null)) {
			System.out.println("Deverá informar um ID para remover!");
		}

		stmt.setInt(1, idCarro);
		stmt.execute();
		stmt.close();
	}

	public void AlteraCarro(Integer idCarro, Carro novasDefinicoes)
			throws SQLException {
//		Carro carroAlterado = new Carro();
//		carroAlterado = buscaCarro(idCarro);

		PreparedStatement stmt = this.connection
				.prepareStatement("update carros set nome = ?,"  + "ano = ?,"
						+ "marca = ?" + "where id = ?");
		stmt.setString(1, novasDefinicoes.getNome());
		stmt.setString(2, novasDefinicoes.getAno());
		stmt.setString(3, novasDefinicoes.getMarca());
		stmt.setLong(4, idCarro);

		stmt.execute();
		stmt.close();

	}

	public Carro buscaCarro(Integer idCarro) throws SQLException {
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from carros where id = ?");
		ResultSet rs = stmt.executeQuery();
		if (idCarro.equals(null)) {
			System.out.println("Deverá informar um ID para remover!");
		}

		stmt.setInt(1, idCarro);

		Carro carroNovo = new Carro();

		while (rs.next()) {
			Carro carro = new Carro();

			carro.setAno(rs.getString("ano"));
			carro.setMarca(rs.getString("marca"));
			carro.setNome(rs.getString("nome"));

			carroNovo = carro;
		}
		stmt.close();

		return carroNovo;

	}
}
