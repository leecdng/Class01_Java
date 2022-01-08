import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class MemberMain extends JFrame implements ActionListener {
   
   //JFrame - North 왼쪽/라벨,오른쪽/텍스트필드 
   
   JPanel formPane= new JPanel(new BorderLayout()); //패널 하나를 보더레이아웃 형식으로 바꿔줌(프레임의 북쪽)
      JPanel formWestPane= new JPanel(new GridLayout(6,1,5,5)); //서쪽에 들어갈 패널 gridlayout 형식 6행1열 라벨들어갈 패널
         String formLbl [] = {" 번  호 "," 이  름 ","  연락처  ","  이메일","  주    소","  등록일"}; //라벨에 들어갈거 
      JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));//텍스트박스들어가는 패널   dfdfsd
      JTextField[] formTf = {new JTextField(5), new JTextField(15), new JTextField(20),
               new JTextField(30), new JTextField(40),new JTextField(20)}; //textFiled를 배열로 만들었다. 


      
      //JFrame- Center
   JPanel centerPane= new JPanel (new BorderLayout()); //추가 수정 삭제/지우기..에 들어가는 패널을 만들게 보더레이아웃 형식으로
      JPanel btnList = new JPanel(new GridLayout(1,0,3,3)); //여기 버튼 들어갈 패널을 만드는데 형식은 버튼이 들어가기 위해서 그리드로 바꿈
         JButton [] btn= {new JButton("전체목록"), new JButton("사원추가"), new JButton("사원수정"),
               new JButton("사원삭제"), new JButton("폼지우기"), new JButton("종료"),
               new JButton("엑셀쓰기"), new JButton("엑셀읽기")};
         
         //JTable엔 3개 다 있어야 한다. jtable 변수를 선언해줘야함 (title 쓸 애들이 필요함)
         DefaultTableModel model;
         String title="번호/이름/연락처/이메일/주소/등록일";
         JTable memberList;
         JScrollPane sp;
         
         //JFrame south 하단 검색창
         JPanel southPane= new JPanel();
            // JLabel searchLbl=new JLabel("이름");
         	DefaultComboBoxModel<String> searchModel = new DefaultComboBoxModel<String>();
         	JComboBox<String> searchKey = new JComboBox<String>(searchModel);
            JTextField searchWord = new JTextField(15);
            JButton searchBtn=new JButton("search");
      
      
   public MemberMain() {
      super("회원관리 시스템");
      
      //frame의 북쪽을 세팅
      setForm();
      //Frame - Center
      setButtonTable();
      //Frame - south 
      setSearchForm();
         

       
      setSize(1200,600);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
  
      
      memberAllList();
      
      
      
   }
   // 데이터베이스에서 회원전체 목록(이름순으로) 가져오기 - JTable 목록을 보여준다.
	public void memberAllList() {  		
    	  MemberDAO dao = new MemberDAO();
    	  List<MemberVO> list = dao.allRecord();
    	  
    	  setMemberModel(list);
	}
	
	public void setMemberModel(List<MemberVO> list) {
		// 기존 JTable의 목록을 지우고 새로 리스트를 출력한다.
  	 	model.setRowCount(0);
  	 	
		// 컬렉션의 VO를 get하여 JTable에 목록으로 추가한다.
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = list.get(i);
			Object[] obj = { vo.getMem_no(), vo.getUsername(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWrite_date()};
		  
			model.addRow(obj);
		}
	}
      
      
      
	public void setForm() {
      add(BorderLayout.NORTH,formPane);
         formPane.add(BorderLayout.WEST,formWestPane);
            for(int i=0; i<formLbl.length;i++) {//0,1,2,3,4,5 라벨
               JLabel lbl= new JLabel(formLbl[i]);
               formWestPane.add(lbl);//왼쪽 패널에 라벨들을 추가함. 
            }
         formPane.add(BorderLayout.CENTER,formCenter);
            for(int i=0; i<formTf.length;i++) {
               JPanel p= new JPanel(new FlowLayout(FlowLayout.LEFT));
               p.add(formTf[i]);
               
               formCenter.add(p);
               if(i==0) formTf[i].setEditable(false); // 첫 번째 번호 칸은 수정 못 하게 하기
               else if(i==5) formTf[i].setEditable(false);
               
            }
   }

   //Frame- Center
   public void setButtonTable() {
      add(centerPane);
      centerPane.add(BorderLayout.NORTH, btnList);
         for(int i=0; i<btn.length; i++) {
            btnList.add(btn[i]);
            
            btn[i].addActionListener(this);
         }
      //JTable                          제목
      model= new DefaultTableModel(title.split("/"),0);
      memberList = new JTable(model);
      sp= new JScrollPane(memberList);
      centerPane.add(sp);
      
      memberList.addMouseListener(new JTableMouseEventProcess(formTf, memberList));
   }
   //Frame- South 프레임의 남쪽에  하단 검색창
   public void setSearchForm() {
      add(BorderLayout.SOUTH,southPane);
      //southPane.add(searchLbl);
      searchModel.addElement("이름");
      searchModel.addElement("전화번호");
      searchModel.addElement("주소");
      southPane.add(searchKey); // 콤보박스 추가
      southPane.add(searchWord);
      southPane.add(searchBtn);
      
      searchBtn.addActionListener(this);
   }

   
   // 사원추가
   public void memberInsert() {
	   //폼의 이름이 입력 상태인지 확인
	   String username = formTf[1].getText();
	   if(username==null || username.equals("")) {
		   JOptionPane.showMessageDialog(this, "이름을 입력하세요."); // 첨 보네 얜 또??????????????
	   } else { // 이름이 있으면
		   MemberVO vo = new MemberVO();
		   vo.setUsername(username);
		   vo.setTel(formTf[2].getText());
		   vo.setEmail(formTf[3].getText());
		   vo.setAddr(formTf[4].getText());
		   
		   MemberDAO dao = new MemberDAO();
		   int cnt = dao.insertRecord(vo);
		   if(cnt>0) { // 사원이 추가됐다는 뜻
			   formDataClear(); // 회원이 추가되면 폼에 있는 데이터를 다 지우는 것
			   memberAllList();
		   } else { // 회원 추가 실패
			   JOptionPane.showMessageDialog(this, "회원추가 실패하였습니다.");
		   }
	   }
   }
   
   public void formDataClear() { // 폼에있는 데이터를 다 지우는 것
	   // 폼의 값을 지운다.
	   for(int i=0; i<formTf.length; i++) {
		   formTf[i].setText("");
	   }
   }
   
   // 마우스 이벤트 처리 내부 클래스 ----- 내부 클래스로 하고 싶으면 인터페이스의 추상메서드를 다 구현해야 함
   // 외부로 해보기로..ㅎ.
  
   
   //사원 수정
   public void memberUpdate() {
	   MemberVO vo = new MemberVO();
	   vo.setMem_no(Integer.parseInt(formTf[0].getText()));
	   vo.setTel(formTf[2].getText());
	   vo.setEmail(formTf[3].getText());
	   vo.setAddr(formTf[4].getText());
	   
	   MemberDAO dao = new MemberDAO();
	   int cnt = dao.updateRecord(vo);
	   if(cnt>0){	// 수정 시 리스트 다시 선택하기
		   memberAllList(); // 다시 리스트 불러오기
	   } else { // 수정 실패 시 안내 메세지 표시
		  JOptionPane.showMessageDialog(this, "회원정보 수정 실패하였습니다.");
	   }
   }
   
   public void memberDelete() {
	   // 삭제할 사원번호
	   String delNum = formTf[0].getText(); //"5"
	   if(delNum==null || delNum.equals("")) {
		   JOptionPane.showMessageDialog(this, "삭제할 사원을 선택 후 삭제버튼을 클릭하세요."); // 인풋다이얼로그는 입력 창이 뜨네
	   } else {
		   MemberDAO dao = new MemberDAO();
		   int cnt = dao.deleteRecord(Integer.parseInt(delNum));
		   if(cnt>0) { // 회원삭제됨
			   JOptionPane.showMessageDialog(this, delNum+"사원이 삭제되었습니다.");
			   memberAllList(); // 다시 리스트 불러오기
			   formDataClear();
		   } else { // 회원삭제 실패
			   JOptionPane.showMessageDialog(this, "사원 삭제를 실패하였습니다.");
		   }
	   }
   }
   // 검색
   public void memberSearch() {
	   String search = searchWord.getText();
	   // 검색어가 입력되었는지 확인
	   if(search!=null && !search.equals("")) {
		   String searchField = (String)searchKey.getSelectedItem(); // "이름", "주소", "전화번호"
		   String fieldName = "";
		   if(searchField.equals("이름")) {
			   fieldName = "username";
		   } else if(searchField.equals("전화번호")) {
			   fieldName = "tel";
		   } else if(searchField.equals("주소")) {
			   fieldName = "addr";
		   }
		   
		   MemberDAO dao = new MemberDAO();
		   List<MemberVO> list = dao.searchRecord(fieldName, search);
		   setMemberModel(list);
		   searchWord.setText(""); // 검색 후 검색어 지우기
	   } else { // 검색어가 없으면 // 내가 걍 추가한 거..
		   memberAllList();
	   }
   }
   
   // 엑셀 쓰기
   public void excelWrite() {
	   JFileChooser fc = new JFileChooser();
	    
	   int state = fc.showSaveDialog(this);
	   if(state==0) {
		   File f = fc.getSelectedFile();
		   
		   // 엑셀
		   HSSFWorkbook workbook = new HSSFWorkbook();
		   HSSFSheet sheet = workbook.createSheet("회원목록");
		   // 제목
		   HSSFRow rowTitle = sheet.createRow(0);
		   
		   String[] excelTitle = title.split("/");
		   
		   for(int i=0; i<excelTitle.length; i++) {
			   rowTitle.createCell(i).setCellValue(excelTitle[i]);
		   }
		   
		   // JTable 목록의 행의 수
		   int rows = memberList.getRowCount(); //
		   //JTable 목록의 열의 수
		   int cols = memberList.getColumnCount(); //6
		   for(int i=0; i<rows; i++) { // 행의 수  //0, 1, 2, 3, 4
			   HSSFRow row = sheet.createRow(i+1); // i가 0일 때 1행이 만들어짐
			   
			   for(int j=0; j<cols; j++) { //열의 수
				   if(j==0) {
					   row.createCell(j).setCellValue((int)memberList.getValueAt(i, j));
				   } else {
					   row.createCell(j).setCellValue((String)memberList.getValueAt(i, j));
				   }
			   } // for
		   } // for
		   
		   // 엑셀을 파일로 쓰기
		   try {
			   FileOutputStream fos = new FileOutputStream(f);
			   workbook.write(fos);
			   fos.close();
			   workbook.close();
		   } catch (Exception e) {
			   System.out.println("엑셀로 쓰기 에러");
		   }

	   } // if
   }
   
   
   // 엑셀 읽기
   public void excelRead() {
	   JFileChooser fc = new JFileChooser(new File("D://testFile"));
	   
	   int state = fc.showOpenDialog(this); // this................................................어려워 다시 보자
	   if(state==0) {
		   try {
			   File f = fc.getSelectedFile();
			   FileInputStream fis = new FileInputStream(f);
			   POIFSFileSystem poi = new POIFSFileSystem(fis);
			   
			   HSSFWorkbook workbook = new HSSFWorkbook(poi);
			   
			   HSSFSheet sheet = workbook.getSheetAt(0);
			   
			   // 기존 JTable의 데이터 지우기
			   model.setRowCount(0);
			   
			   // 시트의 행의 수
			   int rows = sheet.getPhysicalNumberOfRows();
			   for(int r=1; r<rows; r++) {
				   // 행 얻어오기
				   HSSFRow row = sheet.getRow(r);
				   int cols = row.getPhysicalNumberOfCells(); // 열 수
				   Vector v = new Vector();
				   for(int c=0; c<cols; c++) {
					   if(c==0) { // 숫자일 때
						   v.add((int)row.getCell(c).getNumericCellValue());
					   } else { // 문자일 때
						   v.add(row.getCell(c).getStringCellValue());
					   }
				   }
				   model.addRow(v);
			   }
			   
			   poi.close();
			   fis.close();
			   
		   } catch (Exception e) {
			   System.out.println("파일 읽기 실패");
		   }
	   } else { // 취소 버튼
		   
	   }
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      String eventBtn = e.getActionCommand();
      if(eventBtn.equals("사원추가")) {
    	  memberInsert();
      } else if(eventBtn.equals("폼지우기")) {
    	  formDataClear();
      } else if(eventBtn.equals("종료")) {
    	  System.exit(0);
      } else if(eventBtn.equals("사원수정")) {
    	  memberUpdate();
      } else if(eventBtn.equals("사원삭제")) {
    	  memberDelete();
      } else if(eventBtn.equals("search")) {
    	  memberSearch();
      } else if(eventBtn.equals("전체목록")) {
    	  memberAllList();
      } else if(eventBtn.equals("엑셀쓰기")) {
    	  // JTable의 레코드를 엑셀로 쓰기
    	  excelWrite();
      } else if(eventBtn.equals("엑셀읽기")) {
    	  // JTable의 레코드를 엑셀로 읽기
    	  excelRead();
      }
      
   }
   
	public static void main(String[] args) {
		new MemberMain();

	}

}