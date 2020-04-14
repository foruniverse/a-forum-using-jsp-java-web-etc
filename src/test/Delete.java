package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;

import java.io.IOException;
import java.net.URLEncoder;

import java.util.Date;
import java.text.SimpleDateFormat;// 获取当前时间

import dao.UserDao;
import dao.PostDao;
import model.User;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
		{
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		
			int pid = Integer.parseInt( request.getParameter ("pid"));			
			PostDao postDao = new PostDao ();

			
			postDao.deletePost(pid);
			postDao.deleteComment(pid);
			
			response.sendRedirect("index.jsp");
		
		}

}
