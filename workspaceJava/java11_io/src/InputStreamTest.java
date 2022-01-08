

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		try {
			// InputStream : byte 단위 문자를 입력 받는다.
			InputStream is = System.in;
			System.out.print("입력=");
			while(true) {
				
//				// read한 값이 없을 경우 -1이 리턴된다.
//				int code = is.read(); // 1byte 읽어온다.
//				System.out.println(code);
//				if(code == -1) break;
//				System.out.println((char)code);
//			}
//			//System.out.println((char)code);
				
				
//				byte data[] = new byte[5];
//				// cnt: read 데이터수, data 배열에 읽은 값이 있다.
//				int cnt = is.read(data);
//				System.out.println(cnt+"-->"+ new String(data));
				
				
				
				byte data[] = new byte[5];
				// cnt: read 데이터수, data 배열에 읽은 값이 있다.
				int cnt = is.read(data, 2, 3);
				System.out.println(cnt+"-->"+ new String(data));
				
			}
			
		} catch(IOException e) {}
	}

	public static void main(String[] args) {
		new InputStreamTest();

	}

}
