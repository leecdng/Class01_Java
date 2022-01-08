import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bookdata.BookDataSet;
import bookdata.BookVO;
import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class Login {

	public Login() {
		//MemberDataSet.memberData();
	}
	
	public String loginProcess() {
		String id, pw;
		MemberVO mvo = new MemberVO();
		do {
			id = inputData("아이디: ");
			pw = inputData("비밀번호: ");
			if(MemberDataSet.memberList.containsKey(id)) {
				mvo = MemberDataSet.memberList.get(id);
				if(pw.equals(mvo.getPw())) {
					break;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					loginFalse();
				}
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
				loginFalse();
			}
				
		} while(true);
		
		return id;
	}
	
	// 계정 틀렸을 때 다시 실행
	public void loginFalse() {
		do {
			String select = inputData("[1.다시 로그인하기] [2.아이디찾기] [3.비밀번호 찾기] [4.처음으로] : ");
			if(select.equals("1")) {
				break;
			} else if(select.equals("2")) {
				findId();
			} else if(select.equals("3")) {
				findPw();
			} else if(select.equals("4")) {
				BookSystem bs = new BookSystem();
				bs.bookStart();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		} while(true);
	}
	
	
	// 아이디 찾기
	public void findId() {
		String name, birthday, gender, tel;
		name = inputData("이름: ");
		birthday = inputData("생년월일: ");
		gender = inputData("성별 [1.여자] [2.남자]: ");
		if(gender.equals("1")) {
			gender = "여자";
		} else if(gender.equals("2")) {
			gender = "남자";
		}
		tel = inputData("휴대폰번호: ");

		boolean chk = false;
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO mvo = e.getValue();
			mvo.setId(e.getKey());
			if(mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
				System.out.println("인증되었습니다. " + name+ "님의 아이디는 "+ mvo.getId() + "입니다.");
				chk = true;
				break;
			}
		} // while
		if(!chk) System.out.println("가입된 회원 정보가 없습니다.");
	}
	
	// 비밀번호 찾기
	public void findPw() {
		String id, name, birthday, gender, tel;
		id = inputData("아이디: ");
		name = inputData("이름: ");
		birthday = inputData("생년월일: ");
		gender = inputData("성별 [1.여자] [2.남자]: ");
		if(gender.equals("1")) {
			gender = "여자";
		} else if(gender.equals("2")) {
			gender = "남자";
		}
		tel = inputData("휴대폰번호: ");

		boolean chk = false;
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO mvo = e.getValue();
			mvo.setId(e.getKey());
			if(mvo.getId().equals(id) && mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
				System.out.println("인증되었습니다. 새 비밀번호를 설정해주세요.");
				Join join = new Join();
				String pw = join.inputMemberPw();
				mvo.setPw(pw);
				chk = true;
				break;
			}
		} // while
		if(!chk) System.out.println("가입된 회원 정보가 없습니다.");
	}
	
	
	
	// 데이터 입력 받기
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // 데이터 입력 받기 ----->
}
