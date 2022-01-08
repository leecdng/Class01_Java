import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBCON {

	public MemberDAO() {
		
	}
	// ȸ�� ��ü ����
	public List<MemberVO> allRecord() {		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 1. db����
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, to_char(write_date, 'YYYY-MM-DD') write_date from member order by username asc";
			// 2. preparestatement
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // ResultSet�� ǥ �������� ����ִ� �����ϸ� ��.
			while(rs.next()) { // �Ű�µ� ���ڵ尡 �������� ������
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6)); // to_char�� �� �ص� String���� ��ƿ´�???
				list.add(vo);
			}
			
		} catch(Exception e) {
			System.out.println("��üȸ������ ���� �߻�");
			e.addSuppressed(e);
		} finally {
			dbClose(); // ���� �߻��ϵ� �� �ϵ� DB�� �ݾ��ش�.
		}
		
		return list;
	}
	
	// ȸ�� �߰�
	public int insertRecord(MemberVO vo) {
		
		int cnt = 0;
		try {
			dbConn();
			String sql ="insert into member(mem_no, username, tel, email, addr) values(mem_sq.nextval,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddr());
			
			cnt = pstmt.executeUpdate(); // �� ���� �����Ͱ� �߰��� �ƴ���?
			
		} catch(Exception e) {
			System.out.println("ȸ���߰����� �߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	
	}
	
	// ȸ�� ����
	public int updateRecord(MemberVO vo) {
        int cnt=0;
        try {
           
           dbConn();
           String sql= "update member set tel=?, email=?, addr=? where mem_no=?";//�������� ���ϱ� ������ȣ�� ����� ����.
           pstmt = conn.prepareStatement(sql);
           //������ ����ǥ ����
           pstmt.setString(1, vo.getTel());
           pstmt.setString(2, vo.getEmail());
           pstmt.setString(3, vo.getAddr());
           pstmt.setInt(4, vo.getMem_no());
           
           cnt = pstmt.executeUpdate(); //
           
        }catch(Exception e) {
           System.out.println("ȸ������ �����߻�....");
           e.printStackTrace();
        }finally {
           dbClose();
        }
        return cnt;
     }
	
	// ȸ�� ����
	public int deleteRecord(int mem_no) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from member where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("������� ���� �߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}

	// ȸ�� �˻�
	public List<MemberVO> searchRecord(String fieldName, String search) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, to_char(write_date, 'YYYY-MM-DD') write_date from member where "+fieldName+" like ? order by username asc";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, fieldName); // setString�� �˾Ƽ� '' ��������ǥ ����
			pstmt.setString(1, "%"+search+"%");
			
			rs = pstmt.executeQuery(); // select�� �� executeQuery�� ����
			while(rs.next()) { // �Ű�µ� ���ڵ尡 �������� ������
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6)); // to_char�� �� �ص� String���� ��ƿ´�???
				list.add(vo);
			}
			
		} catch(Exception e) {
			System.out.println("�˻� ���� �߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
}
