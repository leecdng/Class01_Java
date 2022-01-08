import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class Join {

	public Join() {

	}
	
	public String joinProcess() {		
		//MemberDataSet.memberData();
		
		String grade, name, birthday, gender, tel, id, pw, email;
		do {
			grade = inputMemberGrade();
			name = inputMemberName();
			birthday = inputMemberBirthday();
			gender = inputMemberGender();
			tel = inputMemberTel();
	
			boolean chk = true;
			Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
			Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
			
			while(it.hasNext()) {
				Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
				MemberVO mvo = e.getValue();
				mvo.setId(e.getKey());
				if(mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
					System.out.println("이미 가입된 회원 정보입니다.");
					chk = false;
					break;
				}
			} // while
			if(chk) {
				System.out.println("인증이 완료되었습니다.");
				break;
			}
		} while(true);
		
		// 아이디, 비번, 이메일
		id = inputMemberId();
		pw = inputMemberPw();
		//email = inputMemberEmail();
		
		System.out.println("회원가입이 완료되었습니다. 해당 계정으로 로그인됩니다.");
		
		MemberVO mvo = new MemberVO(pw, name, birthday, gender, tel, grade);
		MemberDataSet.addMember(id, mvo);
		
		return id;
	}
	
	
	// 회원가입 유형
	public String inputMemberGrade() {
		String grade = inputData("회원가입 유형을 선택하세요. [1.일반회원] [2.관리자] :");
		do {
			if(grade.equals("1")) {
				grade="일반회원";
				break;
			} else if(grade.equals("2")) {
				grade="관리자";
				break;
			} else{
				System.out.println("1과 2중에 선택하세요.");
			}
		} while(true);
		
		return grade;
	}
	
	// 이름
	public String inputMemberName() {
		String name;
		do {
			name = inputData("이름: ");
			if(name.length()<2 || name.length()>24) {
				System.out.println("잘못된 이름입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		} while(true);
		
		return name;
	}
	
	// 생년월일
	public String inputMemberBirthday() {
		String birthday;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		int nowDate = Integer.parseInt(fm.format(cal.getTime()));
		do {
			try {
				birthday = inputData("생년월일(ex:19910101): ");
				int[] birthdayArr = new int[3];
				birthdayArr[0] = Integer.parseInt(birthday.substring(0, 4));
				birthdayArr[1] = Integer.parseInt(birthday.substring(4, 6));
				birthdayArr[2] = Integer.parseInt(birthday.substring(6));

				cal.set(birthdayArr[0], birthdayArr[1]-1, birthdayArr[2]);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				// System.out.println(year + ","+month + ","+day+","+nowDate);
				
				if(birthday.length()!=8) {
					System.out.println("8자리 숫자로만 입력해주세요.");
				}else{
					if(birthdayArr[0]<1900 || birthdayArr[0]>2021 || birthdayArr[0] != year || birthdayArr[1] != month || birthdayArr[2] != day) {
						System.out.println("생년월일을 바르게 입력해주세요.");
					} else if(nowDate < Integer.parseInt(birthday)){ // 현재날짜보다 더 크면
						System.out.println("현재날짜 이후의 날짜는 입력할 수 없습니다.");
					} else {
						break;
					}
				}
			}catch(NumberFormatException nfe) {
				System.out.println("8자리 숫자로만 입력해주세요.");
			}catch(StringIndexOutOfBoundsException sie) {
				System.out.println("8자리 숫자로만 입력해주세요.");
			}
		} while(true);
		
		return birthday;
	}
	
	// 성별
	public String inputMemberGender() {
		String gender;
		do {
			gender = inputData("성별 [1.여자][2.남자]: ");
			if(gender.equals("1")) {
				gender = "여자";
				break;
			} else if(gender.equals("2")) {
				gender = "남자"; 
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. [1.여자][2.남자] 중에서 번호로 선택해주세요.");
			}
		} while(true);
		
		return gender;
	}
	
	// 휴대폰번호
	public String inputMemberTel() {
		String tel;
		do {
			try {
				tel = inputData("휴대폰번호 (숫자만 입력 - 예)01012341234): ");
				Integer.parseInt(tel); // 숫자만 입력되었는지 확인
				String[] telArr = new String[2];
				if(tel.length()==11 || tel.length()==10) {
					telArr[0] = tel.substring(0, 3); //010
					telArr[1] = tel.substring(3);
				}
				else{
					System.out.println("잘못된 형식입니다. 휴대폰번호를 입력해주세요.");
				}
				
				if(!telArr[0].equals("010") && !telArr[0].equals("011") && !telArr[0].equals("016") && !telArr[0].equals("017") && !telArr[0].equals("019") || telArr[1].substring(0,1).equals("0")) {
					System.out.println("잘못된 형식입니다. 휴대폰번호를 입력해주세요.");
				} else {
					break;
				}
			} catch(NumberFormatException nfe) {
				System.out.println("숫자로만 입력해주세요.");
			} catch(NullPointerException npe) {
				
			}
		} while(true);
		
		return tel;
	}
	
	// 아이디
	public String inputMemberId() {
		String id;
		do {
			id = inputData("아이디(영문/숫자 5~10자리): ").toLowerCase(); // 이미 있는 건지 확인, 소문자로 변경
			if(MemberDataSet.memberList.containsKey(id)) {
				System.out.println("이미 사용 중인 아이디입니다. 다시 입력해주세요.");
			} else if(id.length()<5 || id.length()>10){
				System.out.println("아이디는 영문/숫자 5~10자리여야 합니다.");
			} else {
				boolean repeat = true;
				for(int i=0; i<id.length(); i++) {
					id.charAt(i);
					if(!(id.charAt(0)>=97 && id.charAt(0)<=122)) {
						repeat = false;
					} else if(!(id.charAt(i) >= 97 && id.charAt(i)<=122 || id.charAt(i)>=48 && id.charAt(i)<=57)) {
						repeat = false;
					}
				} //for
				if(repeat) break;
				else System.out.println("아이디는 영문/숫자로만 사용 가능하며, 첫 문자는 영문만 가능합니다.");
			} //if
		} while(true);
		
		return id;
	}
	
	// 비밀번호
	public String inputMemberPw() {
		String pw, pw2;
		do {
			pw = inputData("비밀번호 (영문/숫자/특수문자만 사용 6~15자리(대소문자 구분)): ");
			if(pw.length()<6 || pw.length()>15){
				System.out.println("비밀번호는 영문/숫자/특수문자 6~15자리여야 합니다.");
			} else if(pw.indexOf(" ")!=-1){
				System.out.println("비밀번호는 공백을 포함할 수 없습니다.");
			} else {
				char[] ascii = {33,35,36,37,38,40,41,42,43,45,64,94,95,126};
				boolean repeat = true;
				for(int i=0; i<pw.length(); i++) { // 문자 하나씩 비교
					char c = pw.charAt(i);
					boolean repeat2 = false;
					for(int j=0; j < ascii.length; j++) { // 아스키코드 하나씩 비교
						if(c==ascii[j] || (c >=65 && c<=90 || c >= 97 && c<=122 || c>=48 && c<=57)) repeat2 = true; // 한 번이라도 조건에 해당하는 문자면 true를 반환
					}
					if(!repeat2) repeat = false; // 한 번이라도, 위 조건에 해당이 안 된다면 = 쓸 수 없는 문자면 false를 반환
				} //for
				
				if(repeat) {
					pw2 = inputData("비밀번호 확인: "); // pw와 똑같은지 확인
					if(pw2.equals(pw)) break;
					else System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
				} else {
					System.out.println("비밀번호는 영문/숫자/특수문자(~!@#$%^&*()-_+) 만 가능합니다.");
				} //if
			} //if
		} while(true);
		
		return pw;
	}
	
//	// 이메일
//	public String inputMemberEmail() {
//		String email = inputData("이메일: ");
////		if() {
////			
////		}
//		
//		return email; // 유효한 형식인지..ㅋ 확인
//	}
	
	
	
	
	// 데이터 입력 받기
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // 데이터 입력 받기 ----->

}
