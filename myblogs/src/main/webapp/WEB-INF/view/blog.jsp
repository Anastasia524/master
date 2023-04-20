<%@ page language="java" contentType="text/html" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Blog"%>
<%@ page import="domain.Author"%>
 

    
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
<section>
<aside class="leftAside">
<h3>Список постов</h3>
<table>
	<thead>
		<tr>
		<th scope="col">Код</th>
		<th scope="col">Название поста</th>
		<th scope="col">Описание</th>
		<th scope="col">Дата публикации</th>
		<th scope="col">Автор</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="blog" items="${listBlog}">
		<tr>
		<td>${blog.getId()}</td>
		<td>${blog.getTitle()}</td>
		<td>${blog.getContent()}</td>
		<td>${blog.getDate()}</td>
		<td>${blog.getAuthor()}</td>
		
		</tr>
	</c:forEach>
	</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Добавить пост</h3>
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
		<c:forEach var="author" items="${listAuthor}">
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
