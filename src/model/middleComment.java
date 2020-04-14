package model;

import java.sql.*;



public class middleComment {//楼中楼
	
	
	private int postId;//主帖id
	private String userName;// 
	private Timestamp time;
	private String content;
	private int height;
	
	public middleComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public middleComment(int postId, String userName, Timestamp time,
			String content,int height) {
		super();
		this.postId = postId;
		this.userName = userName;
		this.time = time;
		this.content = content;
		this.height = height;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int height() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

}
