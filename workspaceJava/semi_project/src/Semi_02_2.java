

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Semi_02_2 extends JFrame{
	JPanel pane = new JPanel();
		JPanel centerPane = new JPanel();
			JPanel innerPane = new JPanel(new BorderLayout());
				JPanel p = new JPanel(new GridLayout(6,1));
				JPanel p2 = new JPanel(new GridLayout(6,1));

					String[] str = {"진료소명", "일요일/공휴일 운영시간", "진료소명", "일요일/공휴일 운영시간", "진료소명", "일요일/공휴일 운영시간"};
		
	public Semi_02_2() {
		
		
		
		centerPane.setSize(500,500);
		
		for(int i=0; i<6; i++) {
			JLabel lbl = new JLabel(str[i]);
			JTextField tf = new JTextField(30);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			p.add(lbl);
			p2.add(tf);
		}
		
		innerPane.add(p, BorderLayout.WEST);
		innerPane.add(p2);
		innerPane.setBorder(new EmptyBorder(100,0,0,0));
		//innerPane.setBounds(100, 100, 500, 500);
		centerPane.add(innerPane);
		pane.add(centerPane);
		
		add(pane);
		
		setSize(1000, 660);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Semi_02_2();

	}

}
