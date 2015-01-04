<%@page import="br.com.caelum.agenda.modelo.Contato"%>
<%@page import="br.com.caelum.agenda.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista em JSP</title>
</head>
<body>
	<br>
	<br>
	<br>
	<h1><center>LISTA DE CONTATOS</center></h1>
	<br>
	<br>
	<hr>
	<br>
	<center>
	<table>
		<tr>
			<td><center><b>ID</b></center></td>
			<td><center><b>Nome</b></center></td>
			<td><center><b>Endereco</b></center></td>
			<td><center><b>Email</b></center></td>
			<td><center><b>Data de Nascimento</b></center></td>
		</tr>
<%-- 		<%ContatoDao dao = new ContatoDao(); %> --%>
<%-- 		<%for(Contato c: dao.getLista()){%> --%>
<!-- 			<tr> -->
<%-- 				<td><%=c.getId() %></td> --%>
<%-- 				<td><%=c.getNome() %></td> --%>
<%-- 				<td><%=c.getEndereco() %></td> --%>
<%-- 				<td><%=c.getEmail() %></td> --%>
<%-- 				<td><%=c.getDataNascimento().getTime() %></td> --%>
<!-- 			</tr>		 -->
<%-- 		<% }%> --%>
	</table>
	</center>
	
</body>
</html>