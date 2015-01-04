<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="css/jquery.css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ADICIONA CONTATO JSP</title>
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
</head>
<body>

	<c:import url="../cabecalho.jsp" />

	<h1>ADICIONA CONTATOS</h1>
	<form action="AdicionaContatoServlet" method="post">
		Nome: <input type="text" name="nome" /><br> Email: <input
			type="text" name="email" /><br> Endereco: <input type="text"
			name="endereco" /><br>
			Data Nascimento:<caelum:campoData id="dataNascimento"></caelum:campoData> <br> 
			<input type="submit" value="gravar" /><br>
		</form>
		<c:import url="../rodape.jsp" />
	
</body>
</html>