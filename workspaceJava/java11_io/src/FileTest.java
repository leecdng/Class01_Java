import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		// File : 파일 경로와 파일명으로 객체를 생성하여 객체의 정보를 얻을 수 있다.
		File f1 = new File("D://testFile"); // 반드시 절대주소로..
		File f2 = new File("D://");
		File f3 = new File("D://testFile/MultiplicationTable.java");
		File f4 = new File("D://testFile", "MultiplicationTable.java");
		File f5 = new File(f1, "MultiplicationTable.java");
		
		File f6 = new File("D://testFile/createJava");
		// 폴더 생성하기
		// 폴더 존재유무 확인. 있으면 true, 없으면 false 반환
		try {
			if(!f6.exists()) {
				if(f6.mkdirs()) { // 폴더 생성됨 true 실패하면 false 반환
					System.out.println("폴더가 생성되었습니다.");
				} else {
					System.out.println("폴더 생성 실패");
				}
			} else {
				System.out.println("폴더가 이미 존재합니다.");
			}
			
			// 파일 생성하기
			File f7 = new File(f6, "abcd.txt");
	
			if(!f7.exists()) {
				if(f7.createNewFile()) {
					System.out.println("파일이 생성되었습니다.");
				} else {
					System.out.println("파일 생성 실패");
				}
			} else {
				System.out.println("파일이 이미 존재합니다.");
			}
			
			// 마지막 수정일 알아내기
			long lastDate = f3.lastModified(); // 밀리초로 반환
			System.out.println("lastDate :" + lastDate);
			
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(lastDate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String modifiedDate = sdf.format(now.getTime());
			
			System.out.println("마지막 수정일 = " + modifiedDate);
			
			
			// 실행형 파일유무확인
			// 읽기 가능
			// 쓰기 가능
			
			boolean exe = f5.canExecute(); // 실행형 파일 유무확인
			boolean read = f5.canRead(); // 읽기 가능한지
			boolean write = f5.canWrite(); // 쓰기 가능한지
			
			System.out.println(exe + ":" + read + ":" + write);
			
			// 특정 드라이브 혹은 폴더에 있는 파일 및 폴더 정보 얻어오기
			// C://, D:// ...
			File f8 = new File("C://");
			File[] fileList = f8.listFiles();
			
			/*
				 getPath() : 경로명 + 폴더/파일명
				 getName() : 폴더/파일명
				 getAbsolutePath() : 경로명 + 폴더/파일명
				 getParent() : 경로명
				 
				 
			 */
			
			for(File f : fileList) {
				if(f.isDirectory()) { // 만약에 폴더라면
					if(f.isHidden()) {
						System.out.println(f.getPath() + " [숨김 폴더]");
					} else {
						System.out.println(f.getPath() + " [폴더]");
					}
				} else if(f.isFile()) {
					if(f.isHidden()) {
						System.out.println(f.getPath() + " [숨김 파일]");
					} else {
						System.out.println(f.getPath() + " [파일]");
					}
				}
			}
			
			// 현재 시스템의 드라이브를 구한다.
			File[] root = File.listRoots();
			for(File ff : root) {
				System.out.println(ff.getPath());
			}
			
			// 파일크기 : byte
			long size = f3.length();
			System.out.println("size = " + size);
			
			// 파일삭제
			boolean result = f3.delete();
			if(result) {
				System.out.println("파일이 삭제되었습니다.");
			} else {
				System.out.println("파일 삭제 실패");
			}
			
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new FileTest();

	}

}
