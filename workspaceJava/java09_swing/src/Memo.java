import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Memo extends JFrame implements ActionListener, Serializable {
   //1.번째로 메뉴바 만들기 (메뉴안에 메뉴아이템 담는과정)
   JMenuBar mb = new JMenuBar();
      JMenu fileMenu= new JMenu("파일");
         JMenuItem newMenuItem= new JMenuItem("새글");
         JMenuItem openMenuItem= new JMenuItem("열기");
         JMenuItem saveMenuItem= new JMenuItem("저장");
         JMenuItem endMenuItem= new JMenuItem("종료");
   //2.편집메뉴
      JMenu eidtMenu = new JMenu("편집");
         JMenuItem cutMenuItem= new JMenuItem("오려두기");
         JMenuItem copyMenuItem= new JMenuItem("복사하기");
         JMenuItem pasteMenuItem= new JMenuItem("붙여넣기");
   //3.실행메뉴
      JMenu runMenu = new JMenu("실행");
         JMenuItem chromeMenuItem = new JMenuItem("크롬");
         JMenuItem editpluseMenuItem= new JMenuItem("에디트플러스");
   
   JTextArea ta= new JTextArea();
   JScrollPane sp = new JScrollPane(ta);
   
   public static String buffer; // 오려두기, 복사할 경우 데이터를 보관할 변수
   
   public Memo() {
      //담기하면됌.
      //메뉴바를 프레임에 셋하기
      setJMenuBar(mb);
      mb.add(fileMenu); mb.add(eidtMenu);mb.add(runMenu);
      
      fileMenu.add(newMenuItem); fileMenu.add(openMenuItem); fileMenu.add(saveMenuItem);
      fileMenu.addSeparator(); fileMenu.add(endMenuItem);
      
      eidtMenu.add(cutMenuItem); eidtMenu.add(copyMenuItem); eidtMenu.add(pasteMenuItem); 
      
      runMenu.add(chromeMenuItem); runMenu.add(editpluseMenuItem);
      
      File ff = new File("D://testFile/memoObject.txt");
      if(ff.exists()) { //
    	  System.out.println("메세지");
    	  try {
	    	  FileInputStream fis = new FileInputStream(ff);
	    	  ObjectInputStream ois = new ObjectInputStream(fis);
	    	  sp = (JScrollPane) ois.readObject();
	    	  add(sp);
    	  } catch(Exception e){
    		  e.printStackTrace();
    	  }
      } else {
    	  add(sp);
      }
      
      // 단축키 설정
      setShortCut();
      
      setSize(700,700);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      //이벤트등록
      
      newMenuItem.addActionListener(this);
      openMenuItem.addActionListener(this);
      saveMenuItem.addActionListener(this);
      endMenuItem.addActionListener(this);
      cutMenuItem.addActionListener(this);
      copyMenuItem.addActionListener(this);
      pasteMenuItem.addActionListener(this);
      chromeMenuItem.addActionListener(this);
      editpluseMenuItem.addActionListener(this);
   
   }
   public void actionPerformed(ActionEvent ae) {
      //액션이벤트가 생기면 일로 넘어오고 여기ae에 담길 것이다
      //end버튼부터
      Object event = ae.getSource();
      if(event==endMenuItem) {
    	  fileWrite();
    	  System.exit(0);
      } else if(event==newMenuItem){
    	  ta.setText("");// 새문서만들기 공백추가하면됌. 다른창뜨면서 글씨 사라지는거니깐
      } else if(event==openMenuItem) {
    	  fileOpen();
      } else if(event==saveMenuItem) {
    	  fileSave();
      } else if(event==cutMenuItem) {
    	  stringCut();
      } else if(event==copyMenuItem){
    	  stringCopy();
      } else if(event==pasteMenuItem) {
    	  stringPaste();
      } else if(event==chromeMenuItem) {
    	  processStart("C://Program Files/Google/Chrome/Application/chrome.exe https://www.daum.net");
      } else if(event==editpluseMenuItem) {
    	  processStart("C://Program Files/EditPlus/editplus.exe");
      }
         //열기를 누르면 화일탐색기.저장하기 기능하기.열기orsave를 하면 세팅할공간의위치가뜸
         //즉show를 할때 열기창으로 열건지 저장창으로 열건지 선택을 해야됌 
         
   }
   
   public void fileWrite() {
	   try {
		   File f = new File("D://testFile/memoObject.txt");
		   FileOutputStream fos = new FileOutputStream(f);
		   ObjectOutputStream oos = new ObjectOutputStream(fos);
		   oos.writeObject(sp);
		   oos.close();
		   fos.close();
		   
	   } catch(Exception e) {
		   
	   }
   }
   
   // 단축키 설정하기
   public void setShortCut() {
	   // 종료 : 단축키로 사용할 키를 E
	   // 1. 메뉴에 단축키로 사용할 키를 세팅
	   endMenuItem.setMnemonic(KeyEvent.VK_E);
	   // 2. mask키 설정						// 단축키 , Mask
	   endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
	   
	   // 열기 메뉴 : o
	   openMenuItem.setMnemonic(KeyEvent.VK_O);
	   openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
   }
   
   // 외부파일 실행하기
   public void processStart(String url) {
	   Runtime runtime = Runtime.getRuntime();
	   try {
		   runtime.exec(url);
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
   }
   
   public void stringCopy() {
	   buffer = ta.getSelectedText();
   }
   
   public void stringPaste() {
	   // buffer변수에 있는 문자를 커서가 있는 곳에 변경
	   ta.replaceSelection(buffer);
   }
   
   // 오려두기
   public void stringCut() {
	   // 선택영역의 문자를 buffer변수에 보관하고
	   buffer = ta.getSelectedText();
	   // 선택영역의 문자를 지워야 한다.
	   ta.replaceSelection("");
   }
   
   // 파일 저장하기
   public void fileSave() {
	   JFileChooser fc = new JFileChooser(new File("D://testFile"));
	   int state = fc.showSaveDialog(this);
	   // 0: 저장, 1: 취소
	   if(state == 0) {
		   try {
			   File ff = fc.getSelectedFile();
			   FileWriter fw = new FileWriter(ff);
			   fw.write(ta.getText());
			   fw.close();
		   } catch(IOException e) {
			   System.out.println(e.getMessage());
		   }
	   }
   }
      
   //파일 열기
   public void fileOpen() {
      JFileChooser fc = new JFileChooser(new File("D://Java/src"));
      
      // 파일을 여러 개 한 번에 선택 가능하도록 설정하기 // true: 다중선택가능, false: 다중 선택 불가, 1개만 가능
//      fc.setMultiSelectionEnabled(true);
      
      // 필터링(파일명)
      FileFilter filter = new FileNameExtensionFilter("자바(*.java)", "java", "Java", "JAVA", "JaVa");
      fc.setFileFilter(filter);
      
//      FileFilter filter2 = new FileNameExtensionFilter("클래스","class");
//      fc.setFileFilter(filter2);
      
      
      
      // 열기 창을 띄우겠다 // 부모컨테이너(자신)
      int choose = fc.showOpenDialog(this); // 열기: 0, 취소: 1 반환
      if(choose == 0) {
    	  // 선택한 파일 경로와 파일명을 얻어오기
    	  try {
	    	  File f = fc.getSelectedFile();
	    	  FileReader fr = new FileReader(f);
	    	  BufferedReader br = new BufferedReader(fr);
	    	  ta.setText(""); // 이전에 표시된 내용이 있을 경우 지운다.
	    	  while(true) {
	    		  String inData = br.readLine();
	    		  if(inData == null) break;
	    		  ta.append(inData+"\n");
	    	  }
    		  
    		  // 파일을 여러 개 선택했을 때
//    		  File[] f = fc.getSelectedFiles();
//    		  for( File ff : f) {
//    			  FileReader fr = new FileReader(ff);
//    			  BufferedReader br = new BufferedReader(fr);
//    			  while(true) {
//    				  String txt = br.readLine();
//    				  if(txt == null) break;
//    				  ta.append(txt+"\n");
//    			  }
//    			  ta.append("------------------------------------------------\n");
//    		  }
    		  
    	  } catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }
   }

   public static void main(String[] args) {
         new Memo();

   }

}