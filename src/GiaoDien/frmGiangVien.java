package GiaoDien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import KetNoi.ConnectSQL;
import java.awt.Dimension;
import java.util.Vector;
import model.CauHoi;
import model.DeThi;

public class frmGiangVien extends JFrame {

    private JTextField txtMaCH;
    private JScrollPane spMaCH;
    private JComboBox<DeThi> cboDeThi;
    private ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    private String tenGV, userGV;
    private JComboBox<String> cboCapDo;
    private JPanel pnButton, pnCauHoi;
    private JLabel lbl1, lbl3, lbl2, lblTenMH, lblSoLuong, lblThoiGian, lblMaDT;
    private JTextArea txtNoiDung, txtDapAn0, txtDapAn1, txtDapAn2, txtDapAn3;
    private JButton btnThem, btnSua, btnXoa, btnLuuCH, btnXoaCH, btnReset, btnForm1, btnDatabase;
    private Vector<String> listMaCH;
    private HashSet<String> listAllMaCH = new HashSet<>();
    private JList<String> lstMaCH;

    HashSet<String> listMaDT = new HashSet<>();

    PreparedStatement psGetChiTietCauHoi, psGetDeThi, psThemCH,
            psGetCH, psLuuCH, psThemCT_DeThi, psXoaCH;

//    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            frmGiangVien window = new frmGiangVien();
////            window.frThis.setVisible(true);
//            window.setVisible(true);
//
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) { // DQL
//            System.out.println("frmGiangVien2.main() - Lỗi set giao diện");
//        }
//    }
    ConnectSQL sql = new ConnectSQL();

    public frmGiangVien(String userGV, String tenGV) {
        this.tenGV = tenGV;
        this.userGV = userGV;
        
        try {
            psGetChiTietCauHoi = sql.connection.prepareStatement(
                    "select a.*,capdo "
                    + "from CauHoi a inner join CT_DeThi b on a.mach = b.mach "
                    + "where MaDT = ?");

            psThemCH = sql.connection.prepareStatement("Insert into CauHoi values(?,?,?,?,?,?,?)");
            psLuuCH = sql.connection.prepareStatement("Update CauHoi set "
                    + "NoiDung = ?,"
                    + "DapAn0 = ?,"
                    + "DapAn1 = ?,"
                    + "DapAn2 = ?,"
                    + "DapAn3 = ?,"
                    + "CapDo = ?"
                    + "where MaCH = ?");

            psGetCH = sql.connection.prepareStatement(
                    "select a.*,capdo "
                    + "from CauHoi a inner join CT_DeThi b on a.MaCH = b.MaCH "
                    + "where a.mach = ?"
            );
            psThemCT_DeThi = sql.connection.prepareStatement("insert into CT_DeThi (MaDT,MaCH) values (?,?)");
            psXoaCH = sql.connection.prepareStatement("Delete from CT_DeThi where MaDT=? and MaCH=?");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setCboDT();
        initialize();
        addEvents();
        getListAllMaCH();
    }

    private void getListAllMaCH() {
        try {
            Statement ps = sql.connection.createStatement();
            ResultSet resultSet = ps.executeQuery("Select MaCH from CauHoi");
            while (resultSet.next()) {
                listAllMaCH.add(resultSet.getString("MaCH"));
            }
            resultSet.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addEvents() {
        btnXoaCH.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                actXoaCH();
            }
        });
        cboDeThi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actCboDT();
            }
        });

        btnThem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actThemDT();
            }
        });

        btnSua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actSuaDT();
            }
        });

        btnXoa.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actXoaDT();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actBtnReset();
            }
        });
        btnLuuCH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                actLuuCH();
            }
        });
        lstMaCH.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = lstMaCH.getSelectedIndex();
                if (index != -1) {
                    actLstMaCH(index);
                }
            }
        });

        lstMaCH.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                int index = lstMaCH.getSelectedIndex();
                if (index != -1) {
                    actLstMaCH(index);
                }
            }

            public void keyPressed(KeyEvent e) {
            }
        });

        txtMaCH.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                if (listAllMaCH.contains(txtMaCH.getText()))
					try {
                    psGetCH.setString(1, txtMaCH.getText());
                    ResultSet rs = psGetCH.executeQuery();
                    CauHoi ch = new CauHoi();
                    rs.next();
                    ch.noiDung = rs.getString("NoiDung");
                    ch.dapAn0 = rs.getString("DapAn0");
                    ch.dapAn1 = rs.getString("DapAn1");
                    ch.dapAn2 = rs.getString("DapAn2");
                    ch.dapAn3 = rs.getString("DapAn3");
                    ch.capDo = rs.getByte("CapDo");
                    setTxt(ch);
                } catch (Exception e) {
                    System.out.println("Lỗi ở phần addDocumentListener: " + e.getMessage());
                    e.printStackTrace();
                } else {
                    setTxt();
                }
