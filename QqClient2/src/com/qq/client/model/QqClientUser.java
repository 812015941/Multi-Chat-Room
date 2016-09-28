package com.qq.client.model;
import java.io.*;
import com.qq.common.*;
public class QqClientUser {
	public boolean checkUser(User u)
	{
		return new QqClientConServer().SendLoginInfoToServer(u);
	}
	public boolean checkRegister(User u)
	{
		return new QqClientConServer().SendRegisterInfoToServer(u);
	}
}
