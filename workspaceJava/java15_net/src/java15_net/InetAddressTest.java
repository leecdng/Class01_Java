package java15_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		try {
			// ���� �� ��ǻ���� IP�� �̿��� IneAddress ��ü �����ϱ�
			InetAddress ia1 = InetAddress.getLocalHost(); // ���� �߻� // ���� ��ǻ���� ip ������ ������ �� ����
			
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			
			System.out.println("hostAddr1->"+hostAddr1); // 192.168.0.2 // ip
			System.out.println("hostName1->"+hostName1); // DESKTOP-SCJQRR1 // �� ��ǻ���� ����̽� �̸��� ���� (���� url�� ���� �ڸ�)
			
			// url �ּҷ� InetAddress ��ü�� �����ϸ� ip, url ������ ��ü�� ������ �ִ�.
			InetAddress nate = InetAddress.getByName("www.nate.com");
			System.out.println("nate->address-->"+ nate.getHostAddress()); // 120.50.131.112 (���� �ּ�)
			System.out.println("nate->Name-->"+ nate.getHostName()); // www.nate.com (������ ���� ��)
			// ip�� ������ �������� �� ����. �������� ������ ip���ϴ� �� ���� (�̹� ȣ���� �� ������ ����)
			
			InetAddress nateIp = InetAddress.getByName("120.50.131.112");
			System.out.println("nateIp->address-->" + nateIp.getHostAddress());
			System.out.println("nateIp->Name-->" + nateIp.getHostName());
			
			// InetAddress ��ü ��ü ���ϱ�
			System.out.println("---------------------------------------------------");
			InetAddress[] ip = InetAddress.getAllByName("www.naver.com"); // ip�� �� �� ��
			for(InetAddress ia : ip) {
				System.out.println("adress-->" + ia.getHostAddress());
				System.out.println("name-->"+ia.getHostName()+"\n-----------------------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();

	}

}
