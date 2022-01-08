import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	// JTable �÷��������� ����� �迭
	String title[] = {"��ȣ", "�̸�", "����ó", "�ּ�"};
	// JTable ���, ������ ����� 2���� �迭
	Object[][] data = { {100, "ȫ�浿", "010-1234-5678", "����� ������"},
						{200, "�̼���", "010-7878-9696", "����� ���α�"},
						{300, "�������", "010-8787-5555", "����� ��������"}
					};
	
	JLabel lbl = new JLabel(" ");
	
	public JTableTest() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		add(BorderLayout.SOUTH, lbl);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//2�� �Ŀ� �߰��� �� �����ֱ�
		try {Thread.sleep(1000);} catch(Exception e) {}
		
		// ���߰� : addRow();
		Object[] row = {400,"���","010-1234-5555", "����� ���ʱ�"};
		model.addRow(row);
		
		
		
		Vector<Object> v = new Vector<Object>();
		v.add(500);
		v.add("����ó");
		v.add("010-4567-8888");
		v.add("����� ����");

		model.addRow(v);
		
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		
		// �� ����: insertRow()
		Object[] row2 = {600,"��������","010-1111-2222","����� ������"};
		model.insertRow(2, row2);
		
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// ���̵� : moveRow()
		//			start, end, to
		model.moveRow(2, 4, 0); // 2~4��° �ε��� ������ �� ��(0��°)�� �Űܶ�
		
		
		/*
		try {Thread.sleep(1000);} catch(Exception e) {}
		// �÷� �߰�: addColumn() / �÷��� �߰��� ���� �ְ�, �÷��� �����͸� ���� �߰��� ���� �ִ�.
		model.addColumn("��Ÿ");
		Object cData[] = {1, 2, 3, 4, 5, 6};
		model.addColumn("�޸�", cData);
		// ��� �߰��� �� ���� ��-----------------------------------------------------------------Ȯ���ϱ�!!
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// �� ���� : removeRow()
		model.removeRow(3);
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// �÷�(��) ���� : removeColumn(TableColumn Ÿ�� �Ű�����: getColumn() �޼��尡 TableColumn�� ������)// �̰� JTable �޼��忡 ���� // �ٸ� ��...?? ����Ʈ���̺�� �޼��忡 �ֳ� ��..
		table.removeColumn(table.getColumn("��Ÿ"));
		*/
		
		
		table.addMouseListener(new MyEvent());

	}
	
	// ���콺 �̺�Ʈ ����Ŭ����
	public class MyEvent extends MouseAdapter{ // �̹� ��� �޾Ƽ� �̺�Ʈ �������̽��� ��� ���� �ʿ� ����.
		// �� �������̵�
		public void mouseClicked(MouseEvent me) {
			// System.out.println("Ŭ�� �̺�Ʈ �߻�");
			// ���콺 ����, ������, �� ��� �̺�Ʈ�� �߻���.
			// 1. ��ư�� ���� �˾Ƴ��� (1: ����, 2:���, 3:������)
			int eventBtn = me.getButton();
			if(eventBtn == 1) { // ���콺 ���� Ŭ���� ���� ������ ���̴�
				//JTable evt = (JTable) me.getSource(); // �̷� �� �� �ᵵ �ǳ�? get'Selected'Row �޼��带 �Ἥ �׷� ��.
				int row = table.getSelectedRow(); // ������ ���ȣ ������
				String dataStr ="";
				
				for(int c=0; c<table.getColumnCount(); c++) { // �÷��� �ִ� �� ��� ǥ���Ϸ��� �ݺ��� ������ ��
					Object data = table.getValueAt(row, c); // �� ��ȣ, �� ��ȣ�� ��
					dataStr += data +", ";
				}
				
				lbl.setText(dataStr);
				
			}

		}
	}

	public static void main(String[] args) {
		new JTableTest();

	}

}
