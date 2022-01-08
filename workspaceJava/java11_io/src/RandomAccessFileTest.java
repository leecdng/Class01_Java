import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		// 원하는 위치의 데이터를 읽고 쓰기가 가능하다.
		File f = new File("D://testFile/access.txt");
		try {
			// 쓰기 전용 : w  // 읽기 전용 : r // 읽기쓰기 : rw
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java input output test programing";
			raf.writeBytes(str); //
			raf.writeInt(12345); // 왜 09로 뜨는지???????? 4바이트로 들어가 있다니?
			
			// seek : 내가 쓰고 싶은 위치로 옮기겠다. 쓰기 시작할 포인트를 옮기겠다.
			raf.seek(10);
			raf.writeBytes("hong");
			
			// 포인트를 마지막으로 옮기려면
			raf.seek(raf.length());
			byte[] data = {65, 66, 67, 68};
			raf.write(data);
			
			raf.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();

	}

}
