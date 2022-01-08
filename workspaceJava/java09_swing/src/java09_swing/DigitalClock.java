package java09_swing;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame{

	public DigitalClock() {
		
	}
	
	public void start() {
		GridLayout gl = new GridLayout(1,1);
		setLayout(gl);
		setSize(350,150);
		setVisible(true);
		setTitle("½Ã°è");
		
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("HH:mm:ss");
		String time = sdf.format(cal.getTime());
		//cal.roll(hour, minute, second);
		JLabel lb = new JLabel();
		add(lb);
		Font font = new Font("µ¸¿òÃ¼", Font.PLAIN, 30);
		lb.setFont(font);
		lb.setText(time);
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			lb.setText(time);
		}
	}

	public static void main(String[] args) {
		DigitalClock dc = new DigitalClock();
		dc.start();

	}

}
