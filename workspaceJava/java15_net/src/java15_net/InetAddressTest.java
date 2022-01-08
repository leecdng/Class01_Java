package java15_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		try {
			// 현재 내 컴퓨터의 IP를 이용한 IneAddress 객체 생성하기
			InetAddress ia1 = InetAddress.getLocalHost(); // 예외 발생 // 현재 컴퓨터의 ip 정보를 가져올 수 있음
			
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			
			System.out.println("hostAddr1->"+hostAddr1); // 192.168.0.2 // ip
			System.out.println("hostName1->"+hostName1); // DESKTOP-SCJQRR1 // 내 컴퓨터의 디바이스 이름과 같음 (보통 url이 오는 자리)
			
			// url 주소로 InetAddress 객체를 생성하면 ip, url 정보를 객체가 가지고 있다.
			InetAddress nate = InetAddress.getByName("www.nate.com");
			System.out.println("nate->address-->"+ nate.getHostAddress()); // 120.50.131.112 (실제 주소)
			System.out.println("nate->Name-->"+ nate.getHostName()); // www.nate.com (껍데기 같은 것)
			// ip를 가지고 도메인은 못 구함. 도메인을 가지고 ip구하는 건 가능 (이미 호스팅 때 정보가 있음)
			
			InetAddress nateIp = InetAddress.getByName("120.50.131.112");
			System.out.println("nateIp->address-->" + nateIp.getHostAddress());
			System.out.println("nateIp->Name-->" + nateIp.getHostName());
			
			// InetAddress 전체 객체 구하기
			System.out.println("---------------------------------------------------");
			InetAddress[] ip = InetAddress.getAllByName("www.naver.com"); // ip를 두 개 씀
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
