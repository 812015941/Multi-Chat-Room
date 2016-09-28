package com.qq.client.view;
import javax.swing.*;

import com.qq.common.User;
import com.qq.client.model.QqClientUser;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QqRegister extends JFrame implements ActionListener{
	JPanel jp;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	public static void main(String[] args) {
		new QqRegister();
	}
	public QqRegister(){
		jp = new JPanel(new GridLayout(3,2));
		jlb1 = new JLabel("请输入号码",JLabel.CENTER);
		jlb2=new JLabel("请输入密码",JLabel.CENTER);
		jb1=new JButton("注册");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jtf1= new JTextField();
		jpf1=new JPasswordField();
		
		jp.add(jlb1);
		jp.add(jtf1);
		jp.add(jlb2);
		jp.add(jpf1);
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setVisible(true);
		this.setTitle("注册");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(jb1))
		{
			User u = new User();
			u.setUserID(jtf1.getText().trim());
			u.setPasswd(new String(jpf1.getPassword()));
			QqClientUser qqClientUser= new QqClientUser(); 
			//System.out.println("get ID = "+u.getUserID());
			//System.out.println("get Pwd = "+u.getPasswd());
			
			//发信息给服务器（并且由服务器操控数据库添加！）
			
			
			
			
			//从服务器返回信息：是否成功注册
			if(qqClientUser.checkRegister(u)==true)
			{
				JOptionPane.showMessageDialog(this,"这个账号没人使用，可以注册！");
				//this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"用户名已经被注册,请重试");
			}
			
			
		}
		if(e.getSource().equals(jb2))
		{
			this.dispose();
		}
		
	}
}
