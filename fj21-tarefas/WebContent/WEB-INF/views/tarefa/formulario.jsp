<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INSERIR TAREFA</title>
</head>
<body>
	<%@ include file="../cabecalho.jsp"%>
	
	<form action="adicionaTarefa" method="post">
		<form:errors path="tarefa.descricao" cssStyle="color:red"/><br><br>
		Descricao: <br>
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<br> <input type="submit" value="Adicionar">
	</form>
	<%@ include file="../rodape.jsp"%>
</body>
</html>