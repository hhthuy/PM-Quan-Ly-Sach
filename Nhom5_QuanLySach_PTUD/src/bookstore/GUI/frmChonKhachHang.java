package bookstore.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.KhachHangBLL;
import bookstore.Entity.KhachHang;
import java.awt.Window.Type;

/**
 * 
 * @author Nhom5
 *
 */
public class frmChonKhachHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable tblKhachHang;
	private DefaultTableModel model;
	public static KhachHang a;
	private ArrayList<KhachHang> ls = new ArrayList<KhachHang>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmChonKhachHang frame = new frmChonKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmChonKhachHang() {
		setType(Type.POPUP);
		getContentPane().setBackground(new Color(255, 255, 255));
		initComponents();
		loadKhachHang();
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(250, 90, 1000, 585);
		setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 986, 492);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 260, 470);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTen = new JLabel("Tên khách hàng:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setBounds(10, 100, 240, 30);
		panel_2.add(lblTen);
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(37, 140, 183, 30);
		panel_2.add(txtTen);
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setColumns(10);

		txtMa = new JTextField();
		txtMa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMa.setBounds(37, 60, 183, 30);
		panel_2.add(txtMa);
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setColumns(10);

		JLabel lblMa = new JLabel("Mã khách hàng:");
		lblMa.setForeground(new Color(0, 153, 153));
		lblMa.setBounds(10, 20, 240, 30);
		panel_2.add(lblMa);
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setBounds(10, 180, 240, 30);
		panel_2.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtSDT = new JTextField();
		txtSDT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSDT.setBounds(37, 220, 183, 28);
		panel_2.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDiaChi.setBounds(10, 258, 240, 30);
		panel_2.add(lblDiaChi);
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setBounds(37, 293, 183, 30);
		panel_2.add(txtDiaChi);
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setBorder(null);
		btnTimKiem.setBounds(54, 354, 146, 43);
		panel_2.add(btnTimKiem);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchKhachHang();
			}
		});
		btnTimKiem.setBackground(new Color(0, 153, 153));
		btnTimKiem.setIcon(
				new ImageIcon(pnTimKiemKhachHang.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBorder(null);
		btnLamMoi.setBounds(54, 407, 146, 43);
		panel_2.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadKhachHang();
				clearText();
			}
		});
		btnLamMoi.setIcon(
				new ImageIcon(pnTimKiemKhachHang.class.getResource("/nhom05/bookstore/icon/refresh-56-32.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(0, 153, 153));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(0, 153, 153));
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setBounds(280, 78, 696, 402);
		panel_1.add(scrollPane);

		tblKhachHang = new JTable();
		tblKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tblKhachHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 kh\u00E1ch h\u00E0ng",
				"T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9" }));
		scrollPane.setViewportView(tblKhachHang);

		JLabel lblNewLabel = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(0, 153, 153));
		lblNewLabel.setBounds(301, 20, 352, 41);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));

		JButton btnMuaHang = new JButton("Chọn");
		btnMuaHang.setBorder(null);
		btnMuaHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jdXuatHD.txtKhachHang.setText(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 1).toString());
				chonKhachHang();
			}
		});
		btnMuaHang.setBackground(new Color(0, 153, 153));
		btnMuaHang.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnMuaHang.setBounds(412, 489, 134, 45);
		getContentPane().add(btnMuaHang);
	}

	public void chonKhachHang() {
		int row = tblKhachHang.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 khách hàng!");
		} else {
			this.setVisible(false);
			frmChonKhachHang.a = new KhachHang();
			a.setMakhachhang(tblKhachHang.getValueAt(row, 0).toString());
			a.setTenkhachhang(tblKhachHang.getValueAt(row, 1).toString());
			a.setSdt(tblKhachHang.getValueAt(row, 2).toString());
			a.setDiachi(tblKhachHang.getValueAt(row, 3).toString());
			pnHoaDonBanHang.txtKhachHang.setText(a.getMakhachhang());
		}
	}

	public void searchKhachHang() {
		String ma = txtMa.getText().trim();
		if (ma.equals("")) {
			ma = null;
		}
		String ten = txtTen.getText().trim();
		if (ten.equals("")) {
			ten = null;
		}
		String sdt = txtSDT.getText().trim();
		if (sdt.equals("")) {
			sdt = null;
		}
		String diachi = txtDiaChi.getText().trim();
		if (diachi.equals("")) {
			diachi = null;
		}
		KhachHangBLL bll = new KhachHangBLL();
		ArrayList<KhachHang> ls = bll.searchKhachHang(ma, ten, sdt, diachi);
		model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) tblKhachHang.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			KhachHang kh = ls.get(i);
			model.addRow(new Object[] { kh.getMakhachhang(), kh.getTenkhachhang(), kh.getSdt(), kh.getDiachi() });
		}
		tblKhachHang.setModel(model);
	}

	public void loadKhachHang() {
		KhachHangBLL bll = new KhachHangBLL();
		ls = bll.getAllKhachHang();
		model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) tblKhachHang.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { ls.get(i).getMakhachhang(), ls.get(i).getTenkhachhang(), ls.get(i).getSdt(),
					ls.get(i).getDiachi() });
		}
		tblKhachHang.setModel(model);
	}

	public void clearText() {
		txtDiaChi.setText("");
		txtMa.setText("");
		txtSDT.setText("");
		txtTen.setText("");
	}

}
