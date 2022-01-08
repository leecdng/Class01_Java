

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
		// BorderLayout�� GridLayout���� �����ϱ�
		GridLayout layout = new GridLayout(3,2, 10, 10); // ��, ��, ���ݵ�
		setLayout(layout); // setLayout(new GridLayout(3,2));
		
		JButton btn1 = new JButton("��ư1");
		add(btn1);
		
		JButton btn2 = new JButton(icon);
		add(btn2);
		// ���콺 ������ �� icon�ٲٱ�
		btn2.setPressedIcon(icon2);
		// ���콺 ���� �� icon �ٲٱ�
		btn2.setRolloverIcon(icon3);
		
		
		JButton btn3 = new JButton("�ɺ�", icon);
		add(btn3);
		// ��ư�� Ȱ��ȭ true / ��Ȱ��ȭ false
		btn3.setEnabled(false);
		JButton btn4 = new JButton("�� ��° ��ư");
		add(btn4);
		
		// ���� ��ư
		JPanel pane = new JPanel(new GridLayout(3,1)); // �׵θ��� ���� �����̳�
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");
		
		// ���� ��ư �׷� ����� - ��ư �ϳ� ������ �ٸ� ��ư ��ҵ�
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1);
		bg.add(rBtn2);
		bg.add(rBtn3);
		
		pane.add(rBtn1);
		pane.add(rBtn2);
		pane.add(rBtn3);
		
		add(pane);
		
		
		// ��� ��ư
		JToggleButton toggleBtn = new JToggleButton("���", icon3);
		toggleBtn.setRolloverIcon(icon);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);
		
		// �� �����
		JLabel lbl = new JLabel("�� ǥ��", JLabel.RIGHT);
		add(lbl);
		
		
		// ���� �÷� ����
		btn1.setBackground(Color.ORANGE);
		// btn4.setBackground(new Color(11,11,11)); // RGB ���� 0~255��
		Color clr = new Color(100,100,100);
		toggleBtn.setBackground(clr); // RGB ���� 0~255��
		
		// ���ڻ� �÷� ����
		btn1.setForeground(Color.white);
		
		// �󺧿� ���� �־��
		// ����ó������ ���� �ؾ� ��
		lbl.setOpaque(true); // true: ����ó�� ����, false:����ó��
		lbl.setBackground(new Color(20,100,50));
		
		// Font: �۲�(����ü, ����ü, Arial,,,), ��������(�����, ���ϰ�, ����), ����ũ�� ����(px)
		Font fnt = new Font("�ü�ü", Font.ITALIC+Font.BOLD, 40);
		lbl.setFont(fnt);
		
		
		setSize(1000,500);
		setVisible(true);
		// ���α׷��� ����Ǹ� �ڿ������ϰų�, ���α׷��� ������ �� ������ ���� ����
		// DISPOSE_ON_CLOS: ���α׷� ���� �� �ڿ��� �����϶�.
		// DO_NOTHING_ON_CLOSE: �ݱⰡ ������� �ʴ´�.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // (2) �̷� ������ ���ڷ� �ִ� �� �� ���������� �ڵ� �м��� ����� �� �� ����.
		//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // â �ȿ� �޴� ���� �װ� �����߸� �ݱ� �ǰ� �� ���� ����
		
		// �и��ʸ�ŭ �Ͻ�����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
//			btn1.setText("����� ��ư ��");
//			lbl.setText("����� ��");
		} // �и���
		
		// ��ư�� ��, Label�� ���� �����ϱ� // ���� �޼���������� �ٸ� Ŭ������ �޼����� (��Ӱ��赵 �ƴ�)
		btn1.setText("����� ��ư ��");
		lbl.setText("����� ��");
		
	}

	public static void main(String[] args) {
		new JFrameTest();

	}

}
