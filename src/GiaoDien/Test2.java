package GiaoDien;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Timer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Test2 extends JFrame{
	public Test2() {
		this.setTitle("Chương trình test 2222");
		addControls();
	}

	ActionListener action_ChuyenCau = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "abc gif gif ddos chuyeern cau");
		}
	};
	private void addControls() {
		Container container = getContentPane();
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		
		JPanel pnMain = new JPanel();
		container.add(pnMain);
		
		JTextArea txt = new JTextArea();
		txt.setText("dòng 1\ndòng 2");
		txt.setEnabled(false);
		pnMain.add(txt);
		txt.setOpaque(false);
		txt.setBackground(new Color(0,0,0,255));
		pnMain.setOpaque(false);
		
		JLabel lbLabel = new JLabel("");
		lbLabel.setText("jlabel gif ddos");
		pnMain.add(lbLabel);

		String str = "";
		ActionListener actionTime = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
//				Calendar cal = Calendar.getInstance();
				lbLabel.setText(String.valueOf(timeFormat.format(now)));
			}
		};
		
		Timer t = new Timer(1000, actionTime);
		t.start();
		
		JRadioButton rdbtn = new JRadioButton("radio button gi gi do dai dai lam lal muol djfldf djfk dfjkd dfjk");
		rdbtn.setPreferredSize(new Dimension(200,50));
		pnMain.add(rdbtn);

		
//		rdbtn.setEnabled(false);
		
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
		String str1 = "🡠 🡢"; 
		lbl.setText(str1);
		lbl.setFont(new Font("abc",Font.PLAIN,22));
		pnMain.add(lbl); 
		
		JButton btn1 = new JButton("btn 1 motoj noisd dung daii dai dia oi la gia laiuosdfoj jdkj jdkf  fdk dfjk asjkf");
		btn1.addActionListener(action_ChuyenCau);
		JButton btn2 = new JButton("stop timer");
		btn2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				t.stop();
			}
		});
		
		pnMain.add(btn1);
		pnMain.add(btn2);
		
		JButton btn3 = new JButton("btn 3");
		pnMain.add(btn3);
		
		
	}
	public void showWindow() {
		this.setSize(300,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2().showWindow();
	}
}
