package admin.center;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.LocDAO;



public class SearchCenterCombo extends JPanel implements ItemListener { //���
	//���� �õ�/�ñ��� �޺��ڽ�
   
   JComboBox<String> cb1;
   JComboBox<String> cb2;
   JComboBox<String> cb3;
   
   JTextField tf = new JTextField(20);
   JButton btn = new JButton("�˻�");
   LocDAO locdao = new LocDAO();
   LocDAO locdao2 = new LocDAO();
   
   Font combofont = new Font("���� ���",0,14);
   Font btnfont = new Font("���� ���",1,16);
   
   Color clr1 = new Color(38,80,150); // �Ķ���
   
   public SearchCenterCombo() {
      setLayout(new FlowLayout());
      
      //�õ� �޺��ڽ� ����
      Vector<String> list1 = locdao.combo1();
      cb1= new JComboBox(list1);
      cb1.insertItemAt("�á���", 0);
      cb1.setSelectedIndex(0);
       
//      String sido = (String)cb1.getSelectedItem();
//      Vector<String> list2 = locdao.combo2(sido);
//      cb2 = new JComboBox(list2);
      
      cb2 = new JComboBox<String>();
      cb2.addItem("�á�������");
      
      add(cb1);
      add(cb2);
      add(tf);
      add(btn);
      
      cb1.setFont(combofont);
      cb2.setFont(combofont);
      btn.setFont(btnfont);
      cb1.setBackground(Color.white);
      cb2.setBackground(Color.white);
      btn.setBackground(clr1);
      btn.setForeground(Color.white);
      
      cb1.addItemListener(this);
   }
   

   @Override
   public void itemStateChanged(ItemEvent ie) {
      if(ie.getStateChange()==ItemEvent.SELECTED) {
    	  cb2.removeAllItems();
    	  //System.out.println("�׽�Ʈ");
    	  String sido = (String)cb1.getSelectedItem();
    	  if(sido.equals("�á���")) {
    		  //cb2.removeAllItems();
    		  cb2.addItem("�á�������");
    	  }
    	  else {
    		  Vector<String> list2 = locdao2.combo2(sido);  	     	  
        	  DefaultComboBoxModel<String> cb2model = new DefaultComboBoxModel<String>(list2);
        	  cb2.setModel(cb2model);
    	  }
        
      }
   }

   public static void main(String[] args) {
      new SearchCenterCombo();

   }


}