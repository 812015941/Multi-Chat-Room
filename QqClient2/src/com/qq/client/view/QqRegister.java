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
		jlb1 = new JLabel("���������",JLabel.CENTER);
		jlb2=new JLabel("����������",JLabel.CENTER);
		jb1=new JButton("ע��");
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
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
		this.setTitle("ע��");
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
			
			//����Ϣ���������������ɷ������ٿ����ݿ���ӣ���
			
			
			
			
			//�ӷ�����������Ϣ���Ƿ�ɹ�ע��
			if(qqClientUser.checkRegister(u)==true)
			{
				JOptionPane.showMessageDialog(this,"����˺�û��ʹ�ã�����ע�ᣡ");
				//this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"�û����Ѿ���ע��,������");
			}
			
			
		}
		if(e.getSource().equals(jb2))
		{
			this.dispose();
		}
		
	}
}
