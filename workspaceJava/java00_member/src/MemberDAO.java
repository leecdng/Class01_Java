import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBCON {

	public MemberDAO() {
		
	}
	// 회원 전체 선택
	public List<MemberVO> allRecord() {		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 1. db연결
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, to_char(write_date, 'YYYY-MM-DD') write_date from member order by username asc";
			// 2. preparestatement
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // ResultSet에 표 형식으로 담겨있다 생각하면 됨.
			while(rs.next()) { // 옮겼는데 레코드가 남아있을 때까지
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6)); // to_char를 안 해도 String으로 담아온댔나???
				list.add(vo);
			}
			
		} catch(Exception e) {
			System.out.println("전체회원선택 에러 발생");
			e.addSuppressed(e);
		} finally {
			dbClose(); // 예외 발생하든 안 하든 DB는 닫아준다.
		}
		
		return list;
	}
	
	// 회원 추가
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
			
			cnt = pstmt.executeUpdate(); // 몇 개의 데이터가 추가가 됐는지?
			
		} catch(Exception e) {
			System.out.println("회원추가에러 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	
	}
	
	// 회원 수정
	public int updateRecord(MemberVO vo) {
        int cnt=0;
        try {
           
           dbConn();
           String sql= "update member set tel=?, email=?, addr=? where mem_no=?";//시퀀스가 들어가니깐 같은번호로 만들수 없다.
           pstmt = conn.prepareStatement(sql);
           //다음에 물음표 세팅
           pstmt.setString(1, vo.getTel());
           pstmt.setString(2, vo.getEmail());
           pstmt.setString(3, vo.getAddr());
           pstmt.setInt(4, vo.getMem_no());
           
           cnt = pstmt.executeUpdate(); //
           
        }catch(Exception e) {
           System.out.println("회원수정 에러발생....");
           e.printStackTrace();
        }finally {
           dbClose();
        }
        return cnt;
     }
	
	// 회원 삭제
	public int deleteRecord(int mem_no) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from member where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_no);
			
			cnt = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("사원삭제 에러 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}

	// 회원 검색
	public List<MemberVO> searchRecord(String fieldName, String search) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			dbConn();
			String sql = "select mem_no, username, tel, email, addr, to_char(write_date, 'YYYY-MM-DD') write_date from member where "+fieldName+" like ? order by username asc";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, fieldName); // setString이 알아서 '' 작은따옴표 쳐줌
			pstmt.setString(1, "%"+search+"%");
			
			rs = pstmt.executeQuery(); // select일 땐 executeQuery를 쓴다
			while(rs.next()) { // 옮겼는데 레코드가 남아있을 때까지
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6)); // to_char를 안 해도 String으로 담아온댔나???
				list.add(vo);
			}
			
		} catch(Exception e) {
			System.out.println("검색 에러 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
}
