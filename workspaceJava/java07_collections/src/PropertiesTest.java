import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// Properties�÷��� : key, value�� ��� String�� �÷���
		
		Properties prop = new Properties();
		
		// setProperty() : ��ü �߰�
		prop.setProperty("���̹�", "https://www.naver.com");
		prop.setProperty("����Ʈ", "https://www.nate.com");
		prop.setProperty("����", "https://www.daum.net");
		prop.setProperty("����", "https://www.google.com");
		
		// getProperty() : Ű�� �̿��Ͽ� ��ü ������
		System.out.println(prop.getProperty("����"));
		
		// Ű ��� ��ü ���ϱ�
		Enumeration e = prop.propertyNames();	// ���ʸ� �����ϱ� object�� ���
		
		while(e.hasMoreElements()) { // ��ü�� �������� ��� true, ������ false
			String str = (String)e.nextElement();	//  object�ϱ� String���� ����ȯ
			System.out.println("key="+str+", value="+prop.getProperty(str)); // ���� ���� ��µ�
		}
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
