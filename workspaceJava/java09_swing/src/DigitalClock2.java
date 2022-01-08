

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable{
	Font fnt = new Font("����",Font.BOLD, 100);
	Calendar now;
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	int x, y;
	
	public DigitalClock2() {
		// �гη� �ٲ��� �� �߰�
		setLayout(new BorderLayout());
		
		//super("�ð�"); // == JFrame("�ð�"); // ���� ��� �޼��� setTitle("�ð�");
				add(lbl);
				lbl.setFont(fnt);
		
	}
	
	public DigitalClock2(int x, int y) {
		this();
		this.x = x;
		this.y = y;
		
		//setBounds(x, y, 500,200);
		//setVisible(true);
		
		Thread t = new Thread(this); // �� Ŭ���� ��ü�� ����Ű�� Ű���� this
		t.start();
	}
	
	//�ð�����
	public void run() {
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

	}

}
