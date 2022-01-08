import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread {
	ServerSocket ss;
	// 모든 접속자를 ChatService 객체로 만들어 보관할 컬렉션
	List<ChatService> connList = new ArrayList<ChatService>();
	public ChatServer() {
		this.start();
	}

	// 접속을 대기하는 쓰레드
	public void run() {
		try {
			ss = new ServerSocket(19000);
			while(true) {
				System.out.println("접속대기중");
				Socket s = ss.accept();
				
				// 서버에 접속함...
				ChatService service = new ChatService(s);
				connList.add(service);
				
				service.allMessageSend("*MG$"+service.id+"님이 접속하였습니다."); // 모든 클라이언트한테 알려줌
				service.allMessageSend("$CN#" + connList.size()); // 접속자 수
				service.allUserListSend(); // 전체 접속자 리스트 보내기
				
				service.start();
				
			}
		} catch(Exception e) {
			System.out.println("ServerSocket 객체 생성 에러 발생");
		}
	}
	
	// 접속자 정보를 가질 객체 ---- 내부클래스
	class ChatService extends Thread{
		Socket s;
		String id;
		BufferedReader br;
		PrintWriter pw;
		
		ChatService(){}
		ChatService(Socket s){
			this.s = s;
			id = s.getInetAddress().getHostAddress(); // id 구하기
			
			try {
				// 클라이언트가 보낸 문자를 받는 객체
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 서버에서 클라이언트 문자 보내는 객체
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
			} catch(Exception e) {
				System.out.println("ChatService 생성자 메서드 에러");
			}
			
		}
		
		// 클라이언트가 서버로 보내는 문자 받기 // 읽어오기 input 관련
		public void run() {
			while(true) {
				try {
					String msg = br.readLine();
					if(msg!=null && !msg.equals("")) {
						allMessageSend("*MG$" + id + "님: " + msg);
					}
				} catch(Exception e) {
					
				}
			}
		}
		
		// 서버에서 모든 접속자에게 문자 보내기
		public void allMessageSend(String msg) {
			for(int i=0; i<connList.size(); i++) {
				ChatService cs = connList.get(i); // 모든 클라이언트한테 정보를 보냄
				try {
					cs.pw.println(msg);
					cs.pw.flush(); // 엔터치는 거라고 생각하면 됨.
					//System.out.println(msg);
				} catch(Exception e) {
					// 클라이언트에게 Output 중 예외가 발생하면 해당 클라이언트는 접속이 종료됨
					connList.remove(i); // 접속 종료되면 컬렉션 순서 앞으로 하나 당김.
					i--;
				}
			}
		}
		
		// 서버에서 클라이언트에게 전체 접속자 리스트 보내기
		public void allUserListSend() {
			String user = "@LI*";
			for(int i=0; i<connList.size(); i++) {
				user += connList.get(i).id + "/";
			}
			allMessageSend(user); // 전체 접속자리스트 보내기
			
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();

	}

}
