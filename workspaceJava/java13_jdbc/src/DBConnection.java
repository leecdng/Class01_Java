import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@192.168.0.2:1521:xe";
	String username = "c##scott";
	String password = "tiger";
	String sql;
	
	public DBConnection() {
		
	}
	// db ¿¬°á
	public void dbConn() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	// db ´Ý±â
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
