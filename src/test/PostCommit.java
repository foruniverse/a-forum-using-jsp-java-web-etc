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
import dao.PlateDao;
import model.User;

@WebServlet("/PostCommit")
public class PostCommit extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
		{
		    request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		
			
			int sid = Integer.parseInt( request .getParameter ("userId"));			
			String title = request.getParameter("title");
			String content = request.getParameter("content");			
			int plateid = Integer.parseInt(request.getParameter ("plate"));
			 
			PostDao postDao = new PostDao();
			PlateDao  plateDao = new PlateDao();
			
			int pid = postDao.getMaxPostid()+1;
			
			
			//String title="hello 你们是";
			//String content = "hello world";
			//int plateid = 1;
			
			UserDao userDao = new UserDao ();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//转换时间格式到 timestamp
			String date=df.format(new Date());
			
			String username = userDao.checkUserById(sid).getSname();
			//String username= "nmsl";
			
			postDao.insertPost(pid,username,plateid,title,content,date,date);
			plateDao.updatePlateCount(plateid);
			response.sendRedirect("post.jsp?pid="+pid);
			
			
			
	
			
		
		}

}
