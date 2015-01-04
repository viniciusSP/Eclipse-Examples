<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LISTA CONTATOS JSTL</title>
</head>
<body>
	<c:import url="cabecalho.jsp"/>

	<!-- CRIA DAO -->
<center>
	<table>
			<tr>
			<td><center><b>ID</b></center></td>
			<td><center><b>Nome</b></center></td>
			<td><center><b>Email</b></center></td>
			<td><center><b>Endereco</b></center></td>
			<td><center><b>Data de Nascimento</b></center></td>
		</tr>

		<!-- Percorre contatos montaod as linhas da tabela -->

		<c:forEach var="contato" items="${contatos}">
			
			<tr align="center">
				<td>	<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				<td>${contato.nome}</td>
				<td>
					<c:if test="${not empty contato.email}">
					<a href ="mailto:${contato.email}">${contato.email}</a>
					</c:if>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyy"/></td>
			</tr>
		</c:forEach>
	</table>
	</center>
<c:import url="rodape.jsp"/>
</body>
</html>