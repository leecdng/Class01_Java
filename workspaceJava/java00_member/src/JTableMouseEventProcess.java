import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableMouseEventProcess extends MouseAdapter{
	JTextField[] formTf;
	JTable memberList;
	
	public JTableMouseEventProcess() {
		
	}
	
	public JTableMouseEventProcess(JTextField[] formTf, JTable memberList) {
		this.formTf = formTf;
		this.memberList = memberList;
	}
	
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1){ // 왼쪽버튼 클릭되면
			// 현재 클릭한 행을 구하여
			int row = memberList.getSelectedRow(); // 0,1,2,3,4
			//					memberList.getColumnCount()
			for(int col=0; col<formTf.length; col++) {
				if(col==0) {
					formTf[col].setText(String.valueOf(memberList.getValueAt(row, col)));
				} else {
					formTf[col].setText((String)memberList.getValueAt(row, col));
				}
			}
		}
	}
}
