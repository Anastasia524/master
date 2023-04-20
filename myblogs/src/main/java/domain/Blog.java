package domain;

import java.util.Date;

import javax.xml.crypto.Data;


public class Blog {
// Идентификатор поста
 private Long id;
 
 // Заголовок
 private String title;
 
 // Описание
 private String content;
 
 // Дата публикации
 private Date date;
 

 // Внешний ключ -ссылка на сущность Author
 private Long idAuthor;
 
 // Навигационное свойства - ссылка на автора
 private Author author;
 public Blog() {
}
 

 
 public Blog(Long id, String title, String content, Date date, Long idAuthor,  Author author) {
 this.id = id;
 this.title = title;
 this.content = content;
 this.date = date;
 this.author = author;
 this.idAuthor = idAuthor;
 }
 
 
public String getTitle() {
return title;
}
public void setTitle(String title) {
this.title = title;
}

public String getContent() {
return content;
}
public void setContent(String content) {
this.content = content;
}
public Date getDate() {
return date;
}
public void setDate(Date date) {
this.date = date;
}
public Author author () {
return author;
}
public Long getId() {
return id;
}
public void setBlogId(Long id) {
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

@Override
public String toString() {
return "Author {" + "Id = " + id + 
", title = " + title + 
", content = " + content + 
", date = " + date + 
",  fistname = " + author + 
"}";
}
}