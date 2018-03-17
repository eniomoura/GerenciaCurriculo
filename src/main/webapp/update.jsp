<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">

	<form>
		<p> Nome Completo </p>
		<p><input type= "text" name = "nome" value = <%= request.getParameter("nome") %>></input></p>
		
		<p> E-mail </p>
		<p><input type= "text" name = "email" value = <%= request.getParameter("email") %> ></input></p>
		
		<p> Telefone </p>
		<p><input type= "text" name = "telefone" value = <%= request.getParameter("telefone") %>></input></p>
		
		<p> Data de Nascimento </p>
		<p><input type= "text" name = "nascimento" value = <%= request.getParameter("nascimento") %>></input></p>
		
		<p> Endereço </p>
		<p><input type= "text" name = "endereco" value = <%= request.getParameter("endereco") %>></input></p>
		
		<p> Área Desejada </p>	
		<p><input type= "text" name = "area" value = <%= request.getParameter("area") %>></input></p>
		
		<p> Idiomas e Nível </p>
		<p><input type= "text" name = "idiomas" value = <%= request.getParameter("idiomas") %>></input></p>
		
		<p> Conhecimentos Técnicos e Ní­vel </p>
		<p><input type= "text" name = "conhecimentos" value = <%= request.getParameter("conhecimentos") %>></input></p>
		
		<p> Formação </p>
		<p><input type= "text" name = "formacao" value = <%= request.getParameter("formacao") %>></input></p>
		
		<p> Experiência </p>
		<p><input type= "text" name = "experiencia" value = <%= request.getParameter("experiencia") %>></input></p>
		
		<p> Remuneração Desejada </p>
		<p><input type= "text" name = "remuneracao" value = <%= request.getParameter("remuneracao") %>></input></p>
		
	</form>
<input type="submit" value ="atualizar"></input>
<a href = "home">Cancelar</a>
</form>
</body>
</html>

<style>
        body{
            text-align: center;
            background-color: lightgray;
            font-family: 'Times New Roman', Times, serif, Helvetica, sans-serif;
            color: black;
            padding: 5px 10px;
            

            
        }
        
    </style>