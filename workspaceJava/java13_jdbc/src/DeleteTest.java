import java.util.Scanner;

public class DeleteTest extends DBConnection{
	
	public DeleteTest() {
		try {
			// 콘솔에서 사원명을 입력받아 입력받은 사원 삭제
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 사원명= ");
			String name = scan.nextLine();
			
			// DB 연결
			dbConn();
			
			sql="delete from emp where ename=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			System.out.println(result+"개의 레코드가 삭제되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new DeleteTest();
	}
}
  