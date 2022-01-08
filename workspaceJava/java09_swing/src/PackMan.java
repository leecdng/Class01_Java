import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PackMan extends JFrame {
	Image img;
	MyCanvas mc = new MyCanvas();
	int x= 400; int y= 150; int w= 1; // x좌표, y좌표, w=이미지 왼쪽 상단 좌표
	final int CENTER_X= 175; final int CENTER_Y= 150; // X좌표와 Y좌표의 가운데
	final int XY_MIN= -50; final int XY_MAX= 400; // 시작점과 끝점
	final int GAP= 25; // 움직이는 간격
	
	public PackMan() {
		add(mc);
		
		setSize(XY_MAX, XY_MAX);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		do {
			movePackman();
		} while(true);
	}
	
	// 팩맨 움직이기
	public void movePackman() {
		// 오른쪽에서 왼쪽
		x=XY_MAX; y=CENTER_Y; w=1;
		do {
			mc.repaint();
			
			x-=GAP;
			if(w==1) w+=50;
			else if(w==51) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(x>XY_MIN);
		
		// 왼쪽에서 오른쪽
		x=XY_MIN; y=CENTER_Y; w=101;
		do {
			mc.repaint();
			
			x+=GAP;
			if(w==101) w+=50;
			else if(w==151) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(x<XY_MAX);
		
		// 아래에서 위
		x=CENTER_X; y=XY_MAX; w=201;
		do {
			mc.repaint();
			
			y-=GAP;
			if(w==201) w+=50;
			else if(w==251) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(y>XY_MIN);
		
		// 위에서 아래
		x=CENTER_X; y=XY_MIN; w=301;
		do {
			mc.repaint();
			
			y+=GAP;
			if(w==301) w+=50;
			else if(w==351) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(y<XY_MAX);
	}
	
	
	public class MyCanvas extends Canvas{
		
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		
		// 이미지 불러오기
		public void paint(Graphics g) {
			//int imgW = img.getWidth(this);
			int imgH = img.getHeight(this);
			
			g.drawImage(img, x, y, x+50, y+50, w, 1, w+49, imgH, this);
		}
	}


	
	public static void main(String[] args) {
		new PackMan();
	}

}
