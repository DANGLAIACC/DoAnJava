package GiaoDien;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

import KetNoi.Access;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;
import model.CauHoi;

public class frmSinhVien extends JFrame {

    private JLabel lblPre, lblNext, lblFinish, lblTickA, lblTickB, lblTickC, lblTickD;
    private JLabel lblMonHoc, lblCheChuThich;
    private String tenMonHoc;
    private long thoiGian;
    private JScrollPane spDapAn;
    private final ArrayList<CauHoi> listCauHoi;
    private JTextArea txtCauHoi, txtA, txtB, txtC, txtD;
    private int soCauHoi, cauHienTai, soCauTraLoi, cauTruoc;
    private JRadioButton[][] rdbtns;
    private JButton[] btnCau;
    private boolean[] cauDung;
    private boolean dangLamBai = true;
//    private final ImageIcon iconSua,iconDung,iconSai,iconChon;;
    private final ImageIcon iconSua = new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/tickSua32.png"));
    private final ImageIcon iconDung = new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/true32.png"));
    private final ImageIcon iconSai = new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/wrong24.png"));
    private final ImageIcon iconChon = new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/tickChon32.png"));
    private JPanel pnDapAn;
    private Timer t;

    public frmSinhVien() {
        this.listCauHoi = new ArrayList<>();
        getCauHoi2();
        this.addControls();
        this.addEvents();
        this.setUndecorated(true);
    }

//	private void getCauHoi() { // by file txt
//		listCauHoi = new ArrayList<CauHoi>();
//		File file = new File("arrayTuTuong");
//		
//		try {
//			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"));
//			String string ="";
//			while((string=reader.readLine())!=null) {
//				String[] strSplit = string.split("--");
//				ArrayList<String> arrDapAn = new ArrayList<>();
//				
//				arrDapAn.add(strSplit[1]);
//				arrDapAn.add(strSplit[2]);
//				arrDapAn.add(strSplit[3]);
//				arrDapAn.add(strSplit[4]);
//				
//				CauHoi cauHoi = new CauHoi();
//				cauHoi.noiDung = strSplit[0];
//				cauHoi.dapAnDung = strSplit[1];
//				
//				Collections.shuffle(arrDapAn);
//				
//				cauHoi.dapAn0 = arrDapAn.get(0);
//				cauHoi.dapAn1 = arrDapAn.get(1);
//				cauHoi.dapAn2 = arrDapAn.get(2);
//				cauHoi.dapAn3 = arrDapAn.get(3);
//				
//				listCauHoi.add(cauHoi);
//			}
//			reader.close();
//		} catch(Exception e) {}
//		
//		Collections.shuffle(listCauHoi);
//		soCauHoi = listCauHoi.size();
//		rdbtns = new JRadioButton[soCauHoi][4];
//		cauDung = new boolean[soCauHoi];
//		
//	}
    private void getCauHoi2() {//get câu hỏi bằng accdb
        try {
            Access access = new Access();
            Statement statement;
            statement = access.connection.createStatement();
            ResultSet result = statement.executeQuery("select * from CauHoi");
            while (result.next()) {
                ArrayList<String> listDapAn = new ArrayList<>();
                listDapAn.add(result.getString("DapAn0"));
                listDapAn.add(result.getString("DapAn1"));
                listDapAn.add(result.getString("DapAn2"));
                listDapAn.add(result.getString("DapAn3"));

                CauHoi cauHoi = new CauHoi();
                cauHoi.mach = "";
                cauHoi.noiDung = result.getString("NoiDung");
                cauHoi.dapAnDung = listDapAn.get(0);

                Collections.shuffle(listDapAn);

                cauHoi.dapAn0 = "A. " + listDapAn.get(0);
                cauHoi.dapAn1 = "B. " + listDapAn.get(1);
                cauHoi.dapAn2 = "C. " + listDapAn.get(2);
                cauHoi.dapAn3 = "D. " + listDapAn.get(3);

                String dapAnDung = "";

                if (listDapAn.get(0).equals(cauHoi.dapAnDung)) {
                    dapAnDung = "A. " + cauHoi.dapAnDung;
                } else if (listDapAn.get(1).equals(cauHoi.dapAnDung)) {
                    dapAnDung = "B. " + cauHoi.dapAnDung;
                } else if (listDapAn.get(2).equals(cauHoi.dapAnDung)) {
                    dapAnDung = "C. " + cauHoi.dapAnDung;
                } else if (listDapAn.get(3).equals(cauHoi.dapAnDung)) {
                    dapAnDung = "D. " + cauHoi.dapAnDung;
                }

                cauHoi.dapAnDung = dapAnDung;

                listCauHoi.add(cauHoi);
            }
            Collections.shuffle(listCauHoi);
            soCauHoi = listCauHoi.size();
            rdbtns = new JRadioButton[soCauHoi][4];
            cauDung = new boolean[soCauHoi];

        } catch (SQLException e) {
            System.out.println("frmSinhVien.getCauHoi2(): " + e.getMessage());
        }
    }

