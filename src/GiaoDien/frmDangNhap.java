package GiaoDien;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import KetNoi.Access;
import KetNoi.run;
import java.awt.HeadlessException;
import java.sql.SQLException;

public class frmDangNhap extends JFrame {

    private JTextField txtID, txtPass;
    private JButton btnDangNhap = new JButton();
    private JPanel pnMain;
    private PreparedStatement psDangNhap;
    private ResultSet resultSet;
    private String user;

    Access access = new Access();

    public frmDangNhap() {

        // bỏ cái title bar 
        this.setTitle("Đăng nhập hệ thống");
        this.setUndecorated(true);

        addControls();
        ketNoi();
        addEvents();

    }

    private void addControls() {
        Container container = getContentPane();
        ImageIcon image = new ImageIcon("src\\dataImage\\frmDangNhap\\frmDangNhap.jpg");
        pnMain = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };

        pnMain.setOpaque(false);

        container.add(pnMain);
        pnMain.setLayout(null);

        txtID = Format.txt();
        txtPass = Format.txt();

        txtID.setBounds(118, 185, 226, 45);
        txtPass.setBounds(118, 252, 226, 45);

        pnMain.add(txtID);
        pnMain.add(txtPass);
    }

    public void showWindows() {
        this.setSize(418, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void ketNoi() {
        if (access.connection == null) // kết nối thất bại
        {
            Format.formatTxtFalse(txtID);
            Format.formatTxtFalse(txtPass);

            JLabel lbl1 = new JLabel("Không thể kết nối đến cơ sở dữ liệu");
            JLabel lbl2 = new JLabel("Liên hệ KTV: 097.729.3599");
            lbl1.setForeground(Color.white);
            lbl2.setForeground(Color.yellow);

            lbl1.setFont(new Font("consolas", Font.BOLD, 20));
            lbl2.setFont(new Font("arial", Font.BOLD, 24));

            lbl1.setBounds(20, 320, 400, 20);
            lbl2.setBounds(55, 350, 400, 30);

            pnMain.add(lbl1);
            pnMain.add(lbl2);

        } else// kết nối thành công
        {
            btnDangNhap = Format.btn("Đăng nhập");
            btnDangNhap.setBackground(new Color(244, 112, 112));
            btnDangNhap.setForeground(Color.white);
            btnDangNhap.setBounds(87, 325, 250, 45);
            btnDangNhap.setFont(new Font("Courial new", Font.BOLD, 28));
            pnMain.add(btnDangNhap);

            JLabel lblHuongDan = new JLabel();
            lblHuongDan.setText("<html>Nhấn Tab để di chuyển<br>Nhấn Enter để đăng nhập</html>");
            lblHuongDan.setForeground(Color.ORANGE);
            lblHuongDan.setFont(new Font("arial", Font.PLAIN, 13));
            lblHuongDan.setBounds(20, 385, 400, 30);
            pnMain.add(lblHuongDan);

            try {
                psDangNhap = access.connection.prepareStatement("select HoTen from ? where ID=? and password=?");

            } catch (SQLException e) {
                System.out.println("Lỗi kết nối frmDangNhap 121");
                System.out.println(e.getMessage());
            }
        }
    }

    private void addEvents() {

        Action action;
        action = new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtID.getText().equals("")
                        || txtPass.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "Không được để trống username/password",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                checkDangNhap();
            }
        };
        btnDangNhap.addActionListener(action);

        btnDangNhap.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        btnDangNhap.getActionMap().put("Enter", action);

    }

    private void checkDangNhap() {
        /*
		 	Giả sử định danh sinh viên là sv
		 	giảng viên là gv thì check định danh trước
         */

        user = txtID.getText().substring(0, 2);
        StringBuilder query = new StringBuilder("select id,pass from ");

        if (user.equals("gv")) {
            query.append("GiangVien");
        } else if (user.equals("sv")) {
            query.append("SinhVien");
        } else {
            JOptionPane.showMessageDialog(null, "Username/Password sai");

            txtID.requestFocusInWindow();
            txtID.setText("");
            txtPass.setText("");

            return;
        }

        query.append(" where (id=? and pass=?)");
        try {
            PreparedStatement prepared = run.connection.prepareStatement(query.toString());

            prepared.setString(1, txtID.getText());
            prepared.setString(2, txtPass.getText());

            resultSet = prepared.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng nhập thất bại: user: "
                        + txtID.getText() + "; pass: " + txtPass.getText());
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("frmDangNhap.checkDangNhap(): "+e.getMessage());
        }

        txtID.requestFocusInWindow();
        txtID.setText("");
        txtPass.setText("");
    }

    private void checkDangNhap2() {
        /*
		 * */
    }

    public static void main(String[] args) {
        new frmDangNhap().showWindows();
    }

}
