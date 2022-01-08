import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JTableEmp extends JFrame {
	
	JTable table;
	JScrollPane sp;
	String[] title= {"사원명", "급여", "보너스", "입사일"};
	Object[][] obj;
	DefaultTableModel model = new DefaultTableModel(obj, title);
	
	public JTableEmp() {
		
		// 데이터베이스 연동
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연동 실패 : " + e.getMessage());
		}
		
		String dbUrl = "jdbc:oracle:thin:@192.168.0.2:1521:xe";
		try {
			Connection conn = DriverManager.getConnection(dbUrl, "c##scott", "tiger");
			
			String sql = "Select ename, sal, comm, to_char(hiredate, 'YYYY/MM/DD') from emp";
			PreparedStatement psmt = conn.prepareStatement(sql);

			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				String hiredate = rs.getString(4);
				
				Object[] data = {ename, sal, comm, hiredate};
				model.addRow(data);
			}
		
			rs.close();
			psmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		table = new JTable(model);
		sp = new JScrollPane(table);
		add(sp);
		
		setTitle("사원 정보");
		setSize(350, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	

	public static void main(String[] args) {
		new JTableEmp();
	}

}
