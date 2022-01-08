import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame {
	JTabbedPane tp;
	
	JLabel lbl;
	ImageIcon ii = new ImageIcon("img/wbb.png");
	
	JButton btn;
	ImageIcon iii = new ImageIcon("img/wbb2.png");
	
	DigitalClock2 dc = new DigitalClock2(0, 0);
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	PackMan2 pm = new PackMan2();
	
	public JTabbedPaneTest() {
		super("탭메뉴");
		
		tp = new JTabbedPane(JTabbedPane.LEFT); // int값으로 1이랑 같음
		
		tp.addTab("계산기", cal);
		
		lbl = new JLabel(ii);
		tp.addTab("레이블", lbl);
		
		btn = new JButton(iii);
		tp.addTab("버튼", btn);
		
		tp.addTab("시계", dc);
		
		tp.addTab("달력", iii, calendar, "달력"); // 한 번 더 텍스트 쓰는 이유는 뭐지??????????????
		
		tp.insertTab("Button", null, new JButton("추가된 버튼"), "중간에 탭메뉴 추가", 3);
		
		// 탭의 활성화 및 비활성화
		// true: 활성화, false: 비활성화
		//			탭index, true/false
//		tp.setEnabledAt(2, false);
//		tp.setEnabled(false); // 모든 탭메뉴 비활성화, 0번째 탭 내용은 활성화됨
		
		
		//tp.insertTab("팩맨", null, pm, "팩맨", 4);
		//PackMan2 pm = new PackMan2();
//		Thread t = new Thread(this);
//		t.start();
		
//		PackMan2 pm = new PackMan2();
//		tp.insertTab("팩맨", null, pm, "팩맨", 5);
		
		//tp.insertTab("팩맨", null, pm, "팩맨", 4);
		//tp.addTab("팩맨", pm);
		
		tp.insertTab("팩맨", null, pm, "팩맨", 5);
		
		add(tp);
		setSize(500, 500); // 이 이후에 크기가 정해져있다.
			
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pm.setCanvasSize(); // 팩맨 캔버스 크기를 설정한다.
		Thread t = new Thread(pm);
		t.start();
		
		// 크기 설정
		
		
		// 탭의 삭제
//		try {Thread.sleep(1000);}catch(Exception e) {}; // 지연시키는 거 왜 set 메서드들 아래로 와야 하는지 다시 생각해 보기
//		tp.removeTabAt(3);
		//try {Thread.sleep(1000);}catch(Exception e) {};
		//tp.remove(3); // 위에 거랑 똑같은데 무슨 차이????????????????????
		
	}
	
	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
