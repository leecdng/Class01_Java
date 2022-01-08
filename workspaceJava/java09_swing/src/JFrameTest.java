

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
// 								default:Layout
public class JFrameTest extends JFrame {
	ImageIcon icon = new ImageIcon("img/icon.png");
	ImageIcon icon2 = new ImageIcon("img/wbb.png");
	ImageIcon icon3 = new ImageIcon("img/wbb2.png");
	public JFrameTest() {
		// BorderLayout을 GridLayout으로 변경하기
		GridLayout layout = new GridLayout(3,2, 10, 10); // 행, 열, 간격들
		setLayout(layout); // setLayout(new GridLayout(3,2));
		
		JButton btn1 = new JButton("버튼1");
		add(btn1);
		
		JButton btn2 = new JButton(icon);
		add(btn2);
		// 마우스 눌렀을 때 icon바꾸기
		btn2.setPressedIcon(icon2);
		// 마우스 오버 시 icon 바꾸기
		btn2.setRolloverIcon(icon3);
		
		
		JButton btn3 = new JButton("꽃병", icon);
		add(btn3);
		// 버튼을 활성화 true / 비활성화 false
		btn3.setEnabled(false);
		JButton btn4 = new JButton("네 번째 버튼");
		add(btn4);
		
		// 라디오 버튼
		JPanel pane = new JPanel(new GridLayout(3,1)); // 테두리가 없는 컨테이너
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");
		
		// 라디오 버튼 그룹 만들기 - 버튼 하나 누르면 다른 버튼 취소됨
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1);
		bg.add(rBtn2);
		bg.add(rBtn3);
		
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3);
		
		add(pane);
		
		
		// 토글 버튼
		JToggleButton toggleBtn = new JToggleButton("토글", icon3);
		toggleBtn.setRolloverIcon(icon);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);
		
		// 라벨 만들기
		JLabel lbl = new JLabel("라벨 표시", JLabel.RIGHT);
		add(lbl);
		
		
		// 배경색 컬러 설정
		btn1.setBackground(Color.ORANGE);
		// btn4.setBackground(new Color(11,11,11)); // RGB 각각 0~255값
		Color clr = new Color(100,100,100);
		toggleBtn.setBackground(clr); // RGB 각각 0~255값
		
		// 글자색 컬러 설정
		btn1.setForeground(Color.white);
		
		// 라벨에 배경색 넣어보기
		// 투명처리부터 해제 해야 함
		lbl.setOpaque(true); // true: 투명처리 해제, false:투명처리
		lbl.setBackground(new Color(20,100,50));
		
		// Font: 글꼴(굴림체, 돋움체, Arial,,,), 글자유형(기울임, 진하게, 보통), 글자크기 설정(px)
		Font fnt = new Font("궁서체", Font.ITALIC+Font.BOLD, 40);
		lbl.setFont(fnt);
		
		
		setSize(1000,500);
		setVisible(true);
		// 프로그램이 종료되면 자원해제하거나, 프로그램을 종료할 수 없도록 설정 가능
		// DISPOSE_ON_CLOS: 프로그램 종료 시 자원을 해제하라.
		// DO_NOTHING_ON_CLOSE: 닫기가 수행되지 않는다.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // (2) 이런 식으로 숫자로 넣는 게 더 간단하지만 코드 분석이 어려워 잘 안 쓴다.
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 창 안에 메뉴 만들어서 그거 눌러야만 닫기 되게 할 수도 있음
		
		// 밀리초만큼 일시정지
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
//			btn1.setText("변경된 버튼 라벨");
//			lbl.setText("변경된 라벨");
		} // 밀리초
		
		// 버튼의 라벨, Label의 라벨을 변경하기 // 같은 메서드명이지만 다른 클래스의 메서드임 (상속관계도 아님)
		btn1.setText("변경된 버튼 라벨");
		lbl.setText("변경된 라벨");
		
	}

	public static void main(String[] args) {
		new JFrameTest();

	}

}
