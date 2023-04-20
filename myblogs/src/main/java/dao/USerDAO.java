package dao;

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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class USerDAO {
	private String jdbcURL = "jdbc:postgresql://localhost:5433/authors";
	private String jdbcUsername = "postgres";
	private String jdbcPassword = "37852146";

	private static final String INSERT_AUTHORS_SQL = "INSERT INTO authors" + " (firstname,lastname, email,phone, dateregistration) VALUES "
			+ " (?, ?, ?,?,?);";
	String insert_author = "INSERT INTO authors(firsname) VALUES(?)";
	private static final String SELECT_ALL_USERS = "select * from authors";
	 private static final String UPDATE_AUTHORS_SQL = "update authors set firstname = ?, lastname = ?,email= ?, phone = ?, dateregistration =?";
	public USerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	

	
	public List<Author> selectAllAuthors() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Author> authors = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long id = rs.getLong("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				Integer phone = rs.getInt("phone");
				Date dataregistration = rs.getDate("dataregistration");
			
				authors.add(new Author(id, firstname, lastname, email,phone, dataregistration));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return authors;
	}
	
/////
	
	public void insertAuthor(Author author) throws SQLException {
		System.out.println(INSERT_AUTHORS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHORS_SQL)) {
			preparedStatement.setString(1, author.getFirstName());
			preparedStatement.setString(2, author.getLastName());
			preparedStatement.setString(3, author.getEmail());
			preparedStatement.setInt(4, author.getPhone());
			preparedStatement.setDate(5, author.getDataRegistration());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public boolean updateAuthor(Author author) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_AUTHORS_SQL);) {
			System.out.println("updated Author:"+statement);
			statement.setString(1, author.getFirstName());
			statement.setString(2, author.getLastName());
			statement.setString(3, author.getEmail());
			statement.setInt(4,  author.getPhone());
			statement.setDate(5, author.getDataRegistration());
			
			statement.setLong(6, author.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}