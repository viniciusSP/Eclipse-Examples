package br.com.webCarros.carros;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionFactory {
	
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://192.168.56.100/fj21",
				"root", "vinicius");
	}

}