    private void addEvents() {
        Action actionNext = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionNext();
            }
        };

        Action actionPrevious = new AbstractActionImpl1();

        Action action_A_Press = new AbstractActionImpl();

        Action action_B_Press;
        action_B_Press = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!dangLamBai) {
                    return;
                }
                disableLblTick();
                lblTickB.setIcon(iconChon);
                lblTickB.setVisible(true);
                rdbtns[cauHienTai][1].setSelected(true);
            }
        };
        Action action_C_Press = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!dangLamBai) {
                    return;
                }
                disableLblTick();
                lblTickC.setIcon(iconChon);
                lblTickC.setVisible(true);
                rdbtns[cauHienTai][2].setSelected(true);
            }
        };
        Action action_D_Press = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!dangLamBai) {
                    return;
                }
                disableLblTick();
                lblTickD.setIcon(iconChon);
                lblTickD.setVisible(true);
                rdbtns[cauHienTai][3].setSelected(true);
            }
        };

        addActionlbl_Mouse(lblPre);
        addActionlbl_Mouse(lblNext);
        addActionlbl_Mouse(lblFinish);

        addActionPnABCD_Mouse(txtA, lblTickA);
        addActionPnABCD_Mouse(txtB, lblTickB);
        addActionPnABCD_Mouse(txtC, lblTickC);
        addActionPnABCD_Mouse(txtD, lblTickD);

        addAction_Key(lblPre, KeyEvent.VK_LEFT, actionPrevious);
        addAction_Key(lblNext, KeyEvent.VK_RIGHT, actionNext);

        InputMap inputMap = pnDapAn.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("A"), "A");
        inputMap.put(KeyStroke.getKeyStroke("B"), "B");
        inputMap.put(KeyStroke.getKeyStroke("C"), "C");
        inputMap.put(KeyStroke.getKeyStroke("D"), "D");

        pnDapAn.getActionMap().put("A", action_A_Press);
        pnDapAn.getActionMap().put("B", action_B_Press);
        pnDapAn.getActionMap().put("C", action_C_Press);
        pnDapAn.getActionMap().put("D", action_D_Press);

    }

    private void actionFinish() {
        if (!dangLamBai) {
            return;
        }
        t.stop();
        int i = 0;
        int soCauDung = 0;
        String strChon = "";

        while (i < listCauHoi.size()) {
            if (rdbtns[i][0].isSelected()) {
                strChon = listCauHoi.get(i).dapAn0;
                if (strChon.equals(listCauHoi.get(i).dapAnDung)) {
                    rdbtns[i][0].setIcon(iconDung);
                    soCauDung++;
                    cauDung[i] = true;
                } else {
                    rdbtns[i][0].setIcon(iconSai);
                    btnCau[i].setForeground(Color.red);
                }
            } else if (rdbtns[i][1].isSelected()) {
                strChon = listCauHoi.get(i).dapAn1;
                if (strChon.equals(listCauHoi.get(i).dapAnDung)) {
                    rdbtns[i][1].setIcon(iconDung);
                    soCauDung++;
                    cauDung[i] = true;
                } else {
                    rdbtns[i][1].setIcon(iconSai);
                    btnCau[i].setForeground(Color.red);
                }
            } else if (rdbtns[i][2].isSelected()) {
                strChon = listCauHoi.get(i).dapAn2;
                if (strChon.equals(listCauHoi.get(i).dapAnDung)) {
                    rdbtns[i][2].setIcon(iconDung);
                    soCauDung++;
                    cauDung[i] = true;
                } else {
                    rdbtns[i][2].setIcon(iconSai);
                    btnCau[i].setForeground(Color.red);
                }
            } else if (rdbtns[i][3].isSelected()) {
                strChon = listCauHoi.get(i).dapAn3;
                if (strChon.equals(listCauHoi.get(i).dapAnDung)) {
                    rdbtns[i][3].setIcon(iconDung);
                    soCauDung++;
                    cauDung[i] = true;
                } else {
                    rdbtns[i][3].setIcon(iconSai);
                    btnCau[i].setForeground(Color.red);
                }
            } else {
                btnCau[i].setForeground(Color.red);
            }
            i++;
        }
        // strChon xong nhiệm vụ, giờ nó sẽ lưu format của điểm
        strChon = String.format("Số câu đúng: %d câu.%nĐiểm: %.2f.", soCauDung, (soCauDung * 10.0 / listCauHoi.size()));
        JOptionPane.showMessageDialog(null, strChon);
        lblCheChuThich.setVisible(false);
        xemLaiBaiThi();
    }

    private void xemLaiBaiThi() {
        int i = 0, j = 0;
        while (i < soCauHoi) {
            j = 0;
            while (j < 4) {
                if (!rdbtns[i][j].isSelected()) {
                    rdbtns[i][j].setEnabled(false);
                }
                j++;
            }
            i++;
        }
        dangLamBai = false;
        chuyenCau();
    }

    private void actionPrevious() {
        if (cauHienTai > 0) {
            cauTruoc = cauHienTai;
            cauHienTai--;
            chuyenCau();
        }
    }

    private void actionNext() {
        if (cauHienTai < soCauHoi - 1) // không thể next được
        {
            cauTruoc = cauHienTai;
            cauHienTai++;
            chuyenCau();
        }
    }

    private void addActionPnABCD_Mouse(JTextArea txt, JLabel lblTick) {
        /*
		  Khi kích vào txtA thì sẽ cho nó dấu check
		  đồng thời set rdbtns[cauHienTai][0] = selected
         */
        txt.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                txt.setBorder(null);
                txt.setFont(new Font("Segoe ui", Font.PLAIN, 18));
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                txt.setBorder(BorderFactory.createLineBorder(Color.white));
                txt.setFont(new Font("Segoe ui", Font.BOLD, 19));
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!dangLamBai) {
                    return;
                }
                lblTick.setVisible(true);
                if (txt == txtA) {
                    rdbtns[cauHienTai][0].setSelected(true);
                } else if (txt == txtB) {
                    rdbtns[cauHienTai][1].setSelected(true);
                } else if (txt == txtC) {
                    rdbtns[cauHienTai][2].setSelected(true);
                } else if (txt == txtD) {
                    rdbtns[cauHienTai][3].setSelected(true);
                }
                // nếu user kích 2 đáp án thì sẽ xóa dấu tick của
                // đáp án chọn trước
                disableLblTick();
                enableLblTick_pnDapAn();
            }
        });
    }

    private void addActionlbl_Mouse(JLabel lbl) {
        lbl.addMouseListener(new MouseListener() {

            public void mouseReleased(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                // chuot ben ngoai
                if (lbl == lblNext) {
                    lbl.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/right.png")));
                } else if (lbl == lblPre) {
                    lbl.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/left.png")));
                } else if (lbl == lblFinish) {
                    lblFinish.setOpaque(false);
                    lblFinish.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
                    lblFinish.setForeground(Color.black);
                }
            }

            public void mouseEntered(MouseEvent e) {
                if (lbl == lblNext) {
                    lbl.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/rightm.png")));
                } else if (lbl == lblPre) {
                    lbl.setIcon(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/leftm.png")));
                } else if (lbl == lblFinish) {
                    lblFinish.setOpaque(true);
                    lblFinish.setBackground(new Color(77, 148, 255));
                    lblFinish.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
                    lblFinish.setForeground(Color.white);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (lbl == lblNext) {
                    actionNext();
                } else if (lbl == lblPre) {
                    actionPrevious();
                } else if (lbl == lblFinish) {
                    actionFinish();
                }
            }
        });
    }

    private void addAction_Key(JComponent component, int c, Action action) {
        component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(KeyStroke.getKeyStroke(c, 0), "action");
        component.getActionMap().put("action", action);
    }

    private void addControls() {
        Container container = getContentPane();
        ImageIcon image = new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/background.png"));

        JPanel pnMain = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(image.getImage(), 0, 0, null);
            }
        };
        pnMain.setLayout(null);

        container.add(pnMain);
        tenMonHoc = "Tư tưởng Hồ Chí Minh";
        lblMonHoc = new JLabel(tenMonHoc);
        lblMonHoc.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonHoc.setBounds(4, 3, 626, 38);
        lblMonHoc.setFont(new Font("Arial", Font.BOLD, 22));
        lblMonHoc.setForeground(Color.darkGray);

        JLabel lblTimeRemain = new JLabel(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/time.png")));
        lblTimeRemain.setBounds(668, 5, 164, 32);
        lblTimeRemain.setFont(new Font("Arial", Font.BOLD, 26));
        lblTimeRemain.setForeground(Color.red);

        thoiGian = 6500000; // giả sử đây là time đề thi 65s
//		thoiGian *= 60000;// chuyển phút qua milisecond
        ActionListener actionTime = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String str = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(thoiGian),
                        TimeUnit.MILLISECONDS.toMinutes(thoiGian) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(thoiGian)),
                        TimeUnit.MILLISECONDS.toSeconds(thoiGian) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(thoiGian)));
                lblTimeRemain.setText(str);
                thoiGian -= 1000;

                if (thoiGian < -1) {
                    actionFinish();
                }
            }
        };
        t = new Timer(1000, actionTime);
        t.start();

        txtCauHoi = new JTextArea();
        txtA = new JTextArea();
        txtB = new JTextArea();
        txtC = new JTextArea();
        txtD = new JTextArea();

        formatTxt(txtCauHoi);
        formatTxt(txtA);
        formatTxt(txtB);
        formatTxt(txtC);
        formatTxt(txtD);

        txtCauHoi.setBounds(23, 58, 553, 138);

        /*
		 * Lấy kích thước câu hỏi làm chuẩn, txtA canh theo câu hỏi
		 * txtB C D canh theo A
         */
        txtA.setBounds(12, 212, 284, 90);
        txtB.setBounds(305, 212, 284, 90);
        txtC.setBounds(12, 305, 284, 90);
        txtD.setBounds(305, 305, 284, 90);

        lblPre = new JLabel(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/left.png")));//"🡠"
        lblPre.setHorizontalAlignment(SwingConstants.CENTER);
        lblPre.setForeground(Color.BLACK);
        lblPre.setBounds(450, 407, 32, 32);

        lblNext = new JLabel(new ImageIcon(this.getClass().getResource("/dataImage/frmSinhVien/right.png")));//"🡢"
        lblNext.setHorizontalAlignment(SwingConstants.CENTER);
        lblNext.setForeground(lblPre.getForeground());
        lblNext.setBounds(510, 407, 32, 32);

        lblFinish = new JLabel("Nộp bài");
        lblFinish.setHorizontalAlignment(SwingConstants.CENTER);
        lblFinish.setOpaque(false);
        lblFinish.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        lblFinish.setForeground(Color.black);
        lblFinish.setBounds(445, 441, 100, 35);

        int hang = 0, cot = 0;

        pnDapAn = new JPanel();
        pnDapAn.setLayout(new GridLayout(soCauHoi, 5));
        pnDapAn.setPreferredSize(new Dimension(240, soCauHoi * 25));

        pnDapAn.setOpaque(false);
        pnDapAn.setBackground(new Color(0, 0, 0, 0));

        ButtonGroup btnGroup;

        spDapAn = new JScrollPane(pnDapAn);
        spDapAn.setBounds(599, 107, 234, 371);
        spDapAn.setOpaque(false);
        spDapAn.getViewport().setOpaque(false);
        spDapAn.setBackground(new Color(0, 0, 0, 0));
        spDapAn.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spDapAn.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spDapAn.setBorder(null);

        // vô hiệu hóa khi nhấn trái phải làm chạy jscrollpane
        InputMap inputMap = spDapAn.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "no-action");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "no-action");

        btnCau = new JButton[soCauHoi];
        while (hang < soCauHoi) {
            btnGroup = new ButtonGroup();

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

        lblTickA = new JLabel();
        lblTickA.setBounds(264, 212, 32, 32);

        lblTickB = new JLabel();
        lblTickB.setBounds(556, 212, 32, 32);
        lblTickC = new JLabel();
        lblTickC.setBounds(264, 306, 32, 32);
        lblTickD = new JLabel();
        lblTickD.setBounds(556, 306, 32, 32);

        lblCheChuThich = new JLabel();
        lblCheChuThich.setOpaque(true);
        lblCheChuThich.setBackground(Color.white);
        lblCheChuThich.setBounds(267, 392, 145, 85);
        pnMain.add(lblCheChuThich);

        pnMain.add(lblMonHoc);

        pnMain.add(lblTimeRemain);

        pnMain.add(txtCauHoi);

        pnMain.add(txtA);
        pnMain.add(txtB);
        pnMain.add(txtC);
        pnMain.add(txtD);

        pnMain.add(lblTickA);
        pnMain.add(lblTickB);
        pnMain.add(lblTickC);
        pnMain.add(lblTickD);

        pnMain.add(spDapAn);

        pnMain.add(lblPre);
        pnMain.add(lblNext);
        pnMain.add(lblFinish);

        cauTruoc = 0;
        soCauTraLoi = 0;
        cauHienTai = 0;
        chuyenCau();

        int i = 0;
        while (i < 4) {
            rdbtns[cauHienTai][i].setBackground(Color.yellow);
            rdbtns[cauHienTai][i].setOpaque(true);
            i++;
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

    private void batMauChoDapAn() {

        btnCau[cauTruoc].setOpaque(cauTruoc == cauHienTai);
        btnCau[cauTruoc].setBackground(new Color(0, 0, 0, 0));

        btnCau[cauHienTai].setOpaque(true);
        btnCau[cauHienTai].setBackground(Color.YELLOW);
        int i = 0;
        while (i < 4) {
            rdbtns[cauHienTai][i].setOpaque(true);
            rdbtns[cauHienTai][i].setBackground(Color.YELLOW);
            rdbtns[cauTruoc][i].setOpaque(false);
            rdbtns[cauTruoc][i].setBackground(new Color(0, 0, 0, 0));
            i++;
        }
    }

    private void enableLblTick_pnDapAn() {
        if (rdbtns[cauHienTai][0].isSelected()) {
            lblTickA.setIcon(iconChon);
            lblTickA.setVisible(true);
        } else if (rdbtns[cauHienTai][1].isSelected()) {
            lblTickB.setIcon(iconChon);
            lblTickB.setVisible(true);
        } else if (rdbtns[cauHienTai][2].isSelected()) {
            lblTickC.setIcon(iconChon);
            lblTickC.setVisible(true);
        } else if (rdbtns[cauHienTai][3].isSelected()) {
            lblTickD.setIcon(iconChon);
            lblTickD.setVisible(true);
        }
    }

    private void showDapAnDung() {
        if (!cauDung[cauHienTai]) {
            String dapAnDung = listCauHoi.get(cauHienTai).dapAnDung;
            if (txtA.getText().equals(dapAnDung)) {
                lblTickA.setIcon(iconSua);
                lblTickA.setVisible(true);
            } else if (txtB.getText().equals(dapAnDung)) {
                lblTickB.setIcon(iconSua);
                lblTickB.setVisible(true);
            } else if (txtC.getText().equals(dapAnDung)) {
                lblTickC.setIcon(iconSua);
                lblTickC.setVisible(true);
            } else if (txtD.getText().equals(dapAnDung)) {
                lblTickD.setIcon(iconSua);
                lblTickD.setVisible(true);
            }
        }

    }

    private void disableLblTick() {
        lblTickA.setVisible(false);
        lblTickB.setVisible(false);
        lblTickC.setVisible(false);
        lblTickD.setVisible(false);
    }

    private JTextArea formatTxt(JTextArea txt) {
        txt.setEnabled(false); // không cho chọn text hay Ctrl+C
        txt.setDisabledTextColor(Color.black);// set màu cho text bị disable
//		txt.setBackground(new Color(61, 235, 107));// set màu nền = null
        txt.setOpaque(false);
//		txt.setBackground(Color.DARK_GRAY);
//		txt.setBackground(null);
        txt.setFont(new Font("Segoe ui", Font.PLAIN, 18));

        txt.setWrapStyleWord(true);
        txt.setLineWrap(true);

        return txt;
    }

    private void showWindows() {
        this.setSize(837, 481);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("exeption: " + e.getMessage());
        }
        new frmSinhVien().showWindows();
    }

    private class AbstractActionImpl extends AbstractAction {

        public AbstractActionImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if (dangLamBai) {
                disableLblTick();
                lblTickA.setIcon(iconChon);
                lblTickA.setVisible(true);
                rdbtns[cauHienTai][0].setSelected(true);
            }
        }
    }

    private class AbstractActionImpl1 extends AbstractAction {

        public AbstractActionImpl1() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            actionPrevious();
        }
    }
}
