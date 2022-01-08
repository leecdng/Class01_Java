import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UnicasteFileSend extends JFrame implements ActionListener{
	JButton btn = new JButton("���Ϻ�����");
	public UnicasteFileSend() {
		add(btn);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state == 0) {
			try {
				DatagramSocket ds = new DatagramSocket(); // ���+���ϸ�
				InetAddress ia = InetAddress.getByName("192.168.0.2");
				
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f); // �׳� ����Ʈ�� ��������
				String filename = "FN##" + f.getName(); // ���ϸ�
				
				// ���ϸ� ������
				DatagramPacket dp = new DatagramPacket(filename.getBytes(), filename.getBytes().length, ia, 18000);
				ds.send(dp);
				
				while(true) {
					// ���� ���� ������ $%#$
					byte fileContent[] = new byte[512];
					fileContent[0] = '$';
					fileContent[1] = '%';
					fileContent[2] = '#';
					fileContent[3] = '$';
					
					int cnt = fis.read(fileContent, 4, 508);
					if(cnt<=0) break;
					dp = new DatagramPacket(fileContent, cnt+4, ia, 18000);
					ds.send(dp);
					System.out.println("cnt===> "+cnt+"bytes");
				}
				fis.close();
				// ������ �޼��� ������
				dp = new DatagramPacket("^%$&".getBytes(), 4, ia, 18000);
				ds.send(dp);
				ds.close();
				System.out.println("�������� �Ϸ�");
			} catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		new UnicasteFileSend();

	}

}
