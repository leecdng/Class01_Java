

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock1 extends JFrame{
	Font fnt = new Font("����",Font.BOLD, 100);
	Calendar now;
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	
	public DigitalClock1() {
		super("�ð�"); // == JFrame("�ð�"); // ���� ��� �޼��� setTitle("�ð�");
		add(lbl);
		lbl.setFont(fnt);
		
		setSize(500,200);
		setVisible(true);
		
		start(); // â ��� ������ �ҷ��;� �� (?)
	}
	
	//�ð�����
	public void start() {
		do {
			// �ð�����
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		} while(true);
	}
	
	
	// ����ð�(�ú���)�� 00:00:00
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}

	
	
	public static void main(String[] args) {
		new DigitalClock1();
	}

}
