<%@page import="br.com.caelum.agenda.modelo.Contato"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BEM VINDO JSP</title>
</head>
<body>
	<br>
	
	<%Contato contato = new Contato(); %>
	<%contato.setNome("VINICIUS RIBEIRO"); %>
	<%
		String mensagem = "Bem vindo ao sistema de agenda do fj21";
	%>

	<%
		out.println(mensagem);
	%>
	<br>
	<%
		String desenvolvimento = "Desenvolvido por ("+contato.getNome()+ " )";
	%>

	<%
		out.println(desenvolvimento);
	%>
	<br>
	<%
		System.out.print("TUDO FOI EXECUTADO!!!");
	%>

</body>
</html>