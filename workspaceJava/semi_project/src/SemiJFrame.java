

import javax.swing.JFrame;

import user.home.Firstpage;

public class SemiJFrame extends JFrame{

	public SemiJFrame() {
		
//		add(new UpdateCenter()); // ����� �߰�(���)
//		add(new UpdateCenter(1002)); // ����� ����
//		add(new ManageCenter()); // ����� ���� - ���۰�����
//		add(new ManageCenter("����")); // ����� ���� - ����
//		add(new RsvSelectDate(1313, "�Ἶ"));
//		add(new RsvCalendar());
//		add(new RsvSetting());
//		add(new ManageVacc());
//		add(new ManageVacc("����"));
//		add(new ManageRsv("����"));
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
