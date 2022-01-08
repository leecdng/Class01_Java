import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		try {
			ds = new DatagramSocket(15000);
			
			// 받기 대기...
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("받기 대기 중");
			ds.receive(dp); // 데이터를 받을 때까지 대기 모드 (readLine같은 거????? accept가 아니라???
			
			// DatagramPackit에서 전송 받은 데이터를 얻어오기
			byte[] receiveData = dp.getData();
			int byteCount = dp.getLength(); // 전송 받은 byte수
			String receiveStr = new String(receiveData, 0, byteCount);
			System.out.println(receiveStr+"---------------"); // ------- 이 부분은 512바이트 뒤에 끝에 나옴
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
