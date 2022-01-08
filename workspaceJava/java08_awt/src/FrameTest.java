import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// 두 가지 방법. 1. 프레임을 상속받기 2.프레임을 객체로 생성하기
public class FrameTest extends Frame {
   Point xy= new Point(500,300);
   Dimension wh= new Dimension(500,300);
   Rectangle rect = new Rectangle(100,100,400,400);
   
   
   public FrameTest() {
      //setTitle("프레임생성연습중");
      //창의 크기 (pixel 단위)
      super("하위에서 제목설정");// Frame("하위에서 제목설정)  
      //setBounds(200,200,500,400); x,y,w,h ->Rectangle
      //setSize(500,400); //w,h -> Dimension
      //setLocation(300,300);//x,y ->point x좌표,y좌표
      //setSize(wh);
      //setLocation(xy);
      setBounds(rect);
      
      //창을 보여주기 (숨기기 가능)
      
      // 타이틀바에 이미지 아이콘 추가하기
//      Toolkit tk = Toolkit.getDefaultToolkit();
//      Image icon = tk.getImage("img/icon.png");
      
      Image icon = Toolkit.getDefaultToolkit().getImage("img/icon.png");
      setIconImage(icon);
      
      // Button 추가
      Button btn = new Button("center");
      add(btn);
      
      Button btn1 = new Button("north");
      Button btn2 = new Button("south");
      Button btn3 = new Button("east");
      Button btn4 = new Button("west");
      
      add(BorderLayout.NORTH, btn1); // BorderLayout.NORTH = "North"
      add("South", btn2); // String으로 그냥 쓰는 건 권장하진 않음
      add(BorderLayout.EAST, btn3);
      add(BorderLayout.WEST, btn4);
      

      
      setVisible(true); // true:보여줌 false:안보여줌 
      
      

   }

   public static void main(String[]args) {
      new FrameTest();
   }
}
//생성자는 super 아니면 this로 불러야 한다.
//주석처리되어있는건 한번씩 