

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import database.CenterDAO;
import database.CenterVO;
import database.LocDAO;
import database.LocVO;

public class Semi_03_2 extends JPanel implements FocusListener, ActionListener{
	/* 진료소 등록 시 기본 생성자로 객체 생성 */
	/* 진료소 수정 시 생성자(진료소코드) 객체 생성 */
	
	JPanel centerPane = new JPanel(new BorderLayout());	// 가운데 정렬 패널
		// 1. 입력창 패널
		JPanel inputPane = new JPanel(null);
			JLabel[] lbl = new JLabel[6];
				String[] colName = {"진료소명", "주소", "대표 전화번호", "평일 운영시간", "토요일 운영시간", "일요일/공휴일 운영시간"};
			JTextField[] tf = new JTextField[6];
			DefaultComboBoxModel<String> model1;
			JComboBox<String> loc1CB, loc2CB;
			JComboBox<String>[] timeCB = new JComboBox[12];
//					t1_openH, t1_openM, t1_closeH, t1_closeM, t2_openH, t2_openM, t2_closeH, t2_closeM, t3_openH, t3_openM, t3_closeH, t3_closeM;
				String[] hour = new String[24];
				String[] minute = new String[12];
			JLabel[] timeLbl = new JLabel[15];
			
			
		// 2. 버튼 패널
		JPanel btnPane = new JPanel(null);			
			JButton cancleBtn = new JButton("취소");
			JButton insertBtn = new JButton("등록");

	// 폰트 // 컬러
	Font fnt1 = new Font("맑은 고딕", Font.BOLD, 16);
	Font fnt2 = new Font("맑은 고딕", Font.BOLD, 14);
	Font fnt3 = new Font("맑은 고딕", Font.PLAIN, 14);
	Color clr1 = new Color(38,80,150); // 파란색

	private int center_code; // 수정 시 진료소 코드 얻어와야 함
	
	// ----- 진료소 등록 시 실행 -----
	public Semi_03_2() {		
		// 주소 콤보박스(시도, 시군구) 기본 세팅
		setDefaultLocCB();
		// 운영시간 콤보박스 기본 세팅
		setDefaultTime();
	
		// 1. 입력창 세팅 // 라벨, 텍스트필드
		for(int i=0; i<lbl.length; i++) {
			lbl[i] = new JLabel(colName[i]);
			tf[i] = new JTextField();
			lbl[i].setFont(fnt2);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			// 삽입 부분 위치 설정
			if(i<=1) {
				lbl[i].setBounds(0,38*i,170,30);
				if(i==0) {
					tf[i].setBounds(174,38*i,290,30);
				} else if(i==1){
					tf[i].setBounds(174,38*(i+1),290,30);
					loc1CB.setBounds(174,38*i,110,30);
					loc2CB.setBounds(294,38*i,170,30);
				}
			} else if(i>=2) {
				lbl[i].setBounds(0,38*(i+1),170,30);
				if(i==2) {
					tf[i].setBounds(174,38*(i+1),290,30);
				} else if(i>=3){
					timeCB[(i-3)*4+0].setBounds(174,38*(i+1),50,30); // 00(시)
					timeLbl[(i-3)*5+0].setBounds(224,38*(i+1),22,30); // 시
					
					timeCB[(i-3)*4+1].setBounds(246,38*(i+1),50,30); // 00(분)
					timeLbl[(i-3)*5+1].setBounds(296,38*(i+1),22,30); // 분
					
					timeLbl[(i-3)*5+4].setBounds(318,38*(i+1),16,30); // ~ // 라벨배열 인덱스 4,9,14번째
					
					timeCB[((i-3)*4)+2].setBounds(334,38*(i+1),50,30); // 00(시)
					timeLbl[(i-3)*5+2].setBounds(384,38*(i+1),22,30); // 시
					
					timeCB[(i-3)*4+3].setBounds(406,38*(i+1),50,30); // 00(분)
					timeLbl[(i-3)*5+3].setBounds(456,38*(i+1),22,30); // 분
					
					inputPane.add(timeCB[(i-3)*4+0]);
					inputPane.add(timeCB[(i-3)*4+1]);
					inputPane.add(timeCB[(i-3)*4+2]);
					inputPane.add(timeCB[(i-3)*4+3]);
					inputPane.add(timeLbl[(i-3)*5+0]);
					inputPane.add(timeLbl[(i-3)*5+1]);
					inputPane.add(timeLbl[(i-3)*5+2]);
					inputPane.add(timeLbl[(i-3)*5+3]);
					inputPane.add(timeLbl[(i-3)*5+4]);
				}
			}
			inputPane.add(lbl[i]);
			inputPane.add(tf[i]);
		}
		
		tf[1].setText("상세주소"); // 상세주소 글씨 미리 세팅
		tf[1].setForeground(Color.GRAY);
		
		loc1CB.setFont(fnt3);
		loc2CB.setFont(fnt3);
		loc1CB.setBackground(Color.WHITE);
		loc2CB.setBackground(Color.WHITE);
		inputPane.add(loc1CB);
		inputPane.add(loc2CB);
		
		
		// 2. 버튼 세팅
		cancleBtn.setFont(fnt1);
		cancleBtn.setForeground(Color.WHITE);
		cancleBtn.setBackground(clr1);
		cancleBtn.setBorderPainted(false);
		cancleBtn.setBounds(90,0,150,40);
		insertBtn.setFont(fnt1);
		insertBtn.setForeground(Color.WHITE);
		insertBtn.setBackground(clr1);
		insertBtn.setBorderPainted(false);
		insertBtn.setBounds(260,0,150,40);
		btnPane.add(cancleBtn);
		btnPane.add(insertBtn);
		btnPane.setPreferredSize(new Dimension(500,40));
		btnPane.setBorder(new EmptyBorder(150,0,0,0));
		
		// 가운데 정렬 패널에 1,2 패널 넣어주기
		centerPane.add(inputPane);
		centerPane.add(btnPane, BorderLayout.SOUTH);
		centerPane.setPreferredSize(new Dimension(500,350)); //500, 350

		add(centerPane);
		setBorder(new EmptyBorder(100,0,0,0));	// 위쪽 여백
		
		// 이벤트 발생 -- 텍스트 필드 "상세주소"란
		tf[1].addFocusListener(this);
		cancleBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		
		// JOptionPane 폰트 설정
		UIManager.put("OptionPane.messageFont", fnt3);
		UIManager.put("OptionPane.buttonFont", fnt2);
	}
	
