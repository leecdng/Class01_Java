

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
	/* �̱��� ���� -> �������� �ؽ�Ʈ�� ȭ���� �ٲ� ����Ǿ�� �ϰ�, �������������� �Ϲ�ȸ���������� �ٲ� ������ ����Ǿ�� �մϴ�. */
	
	JLabel mainTitle = new JLabel();
		Font mainFnt = new Font("���� ���", Font.BOLD, 38);
		
	JPanel notice1 = new JPanel(new BorderLayout());
		JLabel lbl1 = new JLabel("Ȯ���� ��Ȳ");
		
	JPanel notice2 = new JPanel(new BorderLayout());
		JEditorPane subPane = new JEditorPane();
			String txt1;
		JEditorPane txtPane = new JEditorPane();
			String txt2;
		JPanel editPane = new JPanel(new GridLayout(1, 1, 10, 0));
			JButton cancleBtn = new JButton("���");
			JButton editBtn = new JButton();
		
		// ��Ʈ // �÷�
		Font fnt1 = new Font("���� ���", Font.BOLD, 20);
		Font fnt2 = new Font("���� ���", Font.PLAIN, 14);
		Font fnt3 = new Font("���� ���", Font.BOLD, 14);
		Color clr1 = new Color(38,80,150); // �Ķ���
	
	public Semi_00() {
		setLayout(null);
		setBackground(Color.WHITE);

		// Ÿ��Ʋ
		mainTitle.setText("�ڷγ� �˻�/��� ���� �ý���");
		mainTitle.setFont(mainFnt);
		mainTitle.setBounds(0, 50, 950, 50);
		mainTitle.setHorizontalAlignment(JLabel.CENTER);
		mainTitle.setVerticalAlignment(JLabel.CENTER);
		
		
		// Ȯ���� ��Ȳ		
		lbl1.setFont(fnt1); // ����Ÿ��Ʋ
		lbl1.setForeground(Color.WHITE);
		
		notice1.setBorder(new EmptyBorder(20,20,20,20)); // �г� �ȿ� ���� //�ϼ����� ����
		notice1.setBackground(Color.DARK_GRAY);
		notice1.setBounds(160, 150, 320, 400);
		
		notice1.add(lbl1, BorderLayout.NORTH);
		
		
		// �������� (�������� �Ⱓ �ȳ�)
		txt1 = "�������� �Ⱓ �ȳ�";
		txt2 = "<55~59�� ������>\n- (����Ⱓ) 7.14(��) 20~ 7.24(��) 18��\n- (�����Ⱓ) 7.26(��)~8.14(��)";
		
		subPane.setFont(fnt1); // ����Ÿ��Ʋ ��Ʈ
		txtPane.setFont(fnt2); // ���� ��Ʈ
		txtPane.setBorder(new EmptyBorder(10,0,0,0)); // �г� �ȿ� ���� //�ϼ����� ����
		
		setNotice2(); // ����Ÿ��Ʋ, ���� ���� ����
		setDefaultEditBtn(); // ���� ��ư ���� - <�����ڿ�>������ �ʿ���
		
		notice2.setBorder(new EmptyBorder(20,20,20,20)); // �г� �ȿ� ���� //�ϼ����� ����
		notice2.setBackground(clr1);
		notice2.setBounds(500, 150, 320, 400);
		
		notice2.add(subPane, BorderLayout.NORTH);
		notice2.add(txtPane, BorderLayout.CENTER);
		notice2.add(editPane, BorderLayout.SOUTH);
		
		// ��ü ����
		add(mainTitle);
		add(notice1); add(notice2);
		
		editBtn.addActionListener(this); // �����ϱ�, �����Ϸ� �̺�Ʈ �߻�
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String evtTxt = ae.getActionCommand();
		if(evtTxt.equals("�����ϱ�")) {
			editNotice();
		} else if(evtTxt.equals("�����Ϸ�")) {
			editCheck();
		} else if(evtTxt.equals("���")) {
			editCancle();
		}
	}
	
	// �������� ����Ÿ��Ʋ, ���� ����
	public void setNotice2() {
		subPane.setText(txt1);
		subPane.setForeground(Color.YELLOW);
		subPane.setOpaque(false);  // ���� �г� �����ϰ�
		subPane.setFocusable(false); // ���� ��Ȱ��ȭ
		
		txtPane.setText(txt2);
		txtPane.setForeground(Color.WHITE);
		txtPane.setOpaque(false); // ���� �г� �����ϰ�
		txtPane.setFocusable(false); // ���� ��Ȱ��ȭ
	}
	
	// ���� ��ư ����
	public void setDefaultEditBtn() {
		editBtn.setFont(fnt3);
		editBtn.setText("�����ϱ�");
		editBtn.setForeground(clr1);
		editBtn.setBackground(Color.WHITE);
		editPane.setOpaque(false); // ��ư �г� �����ϰ�
		editPane.add(editBtn);
	}
	
	// �����ϱ� ��ư ������ ����
	public void editNotice() {
		txt1 = subPane.getText(); // ���� �� ����Ÿ��Ʋ �ؽ�Ʈ ��Ƶα�
		subPane.setOpaque(true);
		subPane.setForeground(Color.BLACK);
		subPane.setBackground(new Color(225, 225, 225));
		subPane.setFocusable(true);
		
		txt2 = txtPane.getText(); // ���� �� ���� �ؽ�Ʈ ��Ƶα�
		txtPane.setOpaque(true);
		txtPane.setForeground(Color.BLACK);
		txtPane.setBackground(new Color(225, 225, 225));
		txtPane.setFocusable(true);
		
		cancleBtn.setFont(fnt3);
		cancleBtn.setForeground(clr1);
		cancleBtn.setBackground(Color.WHITE);
		editPane.add(cancleBtn);
		editBtn.setText("�����Ϸ�");
		
		cancleBtn.addActionListener(this);	// ��� ��ư �̺�Ʈ �߻�
	}

	// �����Ϸ� ��ư ������ ����
	public void editCheck() {
		txt1 = subPane.getText(); // ������ ����Ÿ��Ʋ �ؽ�Ʈ ���
		txt2 = txtPane.getText(); // ������ ���� �ؽ�Ʈ ���
		editPane.remove(cancleBtn); // ��� ��ư ���ֱ�
		setNotice2(); // �������� ����Ÿ��Ʋ, ���� ����
		setDefaultEditBtn(); //���� ��ư ����
	}
	
	// ��� ��ư ������ ����
	public void editCancle() {
		editPane.remove(cancleBtn); // ��� ��ư ���ֱ�
		setNotice2(); // �������� ����Ÿ��Ʋ, ���� ���� --> ���� �� �ؽ�Ʈ�鵵 �ٽ� ���õ�
		setDefaultEditBtn(); //���� ��ư ����
	}
}
