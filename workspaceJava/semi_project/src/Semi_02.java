

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Semi_02 extends JPanel implements FocusListener{
	JPanel centerPane = new JPanel(new BorderLayout());	// 가운데 정렬 패널
		// 1. 입력창 패널
		JPanel inputPane = new JPanel(null);
			JLabel[] lbl = new JLabel[6];
				String[] colName = {"진료소명", "주소", "대표 전화번호", "평일 운영시간", "토요일 운영시간", "일요일/공휴일 운영시간"};
			JTextField[] tf = new JTextField[6];
			DefaultComboBoxModel<String> model1;
			JComboBox<String> loc1CB;
			DefaultComboBoxModel<String> model2;
			JComboBox<String> loc2CB;
		// 2. 버튼 패널
		JPanel btnPane = new JPanel(null);			
			JButton cancleBtn = new JButton("취소");
			JButton insertBtn = new JButton("등록");

	// 폰트 // 컬러
	Font fnt1 = new Font("맑은 고딕", Font.BOLD, 16);
	Font fnt2 = new Font("맑은 고딕", Font.BOLD, 14);
	Font fnt3 = new Font("맑은 고딕", Font.PLAIN, 14);
	Color clr1 = new Color(38,80,150); // 파란색
				
	public Semi_02() {		
		// 시구/시군구 ----- 콤보박스에 값 넣어주기
		model1 = new DefaultComboBoxModel<String>();
		model2 = new DefaultComboBoxModel<String>();
		model1.addElement("시도");
		model2.addElement("시군구");
		loc1CB = new JComboBox<String>(model1);
		loc2CB = new JComboBox<String>(model2);
		
		
		// 1. 입력창 세팅 // 라벨, 텍스트필드
		for(int i=0; i<lbl.length; i++) {
			lbl[i] = new JLabel(colName[i]);
			tf[i] = new JTextField();
			lbl[i].setFont(fnt2);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			// 삽입 부분 위치 설정
			if(i<=1) {
				if(i==1) {
					lbl[i].setBounds(0,38*i,170,30);
					tf[i].setBounds(174,38*(i+1),290,30);
					
					loc1CB.setBounds(174,38*i,110,30);
					loc2CB.setBounds(294,38*i,170,30);
				} else {
					lbl[i].setBounds(0,38*i,170,30);
					tf[i].setBounds(174,38*i,290,30);
				}
			} else if(i>=2) {
				lbl[i].setBounds(0,38*(i+1),170,30);
				tf[i].setBounds(174,38*(i+1),290,30);
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
		centerPane.setPreferredSize(new Dimension(500,350));

		add(centerPane);
		setBorder(new EmptyBorder(100,0,0,0));	// 위쪽 여백
		
		// 이벤트 발생 -- 텍스트 필드 "상세주소"란
		tf[1].addFocusListener(this);
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
