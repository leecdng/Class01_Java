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
	
	// JTable 컬럼네임으로 사용할 배열
	String title[] = {"번호", "이름", "연락처", "주소"};
	// JTable 목록, 값으로 사용할 2차원 배열
	Object[][] data = { {100, "홍길동", "010-1234-5678", "서울시 마포구"},
						{200, "이순신", "010-7878-9696", "서울시 종로구"},
						{300, "세종대왕", "010-8787-5555", "서울시 영등포구"}
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
		
		//2초 후에 추가된 행 보여주기
		try {Thread.sleep(1000);} catch(Exception e) {}
		
		// 행추가 : addRow();
		Object[] row = {400,"김삿갓","010-1234-5555", "서울시 서초구"};
		model.addRow(row);
		
		
		
		Vector<Object> v = new Vector<Object>();
		v.add(500);
		v.add("연락처");
		v.add("010-4567-8888");
		v.add("서울시 은평구");

		model.addRow(v);
		
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		
		// 행 삽입: insertRow()
		Object[] row2 = {600,"광개토대왕","010-1111-2222","서울시 강남구"};
		model.insertRow(2, row2);
		
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// 행이동 : moveRow()
		//			start, end, to
		model.moveRow(2, 4, 0); // 2~4번째 인덱스 값들을 맨 앞(0번째)로 옮겨라
		
		
		/*
		try {Thread.sleep(1000);} catch(Exception e) {}
		// 컬럼 추가: addColumn() / 컬럼만 추가할 수도 있고, 컬럼과 데이터를 같이 추가할 수도 있다.
		model.addColumn("기타");
		Object cData[] = {1, 2, 3, 4, 5, 6};
		model.addColumn("메모", cData);
		// 얘네 추가될 때 오류 뜸-----------------------------------------------------------------확인하기!!
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// 행 삭제 : removeRow()
		model.removeRow(3);
		
		
		try {Thread.sleep(1000);} catch(Exception e) {}
		// 컬럼(열) 삭제 : removeColumn(TableColumn 타입 매개변수: getColumn() 메서드가 TableColumn을 리턴함)// 이건 JTable 메서드에 있음 // 다른 건...?? 디폴트테이블모델 메서드에 있나 봄..
		table.removeColumn(table.getColumn("기타"));
		*/
		
		
		table.addMouseListener(new MyEvent());

	}
	
	// 마우스 이벤트 내부클래스
	public class MyEvent extends MouseAdapter{ // 이미 상속 받아서 이벤트 인터페이스를 상속 받을 필요 없음.
		// 재 오버라이딩
		public void mouseClicked(MouseEvent me) {
			// System.out.println("클릭 이벤트 발생");
			// 마우스 왼쪽, 오른쪽, 휠 모두 이벤트가 발생됨.
			// 1. 버튼의 종류 알아내기 (1: 왼쪽, 2:가운데, 3:오른쪽)
			int eventBtn = me.getButton();
			if(eventBtn == 1) { // 마우스 왼쪽 클릭일 때만 실행할 것이다
				//JTable evt = (JTable) me.getSource(); // 이런 거 안 써도 되네? get'Selected'Row 메서드를 써서 그런 듯.
				int row = table.getSelectedRow(); // 선택한 행번호 얻어오기
				String dataStr ="";
				
				for(int c=0; c<table.getColumnCount(); c++) { // 컬럼에 있는 값 모두 표시하려고 반복문 돌리는 것
					Object data = table.getValueAt(row, c); // 행 번호, 열 번호인 듯
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
