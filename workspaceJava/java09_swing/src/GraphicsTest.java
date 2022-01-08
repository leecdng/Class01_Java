import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicsTest extends JFrame{
	MyCanvas canvas = new MyCanvas();
	public GraphicsTest() {
		System.out.println("GraphicsTest");
		add(canvas);
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			System.out.println("MyCanvas");
		}
		
		public void paint(Graphics g) {
			// 직선 그리기
			g.drawLine(100, 100, 500, 500);
			// 그림을 그리기 전에 컬러 설정하고, 그림을 그린다.
			g.setColor(Color.RED);
			g.drawLine(100, 500, 500, 100);
			// 			 x		y	 w	 h
			g.drawOval(200, 200, 300, 300);
			
			g.drawRect(200, 200, 300, 300);
			
			g.setColor(Color.GREEN);
			g.fillOval(300,300,300,300);
			g.fillRect(100, 100, 300, 300);
			
			g.setColor(Color.BLUE);
			int[] x = {100,170,250,50};
			int[] y = {50,50,230, 200};
			g.drawPolygon(x, y, x.length);
			
			g.drawRoundRect(300, 300, 500, 500, 50, 50); // 둥근 사각형
			
			// 문자를 그리기
			String txt = "JAVA 프로그래밍";
			g.setColor(Color.MAGENTA);
			g.setFont(new Font("돋움체", Font.BOLD, 40));
			
			g.drawString(txt, 100, 200);
		}
	}

	public static void main(String[] args) {
		new GraphicsTest();

	}

}
