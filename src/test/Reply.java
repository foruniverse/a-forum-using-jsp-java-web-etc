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

@WebServlet("/Reply")
public class Reply extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
		{
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		
			int pid = Integer.parseInt( request .getParameter ("postId"));
			int sid = Integer.parseInt( request .getParameter ("userId"));
			
			
			String content = request.getParameter("content");
			
			
			PostDao postDao = new PostDao ();
			UserDao userDao = new UserDao ();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//转换时间格式到 timestamp
			
			String username = userDao.checkUserById(sid).getSname();	
			String date=df.format(new Date());
			postDao.insertComment(pid,username,content,date);
			postDao.updatePostCommentCount(pid);
			
			response.sendRedirect("post.jsp?pid="+pid);
		
		}

}
