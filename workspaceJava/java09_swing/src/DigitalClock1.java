

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock1 extends JFrame{
	Font fnt = new Font("굴림",Font.BOLD, 100);
	Calendar now;
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	
	public DigitalClock1() {
		super("시계"); // == JFrame("시계"); // 같은 기능 메서드 setTitle("시계");
		add(lbl);
		lbl.setFont(fnt);
		
		setSize(500,200);
		setVisible(true);
		
		start(); // 창 띄운 다음에 불러와야 함 (?)
	}
	
	//시간변경
	public void start() {
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
		new DigitalClock1();
	}

}
