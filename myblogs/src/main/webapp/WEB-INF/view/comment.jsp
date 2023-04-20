<%@ page language="java" contentType="text/html" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="domain.Blog"%>
<%@ page import="domain.Author"%>
<%@ page import="domain.Comment"%>


    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Комментарии</title>
<head>
<meta charset="UTF-8">
<title>Comments</title>
</head>
<body>
<jsp:include page="/WEB-INF/jspf/header.jsp" />
<div id="main">
<section>
<aside class="leftAside">
<h3>Список комментариев</h3>
<table>
	<thead>
		<tr>
		<th scope="col">Код</th>
		<th scope="col">Комментарий</th>
		<th scope="col">Дата Комментария</th>
		
		<th scope="col">Автор</th>
		<th scope="col">Пост</th>
		
		
		</tr>
	</thead>
	<tbody>
	<c:forEach var="comment" items="${listComment}">
		<tr>
		<td>${comment.getId()}</td>
		<td>${comment.getContent()}</td>
		<td>${comment.getDateComment()}</td>
		
		<td>${comment.getAuthor()}</td>
		<td>${comment.getBlog()}</td>
		
		</tr>
	</c:forEach>
	</tbody>
</table>
</aside>
</section>
<section>
<article>
<h3>Добавить комментарий</h3>
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
		<c:forEach var="author" items="${listAuthor}">
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
		<c:forEach var="blog" items="${listBlog}">
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
