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
	Font fnt = new Font("돋움체",Font.BOLD , 26);
	
	JLabel[] weekLbl = new JLabel[7];
	String[] weekStr = {"일","월","화","수","목","금","토"};
	JLabel[] dayLbl = new JLabel[42];
	
	String yearStr="", monthStr="";
	int year=cal.get(Calendar.YEAR);
	int month=cal.get(Calendar.MONTH)+1;
	int day = cal.get(Calendar.DAY_OF_MONTH);
	int week=0;
	int lastday=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	int yearIdx=10, monthIdx=month-1;
	
	
	public CalendarEx() {
		super("달력");
		setFrame();
	}
	
	// 컨테이너, 컴포넌트 세팅
	public void setFrame() {
		JButton leftBtn = new JButton("◀");
		JButton rightBtn = new JButton("▶");
		
		setDateBox();
		
		yearBox.setSelectedIndex(10);
		monthBox.setSelectedIndex(month-1);
		
		yearLbl = new JLabel("년");
		monthLbl = new JLabel("월");
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
	
	// 연도, 월 ComboBox에 값 넣어주기
	public void setDateBox() {
		for(int i=year+10; i>year-50; i--) { // 현재 연도+10 ~ -50년까지
			yearBox.addItem(i+"");
		}
		for(int i=1; i<=12; i++) { // 월 값 넣어주기
			monthBox.addItem(i+"");
		}
	}
	
	// 요일 출력
	public void printWeek() {
		for(int i=0; i<weekStr.length; i++) {
			weekLbl[i] = new JLabel(weekStr[i], JLabel.CENTER);
			weekLbl[i].setFont(fnt);
			if(i==0) weekLbl[i].setForeground(Color.RED);
			else if(i==6) weekLbl[i].setForeground(Color.BLUE);
			pane2.add(weekLbl[i]);
		}
	}
	
	// 날짜 라벨 생성
	public void printDay() {
		for(int i=0; i<dayLbl.length; i++) {
			dayLbl[i] = new JLabel(" ", JLabel.CENTER);
			dayLbl[i].setFont(fnt);
			pane2.add(dayLbl[i]);
		}
	}
	
	// 현재 년월에 맞는 달력 날짜 출력
	public void printCalendar() {
		cal.set(year, month-1, 1);
		week = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i=0; i<dayLbl.length; i++) {
			if(i<week-1) {	// 요일에 맞게 앞에 공백 출력
				dayLbl[i].setText(" ");
			} else if(i>= week-1 && i<week-1+lastday) {
				if(i == 0 || i%7==0) dayLbl[i].setForeground(Color.RED); // 일요일이면 빨간색
				else if(i%7==6) dayLbl[i].setForeground(Color.BLUE); // 토요일이면 파란색
				dayLbl[i].setText((i+1)-(week-1) +"");	// 날짜 출력 - 해당 칸 순서(i)에서 공백만큼 빼기
			} else {
				dayLbl[i].setText(" "); // 나머지 공백 출력
			}
		}
	}
	
	// 버튼 이벤트 발생
	@Override
	public void actionPerformed(ActionEvent e) {
		String evtBtn = (String) e.getActionCommand();
		if(evtBtn.equals("▶")) { // 오른쪽 버튼이면
			if(monthIdx == 11) { // 12월이면
				if(yearIdx == 0) { // 가장 나중 연도면
					yearBox.setSelectedIndex(yearIdx); // 마지막 년월이면 연도, 월 그대로 두기
					monthBox.setSelectedIndex(monthIdx);
				} else {
					yearBox.setSelectedIndex(yearIdx-1); // 12월이면 연도+1 하기
					monthBox.setSelectedIndex(0); // 1월로 넘어가기
				}
			} else {
				monthBox.setSelectedIndex(monthIdx+1); // 월+1 하기
			}
		} else if(evtBtn.equals("◀")) {
			if(monthIdx == 0) { // 1월이면
				if(yearIdx == 59) { // 가장 예전 연도면
					yearBox.setSelectedIndex(yearIdx); // 가장 처음 년월이면 연도, 월 그대로 두기
					monthBox.setSelectedIndex(monthIdx);
				} else {
					yearBox.setSelectedIndex(yearIdx+1); // 1월이면 연도-1 하기
					monthBox.setSelectedIndex(11); // 12월로 넘어가기
				}
			} else {
				monthBox.setSelectedIndex(monthIdx-1); // 월-1하기
			}
		}
	}
	
	// 콤보박스 이벤트 발생
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
		cal.set(year, month-1, 1); // 바뀐 년월로 날짜 세팅
		week = cal.get(Calendar.DAY_OF_WEEK); // 바뀐 년월의 요일 구하기
		lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 바뀐 년월의 마지막날
		printCalendar(); // 날짜 출력 메서드
	}
	
	
	public static void main(String[] args) {
		new CalendarEx();
	}
	
}
