package GiaoDien2;

import javax.swing.UIManager;

public class frmGiangVien extends javax.swing.JFrame {

    public frmGiangVien() {
        initComponents();
        myCustom();
    }
    private void myCustom(){
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnThemDT = new javax.swing.JButton();
        btnSuaDT = new javax.swing.JButton();
        XoaDT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSoCau = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSoCau1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboDT = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboDT1 = new javax.swing.JComboBox<>();
        btnErase = new javax.swing.JButton();
        btnData = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 550));
        setSize(new java.awt.Dimension(900, 550));
        getContentPane().setLayout(null);

        btnThemDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/add.png"))); // NOI18N
        btnThemDT.setToolTipText("Thêm đề thi");
        btnThemDT.setContentAreaFilled(false);
        getContentPane().add(btnThemDT);
        btnThemDT.setBounds(698, 11, 44, 41);

        btnSuaDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/edit.png"))); // NOI18N
        btnSuaDT.setToolTipText("Sửa đề thi");
        btnSuaDT.setContentAreaFilled(false);
        btnSuaDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDTActionPerformed(evt);
            }
        });
        getContentPane().add(btnSuaDT);
        btnSuaDT.setBounds(748, 11, 44, 41);

        XoaDT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/delete.png"))); // NOI18N
        XoaDT.setToolTipText("Xóa đề thi");
        XoaDT.setContentAreaFilled(false);
        XoaDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaDTActionPerformed(evt);
            }
        });
        getContentPane().add(XoaDT);
        XoaDT.setBounds(798, 11, 44, 41);

        jLabel1.setFont(getFont());
        jLabel1.setText("Chọn đề thi");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 21, 90, 20);

        jLabel3.setFont(getFont());
        jLabel3.setText("Tên môn học");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(127, 70, 380, 20);

        jLabel4.setFont(getFont());
        jLabel4.setText("Tổng số câu:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 70, 80, 20);

        lblSoCau.setFont(getFont());
        lblSoCau.setForeground(new java.awt.Color(255, 0, 0));
        lblSoCau.setText("90");
        getContentPane().add(lblSoCau);
        lblSoCau.setBounds(620, 70, 38, 20);

        jLabel5.setFont(getFont());
        jLabel5.setText("phút");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(800, 70, 30, 20);

        lblSoCau1.setFont(getFont());
        lblSoCau1.setForeground(new java.awt.Color(255, 0, 0));
        lblSoCau1.setText("90");
        getContentPane().add(lblSoCau1);
        lblSoCau1.setBounds(780, 70, 20, 20);

        jLabel6.setFont(getFont());
        jLabel6.setText("Thời gian:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(710, 70, 60, 20);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "List câu hỏi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, getFont()));

        jList1.setFont(getFont());
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 150, 380);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chi tiết câu hỏi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, getFont()));

        jLabel7.setFont(getFont());
        jLabel7.setText("Mã câu hỏi");

        jTextField1.setFont(getFont());
        jTextField1.setText("012345678912");

        jLabel9.setFont(getFont());
        jLabel9.setText("Cấp độ");

        cboDT.setFont(getFont());
        cboDT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhận biết", "Thông hiểu", "Vận dụng", "Vận dụng cao" }));
        cboDT.setSelectedIndex(3);

        jLabel10.setFont(getFont());
        jLabel10.setText("Nội dung câu hỏi");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(getFont());
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField2.setFont(getFont());
        jTextField2.setText("Đáp án đúng");
        jTextField2.setToolTipText("Đáp án đúng");

        jTextField3.setFont(getFont());
        jTextField3.setText("Đáp án sai");
        jTextField3.setToolTipText("Đáp án sai");

        jTextField4.setFont(getFont());
        jTextField4.setText("Đáp án sai");
        jTextField4.setToolTipText("Đáp án sai");

        jTextField5.setFont(getFont());
        jTextField5.setText("Đáp án sai");
        jTextField5.setToolTipText("Đáp án sai");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 296, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cboDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(180, 100, 710, 340);

        jLabel8.setFont(getFont());
        jLabel8.setText("Tên môn học:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 70, 90, 20);

        cboDT1.setFont(getFont());
        cboDT1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cboDT1);
        cboDT1.setBounds(127, 18, 561, 26);

        btnErase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/xoaCauHoi.png"))); // NOI18N
        btnErase.setMnemonic('E');
        btnErase.setText("Erase");
        btnErase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEraseActionPerformed(evt);
            }
        });
        getContentPane().add(btnErase);
        btnErase.setBounds(630, 450, 100, 33);

        btnData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/database.png"))); // NOI18N
        btnData.setMnemonic('D');
        btnData.setText("Data");
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });
        getContentPane().add(btnData);
        btnData.setBounds(310, 450, 90, 33);

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/refresh.png"))); // NOI18N
        btnReset.setMnemonic('R');
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);
        btnReset.setBounds(410, 450, 100, 33);

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmGiangVien/luuCauHoi.png"))); // NOI18N
        btnSave.setMnemonic('S');
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave);
        btnSave.setBounds(520, 450, 100, 33);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaDTActionPerformed

    private void XoaDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_XoaDTActionPerformed

    private void btnEraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEraseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEraseActionPerformed

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();

        } 

        java.awt.EventQueue.invokeLater(() -> {
            new frmGiangVien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton XoaDT;
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnErase;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSuaDT;
    private javax.swing.JButton btnThemDT;
    private javax.swing.JComboBox<String> cboDT;
    private javax.swing.JComboBox<String> cboDT1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblSoCau;
    private javax.swing.JLabel lblSoCau1;
    // End of variables declaration//GEN-END:variables

}
