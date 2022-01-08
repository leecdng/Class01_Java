

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

public class Semi_03 extends JPanel implements FocusListener, ActionListener{
	/* ����� ��� �� �⺻ �����ڷ� ��ü ���� */
	/* ����� ���� �� ������(������ڵ�) ��ü ���� */
	
	JPanel centerPane = new JPanel(new BorderLayout());	// ��� ���� �г�
		// 1. �Է�â �г�
		JPanel inputPane = new JPanel(null);
			JLabel[] lbl = new JLabel[6];
				String[] colName = {"����Ҹ�", "�ּ�", "��ǥ ��ȭ��ȣ", "���� ��ð�", "����� ��ð�", "�Ͽ���/������ ��ð�"};
			JTextField[] tf = new JTextField[6];
			DefaultComboBoxModel<String> model1;
			JComboBox<String> loc1CB;
			JComboBox<String> loc2CB;
		// 2. ��ư �г�
		JPanel btnPane = new JPanel(null);			
			JButton cancleBtn = new JButton("���");
			JButton insertBtn = new JButton("���");

	// ��Ʈ // �÷�
	Font fnt1 = new Font("���� ���", Font.BOLD, 16);
	Font fnt2 = new Font("���� ���", Font.BOLD, 14);
	Font fnt3 = new Font("���� ���", Font.PLAIN, 14);
	Color clr1 = new Color(38,80,150); // �Ķ���

	private int center_code;
	
