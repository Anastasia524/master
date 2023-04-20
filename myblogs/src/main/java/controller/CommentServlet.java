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

import dao.BlogDAO;
import dao.CommentDAO;
import dao.USerDAO;
import domain.Author;
import domain.Blog;
import domain.Comment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BlogDAO daoBlog;
	private USerDAO daoAuthor;
	private CommentDAO daoComment;

	public void init() {
		daoBlog = new BlogDAO();
		daoAuthor = new USerDAO();
		daoComment = new CommentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
				default:
					listComment(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Author> listAuthor = daoAuthor.selectAllAuthors();
		List<Blog> listBlog = daoBlog.selectAllBlogs();
		List<Comment> listComment = daoComment.selectAllComments();
		request.setAttribute("listComment", listComment);
		request.setAttribute("listBlog", listBlog);
		request.setAttribute("listAuthor", listAuthor);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/comment.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
   