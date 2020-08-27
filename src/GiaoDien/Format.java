package GiaoDien;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Format {
	public static JButton btn(String text) {
		JButton btn = new JButton(text);
		btn.setBorderPainted(true);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.setOpaque(true);
		btn.setBackground(new Color(225,225,225));
		
		//btn.setBackground(new Color(244,112,112));
		
		return btn;
	} 
	
	public static JTextField txt() {
		JTextField txt = new JTextField(10);
		txt.setFont(new Font("segoe ui light",Font.PLAIN,28));
		txt.setBackground(new Color(238,239,240));
		txt.setBorder(null);
//		txt.setPreferredSize(new Dimension(180,45));
		
		return txt;
	}
	
	public static void formatTxtFalse(JTextField txt) {
		txt.setText("X");
		txt.setForeground(Color.red);
		txt.setFont(new Font("Arial", Font.BOLD, 38));
		txt.setEnabled(false);
	}
	
}
