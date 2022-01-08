

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class EventProcess implements ActionListener { // 상속
	JLabel lbl;
	public EventProcess() {
		
	}
	
	public EventProcess(JLabel lbl) {
		this.lbl = lbl;
	}
	
	// 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		lbl.setText("이벤트가 발생함");
	}

}
