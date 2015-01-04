<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}
</style>

<script type="text/javascript" src="resources/js/jquery.js"></script>


<script type="text/javascript">
	function finalizaTarefa(id) {
		$.post("finalizaTarefa", {'id' : id}, function() {
			//seleciona o elemento html atraves da
			//ID e alterando o HTML dele
			$("#tarefa_"+id).html("Finalizado");			
		});	
	}
	
	function removeTarefa(id){
		$.post("removeTarefa", {'id': id}, function() {
			$("#tarefa2_"+id).closest("tr").hide();
		});
	}

</script>


<title>LISTA DE TAREFAS</title>
</head>

<body>

	<br>
	<br>
	<hr>
	<br>
	<br>
	<center>
		<h3>LISTA DE TAREFAS</h3>
	</center>

	<br>
	<br>
	<hr>
	<a href="novaTarefa"> Criar nova tarefa </a>
	<br>
	<br>
	<center>
		<table class="tg">
			<tr>
				<th class="tg-031e">ID</th>
				<th class="tg-031e">Descricao</th>
				<th class="tg-031e">Alterar</th>
				<th class="tg-031e">Remover?</th>
				<th class="tg-031e">Finalizado?</th>
				<th class="tg-031e">Data de Finalizacao</th>
			</tr>


			<c:forEach items="${tarefas}" var="tarefa">

				<tr>
					<td>${tarefa.id}</td>
					
					<td>${tarefa.descricao}</td>
					
					<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
					
						<td id="tarefa2_${tarefa.id}">
						
							<a href="#" onClick="removeTarefa(${tarefa.id})">Remover</a></td>
					
							<c:if test="${tarefa.finalizado eq false}">
					
								<td id="tarefa_${tarefa.id}">
						
								<a href="#" onClick="finalizaTarefa(${tarefa.id})">Finaliza agora!</a></td>
							</c:if>
							
							<c:if test="${tarefa.finalizado eq true}">
								<td>Finalizado</td>
							</c:if>
							
					<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
							pattern="dd/MM/yyy" /></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>