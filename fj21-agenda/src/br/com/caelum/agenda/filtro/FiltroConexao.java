package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.ConnectionFactory;


@WebFilter("/*")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		//CRIANDO A CONNECTION
		try {
			Connection c = new ConnectionFactory().getConnection();

			//SETANDO A CONNECTION NO REQUEST
			req.setAttribute("conexao", c);
			
			fc.doFilter(req, res);
			
			c.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
