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
	JButton btn = new JButton("파일보내기");
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
				DatagramSocket ds = new DatagramSocket(); // 경로+파일명
				InetAddress ia = InetAddress.getByName("192.168.0.2");
				
				File f = fc.getSelectedFile();
				FileInputStream fis = new FileInputStream(f); // 그냥 바이트로 가져오기
				String filename = "FN##" + f.getName(); // 파일명
				
				// 파일명 보내기
				DatagramPacket dp = new DatagramPacket(filename.getBytes(), filename.getBytes().length, ia, 18000);
				ds.send(dp);
				
				while(true) {
					// 파일 내용 보내기 $%#$
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
				// 마지막 메세지 보내기
				dp = new DatagramPacket("^%$&".getBytes(), 4, ia, 18000);
				ds.send(dp);
				ds.close();
				System.out.println("파일전송 완료");
			} catch(Exception e) {
				
			}
		}
	}

	public static void main(String[] args) {
		new UnicasteFileSend();

	}

}
