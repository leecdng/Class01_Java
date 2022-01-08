import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {

	public DataInputOutputTest() {
		try {
			// �⺻ ���������� ���� ���Ϸ� �����ϱ�
			File file = new File("D://testFile","data.txt");
			FileOutputStream fos = new FileOutputStream(file); // �⺻�� 1byte�� ���� �д´�??
			DataOutputStream dos = new DataOutputStream(fos);
			
			int num = 1234;
			double data2 = 5628.34;
			boolean boo = true;
			char lastName = 'ȫ';
			
			dos.writeInt(num); // 4byte
			dos.writeDouble(data2); // 8byte
			dos.writeBoolean(boo); // 1byte
			dos.writeChar(lastName); //2byte
			
			dos.close();
			fos.close();
			
		} catch (FileNotFoundException fnfe) {
			System.out.println("������ �����ϴ�.");
		} catch (IOException ioe) {
			System.out.println("���� ���� ����");
		}
		
	}

	public static void main(String[] args) {
		new DataInputOutputTest();

	}

}
