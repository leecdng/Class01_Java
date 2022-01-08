

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public ServerSocketTest() {
		serverStart();
	}

	public void serverStart() {
		try {
			// 0~65536 정도까지 포트 번호 있음
			ServerSocket ss = new ServerSocket(16000);
			System.out.println("Server Start");
			
			while(true) {
				System.out.println("접속 대기 중");
				Socket s = ss.accept(); // 클라이언트의 접속을 기다리는 중
				System.out.println("클라이언트가 접속함");
				InetAddress ia = s.getInetAddress(); // 클라이언트의 ip
				System.out.println("접속자의 ip --> " + ia.getHostAddress());
				
				// 접속자에게 문자 보내기 --> outputStream이 필요
				OutputStream os = s.getOutputStream(); // 바이트 단위로
				OutputStreamWriter osw = new OutputStreamWriter(os); // 한 문자씩
				PrintWriter pw = new PrintWriter(osw); // 한 줄씩
				
				pw.println("welcome~ 안녕!");
				pw.flush();
				
				
				// 클라이언트가 보낸 문자 받기
				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String data = br.readLine();
				System.out.println("클라이언트에게 받은 문자-->" + data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ServerSocketTest();
	}

}
