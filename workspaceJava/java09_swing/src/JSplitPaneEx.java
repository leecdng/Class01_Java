import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class JSplitPaneEx extends JFrame{
	JSplitPane sp1, sp2, sp3, sp4;
	
	DigitalClock2 dc = new DigitalClock2();
	SwingCalendar2 calendar = new SwingCalendar2();
	CalculatorEx2 cal = new CalculatorEx2();
	
	Image img;
	MyCanvas mc = new MyCanvas();
	PackMan2 pm = new PackMan2();

	public JSplitPaneEx() {
		
		
		sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mc, pm);
		sp4.setDividerLocation(300);
		mc.repaint();
		
		
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, calendar, cal);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, sp3);
		Thread t2 = new Thread(dc);
		t2.start();
		
		// 수직 나누기 (왼쪽/오른쪽)
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp4);
		add(sp1);
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pm.setCanvasSize();
		Thread t1 = new Thread(pm);
		t1.start();
	}
	
	
	public class MyCanvas extends Canvas{
		
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/wbb.png");
		}
		
		public void paint(Graphics g) {
			g.drawImage(img, 0,0, this);
		}
	}

	public static void main(String[] args) {
		new JSplitPaneEx();

	}

}
