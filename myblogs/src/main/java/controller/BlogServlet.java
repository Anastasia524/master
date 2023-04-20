package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

import dao.BlogDAO;
import dao.USerDAO;
import domain.Author;
import domain.Blog;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
/**
* 
*/
@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDAO daoBlog;
	private USerDAO daoAuthor;

	public void init() {
		daoBlog = new BlogDAO();
		daoAuthor = new USerDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
				default:
					listBlog(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBlog(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Author> listAuthor = daoAuthor.selectAllAuthors();
		List<Blog> listBlog = daoBlog.selectAllBlogs();
		request.setAttribute("listBlog", listBlog);
		request.setAttribute("listAuthor", listAuthor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/blog.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
   