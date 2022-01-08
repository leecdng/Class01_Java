

import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingComponent {
	JFrame frm = new JFrame("컴포넌트 연습 중");
	Rectangle frmSize = new Rectangle(200,200,500,500);
	public SwingComponent() {
		frm.setTitle("Component");
		// JFrame -> FlowLayout으로 변경
		frm.setLayout(new FlowLayout());
		// JTextField : 한 줄의 문자열을 입력할 수 있는 컴포넌트
		JTextField tf = new JTextField(10);
		frm.add(tf);
		
		JTextField tf2 = new JTextField("ABCDEFG", 20);
		// 값을 변경하기
		tf2.setText("텍스트필드의 값이 변경되었습니다.");
		try {
			String str1 = tf2.getText();
			String str2 = tf2.getText(2, 3); // index, count
			System.out.println("str1-->"+str1);
			System.out.println("str2-->"+str2);
		} catch(Exception e) {
			
		}
		frm.add(tf2);
		
		// 여러 줄의 문자열을 입력하는 컴포넌트
		JTextArea ta = new JTextArea(5, 30); // 행, 열 크기
		JScrollPane sp = new JScrollPane(ta); // 스크롤 기능이 있는 컨테이너
		frm.add(sp);
		
		// JPasswordField : 문자를 마크업 해준다.
		JPasswordField pf = new JPasswordField();
		frm.add(pf);
		
		// JCheckBox : 여러 개를 선택할 수 있는 컴포넌트
		JCheckBox cb1 = new JCheckBox("사과");
		JCheckBox cb2 = new JCheckBox("배",true); // 체크된 상태로 나옴
		frm.add(cb1);
		frm.add(cb2);
		
		// JSlider
		JSlider s1 = new JSlider(JSlider.HORIZONTAL, 1, 10, 5); // 최소, 최대, 처음값
		frm.add(s1);
		
		//
		
		
					// x,y,w,h
		frm.setBounds(frmSize);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new SwingComponent();

	}

}
