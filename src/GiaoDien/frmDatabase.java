package GiaoDien;

import KetNoi.ConnectSQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import javax.swing.JTextField;
import java.awt.Rectangle;

public class frmDatabase extends JDialog {

    private JComboBox<String> cboNguon, cboDich;
    protected static ArrayList<String> listDeThi = new ArrayList<>();
    private ArrayList<String> alMaCH_Nguon = new ArrayList<>();
    private ArrayList<String> alMaCH_Dich = new ArrayList<>();
    private JScrollPane spNguon, spDich;
    private JList<String> lstMaCHNguon, lstMaCHDich;
    private PreparedStatement psGetMaCH, psGetCT_CH;
    private ResultSet resultSet;
    private String maDich, maNguon;
    private JTextField txtFind;
    private JLabel lblFind;
    private JTextArea txtNoiDungCH;

    private void addControl() {
        getContentPane().setLayout(null);

        JLabel lblNguon = new JLabel("Chọn nguồn câu hỏi");
        lblNguon.setFont(new Font("Arial", Font.PLAIN, 16));
        lblNguon.setFocusable(true);
        lblNguon.setBounds(10, 11, 157, 23);
        getContentPane().add(lblNguon);

        cboNguon = new JComboBox<String>();
        cboNguon.setRequestFocusEnabled(false);

        cboNguon.setBounds(10, 39, 157, 25);
        getContentPane().add(cboNguon);

        JLabel lblDich = new JLabel("Chọn đích đến");
        lblDich.setFont(new Font("Arial", Font.PLAIN, 16));
        lblDich.setBounds(302, 11, 157, 23);
        getContentPane().add(lblDich);

        cboDich = new JComboBox<String>();
        cboDich.setRequestFocusEnabled(false);
        cboDich.setBounds(302, 39, 157, 25);
        getContentPane().add(cboDich);

        spNguon = new JScrollPane();
        spNguon.setBounds(10, 90, 157, 308);
        getContentPane().add(spNguon);

        lstMaCHNguon = new JList<String>();
        spNguon.setViewportView(lstMaCHNguon);
        lstMaCHNguon.setFont(new Font("Arial", Font.PLAIN, 16));

        spDich = new JScrollPane();
        spDich.setBounds(302, 90, 157, 308);
        getContentPane().add(spDich);

        lstMaCHDich = new JList<String>();
        lstMaCHDich.setFont(lstMaCHNguon.getFont());
        spDich.setViewportView(lstMaCHDich);
        cboNguon.setFont(new Font("Arial", Font.PLAIN, 14));
        cboDich.setFont(cboNguon.getFont());
        txtNoiDungCH = new JTextArea();
        txtNoiDungCH.setBackground(new Color(0, 0, 0, 0));
        txtNoiDungCH.setWrapStyleWord(true);
        txtNoiDungCH.setLineWrap(true);
        txtNoiDungCH.setText("NoiDungCH");
        txtNoiDungCH.setOpaque(false);
        txtNoiDungCH.setBounds(10, 409, 410, 56);
        txtNoiDungCH.setEnabled(false);
        txtNoiDungCH.setDisabledTextColor(Color.black);
        getContentPane().add(txtNoiDungCH);

        JButton btnAdd = createBtn("Add");
        btnAdd.setBounds(173, 128, 123, 33);
        getContentPane().add(btnAdd);
        btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmDatabase/add.png")));

        JButton btnAddAll = createBtn("Add All");
        btnAddAll.setMargin(new Insets(2, 4, 2, 4));
        btnAddAll.setIcon(new ImageIcon(frmDatabase.class.getResource("/dataImage/frmDatabase/addAll.png")));
        btnAddAll.setBounds(173, 174, 123, 33);
        getContentPane().add(btnAddAll);

        JButton btnRemove = createBtn("Remove");
        btnRemove.setMargin(new Insets(2, 4, 2, 4));
        btnRemove.setIcon(new ImageIcon(frmDatabase.class.getResource("/dataImage/frmDatabase/remove.png")));
        btnRemove.setBounds(173, 218, 123, 33);
        getContentPane().add(btnRemove);

        JButton btnRemoveAll = createBtn("Remove All");
        btnRemoveAll.setMargin(new Insets(2, 4, 2, 4));
        btnRemoveAll.setIcon(new ImageIcon(frmDatabase.class.getResource("/dataImage/frmDatabase/removeAll.png")));
        btnRemoveAll.setBounds(173, 262, 123, 33);
        getContentPane().add(btnRemoveAll);

        btnAdd.setHorizontalTextPosition(SwingConstants.LEFT);
        btnAddAll.setHorizontalTextPosition(SwingConstants.LEFT);
        btnRemove.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnRemoveAll.setHorizontalTextPosition(SwingConstants.RIGHT);

        lblFind = new JLabel("");

        lblFind.setBounds(new Rectangle(0, 0, 16, 16));
        lblFind.setBounds(173, 90, 23, 23);
        lblFind.setFocusable(false);
        lblFind.setIcon(new ImageIcon(frmDatabase.class.getResource("/dataImage/frmDatabase/search.png")));
        getContentPane().add(lblFind);

        txtFind = new JTextField();
        txtFind.setBounds(198, 90, 94, 20);
        txtFind.setColumns(10);
        getContentPane().add(txtFind);
    }

