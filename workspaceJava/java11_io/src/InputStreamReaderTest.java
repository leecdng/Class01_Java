import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		// ����(char)���� �Է¹޴� ��ü
		InputStreamReader isr = new InputStreamReader(System.in);
		try {
			System.out.print("�Է� = ");
			while(true) {
//				int code = isr.read(); // �� ���� 1���ھ� �Է� �޴´�.
//				if(code==1) break;
//				System.out.println(code + "--> " + (char)code);
				
				// �迭�� �̿��Ͽ� �Է� �ޱ�
				char[] data = new char[5];
				int cnt = isr.read(data); // ��� ���� �����Ͱ� �� ��������
				if(cnt <= 0) break;
				// System.out.println("cnt: " + cnt + "-->" + new String(data));
				System.out.println("cnt: " + cnt + "-->" + String.valueOf(data) + "--> "+ data);
			}
		} catch(IOException e) {
			
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}
