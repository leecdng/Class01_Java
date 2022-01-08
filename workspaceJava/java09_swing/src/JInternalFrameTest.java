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
		JButton foreColor = new JButton("���ڻ�");
		
	// �۲�
	JToggleButton boldBtn = new JToggleButton("A"); // ���ϰ�
	JToggleButton italicBtn = new JToggleButton("A"); // ��︲�� 
	JComboBox<String> fontCombo = new JComboBox<String>();
	JComboBox<Integer> sizeCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<String> fontModel; // = new DefaultComboBoxModel<String>();
	DefaultComboBoxModel<Integer> sizeModel = new DefaultComboBoxModel<Integer>();
	
	int bold = 0;
	int italic = 0;
	
	
	// �޷� �ҷ�����
	JButton calBtn = new JButton("�޷�");
	
	public JInternalFrameTest() {
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator(); // �̰� ���ϴ� ����????????
		tb.add(foreColor);
		
		// �۲� ���� �޴�
		boldBtn.setFont(new Font("���� ���", Font.BOLD, 16));
		italicBtn.setFont(new Font("���� ���", Font.ITALIC, 16));
		tb.add(boldBtn);
		tb.add(italicBtn);
		
		// ���� �� ������ �ü������ �����ϴ� �۲��� �̿��Ͽ� �޺��ڽ� �����
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = ge.getAvailableFontFamilyNames();
		fontModel = new DefaultComboBoxModel<String>(fontName);
		fontCombo.setModel(fontModel);
		fontCombo.setSelectedItem("���� ���");
		tb.add(fontCombo);
		
		// ���� ũ��
		for(int size=8; size<100; size+=2) {
			sizeModel.addElement(size);
		}
		sizeCombo.setModel(sizeModel);
		sizeCombo.setSelectedItem(12);
		tb.add(sizeCombo);
		
		
		add(BorderLayout.NORTH, tb);
		
		add(dp); // ��ž�г� ������ ������ �Ͼ�� ����
		
		if1 = new JInternalFrame(); // âũ������, �ּ�ȭ, �ִ�ȭ, ������ȭ ��� �Ұ�
		if1.setSize(300,200);
		if1.setVisible(true);
		//if1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dp.add(if1);
		
		if2 = new JInternalFrame("�޸���", true); // âũ�� ���� ����
		if2.add(new JScrollPane(new JTextArea()));
		if2.setBounds(100,200, 500,400);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("����", true, true, true, true);
		if3.add(new CalculatorEx2());
		if3.setSize(400,350);
		dp.add(if3);
		// ���� ������ Ȱ��ȭ��Ű��
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
				int que = op.showConfirmDialog(ift, "�����Ͻðڽ��ϱ�?", "���� Ȯ��", JOptionPane.YES_NO_CANCEL_OPTION);
				if(que == JOptionPane.YES_OPTION) { //Yes = 0
					// ���� �� ����
					fileSave();
					dispose(); // �ڿ� ����
					System.exit(0);
				} else if(que == JOptionPane.NO_OPTION) { // No = 1
					// ����
					dispose(); // �ڿ� ����
					System.exit(0);
				} else if(que == JOptionPane.CANCEL_OPTION){ // Cancle = 2
					// �ƹ� �ϵ� �� ��
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
					// ���ϰ� ��ư�� ���õǾ��� ��
					bold = 1; // BOLD�� �ٲ���
				} else {
					// ���ϰ� ��ư�� ���� �����Ǿ��� ��
					bold = 0; // PLAIN���� �ٲ���
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
		// borderLayout�� �⺻ ���̾ƿ���
		JDialog dialog = new JDialog(this, "�޷�", true); // (�θ������Ӱ�ü, , ���: �ڿ� ��Ȱ��ȭ�� �Ÿ� true);
		dialog.add(cal);
		dialog.setSize(400,350);
		dialog.setVisible(true);
		
	}
	
	public void fontSetting() {
		// DeskTop���� ���õ� JInternalFrame�� ���� �� JTextArea ������
		JInternalFrame activeIf = dp.getSelectedFrame();
		JTextArea ta = (JTextArea) activeIf.getFocusOwner();
		
		ta.setFont(new Font((String)fontCombo.getSelectedItem(),bold+italic,(Integer)sizeCombo.getSelectedItem()));  
	}
	
	
	public void setFontFore() {
		JColorChooser cc = new JColorChooser(Color.GREEN);
		Color selectColor = cc.showDialog(this, "���ڻ�", Color.MAGENTA);
		
		JInternalFrame selectIf = dp.getSelectedFrame();
		JTextArea ta = (JTextArea) selectIf.getFocusOwner();
		ta.setForeground(selectColor);
	}
	
	// ���� ����
	public void fileSave() {
		JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(this)==0) {
			try {
				File f = fc.getSelectedFile();
				FileWriter fw = new FileWriter(f);
				// ���� ���õ� Frame ������
				JInternalFrame selectIf = dp.getSelectedFrame();
				JTextArea eventTa= (JTextArea) selectIf.getFocusOwner();
				
				fw.write(eventTa.getText());
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	// ���� ����
	public void fileOpen() {
		JFileChooser fc = new JFileChooser();
		// 0:���� , 1: ���
		if(fc.showOpenDialog(this)==0){ // �����
			// ������ ���� ��ü ������
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
			if5.setSelected(true); // ��� setVisible ����, if5�� �гο� �߰��ϱ� ���� �����ؾ� ��.
			if5.setVisible(true);
			
			} catch(Exception e) {
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		new JInternalFrameTest();

	}

}
