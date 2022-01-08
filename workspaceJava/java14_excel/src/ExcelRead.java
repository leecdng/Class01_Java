import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead {

	public ExcelRead() {
		
	}
	
	public void start() {
		try {
			File file = new File("D://testFile", "member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			// byteCode인 InputStream 엑셀 파일로 변환하는 클래스
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			
			// 1. workbook 객체 얻어오기
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			// 시트의 수 구하기
			int sheetCnt = workbook.getNumberOfSheets();
			System.out.println("시트 수= " + sheetCnt);
			
			// 2. sheet 객체 얻어오기
			HSSFSheet sheet = workbook.getSheet("회원목록"); // workbook.getSheetAt(1);
			
			// 행의 수 구하기
			int rowCnt = sheet.getPhysicalNumberOfRows();
			System.out.println("행의 수= " + rowCnt);
			
			// 제목 출력
			System.out.println("번호\t이름\t연락처\t\t나이\t등록일");
			
			for(int rowIdx=1; rowIdx<rowCnt; rowIdx++){ // 1,2,3
				//3. 행객체 구하기
				HSSFRow row = sheet.getRow(rowIdx);
				
				// 셀 수 구하기
				int cellCnt = row.getPhysicalNumberOfCells();
//				System.out.println("셀의 수= " + cellCnt);
				
				// 셀 출력
				for(int cellIdx=0; cellIdx<cellCnt; cellIdx++) {  // 0,1,2,3,4
					
					HSSFCell cell = row.getCell(cellIdx);
					// 번호, 나이
					if(cellIdx==0 || cellIdx==3){
						int data = (int)cell.getNumericCellValue();
						System.out.print(data+"\t");
					} else if(cellIdx==1 || cellIdx==2) {
						String data = cell.getStringCellValue();
						System.out.print(data+"\t");
					} else if(cellIdx==4) { // 등록일일 때 // 날짜 형식일 때
						Date data = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
						String dateStr = format.format(data);
						System.out.println(dateStr);
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ExcelRead().start();
	}

}