    public frmDatabase(JFrame parent, String title) {
        super(parent, title, true);
        addControl();
        setCboDich();
        setCboNguon();
        cboDich.setSelectedIndex(0);
        cboNguon.setSelectedIndex(0);

        actCboDich();
        actCboNguon();
        addEvent();
    }

    public void run() {
        setAutoRequestFocus(false);
        setSize(483, 485);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setCboNguon() {
        cboNguon.addItem("Database ");
        for (String str : listDeThi) {
            cboNguon.addItem(str);
        }
    }

    private void setCboDich() {
        for (String str : listDeThi) {
            cboDich.addItem(str);
        }
    }

    private void addEvent() {
        cboNguon.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actCboNguon();
            }
        });
        cboDich.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actCboDich();
            }
        });

        setActLstMaCH(lstMaCHDich);
        setActLstMaCH(lstMaCHNguon);
    }

    ConnectSQL sql = new ConnectSQL();

    private void setActLstMaCH(JList<String> lst) {
        lst.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                String maCH = lst.getSelectedValue();
                try {
                    psGetCT_CH = sql.connection.prepareStatement("Select NoiDung from CauHoi where MaCauHoi=?");

                    psGetCT_CH.setString(1, maCH);
                    ResultSet r = psGetCT_CH.executeQuery();
                    while (r.next()) {
                        txtNoiDungCH.setText(r.getString("NoiDung"));
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        );
    }

    private JButton createBtn(String text) {
        JButton btn = new JButton(text);
        btn.setMargin(new Insets(2, 4, 2, 4));
        btn.setBorderPainted(true);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBackground(new Color(225, 225, 225));
        btn.setRequestFocusEnabled(false);
        btn.setFont(new Font("Arial", Font.PLAIN, 14));
        btn.setBorder(new LineBorder(new Color(195, 195, 195)));
        btn.addMouseListener(new MouseListener() {

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
                btn.setBorder(new LineBorder(new Color(195, 195, 195)));
                btn.setForeground(Color.BLACK);
            }

            public void mouseEntered(MouseEvent e) {
                btn.setBorder(new LineBorder(new Color(0, 119, 200), 2));
                btn.setForeground(new Color(0, 119, 200));
            }

            public void mouseClicked(MouseEvent e) {

            }
        });
        return btn;
    }

    private void actCboDich() {
        maDich = (String) cboDich.getSelectedItem();
        maDich = maDich.substring(0, maDich.indexOf(" "));

        ArrayList<String> array = new ArrayList<>();
        try {
            psGetMaCH = sql.connection.prepareStatement("Select c.MaCauHoi from CauHoi c "
                    + "inner join CT_DeThi d on c.MaCauHoi=d.MaCauHoi where MaDeThi=?");
            psGetMaCH.setString(1, maDich);
            resultSet = psGetMaCH.executeQuery();
            while (resultSet.next()) {
                array.add(resultSet.getString("MaCauHoi"));
            }
            lstMaCHDich.setListData(new Vector<>(array));
        } catch (SQLException e) {
            System.out.println("Không thể get MaCH cho lstMaCHDich");
            System.out.println(e.getMessage());
        }
    }

    private void actCboNguon() {
        maNguon = (String) cboNguon.getSelectedItem();
        maNguon = maNguon.substring(0, maNguon.indexOf(" "));
        ArrayList<String> array = new ArrayList<>();
        if (maNguon.equals("Database")) {
            try {
                psGetMaCH = sql.connection.
                        prepareStatement("Select CauHoi.MaCauHoi from CauHoi "
                                + "left join (select MaCauHoi from CT_DeThi where MaDeThi=?) d "
                                + "on (CauHoi.MaCauHoi = d.MaCauHoi)"
                                + "where d.MaCauHoi is null");
                psGetMaCH.setString(1, maDich);

                resultSet = psGetMaCH.executeQuery();
                while (resultSet.next()) {
                    array.add(resultSet.getString("MaCauHoi"));
                }

            } catch (Exception e) {
                System.err.println("242 - " + e.getMessage());
                System.out.println("maNguon = " + maNguon);
                System.out.println("maDich = " + maDich);
            }
        } else {
            try {
                psGetMaCH = sql.connection.prepareStatement("select c.MaCauHoi from "
                        + "(select MaCauHoi "
                        + "from CT_DeTHi where (MaDeThi = ?)) c "
                        + "left join  "
                        + "(select MaCauHoi "
                        + "from CT_DeTHi where (MaDeThi = ?)) d "
                        + "on c.MaCauHoi=d.MaCauHoi "
                        + "where d.MaCauHoi is null");
                psGetMaCH.setString(1, maNguon);
                psGetMaCH.setString(2, maDich);
                resultSet = psGetMaCH.executeQuery();
                while (resultSet.next()) {
                    array.add(resultSet.getString("MaCauHoi"));
                }

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        lstMaCHNguon.setListData(new Vector<>(array));
    }
}