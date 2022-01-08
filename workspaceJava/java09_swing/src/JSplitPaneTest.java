import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest extends JFrame {
	JSplitPane sp1, sp2;
	
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	public JSplitPaneTest() {
		// 수직 나누기
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cal, calendar);
		
		// 수평 나누기
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp);
		
		//sp1.add(sp2); // 이렇게는 넣는 거 아닌가 봄..ㅎㅎ 아닌가 되나
		add(sp1);
		
		// 경계선의 위치를 설정할 수 있다.
		sp2.setDividerLocation(350); // 위쪽이 350px
		sp1.setDividerLocation(800); // 왼쪽이 800px
		
		// 경계선의 두께 설정
		sp2.setDividerSize(0); // 사이즈 0이면 마우스가 맞춰지지 않고 사이즈 조정 못 함 // 고정
		sp1.setDividerSize(20);
		
		// 원터치
		sp1.setOneTouchExpandable(true); // 메뉴 닫았다 열었다 할 수 있을 듯
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitPaneTest();

	}

}
