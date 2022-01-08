import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventTest extends JFrame implements WindowListener{

	public WindowEventTest() {
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.addWindowListener(this);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Closing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
	}
	
	
	
	public static void main(String[] args) {
		new WindowEventTest();
	}
}
