package dao;

import java.sql.*;
import java.util.*;

import model.Post;
import model.Comment;
import model.middleComment;
import util.DbHelper;

public class PostDao {
	
	public List<Post> getAllPost ()//查询所有帖子
	{
		List<Post> list = new ArrayList<>();
		String sql= "select * from Post order by createtime";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
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
		return list;
	}
	
	public int getMaxPostid ()// 查询最大postId 达到递增增加postid的效果
	{
		
		String sql= "select max(pid) as max_1 from post";
		PreparedStatement ps;
		int max=-1;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();	
			if(rs.next())
			{                                                                                                                                                                                                                                                                                                                                                                                             
				max=rs.getInt("max_1");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return max;
	}
	
	public int getPostSum ()//查询帖子总数
	{
		
		String sql= "select count(*) as sum_1 from post";
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
	
	public List<Post> searchPost (String word)//帖子搜索（奇怪的报错） 语句可以在sql里运行正确 但是无法在java里运行
	{
		List<Post> list = new ArrayList<>();
		//String sql= "select * from Post where title like %?% or content like %?% or  title like ?% or title like %? or content like %? or content like s?% order by createtime";
		String sql= "select * from Post where title like \"%\"?\"%\" ";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setString(1,"mother");
//			ps.setString(2,word);
//			ps.setString(3,word);
//			ps.setString(4,word);
//			ps.setString(5,word);
//			ps.setString(6,word);
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
		return list;
	}
	
	public Post getPostById (int id)// 根据id查询帖子
	{
		
		String sql= "select * from post where pid =?";
		PreparedStatement ps;
		Post p= null;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();	
			if(rs.next())
			{
				p= new Post(rs.getInt("pid"),rs.getString("creatorname"),rs.getInt("plateid"),rs.getString("title"),rs.getString("content"),rs.getTimestamp("createtime"),rs.getTimestamp("replytime"),rs.getInt("commentcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return p;
	}
	
	
	
	public List<Comment> getAllComment (int id)//根据主帖id查询所有comment
	{
		List<Comment> list = new ArrayList<>();
		String sql= "select * from comment where PostId= ?  order by time DESC";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Comment comment = new Comment();
				comment.setPostId(id);
				comment.setUserName(rs.getString("userName"));
				comment.setContent(rs.getString("content"));
				comment.setTime(rs.getTimestamp("time"));
				comment.setLike(rs.getInt("likecount"));
				comment.setHeight(rs.getInt("height"));
				
				list.add(comment);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}
	
	
	
	public List<middleComment> getAllMiddleComment (int PostId, int height)//根据帖子id 和 评论所在层数查询子评论
	{
		List<middleComment> list = new ArrayList<> ();
		String sql= "select * from middleComment where PostId = ? and height = ?";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,PostId);
			ps.setInt(2,height);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{	
				middleComment middleComment = new  middleComment();
				middleComment.setContent(rs.getString("content"));
				middleComment.setUserName(rs.getString("userName"));
				middleComment.setTime(rs.getTimestamp("time"));
				middleComment.setPostId(PostId);
				middleComment.setHeight(height);
		
				list.add(middleComment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return list.size()== 0 ?null:list;
	}
	
	public long getPostReplyNumber(int id) // 得到一个帖子的回复数
	{
		String sql= "select * from comment where pid ='"+id+"'";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}


	public long getCommentReplyNumber(int id)// 得到帖子楼层的回复数（楼数）
	{
		String sql= "select * from middleComment where pid ='"+id+"'";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.last();
			return rs.getRow();// 得到行数（Post 的 comment数）
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
	// 以上是查询部分
	//-------------------------------------------------------------------------
	// 以下是插入部分
	
	public void  insertComment (int pid, String username, String content,String time)//  插入评论  根据pid
	{
		//服务器端传入的值 不要使用  ---'?'-----这种形式
		String sql = "insert into comment(postid,username,time,content,likecount,height) values(?,?,to_timestamp(?,'YYYY-MM-DD HH24:MI:SS.MS'),?,0,0) ";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,pid);
			ps.setString (2,username);
			ps.setString (3,time);
			ps.setString (4,content);			
			ResultSet rs = ps.executeQuery();	
			rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	
	public boolean insertPost (int pid, String username, int plateid,String title, String content,String time,String time1)//  插入评论  根据pid
	{
		//服务器端传入的值 不要使用  ---'?'-----这种形式
		String sql = "insert into post(pid,creatorname,plateid,title,content,createtime,replytime,commentcount) values(?,?,?,?,?,to_timestamp(?,'YYYY-MM-DD HH24:MI:SS.MS'),to_timestamp(?,'YYYY-MM-DD HH24:MI:SS.MS'),0) ";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,pid);
			ps.setString (2,username);
			ps.setInt(3, plateid);
			ps.setString (4,title);			
			ps.setString (5,content);
			ps.setString(6, time);
			ps.setString(7, time1);
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
	
	public boolean updatePostCommentCount(int pid)// 插入评论后更新评论数量 +1
	{
		String sql="update post set commentcount = commentcount+1 where pid =?";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,pid);			
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
	

//----删除部分------------------------------------------------------------------------------------------------------------------
	
	public Boolean  deletePost(int id)// 删除帖子
	{
		String sql= "delete from post where pid ='"+id+"'";
		PreparedStatement ps;
		try {
			ps = DbHelper.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;              			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public Boolean deleteComment(int id)
	{
		String sql= "delete from comment where postid = ?";
		PreparedStatement ps;
		try{
			ps = DbHelper.getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;		
	}
	
	
	
}

