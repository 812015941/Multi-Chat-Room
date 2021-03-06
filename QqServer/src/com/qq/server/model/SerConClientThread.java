//功能：是服务器和某个客户端的通信线程
package com.qq.server.model;
import java.net.*;
import java.io.*;
import com.qq.common.*;
public class SerConClientThread extends Thread{
	Socket s;
	public SerConClientThread(Socket s)
	{
		//把服务器和该客户端的链接赋给s
		this.s=s;
	}
	public void run()
	{
		while(true)
		{
			//这里该线程就可以接受客户端的信息
			try {
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				
				System.out.println(m.getSender()+"给"+m.getGetter()+"说:"+m.getCon());
				
				//一会完成转发
				//取得接收人的通信线程
				SerConClientThread sc=ManageClientThread.getClientThread(m.getGetter());
				ObjectOutputStream oos=new ObjectOutputStream(sc.s.getOutputStream());
				oos.writeObject(m);
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
}
