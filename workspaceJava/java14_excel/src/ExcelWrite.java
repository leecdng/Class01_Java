import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
	POI �ٿ�ε�
	jakarta.apache.org���� ���� �޴����� POI�� �����Ѵ�.
	poi-bin-5.0.0-20110120.zip�� �ٿ�ε� �Ѵ�.
	
	������ Ǭ ��
	poi-5.0.0.jar, commons-math3-3.6.1,jar ������ build path �����Ѵ�.
  
*/
public class ExcelWrite {
//	Calendar now = Calendar.getInstance();
//	SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
	
	public ExcelWrite() {
		
	}
	
	// ������ �����ϱ�
	public void start() {
//		String dateStr = sdf.format(now.getTime());
		
		// 1. workbook ��ü�� ����
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// 2. sheet ��ü�� ����
		HSSFSheet sheet1 = workbook.createSheet(); // ��Ʈ�� ���� �������
		HSSFSheet sheet2 = workbook.createSheet("ȸ�����"); // ��Ʈ��: ȸ�����
		
		
		// 3. row ��ü�� ����
		HSSFRow row = sheet2.createRow(0); // �� ����
		
		// 4. cell ��ü�� �����ϰ� ���� ����
		row.createCell(0).setCellValue("��ȣ");
		row.createCell(1).setCellValue("�̸�");
		row.createCell(2).setCellValue("����ó");
		row.createCell(3).setCellValue("����");
		row.createCell(4).setCellValue("�����");
		
		// �� ���� - ���� �����Ͽ� �� ����
		HSSFRow row1 = sheet2.createRow(1);
		row1.createCell(0).setCellValue(100);
		row1.createCell(1).setCellValue("ȫ�浿");
		row1.createCell(2).setCellValue("010-1234-5678");
		row1.createCell(3).setCellValue(25);
		row1.createCell(4).setCellValue(Calendar.getInstance());
		
		HSSFRow row2 = sheet2.createRow(2);
		row2.createCell(0).setCellValue(200);
		row2.createCell(1).setCellValue("�̼���");
		row2.createCell(2).setCellValue("010-8888-8888");
		row2.createCell(3).setCellValue(30);
		row2.createCell(4).setCellValue(Calendar.getInstance());
		
		HSSFRow row3 = sheet2.createRow(3);
		row3.createCell(0).setCellValue(300);
		row3.createCell(1).setCellValue("�������");
		row3.createCell(2).setCellValue("010-1111-1111");
		row3.createCell(3).setCellValue(40);
		row3.createCell(4).setCellValue(Calendar.getInstance());
		
		// 5. ���Ϸ� ���� (����)
		File f = new File("D://testFile", "member.xls");
		
		try {
			FileOutputStream fos = new FileOutputStream(f);
			
			// workbook�� write(�Ű�����: FileŸ��) �޼��� ȣ���ϸ� ���Ϸ� ����ȴ�.
			workbook.write(f);
			
			fos.close();
			workbook.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("������ ���� �Ϸ�");
		
	}
	
	public static void main(String[] args) {
		new ExcelWrite().start();

	}

}
