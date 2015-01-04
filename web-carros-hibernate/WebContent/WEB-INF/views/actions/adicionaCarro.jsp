<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADICIONANDO CARROS</title>
</head>
<body>

	<div style="height: 188px; "></div>
	<br>
	<br>
	<center><h3>DIGITE OS DADOS DO VEÍCULO</h3></center>
	<div style="height: 202px; ">
		<form action="adicionandoCarro" method="POST">
			Nome Carro:<input type="text" name="nome"><form:errors path="carro.nome" cssStyle="color:red"/><br>
			Ano Carro: <input type="text" name="ano"><form:errors path="carro.ano" cssStyle="color:red"/><br>
			Marca Carro: <input type="text" name="marca"><form:errors path="carro.marca" cssStyle="color:red"/><br>
			<center><input type="submit" value="enviar"></center>
		</form>
		<center>
		<form action="listaCarros" method="POST">
			<input type="submit" value="Listar Veículos">
		</form>
		</center>
		
	</div>
</body>
</html>