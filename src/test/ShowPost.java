package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import java.io.IOException;
import java.net.URLEncoder;

import dao.PlateDao;
import model.User;
import model.Post;


@WebServlet("/ShowPost")
public class ShowPost extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
			{
			PlateDao postdao= new PlateDao();
			int id =1;
			List<Post> list = postdao.getAllPost(id);
			
			request.setAttribute("list",list);
			request.getRequestDispatcher("post.jsp").forward(request,response);
			}

}
