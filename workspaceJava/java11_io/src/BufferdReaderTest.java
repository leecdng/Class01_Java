import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferdReaderTest {

	public BufferdReaderTest() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("�Է� = ");
			String txt = br.readLine(); // enter������ ���ڿ��� ���ۿ� ���� �� �� �پ� String���� ��ȯ�Ͽ� ����
			System.out.print("txt = " + txt);
			
		} catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new BufferdReaderTest();

	}

}
