

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Semi_01 extends JPanel implements ActionListener{
	Calendar now = Calendar.getInstance();
	int nowYear = now.get(Calendar.YEAR); // nowYear�� yearArr �����ϱ� ����
	int nowDay = now.get(Calendar.DAY_OF_MONTH); // ���� ��Ȱ��ȭ ������ ����
	int nowMonth = now.get(Calendar.MONTH)+1;
	int year = nowYear; int month = nowMonth;// year�� month�� �޺��ڽ� ����Ʈ�� ����
	int lastday; int week;
	// ��¥ ����
	JPanel pane1 = new JPanel(new BorderLayout());
		JPanel dateTopPane = new JPanel(new BorderLayout());
			JLabel dateLbl = new JLabel("��¥ ����", JLabel.LEFT);
		JPanel datePane = new JPanel(new BorderLayout());
			JPanel ymPane = new JPanel();
				Integer[] yearArr = {nowYear-1, nowYear, nowYear+1};
				Integer[] monthArr = {1,2,3,4,5,6,7,8,9,10,11,12};
				JComboBox<Integer> yearCB = new JComboBox<Integer>(yearArr);
				JComboBox<Integer> monthCB = new JComboBox<Integer>(monthArr);
				JButton leftBtn = new JButton("<");
				JButton rightBtn = new JButton(">");
			JPanel dPane = new JPanel(new BorderLayout());
				JPanel weekPane = new JPanel(new GridLayout(1, 7));
					String weekStr = "�Ͽ�ȭ�������";
				JPanel dayPane = new JPanel(new GridLayout(0, 7));
					JButton[] dayBtn = new JButton[38];
	// �ð� ����
	JPanel pane2 = new JPanel(new BorderLayout());
		JPanel timeTopPane = new JPanel(new BorderLayout());
			JLabel timeLbl = new JLabel("�ð� ����", JLabel.LEFT);
		JPanel timePane = new JPanel();
			JButton[] timeBtn = new JButton[10];;
			JLabel timeTxt = new JLabel("������ ��¥�� �������ּ���.");
		
	// �ȳ����� + ���/����Ϸ� ��ư
	JPanel pane3 = new JPanel(new BorderLayout());
		JEditorPane rsvTxt = new JEditorPane();
			String rsvDate = "";
			String rsvTime= "";
		JPanel btnPane = new JPanel();
			JButton calcleBtn = new JButton("���");
			JButton rsvBtn = new JButton("����Ϸ�");
	
	// ��Ʈ // �÷�
	Font fnt1 = new Font("���� ���", Font.BOLD, 16);
	Font fnt2 = new Font("���� ���", Font.BOLD, 14);
	Color clr1 = new Color(38,80,150); // �Ķ���
			
	public Semi_01() {		
		setLayout(null);
//		setBackground(Color.WHITE);
		
		// ----- pane1 ------ ��¥ ���� �г�
		dateLbl.setFont(fnt1);
		dateTopPane.add(dateLbl);
		dateTopPane.setBorder(new EmptyBorder(10,10,10,0)); // ���� �ϼ����� ����
		dateTopPane.setOpaque(false);
		//dateTopPane.setBackground(Color.WHITE); //
		
		leftBtn.setFont(fnt2);
		leftBtn.setBackground(Color.WHITE);
		leftBtn.setBorderPainted(false);
		rightBtn.setFont(fnt2);
		rightBtn.setBackground(Color.WHITE);
		rightBtn.setBorderPainted(false);
		yearCB.setSelectedItem(year);
		yearCB.setFont(fnt1);
		yearCB.setBackground(Color.WHITE);
		monthCB.setSelectedItem(month);
		monthCB.setFont(fnt1);
		monthCB.setBackground(Color.WHITE);
		
		ymPane.add(leftBtn);
		ymPane.add(yearCB);
		ymPane.add(monthCB);
		ymPane.add(rightBtn);
		ymPane.setBackground(Color.WHITE); //
		
		setWeek(); // ���� ����
		setDefaultDate(); // ��¥ ����
		
		weekPane.setBackground(Color.WHITE);
		dayPane.setBackground(Color.WHITE);
		dPane.add(weekPane, BorderLayout.NORTH);
		dPane.add(dayPane);
		
		datePane.add(ymPane, BorderLayout.NORTH);
		datePane.add(dPane);
		
		pane1.add(dateTopPane, BorderLayout.NORTH);
		pane1.add(datePane);
		
		pane1.setBounds(300, 20, 400, 290);
		pane1.setBackground(Color.WHITE); //
		
		// ----- pane2 ------ �ð� ���� �г�
		timeLbl.setFont(fnt1);
		timeTopPane.setBorder(new EmptyBorder(10,10,10,0)); // ���� �ϼ����� ����
		timeTopPane.setBackground(Color.WHITE);
		timeTopPane.add(timeLbl);
		setDefaultTimeBtn(); // �ð� ��ư ����
		timePane.setBorder(new EmptyBorder(10,10,10,10)); // ���� �ϼ����� ����
		timePane.setBackground(Color.WHITE);
		pane2.add(timeTopPane, BorderLayout.NORTH);
		pane2.add(timePane, BorderLayout.CENTER);
		pane2.setBounds(300, 330, 400, 140);
		
		// ----- pane3 ------ �ȳ� �ؽ�Ʈ + ���/����Ϸ� �г�
		rsvTxt.setText("���� ��¥�� �ð��� ������ �ּ���.");
		rsvTxt.setFont(fnt2);
		rsvTxt.setOpaque(false);
		rsvTxt.setAlignmentX(JEditorPane.CENTER_ALIGNMENT);
		rsvTxt.setFocusable(false);
		rsvTxt.setBorder(new EmptyBorder(10,10,10,10));
		calcleBtn.setFont(fnt1);
		calcleBtn.setForeground(Color.WHITE);
		calcleBtn.setBackground(clr1);
		calcleBtn.setBorderPainted(false);
		rsvBtn.setFont(fnt1);
		rsvBtn.setForeground(Color.WHITE);
		rsvBtn.setBackground(clr1);
		rsvBtn.setBorderPainted(false);
		btnPane.add(calcleBtn);	btnPane.add(rsvBtn);
		pane3.add(rsvTxt);
		pane3.add(btnPane, BorderLayout.SOUTH);
		pane3.setBounds(300, 480, 400, 110);
		
		add(pane1);
		add(pane2);
		add(pane3);
		
		// �̺�Ʈ �߻� ���
		yearCB.addActionListener(this);
		monthCB.addActionListener(this);
		leftBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		calcleBtn.addActionListener(this);
		rsvBtn.addActionListener(this);
	}
	
	// ���� ����
	public void setWeek() {
		for(int i=0; i<weekStr.length(); i++) {
			JLabel weekLbl = new JLabel(weekStr.substring(i, i+1));
			if(i==0) weekLbl.setForeground(Color.RED);
			if(i==6) weekLbl.setForeground(Color.BLUE);
			weekLbl.setFont(fnt1);
			weekLbl.setHorizontalAlignment(JLabel.CENTER);
			weekPane.add(weekLbl);
		}
	}
	
	// ���� ��¥ ����
	public void setDefaultDate() {
		now.set(year, month-1, 1);
		week = now.get(Calendar.DAY_OF_WEEK);
		lastday = now.getActualMaximum(Calendar.DAY_OF_MONTH);

		for(int i=0; i<dayBtn.length; i++) {
			if(i<week-1) {	// ����
				dayBtn[i] = new JButton("");
				dayBtn[i].setBackground(Color.WHITE);
				dayBtn[i].setBorderPainted(false);
				dayBtn[i].setEnabled(false);
				dayPane.add(dayBtn[i]);
			} else if(i<lastday+week-1) { // ��¥ ��ư
				dayBtn[i] = new JButton((i+1)-(week-1)+"");
				
				if((i+1)%7==1) dayBtn[i].setForeground(Color.RED);
				else if((i+1)%7==0) dayBtn[i].setForeground(Color.BLUE);
				dayBtn[i].setFont(fnt1);
				dayBtn[i].setHorizontalAlignment(JLabel.CENTER);
				dayBtn[i].setBackground(Color.WHITE);
				dayBtn[i].setBorderPainted(false);
				// ���� ��¥ ��Ȱ��ȭ
				if(year<nowYear || (year==nowYear && month<nowMonth)) {
					dayBtn[i].setEnabled(false);
				} else if(year==nowYear && month==nowMonth) {
					if((i+1)-(week-1) < nowDay+1) dayBtn[i].setEnabled(false);	// ���� ���� ���������� ���� ����
				}
				// ��ư ��� + �̺�Ʈ ���
				dayBtn[i].addActionListener(this);
				dayPane.add(dayBtn[i]);
			} else { // ���� �� �ϰ� ������ �� ��ư // �迭�� ���� ������ ������ ��ư ������ ��. dayPane���� �� �־���
				dayBtn[i] = new JButton(""); 
			}
		}
	}
	
	// �̺�Ʈ �߻� �� ��¥ ����
	public void setDate() {
		dayPane.removeAll();
		dayPane.setVisible(false);
		setDefaultDate();
		dayPane.setVisible(true);
	}
	
	// ���� ��ư ������ ��
	public void setPrev() {
		int yearIdx = (Integer) yearCB.getSelectedItem();
		int monthIdx = (Integer) monthCB.getSelectedItem();
		if(monthIdx==1) {
			yearCB.setSelectedItem(yearIdx-1);
			monthCB.setSelectedItem(12);
			if(yearIdx==nowYear-1) {
				yearCB.setSelectedItem(yearIdx);
				monthCB.setSelectedItem(monthIdx);
			}
		} else {
			monthCB.setSelectedItem(monthIdx-1);
		}
	}
	
	// ���� ��ư ������ ��
	public void setNext() {
		int yearIdx = (Integer) yearCB.getSelectedItem();
		int monthIdx = (Integer) monthCB.getSelectedItem();
		if(monthIdx==12) {
			yearCB.setSelectedItem(yearIdx+1);
			monthCB.setSelectedItem(1);
			if(yearIdx==nowYear+1) {
				yearCB.setSelectedItem(yearIdx);
				monthCB.setSelectedItem(monthIdx);
			}
		} else {
			monthCB.setSelectedItem(monthIdx+1);
		}
	}
	
	// ó�� �ð� ���� ���� --- ��¥ �����϶�� �ȳ� �޼���
	public void setDefaultTimeBtn() {
		timeTxt.setFont(fnt2);
		timePane.add(timeTxt);
	}
	
	// ��¥ ���� �� �ð� ���� ����
	public void setTimeBtn() {
		timePane.removeAll();
		timePane.setVisible(false);
		timePane.setLayout(new GridLayout(0, 5, 12, 12));	// 5�� // ���� ���Ʒ� 12
		
		String timeStr = "09:00 ~ 16:00";	/////////////////////////// ��ð� �ؽ�Ʈ ���� �����;� ��
		
		if(!timeStr.equals("�̿")) {
			int openTime = Integer.parseInt(timeStr.substring(0,2));
			int closeTime = Integer.parseInt(timeStr.substring(8,10));
			for(int i=0; i<10; i++) {
				timeBtn[i] = new JButton(i+openTime+":00");	// ��ư 10���� ����
				if(i<closeTime-openTime) {	// ��ð� ��ư 10������ ���� ������ �׸�ŭ�� �гο� �����ϱ�
					timeBtn[i].setFont(fnt2);
					timeBtn[i].setBorder(new LineBorder(Color.GRAY, 1));
					timeBtn[i].setBackground(new Color(255,255,255)); // ��ư ��Ȱ��ȭ �� �ּ� ó��
					// �ð� ��ư ��Ȱ��ȭ �� �Ʒ� �ּ� ���� ���
//					timeBtn[i].setBackground(new Color(220,220,220));
//					timeBtn.setBorderPainted(false);
//					timeBtn.setEnabled(false);
					timeBtn[i].addActionListener(this);
					timePane.add(timeBtn[i]);
				}
			} // for
		}
		timePane.setVisible(true);
	}
	
	// ��¥ �����ϸ� ����
	public void selectDate() {
		for(int i=0; i<dayBtn.length; i++) {	// ���� �� �� ������ ��ư ���� ������� ��������
			if((i+1)%7==1) dayBtn[i].setForeground(Color.RED);
			else if((i+1)%7==0) dayBtn[i].setForeground(Color.BLUE);
			else dayBtn[i].setForeground(Color.BLACK);
			dayBtn[i].setBackground(Color.WHITE);
		}
		setTimeBtn();	// �ð� ��ư ����
		rsvTxt.setText("���� �ð��� ������ �ּ���.");
	}
	
	// �ð� �����ϸ� ����
	public void selectTime() {
		for(int i=0; i<timeBtn.length; i++) {	// ���� �� �� ������ ��ư ���� ������� ��������
			timeBtn[i].setForeground(Color.BLACK);
			timeBtn[i].setBackground(Color.WHITE);
			timeBtn[i].setBorderPainted(true);
		}
		String rsvPlace = "������ ���Ǽ�"; /////////////////////////////////////// ����Ҹ� �� �޾ƿ;� ��.
		String rsvVacc = "�ƽ�Ʈ������ī"; /////////////////////////////////////// ��� ���� �� �޾ƿ;� ��
		// �˻� ������ ���
		//rsvTxt.setText(year+"�� "+month+"��"+rsvDate+"�� "+rsvTime+"�� "+rsvPlace+"���� �ڷγ� �˻� �����Դϴ�.");
		// ��� ������ ���
		rsvTxt.setText(year+"�� "+month+"��"+rsvDate+"�� "+rsvTime+"�� "+rsvPlace+"���� "+rsvVacc+" ��� ���� ���� �����Դϴ�.");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object evt = ae.getSource();
		String evtStr = ae.getActionCommand();
		if(evt instanceof JComboBox) {	// �޺��ڽ� �̺�Ʈ�� �߻��ϸ�
			year = (Integer)yearCB.getSelectedItem();
			month = (Integer)monthCB.getSelectedItem();
			setDate();	// Ķ���� �缳��
		} else if(evt instanceof JButton) {	// ��ư �̺�Ʈ�� �߻��ϸ�
			JButton evtBtn = (JButton) ae.getSource();
			if(evt==leftBtn) {	// < Ķ���� ���� ��ư
				setPrev();
			} else if(evt==rightBtn) {	// > Ķ���� ���� ��ư
				setNext();
			} else if(evtStr.equals("���")) {//////////////////////////////////// ��� ��ư ������ ��
				//
			} else if(evtStr.equals("����Ϸ�")) {////////////////////////////////// ���� �Ϸ� ��ư ������ ��
				// 
			} else if(evtStr.indexOf(":")!=-1){ // �ð� �����ϸ�
				rsvTime = evtStr;	// ���õ� �ð��� ����
				selectTime();	// �ð� ���� �޼���
				evtBtn.setForeground(Color.WHITE);	// ���õ� �ð� ��ư �� ����
				evtBtn.setBackground(clr1);
				evtBtn.setBorderPainted(false);
			} else {	// ��¥ �����ϸ�
				rsvDate = evtStr; // ���õ� ��¥(��)�� ����
				selectDate();	// ��¥ ���� �޼���
				evtBtn.setForeground(Color.WHITE);	// ���õ� ��¥ ��ư �� ����
				evtBtn.setBackground(clr1);
			}
		}
	}
}
