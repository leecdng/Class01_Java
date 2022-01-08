

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock2 extends JPanel implements Runnable{
	Font fnt = new Font("굴림",Font.BOLD, 100);
	Calendar now;
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	int x, y;
	
	public DigitalClock2() {
		// 패널로 바꿔줄 때 추가
		setLayout(new BorderLayout());
		
		//super("시계"); // == JFrame("시계"); // 같은 기능 메서드 setTitle("시계");
				add(lbl);
				lbl.setFont(fnt);
		
	}
	
	public DigitalClock2(int x, int y) {
		this();
		this.x = x;
		this.y = y;
		
		//setBounds(x, y, 500,200);
		//setVisible(true);
		
		Thread t = new Thread(this); // 이 클래스 전체를 가르키는 키워드 this
		t.start();
	}
	
	//시간변경
	public void run() {
		do {
			// 시간변경
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				
			}
		} while(true);
	}
	
	
	// 현재시간(시분초)을 00:00:00
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		return fmt.format(now.getTime());
	}

	
	
	public static void main(String[] args) {

	}

}
