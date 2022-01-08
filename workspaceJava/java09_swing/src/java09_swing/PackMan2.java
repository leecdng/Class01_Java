package java09_swing;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PackMan2 extends JFrame { // implements ActionListener {
	Image img;
	MyCanvas mc = new MyCanvas();
	int x= 400; int y= 150; int w= 1;
	final int CENTER_X= 175; final int CENTER_Y= 150;
	final int LEFT_MAX= -50; final int RIGHT_MAX= 400;
	int imgW= 1, imgH= 1;
	
	public PackMan2() {
		add(mc);
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		x=400; y=CENTER_Y; w=1;
		do {
			mc.repaint();
			
			x+=-25;
			if(w==1) w+=50;
			else if(w==51) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(x>-50);
		
		
		x=-50; y=CENTER_Y; w=101;
		do {
			mc.repaint();
			
			x+=25;
			if(w==101) w+=50;
			else if(w==151) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(x<400);
		

		x=CENTER_X; y=400; w=201;
		do {
			mc.repaint();
			
			y+=-25;
			if(w==201) w+=50;
			else if(w==251) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(y>-50);
		
		
		x=CENTER_X; y=-50; w=301;
		do {
			mc.repaint();
			
			y+=25;
			if(w==301) w+=50;
			else if(w==351) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(y<400);
		
	}
	
	
	public void movePackman(int x, int y, int w) {
		this.x=x;
		this.y=y;
		this.w=w;
		
		do {
			mc.repaint();
			
			x+=-25;
			if(w==1) w+=50;
			else if(w==51) w-=50;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}	
		} while(x>-50);
	}
	
	
	public class MyCanvas extends Canvas{
		
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		
		public void paint(Graphics g) {
			imgW = img.getWidth(this);
			imgH = img.getHeight(this);

			g.drawImage(img, x, y, x+50, y+50, w, 1, w+49, imgH, this);

		}

		
	}
	
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//	}

	public static void main(String[] args) {
		new PackMan2();
	}

}
