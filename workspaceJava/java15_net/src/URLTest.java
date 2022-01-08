

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		
		try {
			// URL�ּ� (protocol, host(������), port, filename) ���� �̿��Ͽ� ��ü�� �����ϸ�
			// �ش� ������ ���ҽ��� ���� �� �ִ�.
			URL url = new URL("https://www.nate.com/");
			
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile();
			String path = url.getPath();
			
			System.out.println("protocol->" + protocol); // https
			System.out.println("host->" + host); // www.nate.com
			System.out.println("port->" + port); // -1
			System.out.println("file->" + file); // / --> ������ /���.���ϸ�+������(����+��)���� ����
			System.out.println("path->" + path); // / --> ������ /���.���ϸ���� ����
			
			
			
			//URLConnection ��ü�� ���Ͽ� ��� ������ ���� �� �ִ�.
			URLConnection connection = url.openConnection(); //URLConnection�� �����ڸ޼��尡 protected�� URL�޼���� ��ü ����
			connection.connect();// ���ä���� Ȯ���Ͽ��� ��� ������ ���� �� �ִ�. // �߻�޼�����??????
			
			String type = connection.getContentType(); // ��� ���� ���ϱ�
			System.out.println("content-type-->" + type); // text/html; charset=utf-8
			
			// �ڵ� ������
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8); // type.substring(type.indexOf("charset=")+8)

			System.out.println("encode->" + encode);
			
			
			
			// url ��ü���� resource ��������
			InputStream is = url.openStream(); //url��ü�� �о��..? ����Ʈ ������
			InputStreamReader isr = new InputStreamReader(is, "utf-8"); // ���� ������ �ٲ��� (��� ���� �� �ᵵ ��. �³� ���۵���ǲ��Ʈ�� ���� ��)
			BufferedReader br = new BufferedReader(isr); // 1�� ������ �ٲ���
			
			while(true) { // �ҽ� ���� �� �پ� �ҷ���. �ѱ��� ���ڵ� �� �ؼ� ����
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
