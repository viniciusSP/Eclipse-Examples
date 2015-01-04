package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/OiMundo")
public class OiMundo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title> PRIMEIRA SERVLET");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1><center> OLA MUNDO SERVLET!</h1></center>");
		out.println("<br><br><center><h2>HORA ATUAL:</h2></center>");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		out.println(sdf.format(Calendar.getInstance().getTime()));
		out.println("</body>");
		out.println("</html>");
	}
}
