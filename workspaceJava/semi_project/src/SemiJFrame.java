

import javax.swing.JFrame;

import user.home.Firstpage;

public class SemiJFrame extends JFrame{

	public SemiJFrame() {
		
//		add(new UpdateCenter()); // 진료소 추가(등록)
//		add(new UpdateCenter(1002)); // 진료소 수정
//		add(new ManageCenter()); // 진료소 관리 - 슈퍼관리자
//		add(new ManageCenter("강원")); // 진료소 관리 - 직원
//		add(new RsvSelectDate(1313, "얀센"));
//		add(new RsvCalendar());
//		add(new RsvSetting());
//		add(new ManageVacc());
//		add(new ManageVacc("서울"));
//		add(new ManageRsv("서울"));
//		add(new ManageTest());
		add(new Firstpage(2));
		
		setSize(1000, 660);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SemiJFrame();
	}

}
