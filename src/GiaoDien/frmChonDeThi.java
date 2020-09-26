package GiaoDien;

import KetNoi.ConnectSQL;
import java.sql.ResultSet;
import java.sql.Statement;

public class frmChonDeThi extends javax.swing.JFrame {

    private String username, hoTen;

    public frmChonDeThi(String username, String hoTen) {
        this.username = username;
        this.hoTen = hoTen;

        initComponents();

        lblTen.setText(hoTen);
        loadCboDeThi();
        myCustom();
    }

    private void loadCboDeThi() {
        try {
            ConnectSQL sql = new ConnectSQL();
            Statement statement;
            statement = sql.connection.createStatement();
            String query = String.format("select MaDT,TenMH "
                    + "from MonHoc a inner join DeThi b on a.MaMH=b.MaMH");
            ResultSet result = statement.executeQuery(query);
            String tenMh, maDT;
            while (result.next()) {
                maDT = result.getString("MaDT");
                tenMh = result.getString("TenMH");
                cboDeThi.addItem(maDT + " - " + tenMh);
            }
        } catch (Exception e) {
            System.out.println("jksdjfkuiwerjkl: " + e.getMessage());
        }
    }

    private void myCustom() {
        setTitle("Chọn đề thi");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        cboDeThi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnVaoThi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sinh viên: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chọn đề thi");

        lblTen.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTen.setText("Tên sinh viên");

        cboDeThi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đề thi:");

        btnVaoThi.setText("Vào thi");
        btnVaoThi.setActionCommand("");
        btnVaoThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaoThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(btnVaoThi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(cboDeThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnVaoThi)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaoThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaoThiActionPerformed
        String maDT = cboDeThi.getSelectedItem().toString().substring(0,4);
        
        frmSinhVien f2 = new frmSinhVien(username, maDT);
        f2.showWindows();
        this.dispose();

    }//GEN-LAST:event_btnVaoThiActionPerformed
//
//    public static void main(String args[]) {
//
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new frmChonDeThi("1811545103", "Đặng Quốc Lai").setVisible(true);
//        });
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVaoThi;
    private javax.swing.JComboBox<String> cboDeThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblTen;
    // End of variables declaration//GEN-END:variables

}
