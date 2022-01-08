import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicasteReceive() {
		try {
			ds = new DatagramSocket(15000);
			
			// �ޱ� ���...
			byte[] data = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("�ޱ� ��� ��");
			ds.receive(dp); // �����͸� ���� ������ ��� ��� (readLine���� ��????? accept�� �ƴ϶�???
			
			// DatagramPackit���� ���� ���� �����͸� ������
			byte[] receiveData = dp.getData();
			int byteCount = dp.getLength(); // ���� ���� byte��
			String receiveStr = new String(receiveData, 0, byteCount);
			System.out.println(receiveStr+"---------------"); // ------- �� �κ��� 512����Ʈ �ڿ� ���� ����
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
