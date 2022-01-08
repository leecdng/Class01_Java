import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileInputStream fis = new FileInputStream(f); // 바이트 단위로만 읽어올 수 있음
			
			ObjectInputStream ois = new ObjectInputStream(fis); // 객체 단위로 읽어오게 함
			
			Memo memo = (Memo) ois.readObject();
			
			memo.setVisible(true);
			
			
			
		} catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}
