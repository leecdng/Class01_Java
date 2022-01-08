

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
	JPanel centerPane = new JPanel(new BorderLayout());	// ��� ���� �г�
		// 1. �Է�â �г�
		JPanel inputPane = new JPanel(null);
			JLabel[] lbl = new JLabel[6];
				String[] colName = {"����Ҹ�", "�ּ�", "��ǥ ��ȭ��ȣ", "���� ��ð�", "����� ��ð�", "�Ͽ���/������ ��ð�"};
			JTextField[] tf = new JTextField[6];
			DefaultComboBoxModel<String> model1;
			JComboBox<String> loc1CB;
			DefaultComboBoxModel<String> model2;
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
				
	public Semi_02() {		
		// �ñ�/�ñ��� ----- �޺��ڽ��� �� �־��ֱ�
		model1 = new DefaultComboBoxModel<String>();
		model2 = new DefaultComboBoxModel<String>();
		model1.addElement("�õ�");
		model2.addElement("�ñ���");
		loc1CB = new JComboBox<String>(model1);
		loc2CB = new JComboBox<String>(model2);
		
		
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
