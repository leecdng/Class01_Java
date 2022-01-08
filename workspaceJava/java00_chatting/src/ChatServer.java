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
	// ��� �����ڸ� ChatService ��ü�� ����� ������ �÷���
	List<ChatService> connList = new ArrayList<ChatService>();
	public ChatServer() {
		this.start();
	}

	// ������ ����ϴ� ������
	public void run() {
		try {
			ss = new ServerSocket(19000);
			while(true) {
				System.out.println("���Ӵ����");
				Socket s = ss.accept();
				
				// ������ ������...
				ChatService service = new ChatService(s);
				connList.add(service);
				
				service.allMessageSend("*MG$"+service.id+"���� �����Ͽ����ϴ�."); // ��� Ŭ���̾�Ʈ���� �˷���
				service.allMessageSend("$CN#" + connList.size()); // ������ ��
				service.allUserListSend(); // ��ü ������ ����Ʈ ������
				
				service.start();
				
			}
		} catch(Exception e) {
			System.out.println("ServerSocket ��ü ���� ���� �߻�");
		}
	}
	
	// ������ ������ ���� ��ü ---- ����Ŭ����
	class ChatService extends Thread{
		Socket s;
		String id;
		BufferedReader br;
		PrintWriter pw;
		
		ChatService(){}
		ChatService(Socket s){
			this.s = s;
			id = s.getInetAddress().getHostAddress(); // id ���ϱ�
			
			try {
				// Ŭ���̾�Ʈ�� ���� ���ڸ� �޴� ��ü
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				// �������� Ŭ���̾�Ʈ ���� ������ ��ü
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
				
			} catch(Exception e) {
				System.out.println("ChatService ������ �޼��� ����");
			}
			
		}
		
		// Ŭ���̾�Ʈ�� ������ ������ ���� �ޱ� // �о���� input ����
		public void run() {
			while(true) {
				try {
					String msg = br.readLine();
					if(msg!=null && !msg.equals("")) {
						allMessageSend("*MG$" + id + "��: " + msg);
					}
				} catch(Exception e) {
					
				}
			}
		}
		
		// �������� ��� �����ڿ��� ���� ������
		public void allMessageSend(String msg) {
			for(int i=0; i<connList.size(); i++) {
				ChatService cs = connList.get(i); // ��� Ŭ���̾�Ʈ���� ������ ����
				try {
					cs.pw.println(msg);
					cs.pw.flush(); // ����ġ�� �Ŷ�� �����ϸ� ��.
					//System.out.println(msg);
				} catch(Exception e) {
					// Ŭ���̾�Ʈ���� Output �� ���ܰ� �߻��ϸ� �ش� Ŭ���̾�Ʈ�� ������ �����
					connList.remove(i); // ���� ����Ǹ� �÷��� ���� ������ �ϳ� ���.
					i--;
				}
			}
		}
		
		// �������� Ŭ���̾�Ʈ���� ��ü ������ ����Ʈ ������
		public void allUserListSend() {
			String user = "@LI*";
			for(int i=0; i<connList.size(); i++) {
				user += connList.get(i).id + "/";
			}
			allMessageSend(user); // ��ü �����ڸ���Ʈ ������
			
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();

	}

}
