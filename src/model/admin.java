package model;

public class admin {
	private int aid;
	private String apwd;
	
	public admin()
	{
	}
	
	public admin(int id,String pwd)
	{
		super();
		this.aid=id;
		this.apwd=pwd;
	}
	
	public int getId()
	{
		return aid;
	}
	
	public void setId(int id)
	{
		this.aid= id;
	}
	
	public void setPwd(String pwd)
	{
		this.apwd=pwd;
	}
	
	public String getPwd()
	{
		return apwd;
	}

}
