<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ADICIONA NOVO USUARIO</title></head>
<body>
	<h2>P�gina de Login da Concession�ria</h2>
	<hr>
	<center><h3>Efetue login para acessar os recursos da p�gina</h3></center>
	<br>
	<form action="efetuaLogin" method="post">
		Login: <input type="text" name="usuario" /> <br /> Senha: <input
			type="password" name="senha" /> <br /> <br><input type="submit"
			value="Efetuar Login" />
	</form>
	<hr>
	<br><br>
	<form action="criaLogin" method="POST">
	Login: <input type="text" name="usuario" /> <br /> Senha: <input
			type="password" name="senha" /> <br /> <br>
		<input type="submit" value="Criar Login">
	</form>
</body>
</html>