//这是用户信息类
package com.qq.common;

public class User implements java.io.Serializable{
	private String userID;
	private String passwd;
	//private String passwd2;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