	// ����� ��� �� ����
	public Semi_03() {		
		// �޺��ڽ� �⺻ ����
		setDefaultLocCB();
	
		// 1. �Է�â ���� // ��, �ؽ�Ʈ�ʵ�
		for(int i=0; i<lbl.length; i++) {
			lbl[i] = new JLabel(colName[i]);
			tf[i] = new JTextField();
			lbl[i].setFont(fnt2);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			// ���� �κ� ��ġ ����
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
		
		tf[1].setText("���ּ�"); // ���ּ� �۾� �̸� ����
		tf[1].setForeground(Color.GRAY);
		
		loc1CB.setFont(fnt3);
		loc2CB.setFont(fnt3);
		loc1CB.setBackground(Color.WHITE);
		loc2CB.setBackground(Color.WHITE);
		inputPane.add(loc1CB);
		inputPane.add(loc2CB);
		
		
		// 2. ��ư ����
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
		
		// ��� ���� �гο� 1,2 �г� �־��ֱ�
		centerPane.add(inputPane);
		centerPane.add(btnPane, BorderLayout.SOUTH);
		centerPane.setPreferredSize(new Dimension(500,350));

		add(centerPane);
		setBorder(new EmptyBorder(100,0,0,0));	// ���� ����
		
		// �̺�Ʈ �߻� -- �ؽ�Ʈ �ʵ� "���ּ�"��
		tf[1].addFocusListener(this);
		cancleBtn.addActionListener(this);
		insertBtn.addActionListener(this);
		
		// JOptionPane ��Ʈ ����
		UIManager.put("OptionPane.messageFont", fnt3);
		UIManager.put("OptionPane.buttonFont", fnt2);

	}
	
	// ����� ���� �� ����
	public Semi_03(int center_code) {
		this();
		this.center_code = center_code;
		CenterDAO dao = new CenterDAO();
		CenterVO vo = new CenterVO();
		List<CenterVO> list = dao.selectCenter(center_code);
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
		
		insertBtn.setText("���� �Ϸ�");
	}
	
	
	
	
	// �޺��ڽ� �⺻ ����
	public void setDefaultLocCB(){
		LocDAO dao = new LocDAO();
		Vector<String> list1 = dao.combo1();
		model1 = new DefaultComboBoxModel<String>(list1);
		loc1CB = new JComboBox<String>(model1);
		
		Vector<String> list2 = dao.combo2((String)loc1CB.getSelectedItem());
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>(list2);
		loc2CB = new JComboBox<String>(model2);

		// loc1 �޺��ڽ� �̺�Ʈ �߻� ���
		loc1CB.addActionListener(this);
	}
	
	// loc1 �޺��ڽ� ���� �̺�Ʈ �߻� ---> loc2 �޺��ڽ� �ٲ�
	public void setLoc2CB(){
		LocDAO dao = new LocDAO();
		Vector<String> list2 = dao.combo2((String)loc1CB.getSelectedItem());
		DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<String>(list2);
		loc2CB.setModel(model2);
		
		loc2CB.updateUI();	// loc2 (�ñ���) �޺��ڽ� ���� �ٲ��ֱ�
	}
	
	// ���õ� ����� �޺��ڽ� ��������
	public void selectLocCB(int loc_code) {
		LocDAO dao = new LocDAO();
		LocVO vo = new LocVO();
		Vector<LocVO> list = dao.selectLoc(loc_code);	//
		
		for(int i=0; i<list.size(); i++) {
			vo = list.get(i);
		}
		loc1CB.setSelectedItem(vo.getLoc1()); // loc1(�õ�) ���ð� �⺻ ����
		loc2CB.setSelectedItem(vo.getLoc2()); // loc2(�ñ���) ���ð� �⺻ ����
		
		// loc1 �޺��ڽ� �̺�Ʈ �߻� ���
		loc1CB.addActionListener(this);
	}
	
	
	
	// ����� ��� ----> ��� ��ư �̺�Ʈ
	public void insertCenter() {
		LocDAO ldao = new LocDAO();
		CenterVO cvo = new CenterVO();
		CenterDAO cdao = new CenterDAO();
		
		String loc1 = (String)loc1CB.getSelectedItem();
		String loc2 = (String)loc2CB.getSelectedItem();
		int loc_code = ldao.getLocCode(loc1, loc2); // ���õ� �õ�/�ñ��� ������ �ּ� �ڵ� ������
		
		cvo.setCenter_name(tf[0].getText());
		cvo.setLoc_code(loc_code);
		cvo.setCenter_addr(tf[1].getText());
		cvo.setCenter_tel(tf[2].getText());
		cvo.setCenter_time1(tf[3].getText());
		cvo.setCenter_time2(tf[4].getText());
		cvo.setCenter_time3(tf[5].getText());
		
		int cnt = cdao.insertCenterData(cvo);
		if(cnt>0) {
			JOptionPane.showMessageDialog(this, "����� ������ ��ϵǾ����ϴ�.");
		} else {
			JOptionPane.showMessageDialog(this, "����� ���� ����� �����߽��ϴ�. �ٽ� �õ��� �ּ���.");
		}
	}
	
	
	// ����� ���� ----> ���� �Ϸ� ��ư �̺�Ʈ
	public void updateCenter() {
		LocDAO ldao = new LocDAO();
		CenterVO cvo = new CenterVO();
		CenterDAO cdao = new CenterDAO();
		
		String loc1 = (String)loc1CB.getSelectedItem();
		String loc2 = (String)loc2CB.getSelectedItem();
		int loc_code = ldao.getLocCode(loc1, loc2);	// ���õ� �õ�/�ñ��� ������ �ּ� �ڵ� ������
		
		cvo.setCenter_code(center_code);
		cvo.setCenter_name(tf[0].getText());
		cvo.setLoc_code(loc_code);
		cvo.setCenter_addr(tf[1].getText());
		cvo.setCenter_tel(tf[2].getText());
		cvo.setCenter_time1(tf[3].getText());
		cvo.setCenter_time2(tf[4].getText());
		cvo.setCenter_time3(tf[5].getText());
		
		int cnt = cdao.updateCenterData(cvo);
		
		if(cnt>0) {
			JOptionPane.showMessageDialog(this, "����� ���� ������ �Ϸ�Ǿ����ϴ�.");
		} else {
			JOptionPane.showMessageDialog(this, "����� ���� ������ �����߽��ϴ�. �ٽ� �õ��� �ּ���.");
		}
	}
	
	
	// �޺��ڽ� ���� �̺�Ʈ
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		String evtStr = e.getActionCommand();
		if(evt instanceof JComboBox) {
			setLoc2CB();
		} else if(evt instanceof JButton) {
			if(evtStr.equals("���")) {
				insertCenter();
				/////////////////////////////////////// ��� JOptionPane���� Ȯ�� ������ ȭ�� ��ȯ
			} else if(evtStr.equals("���� �Ϸ�")) {
				updateCenter();
				/////////////////////////////////////// ���� �Ϸ� JOptionPane���� Ȯ�� ������ ȭ�� ��ȯ
			} else if(evtStr.equals("���")) {
				/////////////////////////////////////// ��� ��ư ������ ȭ�� ��ȯ
			}
		}
		
	}
	
	// ���ּҶ� ��Ŀ�� �� �̺�Ʈ
	public void focusGained(FocusEvent e) {
		if(tf[1].getText().equals("���ּ�")) {
			tf[1].setText("");
			tf[1].setForeground(Color.BLACK);
		}
	}

	// ���ּҶ� ��Ŀ�� ���� �� �̺�Ʈ
	public void focusLost(FocusEvent e) {
		if(tf[1].getText()==null || tf[1].getText().equals("")) {
			tf[1].setText("���ּ�");
			tf[1].setForeground(Color.GRAY);
		}
	}

}
