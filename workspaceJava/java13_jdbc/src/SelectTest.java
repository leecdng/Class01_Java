import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
		// 1. JVM에 jdbc드라이브 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 이 메서드가 객체로 만들어서 자바가상머신에 알려줌
		} catch(ClassNotFoundException cnfe) {
			System.out.println("jdbc 드라이브 로딩 실패--> " + cnfe.getMessage());
		}
		

		try {
			// 2. DB연결						@서버ip 또는 localhost : port넘버 : 전역데이터베이스변수(SID)
			String dbUrl = "jdbc:oracle:thin:@192.168.0.2:1521:xe";
			//												DBserver, 계정, 비번
			Connection conn = DriverManager.getConnection(dbUrl, "c##scott","tiger");
			// 3. 쿼리문을 만든다. "문자열"로 만들기
			String sql = "select empno, ename, job, to_char(hiredate, 'YYYY-MM-DD') hiredate, sal, comm, deptno"
					+ " from emp where sal>=? or job=? order by ename";
			
			// 4. 쿼리문을 이용하여 PreparedStatement 객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ?를 세팅
			pstmt.setInt(1, 3000);
			pstmt.setString(2, "세일맨"); // 검색하면 이 부분이 달라져야 할 듯! ////////////////////////
			
			// 5. 실행하기
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){ // 우선 제일 첫 번째로 포인트가 이동하게 됨.
				int i=1;
				// 한 줄의 레코드를 출력한다.
				int empno = rs.getInt(1); // rs.getInt("empno");
				String ename = rs.getString(2); // rs.getString("ename");
				String job = rs.getString("job"); // re.getString(3);
				String hiredate = rs.getString(4);
				int sal = rs.getInt(5); // double sal = rs.getDouble(5);
				double comm = rs.getDouble(6);
				int deptno = rs.getInt(7);
				
				
				System.out.println(empno + ", " + ename + ", " + job + ", " + hiredate + ", " +sal+ ", "+comm+ ", "+deptno);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException se) {
			System.out.println("DB연결 에러 발생--->"+se.getMessage());
		}
		
	}

	public static void main(String[] args) {
		new SelectTest();
	}

}
