//���ǿͻ������ӷ������ĺ�̨
//MesType:1��½�ɹ�
//MesType��2ע��ɹ�
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
			//ͨ��oos�����������object o
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
//			ͨ��ois��ȡ��Ϣ
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
	//���͵�һ������
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
				//�ʹ���һ����qq�źͷ������˱���ͨѶ���ӵ��߳�
				
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
