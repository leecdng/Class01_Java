
//�α���1-1
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import database.UserDAO;
import database.UserVO;

public class dd extends JPanel implements ActionListener {//�ǿ���������

      JPanel centerPanel = new JPanel(new BorderLayout());
      JPanel inPanel= new JPanel(null);

           JPanel panel = new JPanel();
            JLabel idlbl= new JLabel("���̵�");
            JLabel namelbl= new JLabel("�̸�");
         JLabel numlbl= new JLabel("�ֹε�Ϲ�ȣ");
         JLabel tellbl= new JLabel("�޴�����ȣ");
         JLabel underballbl= new JLabel("��");
         
         JTextField idfd= new JTextField(25);//���̵��ؽ�Ʈ�ʵ�
         JTextField namefd= new JTextField(25);//�̸��ؽ�Ʈ�ʵ�
         JTextField numfd= new JTextField(15);//�ֹξտ��ؽ�Ʈ�ʵ�
         
         JTextField numfd2= new JTextField(15);//-�ڿ��ؽ�Ʈ�ʵ�
         JTextField telfd= new JTextField(25);//��ȭ��ȣ�ʵ�
         
         JButton selectbtn = new JButton("Ȯ��");
         
          Font font3 = new Font("���� ���",0, 20);
        Font fontidpw = new Font("���� ���",Font.BOLD, 20);
        Font searchft = new Font("���� ���",0, 16);//ã����Ʈ
            
        String id;
      
      public  dd (){
          
         setLayout(new FlowLayout());
         
         centerPanel.setPreferredSize(new Dimension(600,540));
         centerPanel.add(inPanel);
         add(centerPanel);
         
       inPanel.add(idlbl);//���̵��
       idlbl.setBounds(0,60,200,200);
       idlbl.setFont(fontidpw);
       inPanel.add(idfd); //�̸� �ؽ�Ʈ�ʵ�
       idfd.setBounds(130,140,280,40);
       
      
       inPanel.add(namelbl); //�̸� ��
       namelbl.setBounds(0,120,200,200);
       namelbl.setFont(fontidpw);
       inPanel.add(namefd); //�̸� �ؽ�Ʈ�ʵ�
       namefd.setBounds(130,200,280,40);
      
       inPanel.add(numlbl); //�ֹε�Ϲ�ȣ��
       numlbl.setBounds(0,178,200,200);
       numlbl.setFont(fontidpw);
       inPanel.add(numfd); //�ֹε�Ϲ�ȣ �ؽ�Ʈ�ʵ�
       numfd.setBounds(130,260,135,40);
     
       inPanel.add(underballbl);//�ֹε�Ϲ�ȣ - ��
       underballbl.setBounds(267,260,132,40);//-�� ũ��
       inPanel.add(numfd2);
       numfd2.setBounds(280,260,131,40);//-�ڿ� �ؽ�Ʈ�ʵ�
       
       inPanel.add(tellbl);
       tellbl.setBounds(0,235,200,200);//�޴�����ȣ��
       tellbl.setFont(fontidpw);
       inPanel.add(telfd);
       telfd.setBounds(130,316,280,40);
       
       //Ȯ�ι�ư
       inPanel.add(selectbtn);
       selectbtn.setBounds(130,370,280,40);
       selectbtn.setBackground(Color.LIGHT_GRAY);
       selectbtn.setFocusPainted(false);
       selectbtn.setFont(font3);
       
       selectbtn.addActionListener(this);
       
         
      }

         //��й�ȣ ã��.
      public void pwSearch() {
      UserVO uservo= new UserVO();
      uservo.setUser_id(idfd.getText());
      uservo.setUser_name(namefd.getText());
      uservo.setUser_num(numfd.getText().concat(numfd2.getText()));
      uservo.setUser_tel(telfd.getText());
      
      UserDAO userdao = new UserDAO();
      id = userdao.searchPw(uservo);  
      }
      
      public void checkSign() {
         if(idfd.getText()==null || idfd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "���̵� ��Ȯ�ϰ� �Է����ּ���");
         }else if(namefd.getText()==null || namefd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "�̸��� ��Ȯ�ϰ� �Է����ּ���");
         }else if(numfd.getText()==null || numfd2.getText()==null || 
               numfd.getText().equals("")|| numfd2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "�ֹε�� ��ȣ�� ��Ȯ�ϰ� �Է����ּ���");
         }else if(telfd.getText()==null || telfd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "��ȭ��ȣ�� ��Ȯ�ϰ� �Է����ּ���");
         }else { //��� �߰�
            //�޼ҵ� �������� ������ �ȵǰ� �־��� �ФФ�
            pwSearch();
            System.out.println(id);
            //�� ��� id�� null���ϱ�...
            if(id != null) {
               JOptionPane.showMessageDialog(this, "Ȯ�εǾ����ϴ�.");
            }
            else {
               JOptionPane.showMessageDialog(this, "��ġ�ϴ� ������ �����ϴ�.");
            }
            
            
         }
      }
   
   

      @Override
      public void actionPerformed(ActionEvent e) {
         Object event = e.getSource();
         if(event==(selectbtn)){
            checkSign();
         }
         
      }   
   }