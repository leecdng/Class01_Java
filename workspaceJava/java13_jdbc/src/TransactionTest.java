import java.sql.SQLException;

public class TransactionTest extends DBConnection {

	public TransactionTest() {
		
		// a_bank : 5000출금, b_bank : 5000원 입금

		try {
			dbConn(); // DB연결
			
			//트랜젝션 커밋 해제 : 자동으로 커밋되는 것 해제하기
			conn.setAutoCommit(false); // true: 자동커밋, false: 자동커밋해제
			
			int abank = -5000, bbank=5000;
			
			// 출금
			sql = "insert into c_bank(num, money) values(c_number.nextVal, ?)"; // 사용 안 한 가장 작은 번호 구함(?) nextVal
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, abank);
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank) + "원이 출금되었습니다.");
			} else {
				System.out.println(Math.abs(abank) + "원 출금이 실패하였습니다.");
			}
			
			//if(cnt<0) throw new Exception();
			
			// 입금
			sql = "insert into d_bank(num, money) values(d_number.nextVal, ?)"; // 사용한 적이 없는 다음값 nextVal
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(bbank+"원이 입금되었습니다.");
			} else {
				System.out.println(bbank+"원이 입금 실패하였습니다.");
			}
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception ee) {
				
			}			
		} finally {
			dbClose();
		}

	}

	public static void main(String[] args) {
		new TransactionTest();

	}

}
