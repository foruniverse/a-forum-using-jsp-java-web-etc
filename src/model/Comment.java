package model;


import java.sql.Timestamp;


public class Comment {
	
	private int postId;
	private String userName;
	private Timestamp time;
	private String content;
	private int like;
	private int height;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int postId, String userName, Timestamp time, String content,
			int like,  int height) {
		super();
		this.postId = postId;
		this.userName = userName;
		this.time = time;
		this.content = content;
		this.like = like;
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
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}

	public int getHeight() {
		return height;
	}


	public void setHeight(int int1) {
		// TODO Auto-generated method stub
		this.height= int1;
		
	}
	

}
