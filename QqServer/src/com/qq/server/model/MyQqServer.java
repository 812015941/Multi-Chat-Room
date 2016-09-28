//这是qq服务器，他在监听、等待某个QQ客户端，来连接
package com.qq.server.model;
import java.net.*;
import java.io.*;
import java.util.*;
import com.qq.server.db.*;
import com.qq.common.Message;
import com.qq.common.User;

public class MyQqServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyQqServer();
		
	}
	
	public MyQqServer()
	{
		
		try {
			//在端口9999监听
			System.out.println("我是服务器，在9999监听");
			HibernateHelper hibernateHelper = new HibernateHelper();
			hibernateHelper.query();
			ServerSocket ss=new ServerSocket(9999);
			//ServerSocket ss2=new ServerSocket(9998);//专门用来创建新用户的端口
			//加入数据库
			//SqlHelper sqlHelper = new SqlHelper();
			User [] users= new User[hibernateHelper.users.length];
			//************
			//这里有未解决的问题！
			/*for(int i=0;i<10;i++){
				User checkUser =new User();
				checkUser = sqlHelper.getUser(i);
				users[i]=checkUser;
				String checkID = checkUser.getUserID();
				String checkPwd = checkUser.getPasswd();
				System.out.println("checkID="+checkID);
				System.out.println("checkPwd="+checkPwd);
				System.out.println("我晕");
			}*/
			
			
			while(true){
			
				System.out.println("我是服务器，在9999监听，还未导通！");
				//阻塞，等待链接
				Socket s=ss.accept();
				
				System.out.println("我是服务器，在9999监听，现在导通了");
				//接受客户端发来的信息
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());//两个接口公用！因为不可能两个借口同时打开
				User u = (User)ois.readObject();
				//
				Boolean bool =false;
				System.out.println("服务器接收到用户名:"+u.getUserID()+"  \r密码 :"+u.getPasswd());
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				
				
				//判断输入的用户是不是保存在数据库里
				int a;
				
				
				int check=0;
				
				for(a=0;a<hibernateHelper.size;a++){
					//System.out.println("他说它为空？结果是："+checkID);
					
					String checkID = hibernateHelper.getUser(a).getUserID();
					String checkPwd = hibernateHelper.getUser(a).getPasswd();
					System.out.println("checkID="+checkID);
					System.out.println("checkPwd="+checkPwd);
					
					if(u.getPasswd().equals(checkPwd)&&u.getUserID().equals(checkID))
					{
						check=1;
						break;
					}
					
				}
					//if(u.getPasswd().equals(password)&&u.getUserID().equals(id))//******
				// 	
				if(check==1)//******
					{
						//返回一个包成功登陆的信息
						
						m.setMesType("1");
						oos.writeObject(m);
						SerConClientThread scct=new SerConClientThread(s);
						ManageClientThread.addClientThread(u.getUserID(), scct);
						//启动与该客户端通信的线程
						scct.start();
						
					}
					//用户不存在
					if(check==0)
					{
						m.setMesType("2");
						oos.writeObject(m);//把m=2返回去
						s.close();
						
						//关闭连接
						
					}
					
				
			}	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
