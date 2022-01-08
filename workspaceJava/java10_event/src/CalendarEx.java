import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarEx extends JFrame implements ActionListener, ItemListener {
	Calendar cal = Calendar.getInstance();
	JPanel pane = new JPanel();
	JPanel pane2 = new JPanel();
	JComboBox<String> yearBox = new JComboBox<String>();
	JComboBox<String> monthBox = new JComboBox<String>();
	//String[] yearArr = new String[61];
	JLabel yearLbl, monthLbl;
	Color clr = new Color(100,200,200);
	Font fnt = new Font("����ü",Font.BOLD , 26);
	
	JLabel[] weekLbl = new JLabel[7];
	String[] weekStr = {"��","��","ȭ","��","��","��","��"};
	JLabel[] dayLbl = new JLabel[42];
	
	String yearStr="", monthStr="";
	int year=cal.get(Calendar.YEAR);
	int month=cal.get(Calendar.MONTH)+1;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int week=0;
	int lastday=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	int yearIdx=10, monthIdx=month-1;
	
	
	public CalendarEx() {
		super("�޷�");
		setFrame();
	}
	
	// �����̳�, ������Ʈ ����
	public void setFrame() {
		JButton leftBtn = new JButton("��");
		JButton rightBtn = new JButton("��");
		
		setDateBox();
		
		yearBox.setSelectedIndex(10);
		monthBox.setSelectedIndex(month-1);
		
		yearLbl = new JLabel("��");
		monthLbl = new JLabel("��");
		pane.setBackground(clr); 

		leftBtn.setFont(fnt);
		rightBtn.setFont(fnt);
		yearBox.setFont(fnt);
		monthBox.setFont(fnt);
		yearLbl.setFont(fnt);
		monthLbl.setFont(fnt);
		pane.add(leftBtn);
		pane.add(yearBox);
		pane.add(yearLbl);
		pane.add(monthBox);
		pane.add(monthLbl);
		pane.add(rightBtn);
		
		pane2.setLayout(new GridLayout(7,7));
		
		printWeek();
		printDay();
		printCalendar();
		
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		yearBox.addItemListener(this);
		monthBox.addItemListener(this);
		
		add(pane, BorderLayout.NORTH);
		add(pane2, BorderLayout.CENTER);
		
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
//	public void setYearBox() {
//		for(int i=0; i<yearArr.length; i++) {
//			if(i<10) yearArr[i]=year+(10-i)+"";
//			else if(i==10) yearArr[i] = year+"";
//			else yearArr[i]=year-(i-10)+"";
//		}
//		yearBox = new JComboBox<String>(yearArr);
//		for(int i=1; i<=12; i++) {
//			monthBox.addItem(i+"");
//		}
//	}
	
	// ����, �� ComboBox�� �� �־��ֱ�
	public void setDateBox() {
		for(int i=year+10; i>year-50; i--) { // ���� ����+10 ~ -50�����
			yearBox.addItem(i+"");
		}
		for(int i=1; i<=12; i++) { // �� �� �־��ֱ�
			monthBox.addItem(i+"");
		}
	}
	
	// ���� ���
	public void printWeek() {
		for(int i=0; i<weekStr.length; i++) {
			weekLbl[i] = new JLabel(weekStr[i], JLabel.CENTER);
			weekLbl[i].setFont(fnt);
			if(i==0) weekLbl[i].setForeground(Color.RED);
			else if(i==6) weekLbl[i].setForeground(Color.BLUE);
			pane2.add(weekLbl[i]);
		}
	}
	
	// ��¥ �� ����
	public void printDay() {
		for(int i=0; i<dayLbl.length; i++) {
			dayLbl[i] = new JLabel(" ", JLabel.CENTER);
			dayLbl[i].setFont(fnt);
			pane2.add(dayLbl[i]);
		}
	}
	
	// ���� ����� �´� �޷� ��¥ ���
	public void printCalendar() {
		cal.set(year, month-1, 1);
		week = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i=0; i<dayLbl.length; i++) {
			if(i<week-1) {	// ���Ͽ� �°� �տ� ���� ���
				dayLbl[i].setText(" ");
			} else if(i>= week-1 && i<week-1+lastday) {
				if(i == 0 || i%7==0) dayLbl[i].setForeground(Color.RED); // �Ͽ����̸� ������
				else if(i%7==6) dayLbl[i].setForeground(Color.BLUE); // ������̸� �Ķ���
				dayLbl[i].setText((i+1)-(week-1) +"");	// ��¥ ��� - �ش� ĭ ����(i)���� ���鸸ŭ ����
			} else {
				dayLbl[i].setText(" "); // ������ ���� ���
			}
		}
	}
	
	// ��ư �̺�Ʈ �߻�
	@Override
	public void actionPerformed(ActionEvent e) {
		String evtBtn = (String) e.getActionCommand();
		if(evtBtn.equals("��")) { // ������ ��ư�̸�
			if(monthIdx == 11) { // 12���̸�
				if(yearIdx == 0) { // ���� ���� ������
					yearBox.setSelectedIndex(yearIdx); // ������ ����̸� ����, �� �״�� �α�
					monthBox.setSelectedIndex(monthIdx);
				} else {
					yearBox.setSelectedIndex(yearIdx-1); // 12���̸� ����+1 �ϱ�
					monthBox.setSelectedIndex(0); // 1���� �Ѿ��
				}
			} else {
				monthBox.setSelectedIndex(monthIdx+1); // ��+1 �ϱ�
			}
		} else if(evtBtn.equals("��")) {
			if(monthIdx == 0) { // 1���̸�
				if(yearIdx == 59) { // ���� ���� ������
					yearBox.setSelectedIndex(yearIdx); // ���� ó�� ����̸� ����, �� �״�� �α�
					monthBox.setSelectedIndex(monthIdx);
				} else {
					yearBox.setSelectedIndex(yearIdx+1); // 1���̸� ����-1 �ϱ�
					monthBox.setSelectedIndex(11); // 12���� �Ѿ��
				}
			} else {
				monthBox.setSelectedIndex(monthIdx-1); // ��-1�ϱ�
			}
		}
	}
	
	// �޺��ڽ� �̺�Ʈ �߻�
	@Override
	public void itemStateChanged(ItemEvent e) {
		JComboBox evtBox = (JComboBox) e.getSource();
		
		if(evtBox.equals(yearBox)) {
			yearIdx = yearBox.getSelectedIndex();
			yearStr = (String) yearBox.getSelectedItem();
			year = Integer.parseInt(yearStr);
		} else if(evtBox.equals(monthBox)){
			monthIdx = monthBox.getSelectedIndex();
			monthStr = (String) monthBox.getSelectedItem();
			month = Integer.parseInt(monthStr);
		}
		cal.set(year, month-1, 1); // �ٲ� ����� ��¥ ����
		week = cal.get(Calendar.DAY_OF_WEEK); // �ٲ� ����� ���� ���ϱ�
		lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // �ٲ� ����� ��������
		printCalendar(); // ��¥ ��� �޼���
	}
	
	
	public static void main(String[] args) {
		new CalendarEx();
	}
	
}
