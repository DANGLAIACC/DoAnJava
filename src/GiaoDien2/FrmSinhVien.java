package GiaoDien2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class FrmSinhVien extends javax.swing.JFrame {

    public FrmSinhVien() {
        initComponents();
        myCustom();
    }
    private void myCustom(){
        setLocationRelativeTo(null);
        setResizable(false);
        formatTxt(txtB);
        formatTxt(txtA);
        formatTxt(txtC);
        formatTxt(txtD);
        formatTxt(txtCauHoi);
        formatJScrollPane(jScrollPane1);        
        formatJScrollPane(jScrollPane2);
        formatJScrollPane(jScrollPane3);
        formatJScrollPane(jScrollPane4);
        formatJScrollPane(jScrollPane5);

        txtCauHoi.setFont(new Font("Arial",Font.PLAIN,18));
    }

    private void formatTxt(JTextArea txt) {
        txt.setEnabled(false);
        txt.setDisabledTextColor(Color.black);
        txt.setOpaque(false);
        txt.setFont(new Font("arial", Font.PLAIN, 16)); 
        txt.setWrapStyleWord(true);
        txt.setLineWrap(true); 
    }
    private void formatJScrollPane(JScrollPane sp){
        sp.setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setBackground(new Color(0, 0, 0, 0));
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(null);
        sp.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCauHoi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtB = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtC = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtA = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(837, 481));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("time");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(700, 0, 130, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tên môn học");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 630, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmSinhVien/time.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 0, 40, 40);

        txtCauHoi.setEditable(false);
        txtCauHoi.setColumns(20);
        txtCauHoi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCauHoi.setRows(5);
        txtCauHoi.setText("txtCauHoi");
        jScrollPane1.setViewportView(txtCauHoi);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 560, 140);

        txtB.setColumns(20);
        txtB.setRows(5);
        txtB.setText("txtB");
        jScrollPane2.setViewportView(txtB);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(310, 220, 270, 70);

        txtC.setColumns(20);
        txtC.setRows(5);
        txtC.setText("txtC");
        jScrollPane3.setViewportView(txtC);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 310, 270, 70);

        txtA.setColumns(20);
        txtA.setRows(5);
        txtA.setText("txtA");
        jScrollPane4.setViewportView(txtA);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(20, 220, 270, 70);

        txtD.setColumns(20);
        txtD.setRows(5);
        txtD.setText("txtD");
        jScrollPane5.setViewportView(txtD);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(310, 310, 270, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dataImage/frmSinhVien/background.png"))); // NOI18N
        jLabel1.setText("txtA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 840, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
        } 

        java.awt.EventQueue.invokeLater(() -> {
            new FrmSinhVien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextArea txtB;
    private javax.swing.JTextArea txtC;
    private javax.swing.JTextArea txtCauHoi;
    private javax.swing.JTextArea txtD;
    // End of variables declaration//GEN-END:variables

}
