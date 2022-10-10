package bookstore.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.GianHangBLL;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.BLL.SachBLL;
import bookstore.Entity.GianHang;
import bookstore.Entity.NhaXuatBan;
import bookstore.Entity.Sach;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class pnQuanLySach extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtTacGia;
	private JTextField txtNam;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTable tblSach;
	static JComboBox<String> cbbGianHang;
	static JComboBox<String> cbbNhaXuatBan;
	private SachBLL sachBLL = new SachBLL();
	private NhaXuatBanBLL nxbBLL = new NhaXuatBanBLL();
	private GianHangBLL ghBLL = new GianHangBLL();
	private ArrayList<Sach> lst = new ArrayList<>();
	private ArrayList<NhaXuatBan> lstnxb = new ArrayList<>();
	private ArrayList<GianHang> lstgh = new ArrayList<>();
	private JButton btnLamMoi;
	private JButton btnThemMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXuat;

	public pnQuanLySach() {
		initComponents();
		binData("", "", "");
		binCmbNXB();
		binCmbGH();
	}
	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setBounds(0, 0, 1530, 737);
		setLayout(null);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(null);
		jPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(10, 10, 275, 727);
		add(jPanel1);
		
		JLabel lblMa = new JLabel();
		lblMa.setText("Mã Sách:");
		lblMa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMa.setForeground(new Color(0, 153, 153));
		lblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblMa.setBounds(11, 10, 254, 27);
		jPanel1.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setBounds(35, 44, 208, 30);
		jPanel1.add(txtMa);
		
		JLabel lblTen = new JLabel();
		lblTen.setText("Tên Sách:");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setForeground(new Color(0, 153, 153));
		lblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTen.setBounds(11, 84, 254, 30);
		jPanel1.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(34, 124, 209, 30);
		jPanel1.add(txtTen);
		
		JLabel jLabel4 = new JLabel();
		jLabel4.setText("Tác Giả:");
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setForeground(new Color(0, 153, 153));
		jLabel4.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel4.setBounds(11, 164, 254, 30);
		jPanel1.add(jLabel4);
		
		JLabel jLabel5 = new JLabel();
		jLabel5.setText("Năm Xuất Bản:");
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setForeground(new Color(0, 153, 153));
		jLabel5.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel5.setBounds(11, 244, 254, 30);
		jPanel1.add(jLabel5);
		
		JLabel jLabel6 = new JLabel();
		jLabel6.setText("Giá Bán:");
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6.setForeground(new Color(0, 153, 153));
		jLabel6.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel6.setBounds(10, 324, 255, 30);
		jPanel1.add(jLabel6);
		
		JLabel lblLoai = new JLabel();
		lblLoai.setText("Loại sách");
		lblLoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoai.setForeground(new Color(0, 153, 153));
		lblLoai.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblLoai.setBounds(11, 570, 254, 30);
		jPanel1.add(lblLoai);
		
		JLabel jLabel7 = new JLabel();
		jLabel7.setText("Nhà Xuất Bản:");
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setForeground(new Color(0, 153, 153));
		jLabel7.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel7.setBounds(10, 406, 255, 30);
		jPanel1.add(jLabel7);
		
		cbbNhaXuatBan = new JComboBox<String>();
		cbbNhaXuatBan.setSelectedIndex(-1);
		cbbNhaXuatBan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		cbbNhaXuatBan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbNhaXuatBan.setBounds(33, 450, 178, 30);
		jPanel1.add(cbbNhaXuatBan);
		
		JLabel jLabel8 = new JLabel();
		jLabel8.setText("Số Lượng Tồn");
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel8.setForeground(new Color(0, 153, 153));
		jLabel8.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		jLabel8.setBounds(11, 490, 254, 30);
		jPanel1.add(jLabel8);
		
		cbbGianHang = new JComboBox<String>();
		cbbGianHang.setSelectedIndex(-1);
		cbbGianHang.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		cbbGianHang.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cbbGianHang.setBounds(33, 614, 178, 30);
		jPanel1.add(cbbGianHang);
		
		JButton btnGH = new JButton();
		btnGH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGH();
			}
		});
		btnGH.setText("Làm Mới");
		btnGH.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnGH.setBounds(221, 615, 22, 30);
		jPanel1.add(btnGH);
		
		JButton btnNXB = new JButton();
		btnNXB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNXB();
			}
		});
		btnNXB.setText("Làm Mới");
		btnNXB.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNXB.setBounds(221, 451, 22, 30);
		jPanel1.add(btnNXB);
		
		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTacGia.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTacGia.setBounds(35, 204, 208, 30);
		jPanel1.add(txtTacGia);
		
		txtNam = new JTextField();
		txtNam.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNam.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtNam.setBounds(35, 284, 208, 30);
		jPanel1.add(txtNam);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtGiaBan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtGiaBan.setBounds(35, 366, 208, 30);
		jPanel1.add(txtGiaBan);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSoLuong.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSoLuong.setBounds(33, 530, 210, 30);
		jPanel1.add(txtSoLuong);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(295, 90, 1225, 567);
		add(jPanel2);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1201, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jPanel2.setVerticalGroup(
			gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblSach = new JTable();
		tblSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tblSach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u00E1ch", "T\u00EAn s\u00E1ch", "T\u00E1c gi\u1EA3", "N\u0103m xu\u1EA5t b\u1EA3n", "Gi\u00E1 b\u00E1n", "Nh\u00E0 xu\u1EA5t b\u1EA3n", "S\u1ED1 l\u01B0\u1EE3ng t\u1ED3n", "Lo\u1EA1i s\u00E1ch"
			}
		));
		tblSach.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		jScrollPane1.setViewportView(tblSach);
		jPanel2.setLayout(gl_jPanel2);
		
		JPanel jPanel4 = new JPanel();
		jPanel4.setLayout(null);
		jPanel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(295, 667, 1225, 70);
		add(jPanel4);
		
		btnLamMoi = new JButton();
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnQuanLySach.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setText("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(0, 153, 153));
		btnLamMoi.setBounds(98, 15, 125, 40);
		jPanel4.add(btnLamMoi);
		
		btnThemMoi = new JButton();
		btnThemMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();
			}
		});
		btnThemMoi.setIcon(new ImageIcon(pnQuanLySach.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThemMoi.setText("Thêm Mới");
		btnThemMoi.setForeground(Color.WHITE);
		btnThemMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThemMoi.setBorder(null);
		btnThemMoi.setBackground(new Color(0, 153, 153));
		btnThemMoi.setBounds(311, 15, 132, 40);
		jPanel4.add(btnThemMoi);
		
		btnSua = new JButton();
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(new ImageIcon(pnQuanLySach.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setText("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setEnabled(false);
		btnSua.setBorder(null);
		btnSua.setBackground(new Color(0, 153, 153));
		btnSua.setBounds(528, 15, 125, 40);
		jPanel4.add(btnSua);
		
		btnXoa = new JButton();
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnQuanLySach.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setText("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setEnabled(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(0, 153, 153));
		btnXoa.setBounds(743, 15, 125, 40);
		jPanel4.add(btnXoa);
		
		btnXuat = new JButton();
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXuat();
			}
		});
		btnXuat.setIcon(new ImageIcon(pnQuanLySach.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnXuat.setText("Xuất DS");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXuat.setBorder(null);
		btnXuat.setBackground(new Color(0, 153, 153));
		btnXuat.setBounds(954, 15, 125, 40);
		jPanel4.add(btnXuat);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(295, 10, 1225, 70);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel();
		lblTitle.setText("QUẢN LÝ SÁCH");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 153, 153));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblTitle.setBounds(0, 0, 1225, 70);
		panel.add(lblTitle);
	}
	private void tableClick() {
		if (tblSach.getSelectedRow() == -1) {
			return;
		}else {
			btnThemMoi.setEnabled(false);
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);

			int row = tblSach.getSelectedRow();
			txtMa.setText(tblSach.getValueAt(row, 0).toString());
			txtMa.setEditable(false);
			txtTen.setText(tblSach.getValueAt(row, 1).toString());
			txtTacGia.setText(tblSach.getValueAt(row, 2).toString());
			txtNam.setText(tblSach.getValueAt(row, 3).toString());
			txtGiaBan.setText(tblSach.getValueAt(row, 4).toString());
			cbbNhaXuatBan.setSelectedItem(tblSach.getValueAt(row, 5).toString());
			txtSoLuong.setText(tblSach.getValueAt(row, 6).toString());
			cbbGianHang.setSelectedItem(tblSach.getValueAt(row, 7).toString());
		}
	}
	void binCmbGH() {
		cbbGianHang.removeAllItems();
		lstgh = ghBLL.getAll("", "", "");
		for (GianHang i : lstgh) {
			cbbGianHang.addItem(i.getTenGianHang());
		}
		cbbGianHang.setSelectedIndex(-1);
	}

	void binCmbNXB() {
		cbbNhaXuatBan.removeAllItems();
		lstnxb = nxbBLL.getAll("", "", "");
		for (NhaXuatBan i : lstnxb) {
			cbbNhaXuatBan.addItem(i.getTenNXB());
		}
		cbbNhaXuatBan.setSelectedIndex(-1);
	}

	public void binData(String t, String w, String o) {
		lst = sachBLL.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã Sách");
		col.add("Tên sách");
		col.add("Tác Giả");
		col.add("Năm Xuất Bản");
		col.add("Giá bán");
		col.add("Nhà xuất bản");
		col.add("Số lượng");
		col.add("Loại sách");

		Vector data = new Vector();
		for (Sach i : lst) {
			Vector row = new Vector();
			row.add(i.getMaSach());
			row.add(i.getTieuDe());
			row.add(i.getTacGia());
			row.add(i.getNamXuatBan());
			row.add(i.getGiaBia());
			row.add(i.getMaNXB());
			row.add(i.getSoLuongTon());
			row.add(i.getMaGianHang());
			data.add(row);
		}
		DefaultTableModel dtm = new DefaultTableModel(data, col);
		tblSach.setModel(dtm);
	}
	private void btnThem() {
		Sach data = new Sach();
		data.setMaSach(txtMa.getText());
		if (txtMa.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã sách trống!");
			return;
		}
		data.setTieuDe(txtTen.getText());
		if (data.getTieuDe().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên sách trống!");
			return;
		}
		data.setTacGia(txtTacGia.getText());
		if (data.getTacGia().equals("")) {
			JOptionPane.showMessageDialog(this, "Tác giả trống!");
			return;
		}
		try {
			int x = Integer.parseInt(txtNam.getText());
			if (x < 1000 || x > LocalDate.now().getYear()) {
				JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ!");
				return;
			}
			data.setNamXuatBan(x);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ!");
			return;
		}
		try {
			int x = Integer.parseInt(txtGiaBan.getText());
			if (x < 1) {
				JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ!");

				txtGiaBan.requestFocus();
				txtGiaBan.selectAll();
				return;
			}
			data.setGiaBia(x);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ!");
			return;
		}
		if (cbbNhaXuatBan.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(this, "Chọn nhà xuất bản!");
			return;
		}
		data.setMaNXB(lstnxb.get(cbbNhaXuatBan.getSelectedIndex()).getMaNXB());
		try {
			if (Integer.parseInt(txtSoLuong.getText()) < 0) {
				JOptionPane.showMessageDialog(this, "Số lượng tồn không cho phép âm");
				return;
			}
			data.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số lượng tồn không hợp lệ");
			JOptionPane.showMessageDialog(this, e);
			txtSoLuong.requestFocus();
			txtSoLuong.selectAll();
			return;
		}
		if (cbbGianHang.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(this, "Chọn loại sách!");
			return;
		}
		data.setMaGianHang(lstgh.get(cbbGianHang.getSelectedIndex()).getMaGianHang());
		if (JOptionPane.showConfirmDialog(this, "Thêm mới bản ghi?", "Thông báo!!!",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (sachBLL.insertData(data) == true) {
				binData("", "", "");
				JOptionPane.showMessageDialog(null, "Thêm mới thành công !");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm mới thất bại !");
			}
		}
		clearText();
	}
	private void btnXoa() {
		int row = tblSach.getSelectedRow();
		if (row >= 0) {
			String id = tblSach.getValueAt(row, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				if (sachBLL.deleteData(id)) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần xóa trước");
		}
		clearText();
	}
	private void btnSua() {
		int row = tblSach.getSelectedRow();
		if (row >= 0) {
			String id = tblSach.getValueAt(row, 0).toString();
			Sach data = new Sach();
			data.setTieuDe(txtTen.getText());
			data.setTacGia(txtTacGia.getText());
			try {
				data.setNamXuatBan(Integer.parseInt(txtNam.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e);
				txtNam.requestFocus();
				txtNam.selectAll();
				return;
			}
			try {
				data.setGiaBia(Integer.parseInt(txtGiaBan.getText()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e);
				txtGiaBan.requestFocus();
				txtGiaBan.selectAll();
				return;
			}
			data.setMaNXB(lstnxb.get(cbbNhaXuatBan.getSelectedIndex()).getMaNXB());
			try {
				data.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
			} catch (Exception e) {
			}
			data.setMaGianHang(lstgh.get(cbbGianHang.getSelectedIndex()).getMaGianHang());
			data.setMaSach(id);
			if (JOptionPane.showConfirmDialog(this, "Sửa bản ghi này?", "Thông báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (sachBLL.updateData(data)) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "Sửa thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Sửa không thành công!");
				}
			}

		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần sửa trước");
		}
		clearText();
	}
	private void btnLamMoi() {
		binData("", "", "");
		clearText();
		btnSua.setEnabled(false);
		btnThemMoi.setEnabled(true);
		btnXoa.setEnabled(false);
		txtMa.setEditable(true);
	}
	private void btnXuat() {
		JFileChooser fc = new JFileChooser();
		int option = fc.showSaveDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			String filename = fc.getSelectedFile().getName();
			String path = fc.getSelectedFile().getParentFile().getPath();
			int len = filename.length();
			String ext = "";
			String file = "";

			if (len > 4) {
				ext = filename.substring(len - 4, len);
			}

			if (ext.equals(".xls")) {
				file = path + "\\" + filename;
			} else {
				file = path + "\\" + filename + ".xls";
			}
			try {
				toExcel(tblSach, new File(file));
				if (JOptionPane.showConfirmDialog(this, "Mở file?", "Xuất file thành công!!!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					File f = new File(file);
					try {
						Desktop.getDesktop().open(f);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException ex) {
				//Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
			}
		}
	}
	private void toExcel(JTable table, File file) throws IOException {
		String sheetName = "Sheet1";
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		TableModel model = table.getModel();
		// Get colum name
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < model.getColumnCount(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(model.getColumnName(i).toString());
		}
		// iterating r number of rows
		for (int r = 1; r <= model.getRowCount(); r++) {
			row = sheet.createRow(r);
			// iterating c number of columns
			for (int c = 0; c < model.getColumnCount(); c++) {
				HSSFCell cell = row.createCell(c);

				cell.setCellValue(model.getValueAt(r - 1, c).toString());
			}
		}

		FileOutputStream fileOut = new FileOutputStream(file);

		// write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		wb.close();
	}
	private void clearText() {
		txtMa.setText("");
		txtTen.setText("");
		txtNam.setText("");
		txtSoLuong.setText("");
		txtGiaBan.setText("");
		txtTacGia.setText("");
		cbbGianHang.setSelectedIndex(-1);
		cbbNhaXuatBan.setSelectedIndex(-1);
	}
	private void btnGH() {
		new pnTimLoaiSach().setVisible(true);
		//cbbGianHang.setSelectedItem();
	}

	private void btnNXB() {
		new pnTimNhaXuatBan().setVisible(true);
	}
}
