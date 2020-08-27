package GiaoDien;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class frmTest extends JFrame{
	public frmTest() {
		this.setTitle("Chương trình test222");
		addControls();
	}
	JTextArea txt;
	private void addControls() {
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		
		JPanel pnMain = new JPanel();
		container.add(pnMain);
		
		JLabel lbLabel = new JLabel("");
		lbLabel.setText("jlabel gif ddos");
		pnMain.add(lbLabel);
		
		JRadioButton rdbtn = new JRadioButton("Radio Button");
		pnMain.add(rdbtn);
		
		rdbtn.setOpaque(false);
		rdbtn.setBorderPainted(false);
		rdbtn.setContentAreaFilled(false);
		rdbtn.setFocusPainted(false);

		JTextPane txTextArea = new JTextPane();
		txTextArea.setText("Muỗi yêu nghiệt");
		pnMain.add(txTextArea);
		
		txTextArea.setEditable(false);
		txTextArea.setBackground(pnMain.getBackground());
		txTextArea.setHighlighter(null);
		
		JLabel lbl = new JLabel("abc");
		String str1 = "<>";
		lbl.setText(str1);
		lbl.setFont(new Font("abc",Font.PLAIN,22));
		pnMain.add(lbl);
		
		txt = new JTextArea(7,30);
		pnMain.add(txt);
		
		txt.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyReleased(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode() == KeyEvent.VK_V) && 
						 ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
					 actionPaste();
				}
			}
		});
	}
	public void actionPaste() {
//		String[] arrString = txt.getText().split("\?.");
//		JOptionPane.showMessageDialog(null, arrString.toString());
		JOptionPane.showMessageDialog(null, txt.getText());
	}
	public void showWindow() {
		this.setSize(300,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e) {}
		new frmTest().showWindow();
	}
}
