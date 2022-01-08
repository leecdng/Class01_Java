import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class UserListForm extends JFrame{
	// ���ø��г�
	JSplitPane sp1, sp2, sp3;
	
	// �Է�ĭ
	JPanel inputPane = new JPanel(new BorderLayout());
	JPanel tfPane = new JPanel();
	JLabel[] lbl = new JLabel[6];
	String[] col = {"��ȣ", "�̸�", "��ȭ��ȣ", "�̸���", "�ּ�", "�����"};
	JTextField[] tf = new JTextField[6];
	int[] tfWidth = {50, 130, 260, 260, 520, 520};
	
	// ��ư
	JPanel btnPane = new JPanel(new GridLayout(1,7));
	JButton[] btn = new JButton[7];
	String[] btnStr = {"�߰�", "����", "����", "�����", "����", "����������", "�����ҷ�����"};
	
	// ���̺�
	JScrollPane tbSPane;
	JTable tb;
	DefaultTableModel model;
	
	// �˻�â
	JPanel searchPane = new JPanel(new BorderLayout());
	JPanel bgPane = new JPanel();
	JTextField searchTf = new JTextField();
	JButton searchBtn = new JButton("Search");
	
	// ��Ʈ
	Font fnt = new Font("���� ���", Font.BOLD ,14);
	
	
	public UserListForm() {
		// �Է�â ����
		for(int i=0; i<col.length; i++) {
			lbl[i] = new JLabel(col[i]);
			inputPane.add(lbl[i]);
			lbl[i].setBounds(0,38*i+10, 100, 26);
			lbl[i].setFont(fnt);
			
			tf[i] = new JTextField();
			inputPane.add(tf[i]);
			tf[i].setBounds(60,38*i+10, tfWidth[i], 26);
		}
		
		inputPane.add(btnPane, BorderLayout.WEST);
		inputPane.add(tfPane, BorderLayout.CENTER);

	
		// ��ư ����
		for(int i=0; i<btnStr.length; i++) {
			btn[i] = new JButton(btnStr[i]);
			btnPane.add(btn[i]);
			btn[i].setFont(fnt);
		}
		
		// ���̺� ����
		model = new DefaultTableModel(col, 0);
		tb = new JTable(model);
		tb.setFont(fnt);
		tbSPane = new JScrollPane(tb);
		
		// �˻�â ����

		searchPane.add(searchTf);
		searchTf.setBounds(320, 10, 250, 28);
		searchPane.add(searchBtn);
		searchBtn.setBounds(580, 6, 90, 36);
		searchBtn.setFont(fnt);
		searchPane.add(bgPane, BorderLayout.CENTER);
		
		// ���ø��г� ����
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tbSPane, searchPane);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, btnPane, sp3);
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPane, sp2);
		
		sp1.setDividerLocation(240);
		sp1.setDividerSize(0);
		sp2.setDividerLocation(40);
		sp2.setDividerSize(0);
		sp3.setDividerLocation(260);
		sp3.setDividerSize(0);
		
		add(sp1);
		
		setSize(1000,630);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new UserListForm();

	}

}
