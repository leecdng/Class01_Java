

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Semi_01 extends JPanel implements ActionListener{
	Calendar now = Calendar.getInstance();
	int nowYear = now.get(Calendar.YEAR); // nowYear는 yearArr 생성하기 위함
	int nowDay = now.get(Calendar.DAY_OF_MONTH); // 예약 비활성화 기준을 위함
	int nowMonth = now.get(Calendar.MONTH)+1;
	int year = nowYear; int month = nowMonth;// year와 month로 콤보박스 셀렉트값 설정
	int lastday; int week;
	// 날짜 선택
	JPanel pane1 = new JPanel(new BorderLayout());
		JPanel dateTopPane = new JPanel(new BorderLayout());
			JLabel dateLbl = new JLabel("날짜 선택", JLabel.LEFT);
		JPanel datePane = new JPanel(new BorderLayout());
			JPanel ymPane = new JPanel();
				Integer[] yearArr = {nowYear-1, nowYear, nowYear+1};
				Integer[] monthArr = {1,2,3,4,5,6,7,8,9,10,11,12};
				JComboBox<Integer> yearCB = new JComboBox<Integer>(yearArr);
				JComboBox<Integer> monthCB = new JComboBox<Integer>(monthArr);
				JButton leftBtn = new JButton("<");
				JButton rightBtn = new JButton(">");
			JPanel dPane = new JPanel(new BorderLayout());
				JPanel weekPane = new JPanel(new GridLayout(1, 7));
					String weekStr = "일월화수목금토";
				JPanel dayPane = new JPanel(new GridLayout(0, 7));
					JButton[] dayBtn = new JButton[38];
	// 시간 선택
	JPanel pane2 = new JPanel(new BorderLayout());
		JPanel timeTopPane = new JPanel(new BorderLayout());
			JLabel timeLbl = new JLabel("시간 선택", JLabel.LEFT);
		JPanel timePane = new JPanel();
			JButton[] timeBtn = new JButton[10];;
			JLabel timeTxt = new JLabel("예약할 날짜를 선택해주세요.");
		
	// 안내문구 + 취소/예약완료 버튼
	JPanel pane3 = new JPanel(new BorderLayout());
		JEditorPane rsvTxt = new JEditorPane();
			String rsvDate = "";
			String rsvTime= "";
		JPanel btnPane = new JPanel();
			JButton calcleBtn = new JButton("취소");
			JButton rsvBtn = new JButton("예약완료");
	
	// 폰트 // 컬러
	Font fnt1 = new Font("맑은 고딕", Font.BOLD, 16);
	Font fnt2 = new Font("맑은 고딕", Font.BOLD, 14);
	Color clr1 = new Color(38,80,150); // 파란색
			
	public Semi_01() {		
		setLayout(null);
//		setBackground(Color.WHITE);
		
		// ----- pane1 ------ 날짜 선택 패널
		dateLbl.setFont(fnt1);
		dateTopPane.add(dateLbl);
		dateTopPane.setBorder(new EmptyBorder(10,10,10,0)); // 여백 북서남동 순서
		dateTopPane.setOpaque(false);
		//dateTopPane.setBackground(Color.WHITE); //
		
		leftBtn.setFont(fnt2);
		leftBtn.setBackground(Color.WHITE);
		leftBtn.setBorderPainted(false);
		rightBtn.setFont(fnt2);
		rightBtn.setBackground(Color.WHITE);
		rightBtn.setBorderPainted(false);
		yearCB.setSelectedItem(year);
		yearCB.setFont(fnt1);
		yearCB.setBackground(Color.WHITE);
		monthCB.setSelectedItem(month);
		monthCB.setFont(fnt1);
		monthCB.setBackground(Color.WHITE);
		
		ymPane.add(leftBtn);
		ymPane.add(yearCB);
		ymPane.add(monthCB);
		ymPane.add(rightBtn);
		ymPane.setBackground(Color.WHITE); //
		
		setWeek(); // 요일 세팅
		setDefaultDate(); // 날짜 세팅
		
		weekPane.setBackground(Color.WHITE);
		dayPane.setBackground(Color.WHITE);
		dPane.add(weekPane, BorderLayout.NORTH);
		dPane.add(dayPane);
		
		datePane.add(ymPane, BorderLayout.NORTH);
		datePane.add(dPane);
		
		pane1.add(dateTopPane, BorderLayout.NORTH);
		pane1.add(datePane);
		
		pane1.setBounds(300, 20, 400, 290);
		pane1.setBackground(Color.WHITE); //
		
		// ----- pane2 ------ 시간 선택 패널
		timeLbl.setFont(fnt1);
		timeTopPane.setBorder(new EmptyBorder(10,10,10,0)); // 여백 북서남동 순서
		timeTopPane.setBackground(Color.WHITE);
		timeTopPane.add(timeLbl);
		setDefaultTimeBtn(); // 시간 버튼 세팅
		timePane.setBorder(new EmptyBorder(10,10,10,10)); // 여백 북서남동 순서
		timePane.setBackground(Color.WHITE);
		pane2.add(timeTopPane, BorderLayout.NORTH);
		pane2.add(timePane, BorderLayout.CENTER);
		pane2.setBounds(300, 330, 400, 140);
		
		// ----- pane3 ------ 안내 텍스트 + 취소/예약완료 패널
		rsvTxt.setText("예약 날짜와 시간을 선택해 주세요.");
		rsvTxt.setFont(fnt2);
		rsvTxt.setOpaque(false);
		rsvTxt.setAlignmentX(JEditorPane.CENTER_ALIGNMENT);
		rsvTxt.setFocusable(false);
		rsvTxt.setBorder(new EmptyBorder(10,10,10,10));
		calcleBtn.setFont(fnt1);
		calcleBtn.setForeground(Color.WHITE);
		calcleBtn.setBackground(clr1);
		calcleBtn.setBorderPainted(false);
		rsvBtn.setFont(fnt1);
		rsvBtn.setForeground(Color.WHITE);
		rsvBtn.setBackground(clr1);
		rsvBtn.setBorderPainted(false);
		btnPane.add(calcleBtn);	btnPane.add(rsvBtn);
		pane3.add(rsvTxt);
		pane3.add(btnPane, BorderLayout.SOUTH);
		pane3.setBounds(300, 480, 400, 110);
		
		add(pane1);
		add(pane2);
		add(pane3);
		
		// 이벤트 발생 등록
		yearCB.addActionListener(this);
		monthCB.addActionListener(this);
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		calcleBtn.addActionListener(this);
		rsvBtn.addActionListener(this);
	}
	
	// 요일 세팅
	public void setWeek() {
		for(int i=0; i<weekStr.length(); i++) {
			JLabel weekLbl = new JLabel(weekStr.substring(i, i+1));
			if(i==0) weekLbl.setForeground(Color.RED);
			if(i==6) weekLbl.setForeground(Color.BLUE);
			weekLbl.setFont(fnt1);
			weekLbl.setHorizontalAlignment(JLabel.CENTER);
			weekPane.add(weekLbl);
		}
	}
	
	// 현재 날짜 세팅
	public void setDefaultDate() {
		now.set(year, month-1, 1);
		week = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DAY_OF_MONTH);

		for(int i=0; i<dayBtn.length; i++) {
			if(i<week-1) {	// 공백
				dayBtn[i] = new JButton("");
				dayBtn[i].setBackground(Color.WHITE);
				dayBtn[i].setBorderPainted(false);
				dayBtn[i].setEnabled(false);
				dayPane.add(dayBtn[i]);
			} else if(i<lastday+week-1) { // 날짜 버튼
				dayBtn[i] = new JButton((i+1)-(week-1)+"");
				
				if((i+1)%7==1) dayBtn[i].setForeground(Color.RED);
				else if((i+1)%7==0) dayBtn[i].setForeground(Color.BLUE);
				dayBtn[i].setFont(fnt1);
				dayBtn[i].setHorizontalAlignment(JLabel.CENTER);
				dayBtn[i].setBackground(Color.WHITE);
				dayBtn[i].setBorderPainted(false);
				// 이전 날짜 비활성화
				if(year<nowYear || (year==nowYear && month<nowMonth)) {
					dayBtn[i].setEnabled(false);
				} else if(year==nowYear && month==nowMonth) {
					if((i+1)-(week-1) < nowDay+1) dayBtn[i].setEnabled(false);	// 현재 기준 다음날부터 예약 가능
				}
				// 버튼 등록 + 이벤트 등록
				dayBtn[i].addActionListener(this);
				dayPane.add(dayBtn[i]);
			} else { // 삽입 안 하고 생성만 한 버튼 // 배열값 오류 때문에 나머지 버튼 생성만 함. dayPane에는 안 넣었음
				dayBtn[i] = new JButton(""); 
			}
		}
	}
	
	// 이벤트 발생 후 날짜 세팅
	public void setDate() {
		dayPane.removeAll();
		dayPane.setVisible(false);
		setDefaultDate();
		dayPane.setVisible(true);
	}
	
	// 이전 버튼 눌렀을 때
	public void setPrev() {
		int yearIdx = (Integer) yearCB.getSelectedItem();
		int monthIdx = (Integer) monthCB.getSelectedItem();
		if(monthIdx==1) {
			yearCB.setSelectedItem(yearIdx-1);
			monthCB.setSelectedItem(12);
			if(yearIdx==nowYear-1) {
				yearCB.setSelectedItem(yearIdx);
				monthCB.setSelectedItem(monthIdx);
			}
		} else {
			monthCB.setSelectedItem(monthIdx-1);
		}
	}
	
	// 다음 버튼 눌렀을 때
	public void setNext() {
		int yearIdx = (Integer) yearCB.getSelectedItem();
		int monthIdx = (Integer) monthCB.getSelectedItem();
		if(monthIdx==12) {
			yearCB.setSelectedItem(yearIdx+1);
			monthCB.setSelectedItem(1);
			if(yearIdx==nowYear+1) {
				yearCB.setSelectedItem(yearIdx);
				monthCB.setSelectedItem(monthIdx);
			}
		} else {
			monthCB.setSelectedItem(monthIdx+1);
		}
	}
	
	// 처음 시간 선택 설정 --- 날짜 선택하라는 안내 메세지
	public void setDefaultTimeBtn() {
		timeTxt.setFont(fnt2);
		timePane.add(timeTxt);
	}
	
	// 날짜 선택 후 시간 선택 세팅
	public void setTimeBtn() {
		timePane.removeAll();
		timePane.setVisible(false);
		timePane.setLayout(new GridLayout(0, 5, 12, 12));	// 5열 // 간격 위아래 12
		
		String timeStr = "09:00 ~ 16:00";	/////////////////////////// 운영시간 텍스트 정보 가져와야 함
		
		if(!timeStr.equals("미운영")) {
			int openTime = Integer.parseInt(timeStr.substring(0,2));
			int closeTime = Integer.parseInt(timeStr.substring(8,10));
			for(int i=0; i<10; i++) {
				timeBtn[i] = new JButton(i+openTime+":00");	// 버튼 10개만 생성
				if(i<closeTime-openTime) {	// 운영시간 버튼 10개보다 적게 나오면 그만큼만 패널에 삽입하기
					timeBtn[i].setFont(fnt2);
					timeBtn[i].setBorder(new LineBorder(Color.GRAY, 1));
					timeBtn[i].setBackground(new Color(255,255,255)); // 버튼 비활성화 시 주석 처리
					// 시간 버튼 비활성화 시 아래 주석 내용 사용
//					timeBtn[i].setBackground(new Color(220,220,220));
//					timeBtn.setBorderPainted(false);
//					timeBtn.setEnabled(false);
					timeBtn[i].addActionListener(this);
					timePane.add(timeBtn[i]);
				}
			} // for
		}
		timePane.setVisible(true);
	}
	
	// 날짜 선택하면 실행
	public void selectDate() {
		for(int i=0; i<dayBtn.length; i++) {	// 선택 안 된 나머지 버튼 색상 원래대로 돌려놓기
			if((i+1)%7==1) dayBtn[i].setForeground(Color.RED);
			else if((i+1)%7==0) dayBtn[i].setForeground(Color.BLUE);
			else dayBtn[i].setForeground(Color.BLACK);
			dayBtn[i].setBackground(Color.WHITE);
		}
		setTimeBtn();	// 시간 버튼 생성
		rsvTxt.setText("예약 시간을 선택해 주세요.");
	}
	
	// 시간 선택하면 실행
	public void selectTime() {
		for(int i=0; i<timeBtn.length; i++) {	// 선택 안 된 나머지 버튼 색상 원래대로 돌려놓기
			timeBtn[i].setForeground(Color.BLACK);
			timeBtn[i].setBackground(Color.WHITE);
			timeBtn[i].setBorderPainted(true);
		}
		String rsvPlace = "강남구 보건소"; /////////////////////////////////////// 진료소명 값 받아와야 함.
		String rsvVacc = "아스트라제네카"; /////////////////////////////////////// 백신 종류 값 받아와야 함
		// 검사 예약일 경우
		//rsvTxt.setText(year+"년 "+month+"월"+rsvDate+"일 "+rsvTime+"에 "+rsvPlace+"에서 코로나 검사 예정입니다.");
		// 백신 예약일 경우
		rsvTxt.setText(year+"년 "+month+"월"+rsvDate+"일 "+rsvTime+"에 "+rsvPlace+"에서 "+rsvVacc+" 백신 예방 접종 예정입니다.");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object evt = ae.getSource();
		String evtStr = ae.getActionCommand();
		if(evt instanceof JComboBox) {	// 콤보박스 이벤트가 발생하면
			year = (Integer)yearCB.getSelectedItem();
			month = (Integer)monthCB.getSelectedItem();
			setDate();	// 캘린더 재설정
		} else if(evt instanceof JButton) {	// 버튼 이벤트가 발생하면
			JButton evtBtn = (JButton) ae.getSource();
			if(evt==leftBtn) {	// < 캘린더 이전 버튼
				setPrev();
			} else if(evt==rightBtn) {	// > 캘린더 다음 버튼
				setNext();
			} else if(evtStr.equals("취소")) {//////////////////////////////////// 취소 버튼 눌렀을 때
				//
			} else if(evtStr.equals("예약완료")) {////////////////////////////////// 예약 완료 버튼 눌렀을 때
				// 
			} else if(evtStr.indexOf(":")!=-1){ // 시간 선택하면
				rsvTime = evtStr;	// 선택된 시간을 저장
				selectTime();	// 시간 선택 메서드
				evtBtn.setForeground(Color.WHITE);	// 선택된 시간 버튼 색 변경
				evtBtn.setBackground(clr1);
				evtBtn.setBorderPainted(false);
			} else {	// 날짜 선택하면
				rsvDate = evtStr; // 선택된 날짜(일)를 저장
				selectDate();	// 날짜 선택 메서드
				evtBtn.setForeground(Color.WHITE);	// 선택된 날짜 버튼 색 변경
				evtBtn.setBackground(clr1);
			}
		}
	}
}
