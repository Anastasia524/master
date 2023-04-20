<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page import="domain.Author"%>

<% 
Author a1 = new Author(1l, "Михаил","Шторм","mSnus@gmail.com",8800, null);
Author a2 = new Author(2l, "Олег","Громов","oleggromov@gmail.com",8646, null);
Author a3= new Author(3l, "Анастасия","Серго","nalgeon@gmail.com",8959, null);
Author a4 = new Author(4l, "Мария","Ренер","dom1n1k@gmail.com",8964, null);
Author[] authors = new Author[]{a1, a2, a3, a4};
int length = authors.length;
pageContext.setAttribute("authors", authors);
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Авторы</title>
<head>
<meta charset="UTF-8">
<title>Authors</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список авторов</h3>
<table>
	<thead>
	<tr>
	<th scope="col">Код</th>
	<th scope="col">Имя</th>
	<th scope="col">Фамилия</th>
	<th scope="col">Почта</th>
	<th scope="col">Телефон</th>
	<th scope="col">Дата Регистрации</th>
	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="author" items="${authors}">
		<tr>
		<td>${author.getId()}</td>
		<td>${author.getFirstName()}</td>
		<td>${author.getLastName()}</td>
		<td>${author.getEmail()}</td>
		<td>${author.getPhone()}</td>
		<td>${author.getDataRegistration()}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</aside>
	</section>
	<section>
	<article>
	<h3>Наименование автора</h3>
	<div class="text-article">
		<form method="POST" action="">
		<p>
		<label for="lastname">Фамилия
</label> <input type="text" name="lastname" />
		</p>
		<p>
		<label for="firstname">Имя
</label> <input type="text" name="firstname" />
		</p>
		
		<p>
		<label for="email">Почта
</label> <input type="text" name="email" />
		</p>
		<p>
		<label for="phone">Телефон
</label> <input type="text" name="phone" />
		</p>
		<p>
		<label for="dataregistration">Дата Регистрации
</label> <input type="text" name="dataregistration" />
		</p>
		</form>
		<p>
		<button type="submit">Добавить</button>
		</p>
	</div>
	</article>
	</section>
	</div>
	<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>

