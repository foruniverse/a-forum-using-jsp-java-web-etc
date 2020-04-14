package test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

import dao.UserDao;
import model.User;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	public void doPost( HttpServletRequest request, HttpServletResponse response/*, Cookie cookie4, Object Cookie */) 
			throws ServletException, IOException
		{

		 String strId = request.getParameter( "id" );
		 int id = 0;
		 if (strId != null && !"".equals(strId))
			 id = Integer.parseInt(strId);
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		if(dao.checkUserById(id)== null)
		{
			
			String a =URLEncoder.encode("无该用户，请重新检查您输入的 账号","UTF-8");
			response.getWriter().println("<script language='javascript'>alert (decodeURIComponent('"+a+"'));"
					+ "window.location.href='login.jsp'</script>");// 转换编码，防止乱码

			return;
		}
		
		if(!dao.checkUserById(id).getSpwd().equals(password))
		{
			String a =URLEncoder.encode("密码错误","UTF-8");
			response.getWriter().println("<script language='javascript'>alert (decodeURIComponent('"+a+"'));"
					+ "window.location.href='login.jsp'</script>");
			
			return ;
		}

		
		
		// 使用cookie 保存登录信息
		Cookie cookie = new Cookie("userName",URLEncoder.encode(dao.checkUserById(id).getSname(),"utf-8"));
		Cookie cookie2 = new Cookie("isLogin","true");
		Cookie cookie3 = new Cookie("id",""+id+"");
		
		User user= dao.checkUserById(id);
		Cookie cookie4;
		if(user.getRoot()==1)
		{
			cookie4= new Cookie ("isAdmin","true");
		}
		else 
		{
			cookie4 = new Cookie ("isAdmin","false");
		}
		response .addCookie(cookie);
		response .addCookie(cookie2);
		response .addCookie(cookie3);
		
		response .addCookie(cookie4);
		// 登录到论坛主页
		response.sendRedirect("index.jsp");
		
		}
}


