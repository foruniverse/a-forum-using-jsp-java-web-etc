package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Post;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import dao.PostDao;

@WebServlet("/Search")
public class Search extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
		{
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PostDao postDao = new PostDao();
			String word = request.getParameter("content");
			
			List<Post> posts = postDao.searchPost(word);
			
			request.setAttribute("PostList",posts);
			
			response.sendRedirect("searchResult.jsp");
			
		}

}
