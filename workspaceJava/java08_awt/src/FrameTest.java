import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// �� ���� ���. 1. �������� ��ӹޱ� 2.�������� ��ü�� �����ϱ�
public class FrameTest extends Frame {
   Point xy= new Point(500,300);
   Dimension wh= new Dimension(500,300);
   Rectangle rect = new Rectangle(100,100,400,400);
   
   
   public FrameTest() {
      //setTitle("�����ӻ���������");
      //â�� ũ�� (pixel ����)
      super("�������� ������");// Frame("�������� ������)  
      //setBounds(200,200,500,400); x,y,w,h ->Rectangle
      //setSize(500,400); //w,h -> Dimension
      //setLocation(300,300);//x,y ->point x��ǥ,y��ǥ
      //setSize(wh);
      //setLocation(xy);
      setBounds(rect);
      
      //â�� �����ֱ� (����� ����)
      
      // Ÿ��Ʋ�ٿ� �̹��� ������ �߰��ϱ�
//      Toolkit tk = Toolkit.getDefaultToolkit();
//      Image icon = tk.getImage("img/icon.png");
      
      Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");
      setIconImage(icon);
      
      // Button �߰�
      Button btn = new Button("center");
      add(btn);
      
      Button btn1 = new Button("north");
      Button btn2 = new Button("south");
      Button btn3 = new Button("east");
      Button btn4 = new Button("west");
      
      add(BorderLayout.NORTH, btn1); // BorderLayout.NORTH = "North"
      add("South", btn2); // String���� �׳� ���� �� �������� ����
      add(BorderLayout.EAST, btn3);
      add(BorderLayout.WEST, btn4);
      

      
      setVisible(true); // true:������ false:�Ⱥ����� 
      
      

   }

   public static void main(String[]args) {
      new FrameTest();
   }
}
//�����ڴ� super �ƴϸ� this�� �ҷ��� �Ѵ�.
//�ּ�ó���Ǿ��ִ°� �ѹ��� 