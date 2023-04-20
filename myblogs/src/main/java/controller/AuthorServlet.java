package controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import java.util.List;

import domain.Author;

import dao.USerDAO; 
/**
* 
*/
@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;
	private USerDAO userDAO;

	public void init() {
		userDAO = new USerDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
			doGet(request,response);
	}
	
	protected void doGet( HttpServletRequest request,  HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertAuthor(request, response);
				break;
			
			
			case "/update":
				updateAuthor(request, response);
				break;
			default:
				listAuthor(request, response);
				break;
			}
 } catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listAuthor( HttpServletRequest request,  HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Author> listAuthor = userDAO.selectAllAuthors();
		request.setAttribute("listAuthor", listAuthor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/author.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm( HttpServletRequest request,  HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/author.jsp");
		dispatcher.forward(request, response);
	}

	

	private void insertAuthor( HttpServletRequest request,  HttpServletResponse response) 
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Integer phone = Integer.parseInt("phone");
		
		
		Author newAuthor = new Author(id,firstname, lastname, email,phone,null);
		userDAO.insertAuthor(newAuthor);
		response.sendRedirect("list");
	}

	private void updateAuthor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");	
		int phone =Integer.parseInt( request.getParameter("phone"));
		
		

		Author author = new Author(id, firstname,lastname, email, phone,null);
		userDAO.updateAuthor(author);
		response.sendRedirect("list");
	}

	

}