package bookstore.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.GianHangBLL;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.GianHang;
import bookstore.Entity.NhaXuatBan;
import bookstore.Entity.Sach;
import java.awt.Window.Type;

/**
 * 
 * @author Nhom5
 *
 */
public class frmChonSach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtTacGia;
	private JComboBox<String> cbbLoai;
	private JComboBox<String> cbbNXB;
	private JTable tblSach;
	private NhaXuatBanBLL nxb = new NhaXuatBanBLL();
	private GianHangBLL gh = new GianHangBLL();
	private SachBLL bll = new SachBLL();
	private ArrayList<Sach> lst = new ArrayList<>();
	private ArrayList<NhaXuatBan> lstnxb = new ArrayList<>();
	private ArrayList<GianHang> lstgh = new ArrayList<>();
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmChonSach frame = new frmChonSach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmChonSach() {
		setType(Type.UTILITY);
		setAlwaysOnTop(true);
		initComponents();
		loadGianHang();
		loadNXB();
		loadSach();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(250, 100, 1000, 588);
		setTitle("Tìm kiếm sách");
		setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 237, 476);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTen = new JLabel();
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setText("Tên Sách:");
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 10, 217, 30);
		panel.add(lblTen);

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBounds(34, 50, 171, 30);
		panel.add(txtTen);

		JLabel jLabel4 = new JLabel();
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setForeground(new Color(0, 153, 153));
		jLabel4.setText("Tác Giả:");
		jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel4.setBounds(10, 90, 217, 30);
		panel.add(jLabel4);

		txtTacGia = new JTextField();
		txtTacGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTacGia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTacGia.setBounds(34, 130, 171, 30);
		panel.add(txtTacGia);

		JLabel jLabel7 = new JLabel();
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setForeground(new Color(0, 153, 153));
		jLabel7.setText("Nhà Xuất Bản:");
		jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel7.setBounds(10, 170, 217, 30);
		panel.add(jLabel7);

		cbbNXB = new JComboBox<>();
		cbbNXB.setBackground(new Color(255, 255, 255));
		cbbNXB.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbNXB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbbNXB.setBounds(37, 210, 168, 30);
		panel.add(cbbNXB);

		JLabel jLabel9 = new JLabel();
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setForeground(new Color(0, 153, 153));
		jLabel9.setText("Loại Sách:");
		jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel9.setBounds(10, 250, 217, 30);
		panel.add(jLabel9);

		cbbLoai = new JComboBox<>();
		cbbLoai.setBackground(new Color(255, 255, 255));
		cbbLoai.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbLoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		cbbLoai.setBounds(37, 290, 168, 30);
		cbbLoai.setSelectedIndex(-1);
		panel.add(cbbLoai);

		JButton btnTimKiem = new JButton();
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setIcon(new ImageIcon(pnTimKiemSach.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiem.setBorder(null);
		btnTimKiem.setBackground(new Color(0, 153, 153));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchSach();
			}
		});
		btnTimKiem.setText("Tìm Kiếm");
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTimKiem.setBounds(61, 348, 126, 40);
		panel.add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(new Color(255, 255, 255));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadSach();
				txtTacGia.setText("");
				txtTen.setText("");
				cbbLoai.setSelectedIndex(0);
				cbbNXB.setSelectedIndex(0);
			}
		});
		btnLamMoi.setBorder(null);
		btnLamMoi.setIcon(new ImageIcon(frmChonSach.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamMoi.setBounds(61, 412, 126, 40);
		panel.add(btnLamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(257, 97, 718, 389);
		contentPane.add(scrollPane);

		tblSach = new JTable();
		tblSach.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tblSach.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3",
						"N\u0103m Xu\u1EA5t B\u1EA3n", "Gi\u00E1 B\u00E1n", "Nh\u00E0 Xu\u1EA5t B\u1EA3n",
						"S\u1ED1 L\u01B0\u1EE3ng T\u1ED3n", "Lo\u1EA1i S\u00E1ch" }));
		scrollPane.setViewportView(tblSach);

		JLabel lblNewLabel = new JLabel("TÌM KIẾM SÁCH");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(257, 29, 376, 45);
		contentPane.add(lblNewLabel);

		JButton btnChon = new JButton();
		btnChon.setForeground(new Color(255, 255, 255));
		btnChon.setBorder(null);
		btnChon.setBounds(389, 496, 100, 44);
		contentPane.add(btnChon);
		btnChon.setBackground(new Color(0, 153, 153));
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonSach();
			}
		});
		btnChon.setText("Chọn");
		btnChon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		
		JButton btnThemSach = new JButton("Thêm sách");
		btnThemSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThemSach();
			}
		});
		btnThemSach.setForeground(new Color(255, 255, 255));
		btnThemSach.setBorder(null);
		btnThemSach.setBackground(new Color(51, 153, 153));
		btnThemSach.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemSach.setBounds(518, 496, 127, 45);
		contentPane.add(btnThemSach);
	}

	public void btnThemSach() {
		pnQuanLySach pn = new pnQuanLySach();
		setVisible(false);
		GiaoDienChinh.swapPanel(pn);		
	}

	public void chonSach() {
		setVisible(false);
		try {
			pnHoaDonBanHang.txtSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
			pnHoaDonBanHang.txtDonGia.setText(String.valueOf(getThongTinSach().getGiaBia()));
		} catch (Exception e) {
			
		}
		try {
			pnHoaDonNhapHang.txtSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
			pnHoaDonNhapHang.txtDonGia.setText(String.valueOf(getThongTinSach().getGiaBia()));
		} catch (Exception e) {
			
		}
		try {
			pnSuaHoaDonBanHang.txtSach.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
			pnSuaHoaDonBanHang.txtDonGia.setText(String.valueOf(getThongTinSach().getGiaBia()));
		} catch (Exception e) {
			
		}
		
	}

	public Sach getThongTinSach() {
		int row = tblSach.getSelectedRow();
		Sach s = new Sach();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sách!");
		} else {
			s.setMaSach(tblSach.getValueAt(row, 0).toString());
			s.setTieuDe(tblSach.getValueAt(row, 1).toString());
			s.setGiaBia((int) tblSach.getValueAt(row, 4));
			s.setMaNXB(tblSach.getValueAt(row, 5).toString());
		}
		return s;
	}

	public void searchSach() {

		String ten = txtTen.getText().trim();
		if (ten.equals("")) {
			ten = null;
		}
		String tacgia = txtTacGia.getText().trim();
		if (tacgia.equals("")) {
			tacgia = null;
		}
		String nxb1 = nxb.getIdByName(cbbNXB.getSelectedItem().toString());
		if (cbbNXB.getSelectedIndex() == 0) {
			nxb1 = null;
		}
		String loai = gh.getIDByName(cbbLoai.getSelectedItem().toString());
		if (cbbLoai.getSelectedIndex() == 0) {
			loai = null;
		}
		SachBLL bll = new SachBLL();
		ArrayList<Sach> s = bll.searchSach(ten, tacgia, nxb1, loai);
//		ArrayList<Sach> s = bll.searchSach(nxb1);
		model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) tblSach.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = s.size();
		for (int i = 0; i < n; i++) {
			Sach sach = s.get(i);
			model.addRow(new Object[] { sach.getMaSach(), sach.getTieuDe(), sach.getTacGia(), sach.getNamXuatBan(),
					sach.getGiaBia(), sach.getMaNXB(), sach.getSoLuongTon(), sach.getMaGianHang() });
		}
		tblSach.setModel(model);
	}

	public void loadGianHang() {
		lstgh = gh.getAll("", "", "");
		cbbLoai.addItem("Tất cả");
		for (GianHang i : lstgh) {
			cbbLoai.addItem(i.getTenGianHang());
		}
	}

	public void loadNXB() {
		lstnxb = nxb.getAll("", "", "");
		cbbNXB.addItem("Tất cả");
		for (NhaXuatBan i : lstnxb) {
			cbbNXB.addItem(i.getTenNXB());
		}
	}

	public void loadSach() {
		bll = new SachBLL();
		lst = bll.getAll("", "", "");
		model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) tblSach.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = lst.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { lst.get(i).getMaSach(), lst.get(i).getTieuDe(), lst.get(i).getTacGia(),
					lst.get(i).getNamXuatBan(), lst.get(i).getGiaBia(), lst.get(i).getMaNXB(),
					lst.get(i).getSoLuongTon(), lst.get(i).getMaGianHang() });
		}
		tblSach.setModel(model);
	}
}
