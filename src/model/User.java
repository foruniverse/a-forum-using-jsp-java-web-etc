package model;

public class User {
	private int sid;
	private String sname;
	private String spwd;
	private int age;
	private int root;
	public User() {
	}
	
	public User(int sid,String sname,int age, String spwd,int root) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.spwd = spwd;
		this.root =root;
	}

	public int getRoot()
	{
		return root;
	}
	
	public void setRoot(int  root)
	{
		this.root=root;
	}
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd()
	{
		return spwd;
	}

	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
