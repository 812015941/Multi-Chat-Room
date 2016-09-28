//这是客户端连接服务器的后台
//MesType:1登陆成功
//MesType：2注册成功
package com.qq.client.model;
import com.qq.client.model.QqClientUser;
import java.io.*;
import java.util.*;
import java.net.*;
import com.qq.common.*;
public class QqClientConServer {
	public static Socket s;
	
	public boolean SendRegisterInfoToServer(Object o)
	{
		boolean b = false;
		try {
			Socket s =new Socket ("127.0.0.1",9998);
			//通过oos向服务器发送object o
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
//			通过ois读取信息
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("2"))
			{
				b=true;
			}
			else{
				s.close();
			}
		
					
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
		
	}
	//发送第一次请求
	public boolean SendLoginInfoToServer(Object o)
	{
		boolean b =false;
		try {
			s= new Socket("127.0.0.1",9999);
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("1"))
			{
				//就创建一个该qq号和服务器端保持通讯连接得线程
				
				b=true;
				
			}
			else{
				s.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return b;
		
	}
	public void SendInfoToServer(Object o)
	{
		try {
			Socket s= new Socket("127.0.0.1",9999);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
