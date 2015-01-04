<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarroAdicionado</title>
</head>
<body>
	<center>
		<h3>CARRO ADICIONADO COM SUCESSO</h3>
		<br>
		<br>
		<form action="adicionaCarro" method="POST">
		<input type="submit" value="Adicionar novo Veículo">
		</form>
		<form action="listaCarros" method="POST">
		<input type="submit" value="Listar Veículos">
		</form>
	</center>
</body>
</html>