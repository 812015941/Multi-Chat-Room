package com.qq.server.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.qq.common.User;

public class HibernateRegister {
	public static  User [] users = new User[100];
	public static int size;
public static void main(String[] args) {
	//insert();
}
public  HibernateRegister(User u) {
	User newUser = new User();
	newUser.setUserID(u.getUserID());
	newUser.setPasswd(u.getPasswd());
	
	Configuration cfg = new Configuration();
	SessionFactory sf =cfg.configure().buildSessionFactory();
	Session session = sf.openSession();
	/*String hql="from User";
	List<User> list=session.createQuery(hql).list();
	
	int i=0;
	for(User user:list){
		System.out.println("ID:"+user.getUserID());
		System.out.println("passWd:"+user.getPasswd());
		
		User checkUser =new User();
        String id = user.getUserID();
        String password = user.getPasswd();
        checkUser.setPasswd(password);
        checkUser.setUserID(id);
      	users[i]=checkUser;
        //Display values
        //System.out.print("ID: " +checkUser.getUserID());
        //System.out.print(", password: " + checkUser.getPasswd()+"\r");
        i = i+1;
	}*/
	size = 100;
	
	//将list的user导入到User数组里里面
	session.beginTransaction();
	session.save(newUser);
	session.getTransaction().commit();
	session.close();
}
public User getUser(int i)
{
	 //i<=10
	 User checkUser =new User();
	 checkUser = users[i];
	 
	 return users[i];
}
}
