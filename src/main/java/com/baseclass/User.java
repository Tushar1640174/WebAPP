package com.baseclass;

public class User {

	
	private static long pk;
	private String name;
	private String email;
	private String password;
	public long getPk() {
		return pk;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    static
    {
    	pk=System.currentTimeMillis();
    }

	public User(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public User()
	{
		
	}
    
	
}
