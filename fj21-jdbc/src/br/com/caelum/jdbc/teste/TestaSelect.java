package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaSelect {
	public static void main(String[] args) throws SQLException {

		// pega a conexao do statement

		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from contatos");

		// executa a select
		
		ResultSet rs = stmt.executeQuery();
		System.out.println("   NOME     |      EMAIL\n");
		while (rs.next()) {

			String nome = rs.getString("nome");
			String email = rs.getString("email");
			System.out.println(nome + " :: " + email);

		}
		rs.close();
		stmt.close();
		con.close();
	}

}
