import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneEx1 extends JFrame{
	JSplitPane spHori, spClockCalendar, spCalcu, spPack;
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	SwingCalendar2 swingCal = new SwingCalendar2();
	CalculatorEx2 cal = new CalculatorEx2();
	
	ImageIcon ii = new ImageIcon("img/wbb2.png");
	JLabel lbl = new JLabel(ii);
	
	PackMan2 pm = new PackMan2();
	
	

	public JSplitPaneEx1() {
		
		spClockCalendar = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, swingCal);
		spCalcu = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spClockCalendar, cal);
		
		spPack = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lbl, pm);

		
		// 수직 나누기 (왼쪽/오른쪽)
		spHori = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spCalcu, spPack);
		
		add(spHori);
		
		setSize(1200,1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false); // true: 창 크기 조절 가능, false:창크기 조절 불가(고정)

		// 팩맨 설정
		pm.packmanStart(pm);
	}
	


	public static void main(String[] args) {
		new JSplitPaneEx1();

	}

}
