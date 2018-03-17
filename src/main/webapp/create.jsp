<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="usuarioAction.jsp" method ="post">
		<p> Nome Completo </p>
			<p><input type= "text" name = "nome" value = <%= request.getParameter("nome") %>></input></p>
		<p> E-mail </p>
			<p><input type= "text" name = "email" value = <%= request.getParameter("email") %>></input></p>
		<p> Telefone </p>
			<p><input type= "text" name = "telefone" value = <%= request.getParameter("telefone") %>></input></p>
		<p> Data de Nascimento </p>
			<p><input type= "text" name = "nascimento" value = <%= request.getParameter("nascimento") %>></input></p>
		<p> Endereço </p>
			<p><input type= "text" name = "endereço" value = <%= request.getParameter("endereço") %>></input></p>
		<p> Área Desejada </p>	
			<p><input type= "text" name = "area" value = <%= request.getParameter("area") %>></input></p>
		<p> Idiomas e Nível </p>
			<p><input type= "text" name = "idiomas" value = <%= request.getParameter("idiomas") %>></input></p>
		<p> Conhecimentos Técnicos e Nível </p>
			<p><input type= "text" name = "conhecimentos" value = <%= request.getParameter("conhecimentos") %>></input></p>
		<p> Formação </p>
			<p><input type= "text" name = "formaçao" value = <%= request.getParameter("formaçao") %>></input></p>
		<p> Experiência </p>
			<p><input type= "text" name = "experiencia" value = <%= request.getParameter("experiencia") %>></input></p>
		<p> Remuneração Desejada </p>
			<p><input type= "text" name = "remuneraçao" value = <%= request.getParameter("remuneraçao") %>></input></p>
			
<input type ="submit" name="op" value ="Adicionar"></input>
<a href= "home">Cancelar</a>
</form>
</body>
</html>