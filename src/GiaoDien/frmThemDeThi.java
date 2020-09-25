package GiaoDien;

import KetNoi.ConnectSQL;
import java.awt.Frame;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class frmThemDeThi extends javax.swing.JDialog {

    private String username;
    public boolean added;
    
    private final ImageIcon iconTrue = new ImageIcon(getClass()
            .getResource("/dataImage/frmGiangVien/true.png")),
            iconFalse = new ImageIcon(getClass()
                    .getResource("/dataImage/frmGiangVien/xoaCauHoi.png"));
    frmGiangVien f = new frmGiangVien();

    public frmThemDeThi(Frame parent, boolean modal, boolean isAdd, String username) {
        super(parent, modal);
        initComponents();
        myCustom();

        this.username = username;
        if (isAdd) {
            themMonHoc();
        }
    }

//    private void loadMonHoc() {
//        new ConnectSQL();
//        try {
//            Statement ps = ConnectSQL.connection.createStatement();
//            ResultSet resultSet = ps.executeQuery("Select * from MonHoc");
//            while (resultSet.next()) {
//                listMonHoc.add(
//                        new MonHoc(resultSet.getString("MaMH"),
//                                resultSet.getString("TenMH"))
//                );
//            }
//            resultSet.close();
//            ps.close();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    private void themMonHoc() {
        txtMaDT.setText("");
        txtMaMH.setText("");
        txtTenMH.setText("");
        lblMaDT.setIcon(null);
        lblTenMH.setIcon(null);
        lblMaMH.setIcon(null);

        btnLuu.setEnabled(false);
    }

    private void suaMonHoc() {

    }

    private void myCustom() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addKeyChange(txtMaMH, lblMaMH, "Mã môn học", 12);
        addKeyChange(txtMaDT, lblMaDT, "Mã đề thi", 4);

        txtTenMH.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void update() {
                if (txtTenMH.getText().trim().equals("")) {
                    lblTenMH.setIcon(iconFalse);
                    lblTenMH.setToolTipText("Tên môn học không được để trống.");
                    btnLuu.setEnabled(false);
                } else {
                    lblTenMH.setIcon(iconTrue);
                    lblTenMH.setToolTipText("Hợp lệ.");
                    if (lblMaDT.getIcon() == iconTrue
                            && lblMaMH.getIcon() == iconTrue) {
                        btnLuu.setEnabled(true);
                    } else {
                        btnLuu.setEnabled(false);
                    }
                }
            }
        });

    }

    private void addKeyChange(JTextField txt, JLabel lbl, String err, int minLength) {
        txt.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void update() {
                String str = txt.getText().trim();
                if (str.equals("")) {
                    lbl.setIcon(iconFalse);
                    lbl.setToolTipText(err + " không được để trống.");
                    btnLuu.setEnabled(false);
                } else if (str.length() != minLength) {
                    lbl.setIcon(iconFalse);
                    lbl.setToolTipText(err + " không đúng " + minLength + " ký tự.");
                    btnLuu.setEnabled(false);
                } else {
                    lbl.setIcon(iconTrue);
                    lbl.setToolTipText("Hợp lệ.");

                    if (lblMaDT.getIcon() == iconTrue
                            && lblTenMH.getIcon() == iconTrue
                            && lblMaMH.getIcon() == iconTrue) {
                        btnLuu.setEnabled(true);
                    } else {
                        btnLuu.setEnabled(false);
                    }

                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        cboThoiGian = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblMaMH = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaDT = new javax.swing.JTextField();
        lblMaDT = new javax.swing.JLabel();
        lblTenMH = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm đề thi");
        setMinimumSize(new java.awt.Dimension(473, 195));
        setPreferredSize(new java.awt.Dimension(473, 195));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã môn học");
        jLabel1.setPreferredSize(new java.awt.Dimension(78, 32));
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 80, 32);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên môn học");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 54, 81, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Thời gian");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 90, 70, 32);

        txtMaMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaMH.setText("000000000000");
        txtMaMH.setMinimumSize(new java.awt.Dimension(6, 32));
        txtMaMH.setPreferredSize(new java.awt.Dimension(102, 32));
        getContentPane().add(txtMaMH);
        txtMaMH.setBounds(100, 10, 110, 32);

        cboThoiGian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboThoiGian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30", "45", "60", "90", "120" }));
        cboThoiGian.setPreferredSize(new java.awt.Dimension(55, 22));
        getContentPane().add(cboThoiGian);
        cboThoiGian.setBounds(100, 90, 60, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("phút");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(170, 90, 40, 32);

        lblMaMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/true.png"))); // NOI18N
        lblMaMH.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(lblMaMH);
        lblMaMH.setBounds(220, 10, 32, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã đề thi");
        jLabel8.setPreferredSize(new java.awt.Dimension(78, 32));
        jLabel8.setRequestFocusEnabled(false);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 10, 70, 32);

        txtMaDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaDT.setText("0000");
        txtMaDT.setMinimumSize(new java.awt.Dimension(6, 32));
        txtMaDT.setPreferredSize(new java.awt.Dimension(102, 32));
        getContentPane().add(txtMaDT);
        txtMaDT.setBounds(350, 10, 50, 32);

        lblMaDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/xoaCauHoi.png"))); // NOI18N
        lblMaDT.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(lblMaDT);
        lblMaDT.setBounds(410, 10, 32, 32);

        lblTenMH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/xoaCauHoi.png"))); // NOI18N
        lblTenMH.setPreferredSize(new java.awt.Dimension(32, 32));
        getContentPane().add(lblTenMH);
        lblTenMH.setBounds(410, 50, 32, 32);

        txtTenMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenMH.setText("Tên môn học");
        txtTenMH.setMinimumSize(new java.awt.Dimension(6, 32));
        txtTenMH.setPreferredSize(new java.awt.Dimension(102, 32));
        getContentPane().add(txtTenMH);
        txtTenMH.setBounds(100, 50, 300, 32);

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu);
        btnLuu.setBounds(240, 120, 73, 30);

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuy);
        btnHuy.setBounds(330, 120, 70, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (frmGiangVien.listMaDT.contains(txtMaDT.getText())) {
            JOptionPane.showMessageDialog(null, "Mã đề thi đã tồn tại.",
                    "Không thể thêm mã đề thi", JOptionPane.OK_OPTION);
            txtMaDT.selectAll();
            txtMaDT.requestFocus();
        } else {
            ConnectSQL sql = new ConnectSQL();
            try{
                Statement statement = sql.connection.createStatement();
                ResultSet result =  statement.executeQuery(String.format("select TenMH "
                        + "from MonHoc where MaMH = %s",txtMaMH.getText()));
                if(result.next()){
                    String oldTenMH = result.getString("TenMH");
                    String message = String.format("Mã môn học đã tồn tại với tên '%s'.\r\nBạn có muốn cập nhật tên mới thành: '%s' không?", oldTenMH,txtTenMH.getText());
                    int i = JOptionPane.showConfirmDialog(null, message,
        "Cập nhật tên môn học", JOptionPane.OK_CANCEL_OPTION);
                    
                    if(i==1)
                        return;
                }
            } catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
            int thoiGian;
            switch (cboThoiGian.getSelectedIndex()) {
                case 0:
                    thoiGian = 30;
                    break;
                case 1:
                    thoiGian = 45;
                    break;
                case 3:
                    thoiGian = 60;
                    break;
                case 4:
                    thoiGian = 90;
                    break;
                default:
                    thoiGian = 120;
            }
            try {
                String query = "{call procDeThi(?,?,?,?,?)}";
                CallableStatement statement;
                statement = ConnectSQL.connection.prepareCall(query);
                statement.setString(1, txtMaMH.getText());
                statement.setString(2, txtTenMH.getText());
                statement.setString(3, txtMaDT.getText());
                statement.setString(4, frmGiangVien.userGV);
                statement.setInt(5, thoiGian);

                if(statement.execute()){
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    added = true;
                }
                
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi không thêm được");
                System.out.println(e.getMessage());
            }

        }

    }//GEN-LAST:event_btnLuuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cboThoiGian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblMaDT;
    private javax.swing.JLabel lblMaMH;
    private javax.swing.JLabel lblTenMH;
    private javax.swing.JTextField txtMaDT;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
