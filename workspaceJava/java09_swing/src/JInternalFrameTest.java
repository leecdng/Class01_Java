import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class JInternalFrameTest extends JFrame implements ActionListener {
	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2, if3;
	
	ImageIcon openIcon = new ImageIcon("img/open01.gif");
	ImageIcon saveIcon = new ImageIcon("img/save01.gif");
	
	JToolBar tb = new JToolBar();
		JButton openBtn = new JButton(openIcon);
		JButton saveBtn = new JButton(saveIcon);
		JButton foreColor = new JButton("글자색");
		
	// 글꼴
	JToggleButton boldBtn = new JToggleButton("A"); // 진하게
	JToggleButton italicBtn = new JToggleButton("A"); // 기울림꼴 
	JComboBox<String> fontCombo = new JComboBox<String>();
	JComboBox<Integer> sizeCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<String> fontModel; // = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
	
	int bold = 0;
	int italic = 0;
	
	
	// 달력 불러오기
	JButton calBtn = new JButton("달력");
	
	public JInternalFrameTest() {
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator(); // 이거 뭐하는 애지????????
		tb.add(foreColor);
		
		// 글꼴 관련 메뉴
		boldBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		italicBtn.setFont(new Font("맑은 고딕", Font.ITALIC, 16));
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		// 굴꼴 ㅣ 윈도우 운영체제에서 지원하는 글꼴을 이용하여 콤보박스 만들기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = ge.getAvailableFontFamilyNames();
		fontModel = new DefaultComboBoxModel<String>(fontName);
		fontCombo.setModel(fontModel);
		fontCombo.setSelectedItem("맑은 고딕");
		tb.add(fontCombo);
		
		// 글자 크기
		for(int size=8; size<100; size+=2) {
			sizeModel.addElement(size);
		}
		sizeCombo.setModel(sizeModel);
		sizeCombo.setSelectedItem(12);
		tb.add(sizeCombo);
		
		
		add(BorderLayout.NORTH, tb);
		
		add(dp); // 데탑패널 넣으면 바탕색 하얗게 변함
		
		if1 = new JInternalFrame(); // 창크기조절, 최소화, 최대화, 아이콘화 모두 불가
		if1.setSize(300,200);
		if1.setVisible(true);
		//if1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dp.add(if1);
		
		if2 = new JInternalFrame("메모장", true); // 창크기 조절 가능
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(100,200, 500,400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("계산기", true, true, true, true);
		if3.add(new CalculatorEx2());
		if3.setSize(400,350);
		dp.add(if3);
		// 계산기 프레임 활성화시키기
		try {
			if3.setSelected(true);
		} catch(Exception e) {
			
		}
		if3.setVisible(true);
		
		tb.add(calBtn);

		
		setSize(1200, 1000);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		foreColor.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontCombo.addActionListener(this);
		sizeCombo.addActionListener(this);
		calBtn.addActionListener(this);
		
		
		JInternalFrameTest ift = this;
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				JOptionPane op = new JOptionPane();
				int que = op.showConfirmDialog(ift, "저장하시겠습니까?", "저장 확인", JOptionPane.YES_NO_CANCEL_OPTION);
				if(que == JOptionPane.YES_OPTION) { //Yes = 0
					// 저장 후 종료
					fileSave();
					dispose(); // 자원 제거
					System.exit(0);
				} else if(que == JOptionPane.NO_OPTION) { // No = 1
					// 종료
					dispose(); // 자원 제거
					System.exit(0);
				} else if(que == JOptionPane.CANCEL_OPTION){ // Cancle = 2
					// 아무 일도 안 함
				}
			}
		});
	};

	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event instanceof JButton) {
			if(event == openBtn) {
				fileOpen();
			} else if(event == saveBtn) {
				fileSave();
			} else if(event == foreColor) {
				setFontFore();
			} else if(event == calBtn) {
				getCalendarDialog();
			}
		} else if (event instanceof JToggleButton) {
			if(event == boldBtn) {
				if(boldBtn.isSelected()) {
					// 진하게 버튼이 선택되었을 때
					bold = 1; // BOLD로 바꿔줌
				} else {
					// 진하게 버튼이 선택 해제되었을 때
					bold = 0; // PLAIN으로 바꿔줌
				}
				fontSetting();
			} else if(event == italicBtn) {
				if(italicBtn.isSelected()) {
					italic = 2;
				} else {
					italic = 0;
				}
				fontSetting();
			}
		} else if(event instanceof JComboBox) {
			if(event == fontCombo || event == sizeCombo) {
				fontSetting();
			}
		}
		
	}
	
	public void getCalendarDialog() {
		SwingCalendar2 cal = new SwingCalendar2();
		// borderLayout이 기본 레이아웃임
		JDialog dialog = new JDialog(this, "달력", true); // (부모프레임객체, , 모달: 뒤에 비활성화할 거면 true);
		dialog.add(cal);
		dialog.setSize(400,350);
		dialog.setVisible(true);
		
	}
	
	public void fontSetting() {
		// DeskTop에서 선택된 JInternalFrame을 구한 후 JTextArea 얻어오기
		JInternalFrame activeIf = dp.getSelectedFrame();
		JTextArea ta = (JTextArea) activeIf.getFocusOwner();
		
		ta.setFont(new Font((String)fontCombo.getSelectedItem(),bold+italic,(Integer)sizeCombo.getSelectedItem()));  
	}
	
	
	public void setFontFore() {
		JColorChooser cc = new JColorChooser(Color.GREEN);
		Color selectColor = cc.showDialog(this, "글자색", Color.MAGENTA);
		
		JInternalFrame selectIf = dp.getSelectedFrame();
		JTextArea ta = (JTextArea) selectIf.getFocusOwner();
		ta.setForeground(selectColor);
	}
	
	// 파일 저장
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(this)==0) {
			try {
				File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f);
				// 현재 선택된 Frame 얻어오기
				JInternalFrame selectIf = dp.getSelectedFrame();
				JTextArea eventTa= (JTextArea) selectIf.getFocusOwner();
				
				fw.write(eventTa.getText());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	// 파일 열기
	public void fileOpen() {
		JFileChooser fc = new JFileChooser();
		// 0:열기 , 1: 취소
		if(fc.showOpenDialog(this)==0){ // 열기면
			// 선택한 파일 객체 얻어오기
			File f = fc.getSelectedFile();
			JTextArea ta = new JTextArea();
			
			try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String readData = br.readLine();
				if(readData == null) break;
				ta.append(readData+"\n");
			}
			JScrollPane sp2 = new JScrollPane(ta);
			JInternalFrame if5 = new JInternalFrame(f.getPath(), true, true, true, true);
			if5.add(sp2);
			dp.add(if5);
			
			if5.setSize(500,500);
			if5.setSelected(true); // 얘는 setVisible 전에, if5를 패널에 추가하기 전에 설정해야 함.
			if5.setVisible(true);
			
			} catch(Exception e) {
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		new JInternalFrameTest();

	}

}
