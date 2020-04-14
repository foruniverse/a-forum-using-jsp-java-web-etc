package model;

public class Plate {
		
	private int id; //板块id，名称
	private String name;
	private int postCount;
	
	
	public Plate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Plate(int id, String name,int postCount) {
		super();
		this.id = id;
		this.name = name;
		this.postCount = postCount;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPostCount(int count)
	{
		this.postCount= count;
	}
	
	public int getPostCount()
	{
		return postCount;
	}
}
