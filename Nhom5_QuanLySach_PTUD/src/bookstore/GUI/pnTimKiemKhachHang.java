package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.KhachHangBLL;
import bookstore.Entity.KhachHang;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnTimKiemKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private DefaultTableModel model;
	private ArrayList<KhachHang> ls = new ArrayList<KhachHang>();
	private JTable tblKhachHang;

	public pnTimKiemKhachHang() {
		initComponents();
		loadKhachHang();
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1520, 727);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 275, 707);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTen = new JLabel("Tên khách hàng:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setBounds(10, 100, 255, 30);
		panel_2.add(lblTen);
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(37, 140, 200, 30);
		panel_2.add(txtTen);
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setColumns(10);

		txtMa = new JTextField();
		txtMa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMa.setBounds(37, 60, 200, 30);
		panel_2.add(txtMa);
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setColumns(10);

		JLabel lblMa = new JLabel("Mã khách hàng:");
		lblMa.setForeground(new Color(0, 153, 153));
		lblMa.setBounds(10, 20, 255, 30);
		panel_2.add(lblMa);
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setBounds(10, 180, 255, 30);
		panel_2.add(lblSDT);
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtSDT = new JTextField();
		txtSDT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSDT.setBounds(37, 220, 200, 28);
		panel_2.add(txtSDT);
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDiaChi.setBounds(10, 258, 255, 30);
		panel_2.add(lblDiaChi);
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setBounds(37, 293, 200, 30);
		panel_2.add(txtDiaChi);
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(Color.WHITE);
		btnTimKiem.setBorder(null);
		btnTimKiem.setBounds(51, 601, 146, 43);
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
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setBorder(null);
		btnLamMoi.setBounds(51, 654, 146, 43);
		panel_2.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadKhachHang();
				clearText();
			}
		});
		btnLamMoi.setIcon(
				new ImageIcon(pnTimKiemKhachHang.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBackground(new Color(0, 153, 153));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(295, 90, 1215, 548);
		panel_1.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(0, 153, 153));
		scrollPane.setBounds(10, 10, 1195, 528);
		panel.add(scrollPane);

		tblKhachHang = new JTable();
		tblKhachHang.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		tblKhachHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 kh\u00E1ch h\u00E0ng",
				"T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9" }));
		scrollPane.setViewportView(tblKhachHang);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(295, 648, 1215, 70);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JButton btnMuaHang = new JButton("Mua hàng");
		btnMuaHang.setForeground(Color.WHITE);
		btnMuaHang.setIcon(
				new ImageIcon(pnTimKiemKhachHang.class.getResource("/nhom05/bookstore/icon/purchase_order_50px.png")));
		btnMuaHang.setBounds(530, 10, 167, 45);
		panel_4.add(btnMuaHang);
		btnMuaHang.setBorder(null);
		btnMuaHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMuaHang();
				// gdChinh.swapPanel();
			}
		});
		btnMuaHang.setBackground(new Color(0, 153, 153));
		btnMuaHang.setFont(new Font("Segoe UI", Font.PLAIN, 20));

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(295, 10, 1215, 70);
		panel_1.add(panel_3);

		JLabel lblTitle = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBounds(10, 0, 1175, 70);
		panel_3.add(lblTitle);
	}

	public void btnMuaHang() {
		if (tblKhachHang.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 khách hàng!");
		} else {
			pnHoaDonBanHang pn = new pnHoaDonBanHang();
			GiaoDienChinh.swapPanel(pn);
			pnHoaDonBanHang.txtKhachHang.setText(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0).toString());
		}
	}

	public void getThongTinKH() {
		int row = tblKhachHang.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 khách hàng!");
		} else {
			if (JOptionPane.showConfirmDialog(this, "Bạn có muốn chuyển đến giao diện mua hàng không?", "Thông báo!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				pnHoaDonBanHang frm = new pnHoaDonBanHang();
				this.setVisible(false);
				frm.setVisible(true);
				pnHoaDonBanHang.txtKhachHang.setText(tblKhachHang.getValueAt(row, 1).toString());
			}
		}
	}

	private void searchKhachHang() {
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

	private void loadKhachHang() {
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

	private void clearText() {
		txtDiaChi.setText("");
		txtMa.setText("");
		txtSDT.setText("");
		txtTen.setText("");
	}
}
