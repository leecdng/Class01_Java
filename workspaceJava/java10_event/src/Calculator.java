import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener {
	JLabel lbl;
	JPanel pane, pane1, pane2;

	BorderLayout bl = new BorderLayout();
	GridLayout gl = new GridLayout(4,4);
	JButton[] topBtn = new JButton[3];
	String[] btnTxt = {"BackSpace", "Clear", "End"};
	JButton[] operBtn = new JButton[6];
	JButton[] numBtn = new JButton[10];
	String[] operTxt = {"+", "-", "*", "/", ".", "="};
	String evtTxt;
	String totalTxt="";
	
	public Calculator() {
		super("계산기");
		start();
	}
	
	public void start() {
		// 레이아웃, 라벨, 버튼 등 세팅
		createCon();
		
		setSize(400,250);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 값 변환
		
		// 라벨에 출력
		
	}
	
	
	// 컨테이너, 컨포넌트 생성
	public void createCon() {
		//setLayout(layout);
		lbl = new JLabel("0.0");
		pane = new JPanel(); // 버튼 전체 패널
		pane1 = new JPanel(); // 상단 패널
		pane2 = new JPanel(); // 하단 숫자 패널
		
		pane.setLayout(new BorderLayout());
		pane1.setLayout(new GridLayout(1,3));
		
		for(int i=0; i<topBtn.length; i++) {
			topBtn[i] = new JButton(btnTxt[i]);
			pane1.add(topBtn[i]);
			topBtn[i].addActionListener(this);
		}
		
		pane.add(pane1, BorderLayout.NORTH);
		
		for(int i=0; i<operBtn.length; i++) {
			operBtn[i] = new JButton(operTxt[i]);
			operBtn[i].setBackground(new Color(200,200,200));
			operBtn[i].addActionListener(this);
		}

		for(int i=0; i<numBtn.length; i++) {
			numBtn[i] = new JButton(i+"");
			numBtn[i].setBackground(new Color(200,200,200));
			numBtn[i].addActionListener(this);
		}

		pane2.setLayout(gl);
		pane2.add(numBtn[7]);
		pane2.add(numBtn[8]);
		pane2.add(numBtn[9]);
		pane2.add(operBtn[0]);
		pane2.add(numBtn[4]);
		pane2.add(numBtn[5]);
		pane2.add(numBtn[6]);
		pane2.add(operBtn[1]);
		pane2.add(numBtn[1]);
		pane2.add(numBtn[2]);
		pane2.add(numBtn[3]);
		pane2.add(operBtn[2]);
		pane2.add(numBtn[0]);
		pane2.add(operBtn[3]);
		pane2.add(operBtn[4]);
		pane2.add(operBtn[5]);
		pane.add(pane2, BorderLayout.CENTER);
		
		
		
		add(lbl, BorderLayout.NORTH);
		add(pane);

	}

//	public int calculateBtn(Object obj) {
//		ev
//	}


	@Override
	public void actionPerformed(ActionEvent e) {
		evtTxt = e.getActionCommand();
		char c = evtTxt.charAt(0);
		//Object evtBtn = e.getSource();
		double result;
		try {
			if( c>=48 && c<=57 || evtTxt.equals(".")) {
				totalTxt = totalTxt + evtTxt;
				lbl.setText(totalTxt);
			} else if(evtTxt.equals("=")) {
				result = Double.parseDouble(totalTxt);
				lbl.setText(result+"");
			} else if(evtTxt.equals("BackSpace")) {
				if(totalTxt.length()>0) {
					totalTxt = totalTxt.substring(0, totalTxt.length()-1);
					lbl.setText(totalTxt+" ");
				} else {
					lbl.setText(" ");
				}
			} else if(evtTxt.equals("Clear")) {
				totalTxt = "";
				lbl.setText(totalTxt+" ");
			} else if(evtTxt.equals("End")) {
				System.exit(0);
			} else { // 연산자일 경우
				lbl.setText(totalTxt);
				totalTxt = totalTxt + evtTxt;
			}
		} catch(NumberFormatException nfe) {
			
		}
	}
	
	
	
	public static void main(String[] args) {
		new Calculator();

	}

}
