<%@ page language="java" contentType="text/html" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Blog"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Comment"%>
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

Comment c1 = new Comment(1l, "Круто",null,a1,b1,1l,1l);
Comment c2 = new Comment(2l, "Интересно",null,a2,b2,2l,2l);
Comment c3= new Comment(3l, "Любопытно",null,a3,b3,3l,3l);
Comment c4 = new Comment(4l, "Не интересует",null,a4,b4,4l,4l);
Comment[] comments = new Comment[]{c1, c2, c3, c4};

pageContext.setAttribute("comments", comments);
%>

    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Комментарии</title>
<head>
<meta charset="UTF-8">
<title>Blogs</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<aside class="leftAside">
<h3>Список комментариев</h3>
<table>
	<thead>
		<tr>
		<th>Код</th>
		<th>Комментарий</th>
		<th>Дата</th>
		<th>Автор</th>
		<th>Пост</th>
		<th>Id автора</th>
		<th>Id поста</th>
		
		</tr>
	</thead>
	<tbody>
	<c:forEach var="comment" items="${comments}">
		<tr>
		<td>${comment.getId()}</td>
		<td>${comment.getContent()}</td>
		<td>${comment.getDateComment()}</td>
		<td>${comment.getAuthor()}</td>
		<td>${comment.getBlog()}</td>
		<td>${comment.getIdAuthor()}</td>
		<td>${comment.getIdBlog()}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</aside>
<section>
<article>
<h3>Данные по комментарию</h3>
<div class="text-article">
	<form method="POST" action="">
	<p>
	<label for="content">Комментарий</label>
	<input type="text" name="content" />
	</p>
	
	<p>
	<label for="authorname">Автор</label>
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
	<label for="blogname">Пост</label>
	<select>
		<option disabled>Выберите пост</option>
		<c:forEach var="blog" items="${blogs}">
			<option value="${blog}">
				${blog.getTitle()}> 
			</option>
</c:forEach>
	</select>			
	</p>
	<p>
<label for="datecomment">Дата</label>
	<input type="text" name="datecomment" />
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
