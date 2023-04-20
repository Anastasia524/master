package domain;

import javax.xml.crypto.Data;

/**
* Класс для данных сотрудника
*/
public class Blog {
// Идентификатор сотрудника
 private Long id;
 
 // Имя
 private String title;
 
 // Фамилия
 private String content;
 
 // Телефон
 private Data date;
 

 // Внешний ключ -ссылка на сущность Role
 private Long idAuthor;
 
 // Навигационное свойства - ссылка на должность
 private Author author;
 public Blog() {
}
 
 public Blog(String title, String content, Data date, Author author) {
 this.title = title;
 this.content = content;
 this.date = date;
 this.author = author;
 }
 
 public Blog(String title, String content, Data date, Long idAuthor,Author author) {
 this.title = title;
 this.content = content;
 this.date = date;
 this.author = author;
 this.idAuthor = idAuthor;
 }
 
 public Blog(Long id, String title, String content, Data date, Long idAuthor,  Author author) {
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
public Data getDate() {
return date;
}
public void setDate(Data date) {
this.date = date;
}
public Author author () {
return author;
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

@Override
public String toString() {
return "Author {" + "Id = " + id + 
", title = " + title + 
", content = " + content + 
", date = " + date + 
",  fistname = " + getAuthor() + 
"}";
}
}