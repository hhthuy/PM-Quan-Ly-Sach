package bookstore.GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import bookstore.BLL.NhanVienBLL;
import bookstore.Entity.NhanVien;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Nhom5
 *
 */
public class pnTimKiemNhanVien extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnTimKiemNhanVien frame = new pnTimKiemNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pnTimKiemNhanVien() {
		initComponents();
		loadNhanVien();
	}

	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1540, 737);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 275, 717);
		add(panel);
		panel.setLayout(null);

		JLabel lblTen = new JLabel("Tên nhân viên:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(10, 28, 255, 30);
		panel.add(lblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(36, 68, 202, 30);
		panel.add(txtTen);

		JLabel lblSDT = new JLabel("Số điện thoại:");
		lblSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblSDT.setForeground(new Color(0, 153, 153));
		lblSDT.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSDT.setBackground(Color.WHITE);
		lblSDT.setBounds(10, 108, 255, 32);
		panel.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSDT.setBounds(36, 150, 202, 30);
		panel.add(txtSDT);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setForeground(new Color(0, 153, 153));
		lblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblDiaChi.setBounds(10, 190, 255, 32);
		panel.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setBounds(36, 232, 202, 30);
		panel.add(txtDiaChi);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnTimKiem.setIcon(
				new ImageIcon(pnTimKiemNhanVien.class.getResource("/nhom05/bookstore/icon/search-188-32.png")));
		btnTimKiem.setBorder(null);
		btnTimKiem.setBackground(new Color(51, 153, 153));
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnTimKiem.setBounds(73, 609, 130, 40);
		panel.add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnLamMoi.setIcon(
				new ImageIcon(pnTimKiemNhanVien.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(51, 153, 153));
		btnLamMoi.setBounds(73, 667, 130, 40);
		panel.add(btnLamMoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(295, 90, 1235, 553);
		add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 10, 1215, 533);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setBorder(null);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn nh\u00E2n vi\u00EAn",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Ch\u1EE9c v\u1EE5" }));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(295, 657, 1235, 70);
		add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(295, 10, 1235, 70);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TÌM KIẾM NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(51, 153, 153));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 0, 1215, 70);
		panel_1.add(lblNewLabel);
	}

	public void search() {
		String ten = txtTen.getText();
		if (ten.length() == 0) {
			ten = null;
		}
		String sdt = txtSDT.getText();
		if (sdt.length() == 0) {
			sdt = null;
		}
		String diachi = txtDiaChi.getText();
		if (diachi.length() == 0) {
			diachi = null;
		}
		NhanVienBLL nhanvienBLL = new NhanVienBLL();
		ArrayList<NhanVien> ls = nhanvienBLL.search(ten, sdt, diachi);
		model = new DefaultTableModel();
		DefaultTableModel oldModel = (DefaultTableModel) table.getModel();
		int n = oldModel.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(oldModel.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { ls.get(i).getMaNhanVien(), ls.get(i).getTenNhanVien(), ls.get(i).getSDT(),
					ls.get(i).getDiaChi(), ls.get(i).getChucVu() });
		}
		table.setModel(model);
	}

	public void loadNhanVien() {
		NhanVienBLL nhanVienBll = new NhanVienBLL();
		ArrayList<NhanVien> ls = nhanVienBll.getAllNhanVien();
		model = new DefaultTableModel();
		DefaultTableModel oldModel = (DefaultTableModel) table.getModel();
		int n = oldModel.getColumnCount();
		for (int i = 0; i < n; i++) {
			model.addColumn(oldModel.getColumnName(i));
		}
		n = ls.size();
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] { ls.get(i).getMaNhanVien(), ls.get(i).getTenNhanVien(), ls.get(i).getSDT(),
					ls.get(i).getDiaChi(), ls.get(i).getChucVu() });
		}
		table.setModel(model);
	}
	public void lamMoi() {
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtTen.setText("");
		loadNhanVien();
	}
}
