//�����û���Ϣ��
package com.qq.common;

public class User implements java.io.Serializable{
	private String userID;
	private String passwd;
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
	public User(String userID,String passwd){
		this.userID=userID;
		this.passwd=passwd;
		System.out.println("���������캯������");
	}
	public User(){
		System.out.println("�޲������캯������");
	}
	
}
