package GiaoDien;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import KetNoi.ConnectSQL;
import java.awt.HeadlessException;

public class frmDeThi extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtMaDT, txtTenMH;
    private JButton btnOK, btnHuy;
    private JComboBox<String> cboThoiGian;
    private JLabel lblCheckDT, lblCheckMH;

    frmGiangVien frmGiangVien1 = new frmGiangVien();

    private PreparedStatement psThem, psSua;
    ImageIcon icoTrue, icoFalse;
    boolean changeDT = false;// change by DIAlog
    boolean them = true;//mặc định là thêm, nút OK sẽ chuyển về actionThem()

    /**
     * Launch the application. 
     */
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

    public String getMaDT() {
        return txtMaDT.getText();
    }

    public String getTenMH() {
        return txtTenMH.getText();
    }

    public byte getTime() {
        switch (cboThoiGian.getSelectedIndex()) {
            case 0:
                return 45;
            case 1:
                return 60;
            case 2:
                return 90;
            default:
                return 120;
        }
    }

    public void run() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Create the dialog.
     */
    public void setData(String maDT, String tenMH, byte thoiGian) {
        // thông báo đang sửa data
        them = false;
        btnOK.setText("Lưu");
        txtMaDT.setText(maDT);
        txtMaDT.setEnabled(false);
        lblCheckDT.setIcon(icoTrue);
        txtTenMH.setText(tenMH);
        switch (thoiGian) {
            case 45:
                cboThoiGian.setSelectedIndex(0);
                break;
            case 60:
                cboThoiGian.setSelectedIndex(1);
                break;
            case 90:
                cboThoiGian.setSelectedIndex(2);
                break;
            default:
                cboThoiGian.setSelectedIndex(3);
                break;
        }
    }
    private ConnectSQL sql = new ConnectSQL();
    public frmDeThi(JFrame parent, String title) {
        super(parent, title, true);
        try {
            psThem = sql.connection.prepareStatement("insert into DeThi (MaDT,TenMH, ThoiGian) values (?,?,?)");
            psSua = sql.connection.prepareStatement("update DeThi set TenMH = ?, ThoiGian=? where MaDT=?");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        icoTrue = new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/true.png"));
        icoFalse = new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/false.png"));

        setBounds(100, 100, 326, 211);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtMaDT = new JTextField();
        txtMaDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtMaDT.setBounds(104, 17, 172, 26);
        txtMaDT.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {

                boolean hopLe = frmGiangVien.listMaDT.contains(txtMaDT.getText());

                if (hopLe || txtMaDT.getText().isEmpty()) {
                    lblCheckDT.setIcon(icoFalse);
                    lblCheckDT.setToolTipText("Không hợp lệ");
                } else {
                    lblCheckDT.setIcon(icoTrue);
                    lblCheckDT.setToolTipText("Hợp lệ");
                }

                btnOK.setEnabled(false);
                if (lblCheckDT.getIcon() == icoTrue && lblCheckMH.getIcon() == icoTrue) {
                    btnOK.setEnabled(true);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                update();
            }

            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void changedUpdate(DocumentEvent e) {
                update();
            }
        });

        contentPanel.add(txtMaDT);
        txtMaDT.setColumns(10);
        txtTenMH = new JTextField();
        txtTenMH.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtTenMH.setColumns(10);
        txtTenMH.setBounds(104, 60, 172, 26);
        txtTenMH.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                if (txtTenMH.getText().isEmpty()) {
                    lblCheckMH.setIcon(icoFalse);
                    lblCheckMH.setToolTipText("Không hợp lệ");
                } else {
                    lblCheckMH.setIcon(icoTrue);
                    lblCheckMH.setToolTipText("Hợp lệ");
                }
                btnOK.setEnabled(false);
                if (lblCheckDT.getIcon() == icoTrue && lblCheckMH.getIcon() == icoTrue) {
                    btnOK.setEnabled(true);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                update();
            }

            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void changedUpdate(DocumentEvent e) {
                update();
            }
        });
        contentPanel.add(txtTenMH);

        cboThoiGian = new JComboBox<String>();
        cboThoiGian.addItem("45 phút");
        cboThoiGian.addItem("60 phút");
        cboThoiGian.addItem("90 phút");
        cboThoiGian.addItem("120 phút");
        cboThoiGian.setFocusable(false);
        cboThoiGian.setSelectedIndex(0);
        cboThoiGian.setBounds(104, 103, 172, 20);
        contentPanel.add(cboThoiGian);

        JLabel lblMaDT = new JLabel("Mã đề thi");
        lblMaDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaDT.setBounds(10, 16, 84, 26);
        contentPanel.add(lblMaDT);

        JLabel lblTenMH = new JLabel("Tên môn học");
        lblTenMH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTenMH.setBounds(10, 58, 84, 26);
        contentPanel.add(lblTenMH);

        JLabel lblThoiGian = new JLabel("Thời gian");
        lblThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblThoiGian.setBounds(10, 100, 84, 26);
        contentPanel.add(lblThoiGian);

        lblCheckDT = new JLabel("");
        lblCheckDT.setToolTipText("Không hợp lệ.");
        lblCheckDT.setIcon(new ImageIcon(frmDeThi.class.getResource("/dataImage/frmGiangVien/false.png")));
        lblCheckDT.setBounds(279, 17, 24, 24);
        contentPanel.add(lblCheckDT);

        lblCheckMH = new JLabel("");
        lblCheckMH.setToolTipText("Không hợp lệ.");
        lblCheckMH.setIcon(icoFalse);
        lblCheckMH.setBounds(279, 62, 24, 24);
        contentPanel.add(lblCheckMH);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                btnOK = new JButton("Thêm");
                btnOK.setEnabled(false);
                btnOK.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        actionOK();
                    }
                });
                buttonPane.add(btnOK);
                getRootPane().setDefaultButton(btnOK);
            }
            {
                btnHuy = new JButton("Hủy");
                btnHuy.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonPane.add(btnHuy);
            }
        }

    }

    private void actionOK() {
        byte thoiGian;
        switch (cboThoiGian.getSelectedIndex()) {
            case 0:
                thoiGian = 45;
                break;
            case 1:
                thoiGian = 60;
                break;
            case 2:
                thoiGian = 90;
                break;
            default:
                thoiGian = 120;
                break;
        }
        try {
            if (them) // thêm đúng thì set query thành insert into
            {
                psThem.setString(1, txtMaDT.getText());
                psThem.setString(2, txtTenMH.getText());
                psThem.setByte(3, thoiGian);
                psThem.execute();
                JOptionPane.showMessageDialog(null, "Đã thêm đề thi mã: " + txtMaDT.getText());
            } else {
                psSua.setString(1, txtTenMH.getText());
                psSua.setByte(2, thoiGian);
                psSua.setString(3, txtMaDT.getText());
                psSua.execute();
                JOptionPane.showMessageDialog(null, "Đã sửa mã đề thi: " + txtMaDT.getText());
            }
        } catch (HeadlessException | SQLException e) {
        }
        changeDT = true;// đã thay đổi (thêm/sửa) thông tin, cập nhật tới cbo đề thi
        dispose();
    }
}
