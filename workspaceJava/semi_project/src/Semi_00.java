

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Semi_00 extends JPanel implements ActionListener{
	/* 미구현 상태 -> 공지사항 텍스트가 화면이 바뀌어도 저장되어야 하고, 관리자페이지든 일반회원페이지든 바뀐 내용이 적용되어야 합니다. */
	
	JLabel mainTitle = new JLabel();
		Font mainFnt = new Font("맑은 고딕", Font.BOLD, 38);
		
	JPanel notice1 = new JPanel(new BorderLayout());
		JLabel lbl1 = new JLabel("확진자 현황");
		
	JPanel notice2 = new JPanel(new BorderLayout());
		JEditorPane subPane = new JEditorPane();
			String txt1;
		JEditorPane txtPane = new JEditorPane();
			String txt2;
		JPanel editPane = new JPanel(new GridLayout(1, 1, 10, 0));
			JButton cancleBtn = new JButton("취소");
			JButton editBtn = new JButton();
		
		// 폰트 // 컬러
		Font fnt1 = new Font("맑은 고딕", Font.BOLD, 20);
		Font fnt2 = new Font("맑은 고딕", Font.PLAIN, 14);
		Font fnt3 = new Font("맑은 고딕", Font.BOLD, 14);
		Color clr1 = new Color(38,80,150); // 파란색
	
	public Semi_00() {
		setLayout(null);
		setBackground(Color.WHITE);

		// 타이틀
		mainTitle.setText("코로나 검사/백신 예약 시스템");
		mainTitle.setFont(mainFnt);
		mainTitle.setBounds(0, 50, 950, 50);
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		
		
		// 확진자 현황		
		lbl1.setFont(fnt1); // 서브타이틀
		lbl1.setForeground(Color.WHITE);
		
		notice1.setBorder(new EmptyBorder(20,20,20,20)); // 패널 안에 여백 //북서남동 순서
		notice1.setBackground(Color.DARK_GRAY);
		notice1.setBounds(160, 150, 320, 400);
		
		notice1.add(lbl1, BorderLayout.NORTH);
		
		
		// 공지사항 (사전예약 기간 안내)
		txt1 = "사전예약 기간 안내";
		txt2 = "<55~59세 연령층>\n- (예약기간) 7.14(수) 20~ 7.24(토) 18시\n- (접종기간) 7.26(월)~8.14(토)";
		
		subPane.setFont(fnt1); // 서브타이틀 폰트
		txtPane.setFont(fnt2); // 본문 폰트
		txtPane.setBorder(new EmptyBorder(10,0,0,0)); // 패널 안에 여백 //북서남동 순서
		
		setNotice2(); // 서브타이틀, 본문 내용 세팅
		setDefaultEditBtn(); // 수정 버튼 세팅 - <관리자용>에서만 필요함
		
		notice2.setBorder(new EmptyBorder(20,20,20,20)); // 패널 안에 여백 //북서남동 순서
		notice2.setBackground(clr1);
		notice2.setBounds(500, 150, 320, 400);
		
		notice2.add(subPane, BorderLayout.NORTH);
		notice2.add(txtPane, BorderLayout.CENTER);
		notice2.add(editPane, BorderLayout.SOUTH);
		
		// 전체 세팅
		add(mainTitle);
		add(notice1); add(notice2);
		
		editBtn.addActionListener(this); // 수정하기, 수정완료 이벤트 발생
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String evtTxt = ae.getActionCommand();
		if(evtTxt.equals("수정하기")) {
			editNotice();
		} else if(evtTxt.equals("수정완료")) {
			editCheck();
		} else if(evtTxt.equals("취소")) {
			editCancle();
		}
	}
	
	// 공지사항 서브타이틀, 본문 세팅
	public void setNotice2() {
		subPane.setText(txt1);
		subPane.setForeground(Color.YELLOW);
		subPane.setOpaque(false);  // 본문 패널 투명하게
		subPane.setFocusable(false); // 수정 비활성화
		
		txtPane.setText(txt2);
		txtPane.setForeground(Color.WHITE);
		txtPane.setOpaque(false); // 본문 패널 투명하게
		txtPane.setFocusable(false); // 수정 비활성화
	}
	
	// 수정 버튼 세팅
	public void setDefaultEditBtn() {
		editBtn.setFont(fnt3);
		editBtn.setText("수정하기");
		editBtn.setForeground(clr1);
		editBtn.setBackground(Color.WHITE);
		editPane.setOpaque(false); // 버튼 패널 투명하게
		editPane.add(editBtn);
	}
	
	// 수정하기 버튼 누르면 실행
	public void editNotice() {
		txt1 = subPane.getText(); // 수정 전 서브타이틀 텍스트 담아두기
		subPane.setOpaque(true);
		subPane.setForeground(Color.BLACK);
		subPane.setBackground(new Color(225, 225, 225));
		subPane.setFocusable(true);
		
		txt2 = txtPane.getText(); // 수정 전 본문 텍스트 담아두기
		txtPane.setOpaque(true);
		txtPane.setForeground(Color.BLACK);
		txtPane.setBackground(new Color(225, 225, 225));
		txtPane.setFocusable(true);
		
		cancleBtn.setFont(fnt3);
		cancleBtn.setForeground(clr1);
		cancleBtn.setBackground(Color.WHITE);
		editPane.add(cancleBtn);
		editBtn.setText("수정완료");
		
		cancleBtn.addActionListener(this);	// 취소 버튼 이벤트 발생
	}

	// 수정완료 버튼 누르면 실행
	public void editCheck() {
		txt1 = subPane.getText(); // 수정된 서브타이틀 텍스트 담기
		txt2 = txtPane.getText(); // 수정된 본문 텍스트 담기
		editPane.remove(cancleBtn); // 취소 버튼 없애기
		setNotice2(); // 공지사항 서브타이틀, 본문 세팅
		setDefaultEditBtn(); //수정 버튼 세팅
	}
	
	// 취소 버튼 누르면 실행
	public void editCancle() {
		editPane.remove(cancleBtn); // 취소 버튼 없애기
		setNotice2(); // 공지사항 서브타이틀, 본문 세팅 --> 수정 전 텍스트들도 다시 세팅됨
		setDefaultEditBtn(); //수정 버튼 세팅
	}
}
