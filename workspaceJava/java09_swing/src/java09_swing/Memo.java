package java09_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame implements ActionListener{
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새글");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromMenuItem = new JMenuItem("크롬");
			JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
			
			
	public Memo() {
		setJMenuBar(mb);
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(runMenu); 
		
		fileMenu.add(newMenuItem); fileMenu.add(openMenuItem); fileMenu.add(saveMenuItem);
		fileMenu.addSeparator(); fileMenu.add(endMenuItem);
		
		editMenu.add(cutMenuItem); editMenu.add(copyMenuItem); editMenu.add(pasteMenuItem);
		
		runMenu.add(chromMenuItem); runMenu.add(editplusMenuItem);
		
		add(sp);
		
		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		chromMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if(event == endMenuItem){
			System.exit(0);
		} else if(event == newMenuItem) {
			ta.setText("");
		}
		
	}

	public static void main(String[] args) {
		new Memo();

	}


}
