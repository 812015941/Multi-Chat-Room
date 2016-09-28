/*�����б�Ҳ����İ���˺ͺ�����*/
/*����ֵ��ǣ������ſ�Ƭ�����򲻿�*/
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QqFriendList extends JFrame implements ActionListener,MouseListener{
	String owner;
	//�����һ�ſ�Ƭ����ʾ�����б�
	JPanel jphy1,jphy2,jphy3;
	JButton  jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jspl;
	
	//����ڶ��ſ�Ƭ����ʾİ�����б�
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton  jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane jspl2;
	//��������ſ�Ƭ
	JPanel jphmd1,jphmd2,jphmd3;
	JButton jphmd_jb1,jphmd_jb2,jphmd_jb3;
	JScrollPane jspl3;
	//������JFrame���ó�CardLayout
	CardLayout cl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList qqFriendList= new QqFriendList("ownerId");
	}
	public QqFriendList(String ownerId)
	{
		this.owner=ownerId;
		final JPanel mainJPanel = new JPanel(); // Ĭ�ϲ����� ������
		//�����һ�ſ�Ƭ����ʾ�����б�,�ٶ���50������
		jphy_jb1=new JButton("�ҵĺ���");
		jphy_jb2=new JButton("İ����");
		jphy_jb2.addActionListener(this);
		
		jphy_jb3=new JButton("������");
		jphy1 = new JPanel(new BorderLayout());
		//�ٶ���50������
		jphy2 = new JPanel(new GridLayout(50,1,4,6));
		
		//��jphy2��ʼ��50������
		JLabel []jbls=new JLabel[50];
		
		for (int i = 0;i<jbls.length;i++)
		{
			jbls[i]= new JLabel (i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);
		}
		
		jphy3 = new JPanel (new GridLayout(2,1));
		//��������ť���뵽jphy3�С�
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		
		jspl = new JScrollPane(jphy2);
		
		//��jphy1���г�ʼ��
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jspl,"Center");
		jphy1.add(jphy3,"South");
		
		
		//����ڶ��ſ�Ƭ
	
		jpmsr_jb1=new JButton("�ҵĺ���");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("İ����");
		jpmsr_jb3=new JButton("������");
		jpmsr1 = new JPanel(new BorderLayout());
		//�ٶ���20������
		jpmsr2 = new JPanel(new GridLayout(20,1,4,6));
		
		//��jpmsr2��ʼ��20������
		JLabel []jbls2=new JLabel[20];
		
		for (int i = 0;i<jbls2.length;i++)
		{
			jbls2[i]= new JLabel (i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls2[i].addMouseListener(this);
			jpmsr2.add(jbls2[i]);
		}
		
		jpmsr3 = new JPanel (new GridLayout(2,1));
		//��������ť���뵽jpmsr1�С�
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		
		jspl2 = new JScrollPane(jpmsr2);
		
		//��jphy1���г�ʼ��
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jspl2,"Center");
		jpmsr1.add(jpmsr_jb3,"South");
		
		//��������ſ�Ƭ
		jphmd_jb1=new JButton("�ҵĺ���");
		jphmd_jb2=new JButton("İ����");
		jphmd_jb3=new JButton("������");
		jphmd1 = new JPanel(new BorderLayout());
		jphmd2= new JPanel(new GridLayout(3,1));
		jphmd3= new JPanel(new GridLayout(20,1,4,6));
		//�Ѷ�ʮ���û���ǩ���뵽jphmd3��
		JLabel []jbls3= new JLabel[20];
		for(int i = 0;i<jbls3.length;i++)
		{
			jbls3[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls3[i].addMouseListener(this);
			jphmd3.add(jbls3[i]);
			
		}
		//��������ť���뵽jphmd2��
		jphmd2.add(jphmd_jb1);
		jphmd2.add(jphmd_jb2);
		jphmd2.add(jphmd_jb3);
		//��jphmd3�ŵ���������
		jspl3 = new JScrollPane(jphmd3);
		//��jphmd1���г�ʼ��
		jphmd1.add(jphmd2);
		jphmd1.add(jspl3);
		//jphmd1.add(jphmd_jb2,"South");
		
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		this.add(jphmd1,"3");
		//�ڴ�����ʾ�Լ��ı��
		this.setTitle(ownerId);
		this.setSize(140,500);
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0){
		
		
		//�������İ���˰�ť������ʾ�ڶ��ſ�Ƭ
		
		if(arg0.getSource()==jphy_jb2||arg0.getSource()==jphmd_jb2||arg0.getSource()==jpmsr_jb2)
		{
			cl.show(this.getContentPane(),"2" );
			
		}
		else if(arg0.getSource()==jpmsr_jb1||arg0.getSource()==jphmd_jb1||arg0.getSource()==jphy_jb2)
		{
			cl.show(this.getContentPane(),"1" );
		}
		else if(arg0.getSource()==jphmd_jb3||arg0.getSource()==jpmsr_jb3||arg0.getSource()==jphy_jb3)
		{
			cl.show(this.getContentPane(),"3");
		}
		
		
		/*if(arg0.getSource()==jphy_jb2)
		{
			cl.show(this.getContentPane(), "2");
		}else if(arg0.getSource()==jpmsr_jb1){
			cl.show(this.getContentPane(), "1");
		}*/
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//��Ӧ�û�˫�����¼������õ����ѵı��
		if(e.getClickCount()==2)
		{
			//�õ��ú��ѵı��
			String friendNo=((JLabel)e.getSource()).getText();
			
			//System.out.println("��ϣ����"+friendNo+"����");
			QqChat qqChat=new QqChat(this.owner,friendNo);
			Thread t=new Thread (qqChat);
			t.start();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	

