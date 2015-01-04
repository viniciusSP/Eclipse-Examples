<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTACARROS</title>
</head>
<body>
	<br>
	<br>
	<center>
		<h3>LISTA DE CARROS DA AGENCIA</h3>
	</center>
	<hr>
	<br>
	<br>
	<!-- CRIA O DAO -->
	<jsp:useBean id="dao" class="br.com.webCarros.carros.dao.CarroDAO" />
	<table>
		<!-- PERCORRE OS CARROS -->
		<c:forEach var="carros" items="${dao.lista}">
			<tr>
				<td>${carros.id}</td>
				<td>${carros.nome}</td>
				<td>${carros.ano}</td>
				<td>${carros.marca}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>