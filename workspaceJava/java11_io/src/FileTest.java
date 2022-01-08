import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		// File : ���� ��ο� ���ϸ����� ��ü�� �����Ͽ� ��ü�� ������ ���� �� �ִ�.
		File f1 = new File("D://testFile"); // �ݵ�� �����ּҷ�..
		File f2 = new File("D://");
		File f3 = new File("D://testFile/MultiplicationTable.java");
		File f4 = new File("D://testFile", "MultiplicationTable.java");
		File f5 = new File(f1, "MultiplicationTable.java");
		
		File f6 = new File("D://testFile/createJava");
		// ���� �����ϱ�
		// ���� �������� Ȯ��. ������ true, ������ false ��ȯ
		try {
			if(!f6.exists()) {
				if(f6.mkdirs()) { // ���� ������ true �����ϸ� false ��ȯ
					System.out.println("������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ���� ����");
				}
			} else {
				System.out.println("������ �̹� �����մϴ�.");
			}
			
			// ���� �����ϱ�
			File f7 = new File(f6, "abcd.txt");
	
			if(!f7.exists()) {
				if(f7.createNewFile()) {
					System.out.println("������ �����Ǿ����ϴ�.");
				} else {
					System.out.println("���� ���� ����");
				}
			} else {
				System.out.println("������ �̹� �����մϴ�.");
			}
			
			// ������ ������ �˾Ƴ���
			long lastDate = f3.lastModified(); // �и��ʷ� ��ȯ
			System.out.println("lastDate :" + lastDate);
			
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(lastDate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
			String modifiedDate = sdf.format(now.getTime());
			
			System.out.println("������ ������ = " + modifiedDate);
			
			
			// ������ ��������Ȯ��
			// �б� ����
			// ���� ����
			
			boolean exe = f5.canExecute(); // ������ ���� ����Ȯ��
			boolean read = f5.canRead(); // �б� ��������
			boolean write = f5.canWrite(); // ���� ��������
			
			System.out.println(exe + ":" + read + ":" + write);
			
			// Ư�� ����̺� Ȥ�� ������ �ִ� ���� �� ���� ���� ������
			// C://, D:// ...
			File f8 = new File("C://");
			File[] fileList = f8.listFiles();
			
			/*
				 getPath() : ��θ� + ����/���ϸ�
				 getName() : ����/���ϸ�
				 getAbsolutePath() : ��θ� + ����/���ϸ�
				 getParent() : ��θ�
				 
				 
			 */
			
			for(File f : fileList) {
				if(f.isDirectory()) { // ���࿡ �������
					if(f.isHidden()) {
						System.out.println(f.getPath() + " [���� ����]");
					} else {
						System.out.println(f.getPath() + " [����]");
					}
				} else if(f.isFile()) {
					if(f.isHidden()) {
						System.out.println(f.getPath() + " [���� ����]");
					} else {
						System.out.println(f.getPath() + " [����]");
					}
				}
			}
			
			// ���� �ý����� ����̺긦 ���Ѵ�.
			File[] root = File.listRoots();
			for(File ff : root) {
				System.out.println(ff.getPath());
			}
			
			// ����ũ�� : byte
			long size = f3.length();
			System.out.println("size = " + size);
			
			// ���ϻ���
			boolean result = f3.delete();
			if(result) {
				System.out.println("������ �����Ǿ����ϴ�.");
			} else {
				System.out.println("���� ���� ����");
			}
			
		} catch (IOException i) {
			i.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new FileTest();

	}

}
