package model;

import java.sql.Timestamp;

public class Post {
	private int pid;// 帖子标识id
	private String creatorName;//发帖人
	private int plateId;// 所在的板块名
	private String title;//帖子的标题
	private String content;//帖子的主要内rong
	private Timestamp createTime;//帖子的最初发表时间
	private Timestamp replyTime; //帖子最近回复时间
	private int commentCount; // 帖子总评论数
	
	
	
	
	public Post(int id, String creatorName,int plateId, String title, String content,Timestamp time, Timestamp time1, int commentCount)
	{
		super();
		this.pid=id;
		this.content =content;
		this.title=title;    
		this.plateId=plateId;
		this.creatorName=creatorName;
		this.createTime= time;
		this.replyTime = time1;
	
		this.commentCount = commentCount;
	}
	

	public Post() {
		// TODO Auto-generated constructor stub
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public int getPlateId() {
		return plateId;
	}

	public void setPlateId(int plateId) {
		this.plateId = plateId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	

}
