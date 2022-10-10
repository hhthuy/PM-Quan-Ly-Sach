package bookstore.GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.Entity.NhaXuatBan;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnTimNhaXuatBan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTable tblNXB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnTimNhaXuatBan frame = new pnTimNhaXuatBan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pnTimNhaXuatBan() {
		initComponents();
		loadNXB("", "", "");
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1000, 592);
		setIconImage(new ImageIcon(getClass().getResource("imgs/library.png")).getImage());
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 260, 464);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTen = new JLabel("Tên Nhà Xuất Bản:");
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 20, 240, 30);
		panel.add(lblTen);

		txtTen = new JTextField();
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBounds(32, 60, 192, 30);
		panel.add(txtTen);
		txtTen.setColumns(10);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 100, 240, 30);
		panel.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setBounds(32, 140, 192, 30);
		panel.add(txtDiaChi);

		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setBounds(10, 180, 240, 30);
		panel.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSDT.setBounds(32, 220, 192, 30);
		panel.add(txtSDT);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		btnTimKiem
				.setIcon(new ImageIcon(pnTimNhaXuatBan.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiem.setBorder(null);
		btnTimKiem.setBackground(new Color(0, 153, 153));
		btnTimKiem.setForeground(new Color(0, 0, 0));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTimKiem.setBounds(68, 352, 120, 40);
		panel.add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadNXB("", "", "");
				clearText();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnTimNhaXuatBan.class.getResource("/nhom05/bookstore/icon/refresh-56-32.png")));
		btnLamMoi.setForeground(Color.BLACK);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setBounds(68, 414, 120, 40);
		panel.add(btnLamMoi);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(280, 92, 696, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 0, 696, 382);
		panel_1.add(scrollPane);

		tblNXB = new JTable();
		tblNXB.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00EAn nh\u00E0 xu\u1EA5t b\u1EA3n",
						"\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email" }));
		tblNXB.getColumnModel().getColumn(0).setPreferredWidth(92);
		tblNXB.getColumnModel().getColumn(0).setMinWidth(20);
		tblNXB.getColumnModel().getColumn(1).setPreferredWidth(91);
		tblNXB.getColumnModel().getColumn(1).setMinWidth(20);
		tblNXB.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane.setViewportView(tblNXB);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 484, 966, 64);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnChon = new JButton("Chọn");
		btnChon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonNXB();
			}
		});
		btnChon.setForeground(Color.BLACK);
		btnChon.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnChon.setBorder(null);
		btnChon.setBackground(new Color(0, 153, 153));
		btnChon.setBounds(446, 10, 106, 40);
		panel_2.add(btnChon);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(279, 10, 697, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitle = new JLabel("TÌM KIẾM NHÀ XUẤT BẢN");
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setBounds(10, 10, 394, 52);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		panel_3.add(lblTitle);

	}

	public void chonNXB() {
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn chuyển đến giao diện tạo hóa đơn nhập hàng?","Thông báo!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			setVisible(false);
		}else {
			setVisible(false);
			pnQuanLySach.cbbNhaXuatBan.setSelectedItem(tblNXB.getValueAt(tblNXB.getSelectedRow(), 1).toString());
		}
	}

	public void clearText() {
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtTen.setText("");
	}

	public void loadNXB(String t, String w, String o) {
		NhaXuatBanBLL nxb = new NhaXuatBanBLL();
		ArrayList<NhaXuatBan> ls = nxb.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã NXB");
		col.add("Tên NXB");
		col.add("Địa chỉ");
		col.add("Điện thoại");
		col.add("Email");

		Vector data = new Vector();
		for (NhaXuatBan i : ls) {
			Vector row = new Vector();
			row.add(i.getMaNXB());
			row.add(i.getTenNXB());
			row.add(i.getDiaChi());
			row.add(i.getDienThoai());
			row.add(i.getEmail());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblNXB.setModel(dtm);
	}

	public void timKiem() {
		String ten = txtTen.getText();
		if (ten.length() == 0) {
			ten = null;
		}
		String diachi = txtDiaChi.getText();
		if (diachi.length() == 0) {
			diachi = null;
		}
		String sdt = txtSDT.getText();
		if (sdt.length() == 0) {
			sdt = null;
		}
		NhaXuatBanBLL nxb = new NhaXuatBanBLL();
		ArrayList<NhaXuatBan> ls = nxb.search(ten, diachi, sdt);
		DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel old = (DefaultTableModel) tblNXB.getModel();
		int n = old.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(old.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] {ls.get(i).getMaNXB(),ls.get(i).getTenNXB(),ls.get(i).getDiaChi(),ls.get(i).getDienThoai()
					,ls.get(i).getEmail()});
		}
		tblNXB.setModel(model);
	}
}
