<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "usuarioAction.jsp" method="post">
<table>
	<tr>
		<td> Nome Completo </td>
		<td> E-mail </td>
		<td> Telefone </td>
		<td> Data de Nascimento </td>
		<td> Endereço </td>
		<td> Área Desejada </td>
		<td> Idiomas e Nível </td>
		<td> Conhecimentos Técnicos e Nível </td>
		<td> Formação </td>
		<td> Experiência </td>
		<td> Remuneração Desejada </td>
	</tr>
	<tr>
		<td><input type= "text" name = "nome" value = <%= request.getParameter("nome") %>></input></td>
		<td><input type= "text" name = "email" value = <%= request.getParameter("email") %>></input></td>
		<td><input type= "text" name = "telefone" value = <%= request.getParameter("telefone") %>></input></td>
		<td><input type= "text" name = "nascimento" value = <%= request.getParameter("nascimento") %>></input></td>
		<td><input type= "text" name = "endereço" value = <%= request.getParameter("endereço") %>></input></td>
		<td><input type= "text" name = "area" value = <%= request.getParameter("area") %>></input></td>
		<td><input type= "text" name = "idiomas" value = <%= request.getParameter("idiomas") %>></input></td>
		<td><input type= "text" name = "conhecimentos" value = <%= request.getParameter("conhecimentos") %>></input></td>
		<td><input type= "text" name = "formaçao" value = <%= request.getParameter("formaçao") %>></input></td>
		<td><input type= "text" name = "experiencia" value = <%= request.getParameter("experiencia") %>></input></td>
		<td><input type= "text" name = "remuneraçao" value = <%= request.getParameter("remuneraçao") %>></input></td>	
	</tr>

</table>
<input type="submit" value ="atualizar"></input>
<a href = "index.jsp">Cancelar</a>
</form>
</body>
</html>