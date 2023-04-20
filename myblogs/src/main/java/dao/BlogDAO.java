package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Author;
import domain.Blog;



public class BlogDAO extends ConnectionProperty {
	
	

	public BlogDAO()  {
		
	}

	private static final String SELECT_ALL_USERS = "select id,firstname,lastname,email,phone, dataregistration  from authors";
	private static final String SELECT_ALL_BLOGS = "SELECT * from blogs";
	
	
	

	private Author findById(Long id, ArrayList<Author> authors) {
		if(authors != null) {
			for(Author r: authors) {
				if((r.getId()).equals(id)) {
					return r;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	public List<Blog> selectAllBlogs() {

		
		List<Blog> blogs = new ArrayList<>();
		List<Author> authors = new ArrayList<>();
		
		try (Connection connection = getConnection()){

			
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			
			while (rs.next()) {
				authors.add(new Author(
					rs.getLong("id"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getInt("phone"),
					rs.getDate("dataregistration")));
		}
			long idAuthor;
			preparedStatement = connection.prepareStatement(SELECT_ALL_BLOGS);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				idAuthor = rs.getLong("idAuthor");
				blogs.add(new Blog(
							rs.getLong("id"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getDate("date"),
							idAuthor,
							findById(idAuthor, (ArrayList<Author>) authors)
						));
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return blogs;
	}
	

}