	// ----- 진료소 수정 시 실행 -----
	public Semi_03_2(int center_code) {
		this();
		this.center_code = center_code;
		
		CenterDAO dao = new CenterDAO();
		CenterVO vo = new CenterVO();
		List<CenterVO> list = dao.selectCenterData(center_code);
		for(int i=0; i<list.size(); i++) {
			vo = list.get(i);
		}
		
		tf[0].setText(vo.getCenter_name());
		selectLocCB(vo.getLoc_code());
		tf[1].setText(vo.getCenter_addr());
		tf[1].setForeground(Color.BLACK);
		tf[2].setText(vo.getCenter_tel());
		tf[3].setText(vo.getCenter_time1());
		tf[4].setText(vo.getCenter_time2());
		tf[5].setText(vo.getCenter_time3());
		
		insertBtn.setText("수정 완료");
	}
	
	
	
	
	// 주소(시도, 시군구) 콤보박스 기본 세팅
	public void setDefaultLocCB(){
		LocDAO dao = new LocDAO();
		Vector<String> list1 = dao.combo1();
		model1 = new DefaultComboBoxModel<String>(list1);
		loc1CB = new JComboBox<String>(model1);
		loc1CB.insertItemAt("시·도", 0);
		loc1CB.setSelectedIndex(0);
		
		loc2CB = new JComboBox<String>();
		loc2CB.addItem("시·군·구");
		
		// loc1 콤보박스 이벤트 발생 등록
		loc1CB.addActionListener(this);
	}
	
	// 시도(loc1) 콤보박스 선택 이벤트 발생 ---> 시군구(loc2) 콤보박스 바뀜
	public void setLoc2CB(){
		LocDAO dao = new LocDAO();
		if(loc1CB.getSelectedItem().equals("시·도")) {
			loc2CB.removeAllItems();
			loc2CB.addItem("시·군·구");
		} else {
			Vector<String> list2 = dao.combo2((String)loc1CB.getSelectedItem());
			DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>(list2);
			loc2CB.setModel(model2);
		}
		loc2CB.updateUI();	// loc2 (시군구) 콤보박스 내용 업데이트
	}
	
	// 진료소 수정시 --- 해당 진료소 시도/시군구 정보 세팅하기
	public void selectLocCB(int loc_code) {
		LocDAO dao = new LocDAO();
		LocVO vo = new LocVO();
		Vector<LocVO> list = dao.selectLoc(loc_code);	//
		
		for(int i=0; i<list.size(); i++) {
			vo = list.get(i);
		}
		loc1CB.setSelectedItem(vo.getLoc1()); // loc1(시도) 선택값 기본 설정
		loc2CB.setSelectedItem(vo.getLoc2()); // loc2(시군구) 선택값 기본 설정
		
		// loc1 콤보박스 이벤트 발생 등록
		loc1CB.addActionListener(this);
	}
	
	
	
