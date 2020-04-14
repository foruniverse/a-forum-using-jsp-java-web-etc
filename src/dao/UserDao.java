package dao;

import java.sql.*;
import java.util.*;

import model.User;
import util.DbHelper;

public class UserDao {
	
	public User checkUserById(int id) // 用户登录检查
	{
		String sql = "SELECT * FROM users WHERE sid=?";
		PreparedStatement ps;
		User user = null;
		try{
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				user = new User(id,rs.getString("sname"), rs.getInt("age"),rs.getString("spwd"),rs.getInt("root"));
			}
			return user;
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
	

	
	public boolean checkUser(int id) // 检查id是否重复（用于注册时）
	{
		String sql= "select * from users where sid ='"+id+"'";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();              
		}		
		return false;
	}		
	
	public int getUserSum ()//查询用户总数
	{
		
		String sql= "select count(*) as sum_1 from users";
		PreparedStatement ps;
		int sum=-1;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	
			if(rs.next())
			{                                                                                                                                                                                                                                                                                                                                                                                             
				sum=rs.getInt("sum_1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return sum;
	}
	


	public User insertUser(int id,String password,String name)
	{
		String sql=  "insert into users (sid,spwd,age,sname,root) values(?,'"+password+"',18,?,0)";
		PreparedStatement ps;
		User user= null;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,name);
			//ps.setString(2,password);
			//ps.setString(3,mail);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 user = new User(id,rs.getString("sname"), rs.getInt("age"),rs.getString("spwd"),rs.getInt("root"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return user;
	}
	
}
