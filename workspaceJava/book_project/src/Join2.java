import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import memberdata.MemberDataSet2;
import memberdata.MemberVO;

public class Join2 {

	public Join2() {
		joinProcess();
	}
	
	public void joinProcess() {
		String grade = inputData("회원가입 유형을 선택하세요. [1.일반회원] [2.관리자] :");
		
		String name = inputData("이름: ");
		String birthdayTxt = inputData("생년월일(ex:19910101): ");
		String[] birthday = new String[3];
		birthday[0] = birthdayTxt.substring(0, 4);
		birthday[1] = birthdayTxt.substring(4, 6);
		birthday[2] = birthdayTxt.substring(6);
		String gender = inputData("성별: ");
		String telTxt = inputData("휴대폰번호: ");
		String[] tel = new String[3];
		tel[0] = telTxt.substring(0, 3);
		tel[1] = telTxt.substring(3, 7);
		tel[2] = telTxt.substring(7);
		System.out.println("인증이 완료되었습니다.");
		
		String id = inputData("아이디: ");
		String pw = inputData("비밀번호: ");
		String pw2 = inputData("비밀번호 확인: ");
		String email = inputData("이메일: ");
		
		
		MemberDataSet2.MemberData();
		MemberVO mvo = new MemberVO(pw, name, birthday, gender, tel, email, grade);
		MemberDataSet2.addMember(grade, id, mvo);
		
		// 출력해보기
		Set<Map.Entry<String, HashMap>> allList = MemberDataSet2.allMember.entrySet();
		Iterator<Map.Entry<String, HashMap>> it = allList.iterator();
		while(it.hasNext()) {
			Map.Entry<String, HashMap> e = (Map.Entry<String, HashMap>)it.next();
			Set<Map.Entry<String, MemberVO>> memList = ((HashMap)e.getValue()).entrySet();
			
			Iterator<Map.Entry<String, MemberVO>> it2 = memList.iterator();
			System.out.println(e.getKey());
			while(it.hasNext()) {
				Map.Entry<String, MemberVO> e2 = (Map.Entry<String, MemberVO>)it2.next();
				MemberVO mvo2 = e2.getValue();
//				mvo2.setGrade(e.getKey());
//				mvo2.setId(e2.getKey());
				System.out.println(e.getKey()+", "+ e2.getKey()+", "+ mvo2.getPw());
			}
			System.out.println();
		}
	}
	
	
	// 데이터 입력 받기
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // 데이터 입력 받기 ----->

}
