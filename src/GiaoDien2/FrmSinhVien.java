package GiaoDien2;

import KetNoi.ConnectSQL;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import model.CauHoi;

public class frmSinhVien extends javax.swing.JFrame {

    private final ArrayList<CauHoi> lstCauHoi = new ArrayList<>();
    private int soCauHoi, cauHienTai, soCauTraLoi, cauTruoc;
    private JRadioButton[][] rdbtns;
    private JButton[] btnCau;

    public frmSinhVien() {
        initComponents();
        myCustom();
    }

    private void myCustom() {
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

        txtCauHoi.setFont(new Font("Arial", Font.PLAIN, 18));
    }

    private void getCauHoi() {
        ConnectSQL connect = new ConnectSQL();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connect = new ConnectSQL();
            statement = connect.connection.createStatement();
            resultSet = statement.executeQuery("select * from CauHoi");
            while (resultSet.next()) {
                ArrayList<String> listDapAn = new ArrayList<>();
                listDapAn.add(resultSet.getString("DapAn0"));
                listDapAn.add(resultSet.getString("DapAn1"));
                listDapAn.add(resultSet.getString("DapAn2"));
                listDapAn.add(resultSet.getString("DapAn3"));

                CauHoi cauHoi = new CauHoi();
                cauHoi.mach = resultSet.getString("MaCH");
                cauHoi.noiDung = resultSet.getString("NoiDung");
                cauHoi.dapAnDung = listDapAn.get(0);

                Collections.shuffle(listDapAn);

                cauHoi.arrDapAn[0] = "A. " + listDapAn.get(0);
                cauHoi.arrDapAn[1] = "B. " + listDapAn.get(1);
                cauHoi.arrDapAn[2] = "C. " + listDapAn.get(2);
                cauHoi.arrDapAn[3] = "D. " + listDapAn.get(3);

                lstCauHoi.add(cauHoi);
            }
            Collections.shuffle(lstCauHoi);
            soCauHoi = lstCauHoi.size();
            rdbtns = new JRadioButton[soCauHoi][4];

        } catch (SQLException e) {
            System.out.println("frmSinhVien.getCauHoi2(): " + e.getMessage());
        }finally{
            try{ statement.close();}catch(SQLException e){}
            try{ resultSet.close();}catch(SQLException e){}
            try{ connect.connection.close();}catch(Exception e){}

        }
    }

    private void renderRadioButton() {
        btnCau = new JButton[soCauHoi];
        int hang = 0, cot = 0;
        while (hang < soCauHoi) {
            ButtonGroup btnGroup = new ButtonGroup();

            cot = 0;

            while (cot < 5) {
                if (cot > 0) {
                    rdbtns[hang][cot - 1] = new JRadioButton();

                    InputMap inputMap2 = rdbtns[hang][cot - 1].getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
                    inputMap2.put(KeyStroke.getKeyStroke("RIGHT"), "no-action");
                    inputMap2.put(KeyStroke.getKeyStroke("LEFT"), "no-action");
                    inputMap2.put(KeyStroke.getKeyStroke("A"), "no-action");
                    inputMap2.put(KeyStroke.getKeyStroke("B"), "no-action");
                    inputMap2.put(KeyStroke.getKeyStroke("C"), "no-action");
                    inputMap2.put(KeyStroke.getKeyStroke("D"), "no-action");

                    rdbtns[hang][cot - 1].setOpaque(false);
                    rdbtns[hang][cot - 1].setBackground(new Color(0, 0, 0, 0));

                    rdbtns[hang][cot - 1].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 148, 255)));
                    rdbtns[hang][cot - 1].setBorderPainted(true);
                    btnGroup.add(rdbtns[hang][cot - 1]);

                    action_ChuyenCau(rdbtns[hang][cot - 1], hang);

                    pnDapAn.add(rdbtns[hang][cot - 1]);
                } else {
                    btnCau[hang] = new JButton("  " + (hang + 1));
                    btnCau[hang].setHorizontalAlignment(JLabel.LEFT);
                    btnCau[hang].setFont(new Font("Arial", Font.BOLD, 14));
                    btnCau[hang].setForeground(Color.blue);
                    btnCau[hang].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(77, 148, 255)));
                    btnCau[hang].setOpaque(false);
                    btnCau[hang].setBackground(new Color(0, 0, 0, 0));
                    btnCau[hang].setFocusPainted(false);
                    btnCau[hang].setContentAreaFilled(false);
                    action_ChuyenCau(btnCau[hang], hang);

                    pnDapAn.add(btnCau[hang]);
                }
                cot++;
            }
            hang++;
        }
    }

    private void action_ChuyenCau(AbstractButton rdbtn, int n) {
        rdbtn.addActionListener((ActionEvent arg0) -> {
            cauTruoc = cauHienTai;
            cauHienTai = n;
            chuyenCau();
        });
    }

    private void chuyenCau() {
        disableLblTick();
        txtCauHoi.setText("Câu " + (cauHienTai + 1) + ": " + listCauHoi.get(cauHienTai).noiDung);
        txtA.setText(listCauHoi.get(cauHienTai).dapAn0);
        txtB.setText(listCauHoi.get(cauHienTai).dapAn1);
        txtC.setText(listCauHoi.get(cauHienTai).dapAn2);
        txtD.setText(listCauHoi.get(cauHienTai).dapAn3);

        enableLblTick_pnDapAn();
        batMauChoDapAn();

        spDapAn.getVerticalScrollBar().setValue(rdbtns[cauHienTai][0].getY() - 157);

        if (!dangLamBai) {
            showDapAnDung();
        }
    }

    private void formatTxt(JTextArea txt) {
        txt.setEnabled(false);
        txt.setDisabledTextColor(Color.black);
        txt.setOpaque(false);
        txt.setFont(new Font("arial", Font.PLAIN, 16));
        txt.setWrapStyleWord(true);
        txt.setLineWrap(true);
    }

    private void formatJScrollPane(JScrollPane sp) {
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
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
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
        setPreferredSize(jLabel1.getPreferredSize());
        setResizable(false);
        setSize(new java.awt.Dimension(836, 481));
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

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(null);
        jScrollPane6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane6.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());
        jScrollPane6.setViewportView(jPanel1);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(601, 107, 232, 371);

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
        jLabel1.setBounds(0, 0, 840, 481);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(() -> {
            new frmSinhVien().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea txtA;
    private javax.swing.JTextArea txtB;
    private javax.swing.JTextArea txtC;
    private javax.swing.JTextArea txtCauHoi;
    private javax.swing.JTextArea txtD;
    // End of variables declaration//GEN-END:variables

}
