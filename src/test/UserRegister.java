package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.*;
import java.io.IOException;
import java.net.URLEncoder;

import dao.UserDao;
import model.User;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
			throws ServletException, IOException
			{
			 	request.setCharacterEncoding("utf-8");
				String strId=request.getParameter("id");
//				 int id = 6;
//				 if (strId != null && !"".equals(strId))
				int	 id = Integer.parseInt(strId);
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				UserDao dao = new UserDao();
				
				if(dao.checkUser(id))
				{
					String a =URLEncoder.encode("用户ID已被占用","UTF-8");
					response.getWriter().println("<script language='javascript'>alert (decodeURIComponent('"+a+"'));"
							+ "window.location.href='register.jsp'</script>");// 转换编码，防止乱码
					return;
				}	
				
				dao.insertUser(id,password,name);
				Cookie cookie = new Cookie("userName",URLEncoder.encode(dao.checkUserById(id).getSname(), "UTF-8"));
				Cookie cookie2 = new Cookie("isLogin","true");
				Cookie cookie3 = new Cookie("id",""+id+"");
				Cookie cookie4 = new Cookie("isAdmin","false");
				
				response .addCookie(cookie);
				response .addCookie(cookie2);
				response .addCookie(cookie3);
				response.addCookie(cookie4);
				response.sendRedirect("index.jsp");
				
				
				
							
				
			}
}
