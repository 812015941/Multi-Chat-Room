/*QQ�ͻ��˵�½����*/
package com.qq.client.view;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import com.qq.client.model.QqClientConServer;
import com.qq.client.model.QqClientUser;
import com.qq.common.User;

public class QqClientLogin extends JFrame implements ActionListener{
	//���山����Ҫ�����
	JLabel jbl1;
	//�����в���Ҫ�����
	//�в�������JPanel����һ����ѡ��Ĵ��ڹ���
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;//
	JLabel jp2_jbl1,jp2_jbl2;
	JButton jp2_jbl4;
	JButton jp2_jbl3;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	
	//���岿��Ҫ�����
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	public static void main(String[] args) 
	{
		QqClientLogin qqClientLogin = new QqClientLogin();
	}
	
	public QqClientLogin()
	{
		//������
		jbl1= new JLabel(new ImageIcon("image/tou.gif"));
		//�����в�
		jp2 = new JPanel(new GridLayout(3,3));
		
		jp2_jbl1=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ����",JLabel.CENTER);
		
		jp2_jbl3=new JButton("��������");
		jp2_jbl3.addActionListener(this);
	
		jp2_jbl4=new JButton("�������뱣��");
		jp2_jbl4.addActionListener(this);
		jp2_jb1=new JButton ("���");//new ImageIcon("image/clear.gif"));
		jp2_jb1.addActionListener(this);
		jp2_jtf= new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("�����¼");
		jp2_jcb2=new JCheckBox("��ס����");
		//�ѿؼ�����˳����뵽jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		//����ѡ�����
		jtp = new JTabbedPane();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jtp.add("QQ����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("�����ʼ�",jp4);
		//�����ϲ�
		jp1=new JPanel();
		jp1_jb1 = new JButton("��½");/*new ImageIcon("image/denglu.gif"));*/
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton("ȡ��");//new ImageIcon("image/quxiao.gif"));
		jp1_jb3 = new JButton("��");//new ImageIcon("image/xiangdao.gif"));		
		jp1_jb3.addActionListener(this);
		//��������ť����jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		
		this.add(jbl1,"North");
		this.add(jtp,"Center");
		//this.add(jp2,"Center");
		this.add(jp1,"South");
		this.setSize(350,240);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jp1_jb1)//��½
		{// TODO Auto-generated method stub
			QqClientUser qqClientUser = new QqClientUser();
			User u=new User();
			u.setUserID(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(qqClientUser.checkUser(u)==true)//=if(...==1)
			{
				new QqFriendList(u.getUserID());
				this.dispose();
				
			}
			
			else{
				JOptionPane.showMessageDialog(this,"�û����������,������");
				
			}
		}
		if(arg0.getSource()==jp2_jb1)//�������
		{
			
			jp2_jtf.setText("");
			jp2_jpf.setText("");
		}
		if(arg0.getSource()==jp1_jb3)
		{
			new QqRegister();
		}
		if(arg0.getSource()==jp2_jbl3)//��������
		{
			//
		}
		if(arg0.getSource()==jp2_jbl4)//�������뱣��
		{
			//
		}
		
	}

}
