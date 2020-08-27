/// đây là bộ câu hỏi môn tư tưởng

package GiaoDien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class frmThemCauHoiTest {
	private ArrayList<StringBuilder> arraySQL  = new ArrayList<>();
	private ArrayList<StringBuilder> arrayArr  = new ArrayList<>();
	private JFrame frame;
	private JPanel pnMain;
	int i;
	private JTextArea txtCauHoi,txtDapAn;
	private JButton[] btnTungDapAn = new JButton[4];
	private String[] arrDapAn=new String[4];// quy định i=0 là đáp án đúng, còn lại là sai
	public frmThemCauHoiTest() {
		addControls();
	}
	private JTextArea createTxt() {
		JTextArea txt = new JTextArea(5,44);
		txt.setFont(new Font("Segoe UI",Font.PLAIN,16));
		txt.setAutoscrolls(true);
		txt.setWrapStyleWord(true);
		txt.setLineWrap(true);
		txt.setForeground(Color.white);
		txt.setOpaque(true);
		
		txt.setBackground(Color.darkGray);
//		txt.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_TAB) {
//                    if (e.getModifiers() > 0) {
//                        txt.transferFocusBackward();
//                    } else {
//                        txt.transferFocus();
//                    }
//                    e.consume();
//                }
//                
//                else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                	if (txt==txtDapAn)
//                		dienCauMoi();
//                	else {
//                		txt.transferFocus();
//                	}
//                	e.consume();
//                }
//            }
//        });
		return txt;
	}
	private JButton createBtn(String text) {
		JButton btn = new JButton(text);
		btn.setPreferredSize(new Dimension(600,80));
		btn.setFont(new Font("Segoe ui light",Font.PLAIN,16));
		btn.setOpaque(false);
		btn.setForeground(Color.black);
		btn.setVisible(true);
		return btn;
	}

	private void addControls() {
		frame  = new JFrame();
		pnMain = new JPanel();
		pnMain.setBackground(Color.black);
		pnMain.setOpaque(true);
		frame.add(pnMain);
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	ghiFile();
                System.exit(0);
            }
        });
		
		txtCauHoi = createTxt();
		txtDapAn = createTxt();
		txtDapAn.setForeground(Color.yellow);
		txtDapAn.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyReleased(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB
						|| e.getKeyCode()==KeyEvent.VK_ENTER)
					actionPaste();
			}
		});
		
		KeyStroke ctrlV = KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK);
		txtDapAn.registerKeyboardAction(new CombineAction(
				txtDapAn.getActionForKeyStroke(ctrlV),
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPaste();
//						System.out.println("Đã Paste");
					}
				}), ctrlV, JComponent.WHEN_FOCUSED);
		
		pnMain.add(txtCauHoi);
		pnMain.add(txtDapAn); 
		i=0; 
		while (i<4) {
			btnTungDapAn[i] = createBtn("");
			pnMain.add(btnTungDapAn[i]);
			btnTungDapAn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((JButton) e.getSource()==btnTungDapAn[0])
						xuatChuoi(0);
					else if ((JButton) e.getSource()==btnTungDapAn[1])
						xuatChuoi(1);
					else if ((JButton) e.getSource()==btnTungDapAn[2])
						xuatChuoi(2);
					else if ((JButton) e.getSource()==btnTungDapAn[3])
						xuatChuoi(3);
					
					txtCauHoi.setText("");
					txtDapAn.setText("");
					
					
					txtCauHoi.setRequestFocusEnabled(true);
				}
			});
			i++;
		}
	}
	
	private void xuatChuoi(int j) {
//		System.out.println(j);
		if(j!=0) {
			String temp=arrDapAn[0];
			arrDapAn[0]=arrDapAn[j];
			arrDapAn[j]=temp;
		}
//		System.out.println("Đáp án vừa chọn: "+arrDapAn[0]);
		
		StringBuilder ketQua = new StringBuilder();
		ketQua.append("INSERT INTO CAUHOI VALUES (N'").append(txtCauHoi.getText().trim());
		ketQua.append("',N'").append(arrDapAn[0]);
		ketQua.append("',N'").append(arrDapAn[1]);
		ketQua.append("',N'").append(arrDapAn[2]);
		ketQua.append("',N'").append(arrDapAn[3]);
		ketQua.append("')");

		arraySQL.add(ketQua);

		ketQua = new StringBuilder();
		ketQua.append(txtCauHoi.getText().trim()).append("--");
		ketQua.append(arrDapAn[0]).append(".--");
		ketQua.append(arrDapAn[1]).append(".--");
		ketQua.append(arrDapAn[2]).append(".--");
		ketQua.append(arrDapAn[3]).append(".");
		
		arrayArr.add(ketQua);
		
//		System.out.println(arrayArr);
	}

	private class CombineAction implements ActionListener{

		private ActionListener action1,action2;
		
		public CombineAction(ActionListener action1,ActionListener action2) {
			this.action1 = action1;
			this.action2 = action2;
		}
		public void actionPerformed(ActionEvent e) {
			if(action1!=null)
				action1.actionPerformed(e);
			if(action2!=null)
				action2.actionPerformed(e);
		}
		
	}
	private void actionPaste() {
		String str = txtDapAn.getText();
		// xóa enter
		str = str.replaceAll("\\r|\\n", "");
		txtDapAn.setText(str);
//		System.out.println(str);
		str = str.replaceFirst("a. ", "A. ");
		str = str.replaceFirst("b. ", "B. ");
		str = str.replaceFirst("c. ", "C. ");
		str = str.replaceFirst("d. ", "D. ");
		str = str.replaceFirst("A. ", "");
		str = str.replaceFirst("B. ", "--");
		str = str.replaceFirst("C. ", "--");
		str = str.replaceFirst("D. ", "--");
//		System.out.println(str);
		// chuỗi: 1 	--2		--3		--4
		arrDapAn = str.split("--");
		if (arrDapAn.length==4)
		{
			for(int x=0;x<4;x++) {
				arrDapAn[x]=arrDapAn[x].trim(); 
				btnTungDapAn[x].setText(arrDapAn[x]);
				
//				System.out.println(arrDapAn.toString());
			}
		}
		else {
			System.out.println(str);
			JOptionPane.showMessageDialog(null, "Length: "+arrDapAn.length);
			System.out.println("Length: "+arrDapAn.length);
			for(int j=0;j<arrDapAn.length;j++)
			{
				System.out.println(arrDapAn[j]);
			}
		}
	}
	public void ghiFile() {
		File fileArray = new File("arrayTuTuong");
		File fileSQL = new File("SQLTuTuong");
		try{
           Writer outSQL=new BufferedWriter(new OutputStreamWriter(
        		   new FileOutputStream(fileSQL,true),"UTF8"));
           Writer outArr=new BufferedWriter(new OutputStreamWriter(
        		   new FileOutputStream(fileArray,true),"UTF8"));
           int i=0;
           while(i<arrayArr.size())
           {
        	   outSQL.append(arraySQL.get(i)).append("\r\n");
        	   outArr.append(arrayArr.get(i)).append("\r\n");
        	   i++;
           }
           outSQL.flush();
           outArr.flush();
           
           outSQL.close();
           outArr.close();
           
       }
       catch (Exception e){
       }
		i=0;
	}
	
	public void luuDataToString() {
//		String cauHoi = txtCauHoi.getText().trim(), 
//		dapAn0 = txt0.getText().trim(), dapAn1 = txt1.getText().trim(), 
//		dapAn2 = txt2.getText().trim(), dapAn3 = txt3.getText().trim();
//		
//		StringBuilder ketQua = new StringBuilder();
//		ketQua.append("INSERT INTO CAUHOI VALUES (N'").append(cauHoi);
//		ketQua.append("',N'").append(dapAn0);
//		ketQua.append("',N'").append(dapAn1);
//		ketQua.append("',N'").append(dapAn2);
//		ketQua.append("',N'").append(dapAn3);
//		ketQua.append("')");
//
//		arraySQL.add(ketQua);
//
//		ketQua = new StringBuilder();
//		ketQua.append(cauHoi).append("--");
//		ketQua.append(dapAn0).append(".--");
//		ketQua.append(dapAn1).append(".--");
//		ketQua.append(dapAn2).append(".--");
//		ketQua.append(dapAn3).append(".");
//		
//		arrayArr.add(ketQua);
	}
	
	private void showWindow() {
		frame.setSize(650,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		frmThemCauHoiTest run = new frmThemCauHoiTest();
		run.showWindow();
	}
	
}
