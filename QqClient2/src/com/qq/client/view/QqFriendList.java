/*好友列表，也包括陌生人和黑名单*/
/*很奇怪的是，第三张卡片打死打不开*/
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QqFriendList extends JFrame implements ActionListener,MouseListener{
	String owner;
	//处理第一张卡片（显示好友列表）
	JPanel jphy1,jphy2,jphy3;
	JButton  jphy_jb1,jphy_jb2,jphy_jb3;
	JScrollPane jspl;
	
	//处理第而张卡片（显示陌生人列表）
	JPanel jpmsr1,jpmsr2,jpmsr3;
	JButton  jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
	JScrollPane jspl2;
	//处理第三张卡片
	JPanel jphmd1,jphmd2,jphmd3;
	JButton jphmd_jb1,jphmd_jb2,jphmd_jb3;
	JScrollPane jspl3;
	//把整个JFrame设置成CardLayout
	CardLayout cl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList qqFriendList= new QqFriendList("ownerId");
	}
	public QqFriendList(String ownerId)
	{
		this.owner=ownerId;
		final JPanel mainJPanel = new JPanel(); // 默认布局是 流布局
		//处理第一张卡片（显示好友列表）,假定有50个好友
		jphy_jb1=new JButton("我的好友");
		jphy_jb2=new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		
		jphy_jb3=new JButton("黑名单");
		jphy1 = new JPanel(new BorderLayout());
		//假定有50个好友
		jphy2 = new JPanel(new GridLayout(50,1,4,6));
		
		//给jphy2初始化50个好友
		JLabel []jbls=new JLabel[50];
		
		for (int i = 0;i<jbls.length;i++)
		{
			jbls[i]= new JLabel (i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);
		}
		
		jphy3 = new JPanel (new GridLayout(2,1));
		//把两个按钮加入到jphy3中、
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		
		
		jspl = new JScrollPane(jphy2);
		
		//对jphy1进行初始化
		jphy1.add(jphy_jb1,"North");
		jphy1.add(jspl,"Center");
		jphy1.add(jphy3,"South");
		
		
		//处理第二张卡片
	
		jpmsr_jb1=new JButton("我的好友");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("陌生人");
		jpmsr_jb3=new JButton("黑名单");
		jpmsr1 = new JPanel(new BorderLayout());
		//假定有20个好友
		jpmsr2 = new JPanel(new GridLayout(20,1,4,6));
		
		//给jpmsr2初始化20个好友
		JLabel []jbls2=new JLabel[20];
		
		for (int i = 0;i<jbls2.length;i++)
		{
			jbls2[i]= new JLabel (i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls2[i].addMouseListener(this);
			jpmsr2.add(jbls2[i]);
		}
		
		jpmsr3 = new JPanel (new GridLayout(2,1));
		//把两个按钮加入到jpmsr1中、
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		
		jspl2 = new JScrollPane(jpmsr2);
		
		//对jphy1进行初始化
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jspl2,"Center");
		jpmsr1.add(jpmsr_jb3,"South");
		
		//处理第三张卡片
		jphmd_jb1=new JButton("我的好友");
		jphmd_jb2=new JButton("陌生人");
		jphmd_jb3=new JButton("黑名单");
		jphmd1 = new JPanel(new BorderLayout());
		jphmd2= new JPanel(new GridLayout(3,1));
		jphmd3= new JPanel(new GridLayout(20,1,4,6));
		//把二十个用户标签加入到jphmd3中
		JLabel []jbls3= new JLabel[20];
		for(int i = 0;i<jbls3.length;i++)
		{
			jbls3[i]=new JLabel(i+1+"",new ImageIcon("image/mm.jpg"),JLabel.LEFT);
			jbls3[i].addMouseListener(this);
			jphmd3.add(jbls3[i]);
			
		}
		//把三个按钮加入到jphmd2中
		jphmd2.add(jphmd_jb1);
		jphmd2.add(jphmd_jb2);
		jphmd2.add(jphmd_jb3);
		//把jphmd3放到滚动轴中
		jspl3 = new JScrollPane(jphmd3);
		//对jphmd1进行初始化
		jphmd1.add(jphmd2);
		jphmd1.add(jspl3);
		//jphmd1.add(jphmd_jb2,"South");
		
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		this.add(jphmd1,"3");
		//在窗口显示自己的编号
		this.setTitle(ownerId);
		this.setSize(140,500);
		this.setIconImage((new ImageIcon("image/qq.gif")).getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0){
		
		
		//如果按了陌生人按钮，就显示第二张卡片
		
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
		//响应用户双击的事件，并得到好友的编号
		if(e.getClickCount()==2)
		{
			//得到该好友的编号
			String friendNo=((JLabel)e.getSource()).getText();
			
			//System.out.println("你希望和"+friendNo+"聊天");
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
	

