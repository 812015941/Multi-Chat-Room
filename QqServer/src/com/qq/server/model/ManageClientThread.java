package com.qq.server.model;
import java.util.*;
public class ManageClientThread {
	public static HashMap hm=new HashMap<String,SerConClientThread>();
	
	//向Hm中添加一个客户端通讯线程
	public static void addClientThread(String uid,SerConClientThread ct)
	{
		hm.put(uid, ct);
		
	}
	public static SerConClientThread getClientThread(String uid)
	{
		return (SerConClientThread)hm.get(uid);
	}
}
