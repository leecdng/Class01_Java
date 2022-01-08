import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StandardClock extends JFrame implements Runnable{
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	Font fnt = new Font("µ¸¿òÃ¼", Font.BOLD, 80);
	String area;
	int x, y;
	
	public StandardClock() {

	}
	
	public StandardClock(String area, int x, int y) {
		this.area = area;
		this.x = x;
		this.y = y;
		setTitle(area);
	}
	
	public void getTimer(String area) {
		//Calendar now = Calendar.getInstance();
		
		TimeZone tz = TimeZone.getTimeZone(area);
		sdf.setTimeZone(tz);
		
		Calendar now = Calendar.getInstance();
//		Date date = new Date();
//		String time = sdf.format(date);
		String time = sdf.format(now.getTime());
		lbl.setText(time);
	}
	
	public void run() {
		lbl.setFont(fnt);
		add(lbl);
		
		setSize(500, 200);
		setLocation(x, y);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		do {
			getTimer(area);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				
			}
		} while(true);
	}

	public static void main(String[] args) {
		StandardClock sc1 = new StandardClock("Asia/Seoul", 100, 100);
		StandardClock sc2 = new StandardClock("Australia/Canberra", 650, 100);
		StandardClock sc3 = new StandardClock("Europ/United Kingdom", 1200, 100);
		
		Thread t1 = new Thread(sc1);
		Thread t2 = new Thread(sc2);
		Thread t3 = new Thread(sc3);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
