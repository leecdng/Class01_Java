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
		// ���� ������
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, cal, calendar);
		
		// ���� ������
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp);
		
		//sp1.add(sp2); // �̷��Դ� �ִ� �� �ƴѰ� ��..���� �ƴѰ� �ǳ�
		add(sp1);
		
		// ��輱�� ��ġ�� ������ �� �ִ�.
		sp2.setDividerLocation(350); // ������ 350px
		sp1.setDividerLocation(800); // ������ 800px
		
		// ��輱�� �β� ����
		sp2.setDividerSize(0); // ������ 0�̸� ���콺�� �������� �ʰ� ������ ���� �� �� // ����
		sp1.setDividerSize(20);
		
		// ����ġ
		sp1.setOneTouchExpandable(true); // �޴� �ݾҴ� ������ �� �� ���� ��
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitPaneTest();

	}

}
