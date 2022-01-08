import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferdReaderTest {

	public BufferdReaderTest() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("입력 = ");
			String txt = br.readLine(); // enter까지의 문자열을 버퍼에 담은 후 한 줄씩 String으로 변환하여 리턴
			System.out.print("txt = " + txt);
			
		} catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new BufferdReaderTest();

	}

}
