package bookstore.GUI;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.GianHangBLL;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.GianHang;
import bookstore.Entity.NhaXuatBan;
import bookstore.Entity.Sach;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnTimKiemSach extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					pnTimKiemSach frame = new pnTimKiemSach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pnTimKiemSach() {
		initComponents();
		loadGianHang();
		loadNXB();
		loadSach();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setVisible(false);
		setBounds(0, ABORT, 1530, 737);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 275, 717);
		add(panel);
		panel.setLayout(null);

		JLabel lblTen = new JLabel();
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setText("Tên Sách:");
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 10, 255, 30);
		panel.add(lblTen);

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBounds(34, 50, 198, 30);
		panel.add(txtTen);

		JLabel jLabel4 = new JLabel();
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setForeground(new Color(0, 153, 153));
		jLabel4.setText("Tác Giả:");
		jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel4.setBounds(10, 90, 255, 30);
		panel.add(jLabel4);

		txtTacGia = new JTextField();
		txtTacGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTacGia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTacGia.setBounds(34, 130, 198, 30);
		panel.add(txtTacGia);

		JLabel jLabel7 = new JLabel();
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setForeground(new Color(0, 153, 153));
		jLabel7.setText("Nhà Xuất Bản:");
		jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel7.setBounds(10, 170, 255, 30);
		panel.add(jLabel7);

		cbbNXB = new JComboBox<>();
		cbbNXB.setBackground(new Color(255, 255, 255));
		cbbNXB.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbNXB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		cbbNXB.setBounds(37, 210, 195, 30);
		panel.add(cbbNXB);

		JLabel jLabel9 = new JLabel();
		jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel9.setForeground(new Color(0, 153, 153));
		jLabel9.setText("Loại Sách:");
		jLabel9.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel9.setBounds(10, 250, 255, 30);
		panel.add(jLabel9);

		cbbLoai = new JComboBox<>();
		cbbLoai.setBackground(new Color(255, 255, 255));
		cbbLoai.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbLoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		cbbLoai.setBounds(37, 290, 195, 30);
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
		btnTimKiem.setBounds(80, 604, 126, 40);
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
		btnLamMoi
				.setIcon(new ImageIcon(pnTimKiemSach.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamMoi.setBounds(80, 667, 126, 40);
		panel.add(btnLamMoi);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(295, 90, 1225, 557);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1205, 537);
		panel_1.add(scrollPane);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		tblSach = new JTable();
		tblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblSachMouseClicked();
			}
		});
		tblSach.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tblSach.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3",
						"N\u0103m Xu\u1EA5t B\u1EA3n", "Gi\u00E1 B\u00E1n", "Nh\u00E0 Xu\u1EA5t B\u1EA3n",
						"S\u1ED1 L\u01B0\u1EE3ng T\u1ED3n", "Lo\u1EA1i S\u00E1ch" }));
		scrollPane.setViewportView(tblSach);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(295, 10, 1225, 70);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTitle = new JLabel("TÌM KIẾM SÁCH");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBounds(10, 0, 1205, 70);
		panel_2.add(lblTitle);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(295, 657, 1225, 70);
		add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnChon = new JButton();
		btnChon.setIcon(new ImageIcon(pnTimKiemSach.class.getResource("/nhom05/bookstore/icon/purchase_order_50px.png")));
		btnChon.setText("Mua Sách");
		btnChon.setForeground(Color.WHITE);
		btnChon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnChon.setBorder(null);
		btnChon.setBackground(new Color(0, 153, 153));
		btnChon.setBounds(535, 13, 150, 44);
		panel_3.add(btnChon);
	}

	public void tblSachMouseClicked() {
		txtTacGia.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 2).toString());
		txtTen.setText(tblSach.getValueAt(tblSach.getSelectedRow(), 1).toString());
		cbbLoai.setSelectedItem(tblSach.getValueAt(tblSach.getSelectedRow(), 7));
		cbbNXB.setSelectedItem(tblSach.getValueAt(tblSach.getSelectedRow(), 5));
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
