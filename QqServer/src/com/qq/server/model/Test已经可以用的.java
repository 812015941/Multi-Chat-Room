package com.qq.server.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qq.common.User;



public class Test已经可以用的 {
public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	User user=(User) ac.getBean("user");
	System.out.println(user.getUserID());
	
//	SessionFactory ts = (SessionFactory) ac.getBean("sessionFactory");
//	
//	Session s = ts.openSession();
//	User user = new User("aa","aa@sohu.com",123,10.0f);
//	
//	Transaction tx=s.beginTransaction();
//	s.save(employee);
//	tx.commit();
	
}
}