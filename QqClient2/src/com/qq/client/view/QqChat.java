//这是与好友聊天的界面
//因为客户端 ，要处于读取的状态，因此我们把它做成一个线程
package com.qq.client.view;
import java.awt.*;
import com.qq.common.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;

import javax.swing.*;
import com.qq.client.model.*;
import java.io.*;

public class QqChat extends JFrame implements ActionListener,Runnable{
	
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String ownerId;
	String friendId;
	
	
	public QqChat(String ownerId,String friend)
	{
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField();
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel(new GridLayout(1,2));
		jp.add(jtf);
		jp.add(jb);
		
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.add(jta,"Center");
		this.add(jp, "South");
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		QqChat qqchat = new QqChat("ownId","friend");
	}
	public void ShowChat(String a)
	{
		this.jta.setText(jta.getText()+a);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb)
		{
			//如果用户点击了，发送按钮
			Message m = new Message();
			//m.setMesType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			ShowChat(m.getSender()+"对"+m.getGetter()+"说:   "+m.getCon()+"\n");
			//发送给服务器
			try {
				ObjectOutputStream oos = new ObjectOutputStream(QqClientConServer.s.getOutputStream());
				oos.writeObject(m);
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				//读取[如果读不到就等待.]
				ObjectInputStream ois = new ObjectInputStream(QqClientConServer.s.getInputStream());
				
				Message m = (Message)ois.readObject();
				//显示
				String info=m.getSender()+"对"+m.getGetter()+"说"+m.getCon()+"\r\n";
				this.jta.append(info);
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}
	}
	
	
	
}
