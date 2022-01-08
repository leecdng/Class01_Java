import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PackMan2 extends JPanel implements KeyListener, Runnable {
	MyCanvas mc = new MyCanvas();
	Dimension dim;
	
	// 캔버스의 x좌표, y좌표
	int x, y;
	// 이미지 포인트로 사용할 변수
	int p=0;
	
	//JTabbedPaneTest tp = new JTabbedPaneTest();
	
//	int w=500;
//	int h=500;
	
	
	public PackMan2() {
		setLayout(new BorderLayout());
		add(mc);
		
		mc.setFocusable(true);
		
//		setSize(500,500);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 캔버스 크기를 구한다.
		
		
		// 이벤트 등록 -- 키 이벤트
		mc.addKeyListener(this); // 메서드는 현재 클래스에 있다. this
		
//		
//		Thread t = new Thread(this);
//		t.start();
		
	}
	
	class MyCanvas extends Canvas{
		Image packMan;
		MyCanvas(){
			packMan = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		
		public void paint(Graphics g) {
			//					 canvas						img
			//										p=0		0, 	0, 	50,	50
			//										p=1		50, 0, 100, 50
			//										p=2		100,0, 150,	50
			//										p=3		150,0, 200, 50
			g.drawImage(packMan, x, y, x+50, y+50,   p*50, 0, p*50+50, 50, this);
		}
	}
	
	public void setCanvasSize() {
		// 캔버스 크기를 구한다.
		dim = mc.getSize();
		x = (int) dim.getWidth()/2 - 25;
		y = (int) dim.getHeight()/2 -25;

		System.out.println("w="+dim.getWidth()+"h="+dim.getHeight());
	}
	
	public void packmanStart(PackMan2 p) {
		setCanvasSize();
		Thread t = new Thread(p);
		t.start();
	}
	
	public void run() {
		// 난 생성자에 있는 내용 다 넣어줬었지만 무한루프부터만 이렇게 넣어주심 쌤은
		
		// paint() 메서드를 반복 호출
		while(true) {
			mc.repaint();
			// 이미지 변환 // 왼쪽으로 이동 0,1	2,3		4,5		6,7
			if(p%2==0) p++;
			else p--;
			// 좌표 이동 // 왼쪽으로 이동
			if(p==0 || p==1) { // 왼쪽으로 이동
				x-=5;
				if(x<=-50) x = (int)dim.getWidth();
			} else if(p==2 || p==3) { // 오른쪽으로 이동
				x+=5;
				if(x>=(int)dim.getWidth()) x = -50;
			} else if(p==4 || p==5) { // 위쪽으로 이동
				y-=5;
				if(y<=-50) y = (int) dim.getHeight();
			} else if(p==6 || p==7) { // 아래쪽으로 이동
				y+=5;
				if(y>=(int) dim.getHeight()) y = -50;
			}
			// 시간 지연
			try {
				Thread.sleep(200);
			} catch(Exception e) {
				
			}
		}
	}
	
	// KeyEvent 오버라이딩
	public void keyPressed(KeyEvent ke) {}
	
	public void keyReleased(KeyEvent ke) {
		int code = ke.getKeyCode();
		if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) { // 왼쪽 방향키
			p=0;
		} else if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
			p=2;
		} else if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			p=4;
		} else if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_X) {
			p=6;
		}
		
		
		//System.out.println(key); // 37,38,39,40 < ^ > 아래
	}
	
	public void keyTyped(KeyEvent ke) {}
	
	

	public static void main(String[] args) {

	}

}
