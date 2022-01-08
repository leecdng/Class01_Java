import java.io.BufferedInputStream;

public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		try {
			// BufferedInputStream :바이트 단위로 문자를 읽어 버퍼에 저장 후 한 줄씩 읽을 수 있는 객체
			BufferedInputStream bis = new BufferedInputStream(System.in);
			byte[] data = new byte[10]; // 10바이트만 읽게 해놓음
			
			System.out.print("입력 = ");
			int cnt = bis.read(data);
			System.out.println(cnt + "--> " + new String(data));
		} catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new BufferedInputStreamTest();

	}

}
