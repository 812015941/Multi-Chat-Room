//����qq�����������ڼ������ȴ�ĳ��QQ�ͻ��ˣ�������
package com.qq.server.model;
import java.net.*;
import java.io.*;
import java.util.*;
import com.qq.server.db.*;
import com.qq.common.Message;
import com.qq.common.User;

public class MyQqServerRegister {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyQqServerRegister();
	}
	
	public MyQqServerRegister()
	{
		
		try {
			//�ڶ˿�9998����
			System.out.println("����ע��ר�÷���������9998����");
			ServerSocket ss=new ServerSocket(9998);
			
			
			
			while(true){
			
				System.out.println("���Ƿ���������9998��������δ��ͨ��");
				//�������ȴ�����
				Socket s=ss.accept();
				
				System.out.println("���Ƿ���������9998���������ڵ�ͨ��");
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
				
				
				/*String id = null;
				id = sqlHelper.getID(a);
				String password = sqlHelper.getPassword(a);
				System.out.println("�û�����"+id);
				System.out.println("������"+password);*/
				int check=0;
				
				/*for(a=0;a<hibernateRegister.size;a++){
					//System.out.println("��˵��Ϊ�գ�����ǣ�"+checkID);
					
					String checkID = hibernateRegister.getUser(a).getUserID();
					String checkPwd = hibernateRegister.getUser(a).getPasswd();
					System.out.println("checkID="+checkID);
					System.out.println("checkPwd="+checkPwd);
					
					if(u.getPasswd().equals(checkPwd)&&u.getUserID().equals(checkID))
					{
						check=1;
						break;
					}
					
				}*/
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
						//�������ݿ�
						new HibernateRegister(u);
						System.out.println("��tm�����أ�id��"+u.getUserID());
						
					}
					
				
			}	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
