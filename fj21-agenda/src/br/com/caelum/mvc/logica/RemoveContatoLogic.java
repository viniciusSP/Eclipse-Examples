package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;



public class RemoveContatoLogic implements Logica {


	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		long id = Long.parseLong(req.getParameter("id"));

		Contato contato = new Contato();
		contato.setId(id);
		Connection conn = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(conn);
		dao.exclui(contato);
		
		conn.close();
		return "mvc?logica=ListaContatosLogic";
	}
	

}
