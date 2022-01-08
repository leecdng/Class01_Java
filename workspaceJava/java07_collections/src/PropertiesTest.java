import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// Properties컬렉션 : key, value가 모두 String인 컬렉션
		
		Properties prop = new Properties();
		
		// setProperty() : 객체 추가
		prop.setProperty("네이버", "https://www.naver.com");
		prop.setProperty("네이트", "https://www.nate.com");
		prop.setProperty("다음", "https://www.daum.net");
		prop.setProperty("구글", "https://www.google.com");
		
		// getProperty() : 키를 이용하여 객체 얻어오기
		System.out.println(prop.getProperty("다음"));
		
		// 키 목록 전체 구하기
		Enumeration e = prop.propertyNames();	// 제너릭 없으니까 object로 담김
		
		while(e.hasMoreElements()) { // 객체가 남아있을 경우 true, 없으면 false
			String str = (String)e.nextElement();	//  object니까 String으로 형변환
			System.out.println("key="+str+", value="+prop.getProperty(str)); // 순서 없이 출력됨
		}
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
