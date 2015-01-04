package br.com.webCarros.carros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.webCarros.carros.ConnectionFactory;
import br.com.webCarros.carros.model.Login;

public class LoginDAO {

	private Connection connection;

	public LoginDAO() throws Exception {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Login login) throws SQLException {
		String sql = "Insert into login " + "(usuario, senha)" + "VALUES (?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());

		stmt.execute();
		stmt.close();
	}

	public Login buscaLogin(Login login) throws SQLException {
		String sql = "Select * from login where id = ?";

		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, login.getId());
		stmt.execute();
		stmt.close();

		return login;
	}

	public void altera(Login login) throws SQLException {
		String sql = "update login set usuario = ?, senha = ? where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());
		stmt.setLong(3, login.getId());
		stmt.execute();
		stmt.close();
	}

	public void deleta(Login login) throws SQLException {
		String sql = "delete from login where id = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, login.getId());
		stmt.execute();
		stmt.close();
	}
	
	public boolean existeUsuario(Login login) throws SQLException {
		if (login == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		PreparedStatement stmt = this.connection
				.prepareStatement("select * from login where usuario = ? and senha = ?");
		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());
		
		ResultSet rs = stmt.executeQuery();

		boolean encontrado = rs.next();
		rs.close();
		stmt.close();

		return encontrado;

		
	}

}
