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
		String grade = inputData("ȸ������ ������ �����ϼ���. [1.�Ϲ�ȸ��] [2.������] :");
		
		String name = inputData("�̸�: ");
		String birthdayTxt = inputData("�������(ex:19910101): ");
		String[] birthday = new String[3];
		birthday[0] = birthdayTxt.substring(0, 4);
		birthday[1] = birthdayTxt.substring(4, 6);
		birthday[2] = birthdayTxt.substring(6);
		String gender = inputData("����: ");
		String telTxt = inputData("�޴�����ȣ: ");
		String[] tel = new String[3];
		tel[0] = telTxt.substring(0, 3);
		tel[1] = telTxt.substring(3, 7);
		tel[2] = telTxt.substring(7);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
		String id = inputData("���̵�: ");
		String pw = inputData("��й�ȣ: ");
		String pw2 = inputData("��й�ȣ Ȯ��: ");
		String email = inputData("�̸���: ");
		
		
		MemberDataSet2.MemberData();
		MemberVO mvo = new MemberVO(pw, name, birthday, gender, tel, email, grade);
		MemberDataSet2.addMember(grade, id, mvo);
		
		// ����غ���
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
	
	
	// ������ �Է� �ޱ�
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // ������ �Է� �ޱ� ----->

}
