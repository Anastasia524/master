package domain;

import javax.xml.crypto.Data;

/**
* Класс для данных сотрудника
*/
public class Comment {
// Идентификатор сотрудника
 private Long id;
 
 
 
 // Фамилия
 private String content;
 
 // Телефон
 private Data datecomment;
 

 // Внешний ключ -ссылка на сущность Role
 private Long idBlog;
 private Long idAuthor;
 
 // Навигационное свойства - ссылка на должность
 private Blog blog;
 private Author author;
 public Comment() {
}
 
 public Comment( String content, Data datecomment, Author author, Blog blog) {

 this.content = content;
 this.datecomment = datecomment;
 this.author = author;
 this.blog = blog;
 }
 
 public Comment(String content, Data datecomment, Author author, Blog blog, Long idAuthor, Long idBlog) {
	 this.content = content;
	 this.datecomment = datecomment;
	 this.author = author;
	 this.blog = blog;
 this.idAuthor = idAuthor;
 this.idBlog = idBlog;
 }
 
 public Comment(Long id, String content, Data datecomment, Author author, Blog blog, Long idAuthor, Long idBlog) {
 this.id = id;
 this.content = content;
 this.datecomment = datecomment;
 this.author = author;
 this.blog = blog;
this.idAuthor = idAuthor;
this.idBlog = idBlog;
 }
 


public String getContent() {
return content;
}
public void setContent(String content) {
this.content = content;
}
public Data getDateComment() {
return datecomment;
}
public void setDateComment(Data datecomment) {
this.datecomment = datecomment;
}
public Author author () {
return author;
}
public Blog blog () {
return blog;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}


public String getAuthor() {
return author.getFirstName();
}
public void setAuthor(Author author) {
this.author = author;
}
public Long getIdAuthor() {
return idAuthor;
}
public void setIdAuthor(Long idAuthor) {
this.idAuthor = idAuthor;
}


public String getBlog() {
return blog.getTitle();
}
public void setBlog(Blog blog) {
this.blog = blog;
}
public Long getIdBlog() {
return idBlog;
}
public void setIdBlog(Long idBlog) {
this.idBlog = idBlog;
}
@Override
public String toString() {
return "Author {" + "Id = " + id + 
", title = " + getBlog() + 
", content = " + content + 
", date = " + datecomment + 
",  fistname = " + getAuthor() + 
"}";
}
}