//				boolean check = listMaCH.contains(txtMaCH.getText());
//				//Mã câu hỏi đã tồn tại trong đề thi thì ko thêm nữa
//				btnThemCH.setEnabled(!check);
            }

            public void removeUpdate(DocumentEvent arg0) {
                update();
            }

            public void insertUpdate(DocumentEvent arg0) {
                update();
            }

            public void changedUpdate(DocumentEvent arg0) {
                update();
            }
        });

        ActionListener isEmpty = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (txtMaCH.getText().isEmpty()
                        || txtNoiDung.getText().isEmpty()
                        || txtDapAn0.getText().isEmpty()
                        || txtDapAn1.getText().isEmpty()
                        || txtDapAn2.getText().isEmpty()
                        || txtDapAn3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Câu hỏi không hợp lệ");
                }
            }
        };
        btnLuuCH.addActionListener(isEmpty);
        btnDatabase.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actBtnDatabase();
            }
        });
    }

    private void actBtnDatabase() {
        frmDatabase database = new frmDatabase(this, "Mở Database");
        database.run();
    }

    private void actXoaCH() {
        byte chon = (byte) JOptionPane.showConfirmDialog(null, "Xóa câu hỏi khỏi bộ đề hiện tại?", "Xác nhận Xóa", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (chon == 0) {
            try {
                psXoaCH.setString(1, lblMaDT.getText());
                psXoaCH.setString(2, txtMaCH.getText());
                psXoaCH.execute();
                int i = listMaCH.indexOf(txtMaCH.getText());
                listMaCH.remove(i);
                lstMaCH.setListData(listMaCH);
                listCauHoi.remove(i);
                lblSoLuong.setText(listMaCH.size() + "");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Không thể xóa câu hỏi.");
                System.out.println(e.getMessage());
            }

        }
    }

    private void actLuuCH() {
        /*
		 * btnLuuCH xử lý như sau:
		 * Kiểm tra MaCH đã tồn tại trong table CauHoi chưa? nếu chưa thì Insert into
		 * Nếu đã tồn tại thì 
		 * Kiểm tra các txt có bị thay đổi ko? nếu có thì update lại bảng CauHoi
		 * 
		 * Sau cùng là kiểm tra MaCH đã có trong listMaCH.constraint() chưa
		 * nếu chưa thì thêm mới câu hỏi vào bộ đề insert into CT_CauHoi
		 * */
        boolean check1 = listAllMaCH.contains(txtMaCH.getText());
        boolean check2 = listMaCH.contains(txtMaCH.getText());
        CauHoi ch = getCauHoi();
        if (check1) // đã tồn tại trong bảng CauHoi
			try {
            psLuuCH.setString(1, ch.noiDung);
            psLuuCH.setString(2, ch.dapAn0);
            psLuuCH.setString(3, ch.dapAn1);
            psLuuCH.setString(4, ch.dapAn2);
            psLuuCH.setString(5, ch.dapAn3);
            psLuuCH.setByte(6, ch.capDo);
            psLuuCH.setString(7, ch.mach);

            psLuuCH.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể cập nhật câu hỏi.");
            e.printStackTrace();
        } else 
			try {
            psThemCH.setString(1, ch.mach);
            psThemCH.setString(2, ch.noiDung);
            psThemCH.setString(3, ch.dapAn0);
            psThemCH.setString(4, ch.dapAn1);
            psThemCH.setString(5, ch.dapAn2);
            psThemCH.setString(6, ch.dapAn3);
            psThemCH.setByte(7, ch.capDo);
            psThemCH.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm câu hỏi vào Database.");
            e.printStackTrace();
        }
        if (!check2) {
            try {
                psThemCT_DeThi.setString(1, lblMaDT.getText());
                psThemCT_DeThi.setString(2, txtMaCH.getText());
                psThemCT_DeThi.execute();

                listCauHoi.add(ch);
                listAllMaCH.add(txtMaCH.getText());
                listMaCH.add(ch.mach);
                lstMaCH.setListData(new Vector<>(listMaCH));
                lblSoLuong.setText(listMaCH.size() + "");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Không thể thêm câu hỏi vào bộ đề");
                System.out.println(e.getMessage());
            }
        }
    }

    private void setCboDT() {
        cboDeThi = new JComboBox<DeThi>();
        try {
            psGetDeThi = sql.connection.prepareStatement(
                    "select madt,TenMH,ThoiGian "
                    + "from dethi a inner join monhoc b on a.MaMH= b.mamh");
            ResultSet resultSet = psGetDeThi.executeQuery();
            while (resultSet.next()) {
                DeThi dt = new DeThi();
                dt.setMaDT(resultSet.getString("MaDT"));
                dt.setTenMH(resultSet.getString("TenMH"));
                dt.setThoiGian(resultSet.getByte("ThoiGian"));
                listMaDT.add(dt.getMaDT());
                cboDeThi.addItem(dt);
                frmDatabase.listDeThi.add(dt.toString());
            }
        } catch (Exception e) {
            System.out.println("Dong 349: " + e.getMessage());
        }
    }

    private void actCboDT() {
        DeThi dt = (DeThi) cboDeThi.getSelectedItem();
        listCauHoi.clear();
        setLstMaCH(dt.getMaDT());
        lblTenMH.setText(dt.getTenMH());
        lblMaDT.setText(dt.getMaDT());
        lblSoLuong.setText(listCauHoi.size() + "");
        lblThoiGian.setText(dt.getThoiGian() + "");

        if (listCauHoi.size() > 0) {
            lstMaCH.setSelectedIndex(0);
            actLstMaCH(0);
        } else {
            setTxt();
            txtMaCH.setText("");
        }
    }

    private void setTxt() {
        txtNoiDung.setText("");
        txtDapAn0.setText("");
        txtDapAn1.setText("");
        txtDapAn2.setText("");
        txtDapAn3.setText("");
        cboCapDo.setSelectedIndex(0);
    }

    private void setTxt(CauHoi ch) {
        txtNoiDung.setText(ch.noiDung);
        txtDapAn0.setText(ch.dapAn0);
        txtDapAn1.setText(ch.dapAn1);
        txtDapAn2.setText(ch.dapAn2);
        txtDapAn3.setText(ch.dapAn3);
        cboCapDo.setSelectedIndex(ch.capDo);
    }

    private void actLstMaCH(int index) {
        CauHoi ch = listCauHoi.get(index);
        txtMaCH.setText(ch.mach);
        setTxt(ch);
    }

    private void setLstMaCH(String maDT) {
        listMaCH = new Vector<>();
        try {
            psGetChiTietCauHoi.setString(1, maDT);
            ResultSet resultSet = psGetChiTietCauHoi.executeQuery();

            while (resultSet.next()) {
                CauHoi ch = new CauHoi();
                ch.mach = resultSet.getString("MaCH");
                ch.noiDung = resultSet.getString("NoiDung");
                ch.dapAn0 = resultSet.getString("DapAn0");
                ch.dapAn1 = resultSet.getString("DapAn1");
                ch.dapAn2 = resultSet.getString("DapAn2");
                ch.dapAn3 = resultSet.getString("DapAn3");
                ch.capDo = resultSet.getByte("CapDo");
                listCauHoi.add(ch);
                listMaCH.add(ch.mach);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lstMaCH.setListData(new Vector<>(listMaCH));
        }

    }

    private void actThemDT() {
        frmDeThi themDT = new frmDeThi(this, "Thêm đề thi");
        themDT.run();
        if (themDT.changeDT) // thêm thành công thì sửa lại cái cbo đề thi
        {
            cboDeThi.addItem(new DeThi(themDT.getMaDT(), themDT.getTenMH(), themDT.getTime()));
        }
    }

    private void initialize() {
        setTitle("Sửa bộ đề - "+tenGV);
        setBounds(100, 100, 900, 546);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        cboDeThi.setBounds(33, 15, 692, 26);
        cboDeThi.setFocusable(false);
        cboDeThi.setFont(new Font("arial", Font.PLAIN, 14));
        try {
            cboDeThi.setSelectedIndex(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        getContentPane().add(cboDeThi);

        btnThem = new JButton();
        btnThem.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/add.png")));
        btnThem.setBounds(729, 11, 38, 35);
        btnThem.setContentAreaFilled(false);
        btnThem.setFocusable(false);
        btnThem.setToolTipText("Thêm đề thi");
        getContentPane().add(btnThem);

        btnSua = new JButton();
        btnSua.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/edit.png")));
        btnSua.setContentAreaFilled(false);
        btnSua.setBounds(769, 11, 38, 35);
        btnSua.setToolTipText("Sửa đề thi");
        btnSua.setFocusable(false);

        getContentPane().add(btnSua);

        btnXoa = new JButton();
        btnXoa.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/delete.png")));
        btnXoa.setContentAreaFilled(false);
        btnXoa.setBounds(807, 11, 38, 35);
        btnXoa.setToolTipText("Xóa đề thi");
        getContentPane().add(btnXoa);

        btnXoa.setFocusable(false);

        spMaCH = new JScrollPane();
        spMaCH.setBounds(10, 73, 142, 419);
        spMaCH.getVerticalScrollBar().setPreferredSize(new Dimension(18, Integer.MAX_VALUE));

        getContentPane().add(spMaCH);
        spMaCH.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spMaCH.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        TitledBorder tit1 = new TitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "List câu hỏi");
        spMaCH.setBorder(tit1);

        lstMaCH = new JList<>();
        lstMaCH.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstMaCH.setFont(new Font("Arial", Font.PLAIN, 16));

        lstMaCH.setOpaque(false);

        spMaCH.setViewportView(lstMaCH);
        tit1.setTitleFont(new Font("Segoe ui", Font.PLAIN, 15));

        pnCauHoi = new JPanel();
        pnCauHoi.setBounds(156, 73, 718, 383);
        getContentPane().add(pnCauHoi);
        TitledBorder tit2 = new TitledBorder(BorderFactory.createLineBorder(Color.darkGray), "Chi tiết câu hỏi");
        tit2.setTitleFont(new Font("Segoe ui", Font.PLAIN, 15));
        pnCauHoi.setBorder(tit2);
        pnCauHoi.setLayout(null);

        txtMaCH = new JTextField();
        txtMaCH.setText("MaCH");
        txtMaCH.setBounds(137, 22, 146, 33);
        txtMaCH.setFont(new Font("Arial", Font.BOLD, 16));
        pnCauHoi.add(txtMaCH);

        txtNoiDung = new JTextArea();
        txtNoiDung.setText("Nội dung câu hỏi");
        txtNoiDung.setBounds(10, 79, 698, 104);
        txtNoiDung.setFont(new Font("Arial", Font.PLAIN, 16));
        txtNoiDung.setWrapStyleWord(true);
        txtNoiDung.setLineWrap(true);
        pnCauHoi.add(txtNoiDung);

        txtDapAn0 = new JTextArea();
        txtDapAn0.setText("Đáp án đúng");
        txtDapAn0.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDapAn0.setBounds(10, 206, 698, 23);
        pnCauHoi.add(txtDapAn0);

        txtDapAn1 = new JTextArea();
        txtDapAn1.setText("Đáp án sai 1");
        txtDapAn1.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDapAn1.setBounds(10, 251, 698, 23);
        pnCauHoi.add(txtDapAn1);

        txtDapAn2 = new JTextArea();
        txtDapAn2.setText("Đáp án sai 2");
        txtDapAn2.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDapAn2.setBounds(10, 295, 698, 23);
        pnCauHoi.add(txtDapAn2);

        txtDapAn3 = new JTextArea();
        txtDapAn3.setText("Đáp án sai 3");
        txtDapAn3.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDapAn3.setBounds(10, 344, 698, 23);
        pnCauHoi.add(txtDapAn3);

        cboCapDo = new JComboBox<>();
        cboCapDo.setBounds(384, 28, 150, 23);
        cboCapDo.addItem("Nhận biết");
        cboCapDo.addItem("Thông hiểu");
        cboCapDo.addItem("Vận dụng");
        cboCapDo.addItem("Vận dụng cao");

        pnCauHoi.add(cboCapDo);
        btnXoa.setFocusable(false);

        lbl1 = new JLabel("Tên môn học: ");
        lbl1.setBounds(10, 48, 88, 20);
        getContentPane().add(lbl1);

        lbl2 = new JLabel("Tổng số câu");
        lbl2.setBounds(485, 48, 70, 20);
        getContentPane().add(lbl2);

        lbl3 = new JLabel("Thời gian");
        lbl3.setBounds(609, 48, 62, 20);
        getContentPane().add(lbl3);

        JLabel lbl4 = new JLabel("phút");
        lbl4.setBounds(695, 48, 29, 20);
        getContentPane().add(lbl4);

        lblTenMH = new JLabel("Môn học gì gì đó");
        lblTenMH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTenMH.setBounds(92, 48, 389, 20);
        getContentPane().add(lblTenMH);

        lblSoLuong = new JLabel("100");
        lblSoLuong.setForeground(Color.RED);
        lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSoLuong.setBounds(558, 48, 42, 20);
        getContentPane().add(lblSoLuong);

        lblThoiGian = new JLabel("120");
        lblThoiGian.setForeground(Color.BLUE);
        lblThoiGian.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblThoiGian.setBounds(668, 48, 42, 20);
        getContentPane().add(lblThoiGian);

        lblMaDT = new JLabel("");

        cboDeThi.setSelectedIndex(0);

        pnButton = new JPanel();
        pnButton.setBounds(156, 457, 718, 43);
        getContentPane().add(pnButton);

        btnForm1 = new JButton("Form 2 (F)");
        btnForm1.setMnemonic('F');
        btnForm1.setMargin(new Insets(2, 8, 2, 8));
        pnButton.add(btnForm1);
        btnForm1.setIcon(new ImageIcon(frmGiangVien.class.getResource("/dataImage/frmGiangVien/formCopyPaste.png")));
        btnForm1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnForm1.setFocusable(false);

        btnDatabase = new JButton("Data (D)");
        btnDatabase.setMargin(new Insets(2, 8, 2, 8));
        pnButton.add(btnDatabase);
        btnDatabase.setIcon(new ImageIcon(frmGiangVien.class.getResource("/dataImage/frmGiangVien/database.png")));
        btnDatabase.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDatabase.setFocusable(false);

        btnReset = new JButton("Reset (R)");

        pnButton.add(btnReset);
        btnReset.setMargin(new Insets(2, 8, 2, 8));
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReset.setFocusable(false);
        btnReset.setIcon(new ImageIcon(frmGiangVien.class.getResource("/dataImage/frmGiangVien/refresh.png")));
//		
//		btnThemCH = new JButton("Thêm (A)");
//		
//		pnButton.add(btnThemCH);
//		btnThemCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnThemCH.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/themCauHoi.png")));
//		btnThemCH.setFocusable(false);
//		btnThemCH.setEnabled(false);
//		btnThemCH.setMargin(new Insets(2, 8, 2, 8));
//		
        btnLuuCH = new JButton("Lưu (S)");
        btnLuuCH.setMnemonic('S');
        pnButton.add(btnLuuCH);
        btnLuuCH.setMargin(new Insets(2, 8, 2, 8));

        btnLuuCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnLuuCH.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/luuCauHoi.png")));
        btnLuuCH.setFocusable(false);

        btnXoaCH = new JButton("Xóa");
        btnXoaCH.setMargin(new Insets(2, 8, 2, 8));
        pnButton.add(btnXoaCH);
        btnXoaCH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnXoaCH.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmGiangVien/xoaCauHoi.png")));

        btnDatabase.setPreferredSize(btnForm1.getPreferredSize());
        btnReset.setPreferredSize(btnForm1.getPreferredSize());
        btnLuuCH.setPreferredSize(btnForm1.getPreferredSize());
        btnXoaCH.setPreferredSize(btnForm1.getPreferredSize());

        actCboDT();

    }

    private CauHoi getCauHoi() {
        CauHoi ch = new CauHoi();
        ch.mach = txtMaCH.getText();
        ch.noiDung = txtNoiDung.getText();
        ch.dapAn0 = txtDapAn0.getText();
        ch.dapAn1 = txtDapAn1.getText();
        ch.dapAn2 = txtDapAn2.getText();
        ch.dapAn3 = txtDapAn3.getText();
        ch.capDo = (byte) (cboCapDo.getSelectedIndex() + 1);
        return ch;
    }

    private void actBtnReset() {
        txtMaCH.setText("");
        setTxt();
        txtMaCH.requestFocus();
    }

    private void actXoaDT() {
        DeThi dt = (DeThi) cboDeThi.getSelectedItem();
        int x = JOptionPane.showConfirmDialog(null, "Xóa đề thi?", "Xác nhận xóa đề thi", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (x == 0) {
            try {
                PreparedStatement psXoaDT = sql.connection.prepareStatement(
                        "Delete from DeThi where MaDT = '" + dt.getMaDT() + "'");
                PreparedStatement psXoaCTDT = sql.connection.prepareStatement(
                        "Delete from CT_DeThi where MaDT = '" + dt.getMaDT() + "'");
                psXoaCTDT.execute();
                psXoaDT.execute();
                cboDeThi.removeItem(dt);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi không xóa được");
                System.out.println(e.getMessage());
            }
        }
    }

    private void actSuaDT() {
        frmDeThi suaDT = new frmDeThi(this, "Sửa đề thi");
        suaDT.setLocationRelativeTo(null);
        suaDT.setData(lblMaDT.getText(), lblTenMH.getText(), Byte.parseByte(lblThoiGian.getText()));
        suaDT.run();
        if (suaDT.changeDT) // thêm sửa thì sửa lại cái cbo đề thi
        {
            DeThi dt = (DeThi) cboDeThi.getSelectedItem();
            cboDeThi.removeItem(dt);
            dt = new DeThi(suaDT.getMaDT(), suaDT.getTenMH(), suaDT.getTime());
            cboDeThi.addItem(dt);
            cboDeThi.setSelectedItem(dt);
        }
    }
}
