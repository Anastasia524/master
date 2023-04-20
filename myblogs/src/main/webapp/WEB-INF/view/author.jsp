<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page import="domain.Author"%>

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
<th>Код</th>
<th>Имя Автора</th>
<th>Фамилия Автора</th>
<th>Почта</th>
<th>Телефон</th>
<th>Дата Регистрации</th>
</tr>
</thead>
<tbody>
<c:forEach var="author" items="${listAuthor}">
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
<h3>Добавить автора</h3>
<div class="text-article">
<form method="POST" action="">
<p>
<label for="firstname">Имя</label> <input type="text" name="firstname" />
</p>
<p>
<label for="lastname">Фамилия</label> <input type="text" name="lastname" />
</p>
<p>
<label for="email">Почта</label> <input type="text" name="email" />
</p>
<p>
<label for="phone">Телефон</label> <input type="text" name="phone" />
</p>
<p>
<label for="dataregistration">Дата Регистрации</label> <input type="text" name="dataregistration" />
</p>
<p>
<button type="submit" >Добавить</button>
</p>
</form>

</div>
</article>
</section>
</div>


<jsp:include page="/WEB-INF/jspf/footer.jsp" />
</body>
</html>

