

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventActionTest2 extends JFrame {
	JButton okBtn = new JButton("OK");
	JLabel lbl = new JLabel("jjjj", JLabel.CENTER); // 라벨도 이벤트가 있다. 글자만 보이는 거긴 함.

	public EventActionTest2() {
		add(BorderLayout.NORTH, okBtn);
		add(lbl); // 위치 안 잡으면 센터로 들어감
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 이벤트 등록
		okBtn.addActionListener(new EventProcess(lbl));
	}

	public static void main(String[] args) {
		new EventActionTest2();

	}

}