	// 운영시간 콤보박스 기본세팅
	public void setDefaultTime(){
		
		for(int i=0; i<hour.length; i++) {
			hour[i]=i+"";
		}
		
		for(int i=0; i<minute.length; i++) {
			minute[i]=(i*5)+"";
		}
		
		// 시/분 콤보박스
		for(int i=0; i<timeCB.length; i++) {
			if(i%2==0) timeCB[i] = new JComboBox<String>(hour);
			else timeCB[i] = new JComboBox<String>(minute);
			
			timeCB[i].setFont(fnt3);
			timeCB[i].setBackground(Color.WHITE);
		}
		
		// 시/분 라벨
		for(int i=0; i<timeLbl.length; i++) {
			if(i%5==4) timeLbl[i] = new JLabel("~");
			else if(i%2==0) timeLbl[i] = new JLabel("시");
			else timeLbl[i] = new JLabel("분");
			
			timeLbl[i].setFont(fnt3);
		}
	}
	
	
	// 입력된 진료소 정보 CenterVO에 저장하기 ---> 등록, 수정 메서드에 공통 실행
	public CenterVO setCenterVO() {
		LocDAO ldao = new LocDAO();
		CenterVO cvo = new CenterVO();
		CenterDAO cdao = new CenterDAO();
		
		String loc1 = (String)loc1CB.getSelectedItem();
		String loc2 = (String)loc2CB.getSelectedItem();
		int loc_code = ldao.getLocCode(loc1, loc2); // 선택된 시도/시군구 정보로 주소 코드 얻어오기
		
		cvo.setCenter_name(tf[0].getText());
		cvo.setLoc_code(loc_code);
		cvo.setCenter_addr(tf[1].getText());
		cvo.setCenter_tel(tf[2].getText());
		cvo.setCenter_time1(tf[3].getText());
		cvo.setCenter_time2(tf[4].getText());
		cvo.setCenter_time3(tf[5].getText());
		
		return cvo;
	}
	
	// 진료소 등록 ----> 등록 버튼 이벤트
	public void insertCenter() {
		CenterVO cvo = setCenterVO(); // 등록은 center_code 시퀀스 자동 등록이라 필요 없음
		CenterDAO cdao = new CenterDAO();
		
		int cnt = cdao.insertCenterData(cvo);
		if(cnt>0) {
			JOptionPane.showMessageDialog(this, "진료소 정보가 등록되었습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "진료소 정보 등록을 실패했습니다. 다시 시도해 주세요.");
		}
	}
	
	
	// 진료소 수정 ----> 수정 완료 버튼 이벤트
	public void updateCenter() {
		CenterVO cvo = setCenterVO();
		CenterDAO cdao = new CenterDAO();
		
		cvo.setCenter_code(center_code);	// 수정은 기존 center_code 필요함
		
		int cnt = cdao.updateCenterData(cvo);
		if(cnt>0) {
			JOptionPane.showMessageDialog(this, "진료소 정보 수정이 완료되었습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "진료소 정보 수정을 실패했습니다. 다시 시도해 주세요.");
		}
	}
	
	
	// 콤보박스 선택 이벤트
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		String evtStr = e.getActionCommand();
		if(evt instanceof JComboBox) {
			setLoc2CB();
		} else if(evt instanceof JButton) {
			if(evtStr.equals("등록")) {
				insertCenter();
				/////////////////////////////////////// 등록 JOptionPane에서 확인 누르면 화면 전환
			} else if(evtStr.equals("수정 완료")) {
				updateCenter();
				/////////////////////////////////////// 수정 완료 JOptionPane에서 확인 누르면 화면 전환
			} else if(evtStr.equals("취소")) {
				/////////////////////////////////////// 취소 버튼 누르면 화면 전환
			}
		}
		
	}
	
	// 상세주소란 포커스 시 이벤트
	public void focusGained(FocusEvent e) {
		if(tf[1].getText().equals("상세주소")) {
			tf[1].setText("");
			tf[1].setForeground(Color.BLACK);
		}
	}

	// 상세주소란 포커스 해제 시 이벤트
	public void focusLost(FocusEvent e) {
		if(tf[1].getText()==null || tf[1].getText().equals("")) {
			tf[1].setText("상세주소");
			tf[1].setForeground(Color.GRAY);
		}
	}

}
