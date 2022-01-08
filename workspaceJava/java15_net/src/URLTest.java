

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
		try {
			// URL주소 (protocol, host(도메인), port, filename) 등을 이용하여 객체를 생성하면
			// 해당 서버의 리소스를 얻어올 수 있다.
			URL url = new URL("https://www.nate.com/");
			
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile();
			String path = url.getPath();
			
			System.out.println("protocol->" + protocol); // https
			System.out.println("host->" + host); // www.nate.com
			System.out.println("port->" + port); // -1
			System.out.println("file->" + file); // / --> 보통은 /경로.파일명+데이터(변수+값)까지 나옴
			System.out.println("path->" + path); // / --> 보통은 /경로.파일명까지 나옴
			
			
			
			//URLConnection 객체를 구하여 헤더 정보를 얻어올 수 있다.
			URLConnection connection = url.openConnection(); //URLConnection은 생성자메서드가 protected라서 URL메서드로 객체 생성
			connection.connect();// 통신채널을 확보하여야 헤더 정보를 얻어올 수 있다. // 추상메서드임??????
			
			String type = connection.getContentType(); // 헤더 정보 구하기
			System.out.println("content-type-->" + type); // text/html; charset=utf-8
			
			// 코드 얻어오기
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8); // type.substring(type.indexOf("charset=")+8)

			System.out.println("encode->" + encode);
			
			
			
			// url 객체에서 resource 가져오기
			InputStream is = url.openStream(); //url객체를 읽어옴..? 바이트 단위로
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 문자 단위로 바꿔줌 (영어만 쓰면 안 써도 됨. 걔넨 버퍼드인풋스트림 쓰는 듯)
			BufferedReader br = new BufferedReader(isr); // 1줄 단위로 바꿔줌
			
			while(true) { // 소스 내용 한 줄씩 불러옴. 한글은 인코딩 안 해서 깨짐
				String readData = br.readLine();
				if(readData==null) break;
				//System.out.println(readData);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		URLTest url = new URLTest();

	}

}
