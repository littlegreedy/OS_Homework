package pers.ap.sample.tcp;

import java.net.*;
public class TcpServer
{
	public static void main(String [] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(8001);
			while(true)
			{
				Socket s=ss.accept();
				System.out.println("client has came");
				new Thread(new Worker(s)).start();
			}
			//ss.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}