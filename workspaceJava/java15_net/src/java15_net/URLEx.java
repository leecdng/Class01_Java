package java15_net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLEx extends JFrame implements ActionListener{
	JPanel pane = new JPanel(new BorderLayout());
	JLabel lbl = new JLabel("　URL　");
	JTextField tf = new JTextField();
	JButton btn = new JButton("소스보기");
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);

	public URLEx() {
		
		tf.setSize(300, 100);
		ta.setCaretPosition(ta.getDocument().getLength());

		pane.add(lbl, BorderLayout.WEST);
		pane.add(tf, BorderLayout.CENTER);
		pane.add(btn, BorderLayout.EAST);
		
		add(pane, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String urlTxt = tf.getText();
		try {
			URL url = new URL(urlTxt);
			URLConnection connection = url.openConnection();
			connection.connect();
			
			String type = connection.getContentType();
			String encode = type.substring(type.indexOf("charset=")+8);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is, encode);
			BufferedReader br = new BufferedReader(isr);
			
			String source;
			String result="";
			while(true) {
				source = br.readLine();
				result += (source+"\n");
				if(source==null) break;
			}
			ta.append(result);
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		new URLEx();

	}
}
