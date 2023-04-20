<%@ page language="java" contentType="text/html" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Blog"%>
<%@ page import="domain.Author"%>
<% 
Author a1 = new Author(1l, "Михаил","Шторм","mSnus@gmail.com",8800, null);
Author a2 = new Author(2l, "Олег","Громов","oleggromov@gmail.com",8646, null);
Author a3= new Author(3l, "Анастасия","Серго","nalgeon@gmail.com",8959, null);
Author a4 = new Author(4l, "Мария","Ренер","dom1n1k@gmail.com",8964, null);
Author[] authors = new Author[]{a1, a2, a3, a4};
int length = authors.length;
pageContext.setAttribute("authors", authors);

Blog b1 = new Blog(1l, "Время сна","Всё, что нужно знать о сне; 10 способов улучшить свой сон; К чему приводит недостаток сна", null,1l, a1);
Blog b2 = new Blog(2l, "Как справиться с беспокойством, если не можете повлиять на ситуацию","Попробуйте переключиться или направьте энергию на борьбу с возможными последствиями.", null,2l, a2);
Blog b3= new Blog(3l, "Астроном Владимир Сурдин: 6 космических чудес, которые поражают воображение","Рождение и смерть звёзд, поиск далёких галактик с помощью тёмной материи, выбросы солнечной энергии и не только.",null,3l, a3);
Blog b4 = new Blog(4l, "Хотите работать в медиа? 7 шагов по реализации мечты","Построить карьеру можно, даже если у вас нет профильного образования.", null,4l, a4);
Blog[] blogs = new Blog[]{b1, b2, b3, b4};
pageContext.setAttribute("blogs", blogs);
%>

    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Посты</title>
<head>
<meta charset="UTF-8">
<title>Blogs</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<aside class="leftAside">
<h3>Список постов</h3>
<table>
	<thead>
		<tr>
		<th>Код</th>
		<th>Заголовок</th>
		<th>Описание</th>
		<th>Дата</th>
		<th>Автор</th>
		<th>Id автора</th>
		
		</tr>
	</thead>
	<tbody>
	<c:forEach var="blog" items="${blogs}">
		<tr>
		<td>${blog.getId()}</td>
		<td>${blog.getTitle()}</td>
		<td>${blog.getContent()}</td>
		<td>${blog.getDate()}</td>
		<td>${blog.getAuthor()}</td>
		<td>${blog.getIdAuthor()}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</aside>
<section>
<article>
<h3>Данные по посту</h3>
<div class="text-article">
	<form method="POST" action="">
	<p>
	<label for="title">Заголовок</label>
	<input type="text" name="title" />
	</p>
	<p>
	<label for="content">Описание</label>
	<input type="text" name="content" />
	</p>
	<p>
	<label for="authorname">Должность</label>
	<select>
		<option disabled>Выберите автора</option>
		<c:forEach var="author" items="${authors}">
			<option value="${author}">
				${author.getLastName()}> 
			</option>
</c:forEach>
	</select>			
	</p>
	<p>
<label for="date">Дата</label>
	<input type="text" name="date" />
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
