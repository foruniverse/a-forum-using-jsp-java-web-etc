package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import util.DbHelper;
import model.Plate;
import model.Post;


public class PlateDao {
	
	public Plate checkPlateById(int plateid)//根据板块ID查询板块
	{
		Plate plate = null;
		String sql =" select * from plate where id = ?";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,plateid);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{	
				 plate = new  Plate(plateid,rs.getString("name"),rs.getInt("postcount"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return plate;
	}
	
	
		public List<Post> getAllPost(int id)//得到该板块下的所有帖子
		{
			List<Post> list = new ArrayList<> ();
			String sql =" select * from post where plateid = ?";
			PreparedStatement ps;
			try {
				ps = DbHelper.getConnection().prepareStatement(sql);
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				while (rs.next())
				{	
					Post p= new Post(rs.getInt("pid"),rs.getString("creatorname"),rs.getInt("plateid"),rs.getString("title"),rs.getString("content"),rs.getTimestamp("createtime"),rs.getTimestamp("replytime"),rs.getInt("commentcount"));
					
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return list.size()==0?null:list;
		}
		
		public List<Plate> getAllPlate()//查询所有已有的 板块
		{
			List<Plate> plate = new ArrayList<> ();
			String sql = " select * from plate";
			PreparedStatement ps;
			try{
				ps = DbHelper.getConnection().prepareStatement(sql);
				ResultSet rs = ps. executeQuery();
				while ( rs.next())
				{
					Plate p =new Plate(rs.getInt("id"),rs.getString("name"),rs.getInt("postcount"));
					plate.add(p);
				}
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			return plate.size()==0?null:plate;
				
		}
		public long getPostCount(int plateId) //查询该板块下的帖子总数
		{
			
			String sql =" select * from plate where id = ?";
			PreparedStatement ps;
			try {
				ps = DbHelper.getConnection().prepareStatement(sql);
				ps.setInt(1,plateId);
				ResultSet rs = ps.executeQuery();
				while (rs.next())
				{	
					rs.last();
					return rs.getRow();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}


		public boolean updatePlateCount(int plateid) {
			// TODO Auto-generated method stub
			String sql = "update plate set postcount = postcount+1 where id = ?";
			PreparedStatement ps;
			try {
				ps = DbHelper.getConnection().prepareStatement(sql);
				ps.setInt(1,plateid);
				ResultSet rs = ps.executeQuery();
				if (rs.next())
				{	
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
		
	
}
