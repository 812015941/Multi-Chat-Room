//����qq�����������ڼ������ȴ�ĳ��QQ�ͻ��ˣ�������
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
			//�ڶ˿�9999����
			System.out.println("���Ƿ���������9999����");
			HibernateHelper hibernateHelper = new HibernateHelper();
			hibernateHelper.query();
			ServerSocket ss=new ServerSocket(9999);
			//ServerSocket ss2=new ServerSocket(9998);//ר�������������û��Ķ˿�
			//�������ݿ�
			//SqlHelper sqlHelper = new SqlHelper();
			User [] users= new User[hibernateHelper.users.length];
			//************
			//������δ��������⣡
			/*for(int i=0;i<10;i++){
				User checkUser =new User();
				checkUser = sqlHelper.getUser(i);
				users[i]=checkUser;
				String checkID = checkUser.getUserID();
				String checkPwd = checkUser.getPasswd();
				System.out.println("checkID="+checkID);
				System.out.println("checkPwd="+checkPwd);
				System.out.println("����");
			}*/
			
			
			while(true){
			
				System.out.println("���Ƿ���������9999��������δ��ͨ��");
				//�������ȴ�����
				Socket s=ss.accept();
				
				System.out.println("���Ƿ���������9999���������ڵ�ͨ��");
				//���ܿͻ��˷�������Ϣ
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());//�����ӿڹ��ã���Ϊ�������������ͬʱ��
				User u = (User)ois.readObject();
				//
				Boolean bool =false;
				System.out.println("���������յ��û���:"+u.getUserID()+"  \r���� :"+u.getPasswd());
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				
				
				//�ж�������û��ǲ��Ǳ��������ݿ���
				int a;
				
				
				int check=0;
				
				for(a=0;a<hibernateHelper.size;a++){
					//System.out.println("��˵��Ϊ�գ�����ǣ�"+checkID);
					
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
						//����һ�����ɹ���½����Ϣ
						
						m.setMesType("1");
						oos.writeObject(m);
						SerConClientThread scct=new SerConClientThread(s);
						ManageClientThread.addClientThread(u.getUserID(), scct);
						//������ÿͻ���ͨ�ŵ��߳�
						scct.start();
						
					}
					//�û�������
					if(check==0)
					{
						m.setMesType("2");
						oos.writeObject(m);//��m=2����ȥ
						s.close();
						
						//�ر�����
						
					}
					
				
			}	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
