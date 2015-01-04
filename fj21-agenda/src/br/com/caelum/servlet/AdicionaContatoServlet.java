package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/AdicionaContatoServlet")
public class AdicionaContatoServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		

		Contato contato = new Contato();

		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));

		// SETANDO A DATA QUEEH CHATO P KCT
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Date data = null;
		try {
			data = sdf.parse(req.getParameter("dataNascimento"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		contato.setDataNascimento(cal);
		
		Connection conn;
		try {
			conn = new ConnectionFactory().getConnection();
			
			ContatoDao dao = new ContatoDao(conn);
			dao.adiciona(contato);

			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/contato-adicionado.jsp");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
