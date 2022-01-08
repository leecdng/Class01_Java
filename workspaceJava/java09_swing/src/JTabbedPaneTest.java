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
		super("�Ǹ޴�");
		
		tp = new JTabbedPane(JTabbedPane.LEFT); // int������ 1�̶� ����
		
		tp.addTab("����", cal);
		
		lbl = new JLabel(ii);
		tp.addTab("���̺�", lbl);
		
		btn = new JButton(iii);
		tp.addTab("��ư", btn);
		
		tp.addTab("�ð�", dc);
		
		tp.addTab("�޷�", iii, calendar, "�޷�"); // �� �� �� �ؽ�Ʈ ���� ������ ����??????????????
		
		tp.insertTab("Button", null, new JButton("�߰��� ��ư"), "�߰��� �Ǹ޴� �߰�", 3);
		
		// ���� Ȱ��ȭ �� ��Ȱ��ȭ
		// true: Ȱ��ȭ, false: ��Ȱ��ȭ
		//			��index, true/false
//		tp.setEnabledAt(2, false);
//		tp.setEnabled(false); // ��� �Ǹ޴� ��Ȱ��ȭ, 0��° �� ������ Ȱ��ȭ��
		
		
		//tp.insertTab("�Ѹ�", null, pm, "�Ѹ�", 4);
		//PackMan2 pm = new PackMan2();
//		Thread t = new Thread(this);
//		t.start();
		
//		PackMan2 pm = new PackMan2();
//		tp.insertTab("�Ѹ�", null, pm, "�Ѹ�", 5);
		
		//tp.insertTab("�Ѹ�", null, pm, "�Ѹ�", 4);
		//tp.addTab("�Ѹ�", pm);
		
		tp.insertTab("�Ѹ�", null, pm, "�Ѹ�", 5);
		
		add(tp);
		setSize(500, 500); // �� ���Ŀ� ũ�Ⱑ �������ִ�.
			
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pm.setCanvasSize(); // �Ѹ� ĵ���� ũ�⸦ �����Ѵ�.
		Thread t = new Thread(pm);
		t.start();
		
		// ũ�� ����
		
		
		// ���� ����
//		try {Thread.sleep(1000);}catch(Exception e) {}; // ������Ű�� �� �� set �޼���� �Ʒ��� �;� �ϴ��� �ٽ� ������ ����
//		tp.removeTabAt(3);
		//try {Thread.sleep(1000);}catch(Exception e) {};
		//tp.remove(3); // ���� �Ŷ� �Ȱ����� ���� ����????????????????????
		
	}
	
	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
