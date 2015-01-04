<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA DE CARROS</title>
</head>
<body>
	<center>
		<h3>LISTA DE CARROS</h3>
	</center>
	<br>
	<br>

	<center>
		<table>
			<tr>
				<td><center>ID</center></td>
				<td><center>NOME</center></td>
				<td><center>ANO</center></td>
				<td><center>MARCA</center></td>
				<td><center>REMOVER?</center></td>
				
			</tr>
			<c:forEach items="${carros}" var="carro">
				<tr>
					<td>${carro.id}</td>
					<td>${carro.nome}</td>
					<td>${carro.ano}</td>
					<td>${carro.marca}</td>
					<td><a href="removeCarro?id=${carro.id}" >Remover</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<form action="adicionaCarro" method="POST">
			<input type="submit" value="Adicionar novo Veículo">
		</form>
	</center>
</body>
</html>