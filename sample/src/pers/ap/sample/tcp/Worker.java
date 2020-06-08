package pers.ap.sample.tcp;

import java.net.*;
import java.io.*;
import java.util.Random;

class Worker implements Runnable {
	Socket s;

	public Worker(Socket s) {
		this.s = s;
	}

	public void run() {
		String[] strings=new String[3];
		int count=0;
		try {
			System.out.println("worker of server");
			InputStream ips = s.getInputStream();
			OutputStream ops = s.getOutputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(ips));
			DataOutputStream dos = new DataOutputStream(ops);
			while (true) {
				int waitOfTime=(int)(Math.random()*10+1);
				Thread.sleep(waitOfTime*600);
				String strWord = br.readLine();

				System.out.println(strWord);
				if (strWord.equalsIgnoreCase("quit"))
					break;
//				String strEcho = strWord + " 666";
//				// dos.writeBytes(strWord +"---->"+ strEcho +"\r\n");
//				System.out.println("server said:" + strWord + "---->" + strEcho);
//				dos.writeBytes(strWord + "---->" + strEcho + System.getProperty("line.separator"));

					strings[count++] = strWord;
				if(count==strings.length){
					for (String s: strings)
						System.out.print(s+" ");
				}

			}
			br.close();
			dos.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}