package bookstore.GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import bookstore.BLL.NhaXuatBanBLL;
import bookstore.Entity.NhaXuatBan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pnNhaXuatBan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTextField txtEmail;
	private JTable tblNXB;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnThem;
	private JButton btnLamMoi;
	private NhaXuatBanBLL nxbdll = new NhaXuatBanBLL();
	private ArrayList<NhaXuatBan> lst = new ArrayList<>();

	public pnNhaXuatBan() {
		initComponents();
		binData("", "", "");
	}

	/**
	 * Create the panel.
	 */
	public void initComponents() {
		setVisible(false);
		setSize(1530, 737);
		setLayout(null);

		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(null);
		jPanel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBounds(10, 10, 275, 717);
		add(jPanel1);

		JLabel tblMa = new JLabel();
		tblMa.setText("Mã Nhà Xuất Bản");
		tblMa.setHorizontalAlignment(SwingConstants.CENTER);
		tblMa.setForeground(new Color(51, 153, 153));
		tblMa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tblMa.setBounds(10, 20, 255, 27);
		jPanel1.add(tblMa);

		txtMa = new JTextField();
		txtMa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMa.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtMa.setBounds(32, 57, 202, 30);
		jPanel1.add(txtMa);

		JLabel tblTen = new JLabel();
		tblTen.setText("Tên Nhà Xuất Bản");
		tblTen.setHorizontalAlignment(SwingConstants.CENTER);
		tblTen.setForeground(new Color(51, 153, 153));
		tblTen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tblTen.setBounds(10, 97, 255, 27);
		jPanel1.add(tblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTen.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtTen.setBounds(32, 134, 202, 30);
		jPanel1.add(txtTen);

		JLabel tblDiaChi = new JLabel();
		tblDiaChi.setText("Địa Chỉ");
		tblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		tblDiaChi.setForeground(new Color(51, 153, 153));
		tblDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tblDiaChi.setBounds(10, 174, 255, 27);
		jPanel1.add(tblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDiaChi.setBounds(32, 213, 202, 30);
		jPanel1.add(txtDiaChi);

		JLabel tblDienThoai = new JLabel();
		tblDienThoai.setText("Điện Thoại");
		tblDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		tblDienThoai.setForeground(new Color(51, 153, 153));
		tblDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tblDienThoai.setBounds(10, 258, 255, 27);
		jPanel1.add(tblDienThoai);

		txtDienThoai = new JTextField();
		txtDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDienThoai.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDienThoai.setBounds(32, 291, 202, 30);
		jPanel1.add(txtDienThoai);

		JLabel tblEmail = new JLabel();
		tblEmail.setText("Email");
		tblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tblEmail.setForeground(new Color(51, 153, 153));
		tblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		tblEmail.setBounds(10, 338, 255, 27);
		jPanel1.add(tblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtEmail.setBounds(32, 371, 202, 30);
		jPanel1.add(txtEmail);

		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(Color.WHITE);
		jPanel2.setBounds(295, 90, 1225, 538);
		add(jPanel2);

		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
		gl_jPanel2.setHorizontalGroup(gl_jPanel2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_jPanel2.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
						.addContainerGap()));
		gl_jPanel2.setVerticalGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel2.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE).addContainerGap()));

		tblNXB = new JTable();
		tblNXB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClick();
			}
		});
		tblNXB.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		tblNXB.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 nh\u00E0 xu\u1EA5t b\u1EA3n", "T\u00EAn nh\u00E0 xu\u1EA5t b\u1EA3n",
						"\u0110\u1ECBa ch\u1EC9", "\u0110i\u1EC7n tho\u1EA1i", "Email" }));
		jScrollPane1.setViewportView(tblNXB);
		jPanel2.setLayout(gl_jPanel2);

		JPanel jPanel4 = new JPanel();
		jPanel4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel4.setBackground(Color.WHITE);
		jPanel4.setBounds(295, 657, 1225, 70);
		add(jPanel4);

		btnLamMoi = new JButton();
		btnLamMoi.setBounds(140, 15, 128, 40);
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLamMoi();
			}
		});
		btnLamMoi.setIcon(new ImageIcon(pnNhaXuatBan.class.getResource("/nhom05/bookstore/icon/icons8_reset_32.png")));
		btnLamMoi.setText("Làm Mới");
		btnLamMoi.setForeground(Color.WHITE);
		btnLamMoi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnLamMoi.setBorder(null);
		btnLamMoi.setBackground(new Color(51, 153, 153));

		btnThem = new JButton();
		btnThem.setBounds(341, 15, 128, 40);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem();
			}
		});
		btnThem.setIcon(new ImageIcon(pnNhaXuatBan.class.getResource("/nhom05/bookstore/icon/icons8_add_32.png")));
		btnThem.setText("Thêm");
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnThem.setBorder(null);
		btnThem.setBackground(new Color(51, 153, 153));

		btnSua = new JButton();
		btnSua.setBounds(550, 15, 128, 40);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSua();
			}
		});
		btnSua.setIcon(
				new ImageIcon(pnNhaXuatBan.class.getResource("/nhom05/bookstore/icon/icons8_edit_property_32.png")));
		btnSua.setText("Sửa");
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnSua.setEnabled(false);
		btnSua.setBorder(null);
		btnSua.setBackground(new Color(51, 153, 153));

		btnXoa = new JButton();
		btnXoa.setBounds(754, 15, 128, 40);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXoa();
			}
		});
		btnXoa.setIcon(new ImageIcon(pnNhaXuatBan.class.getResource("/nhom05/bookstore/icon/icons8_trash_32.png")));
		btnXoa.setText("Xóa");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXoa.setEnabled(false);
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(51, 153, 153));

		JButton btnXuat = new JButton();
		btnXuat.setBounds(948, 15, 128, 40);
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXuat();
			}
		});
		btnXuat.setIcon(new ImageIcon(pnNhaXuatBan.class.getResource("/nhom05/bookstore/icon/icons8_export_32.png")));
		btnXuat.setText("Xuất DS");
		btnXuat.setForeground(Color.WHITE);
		btnXuat.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnXuat.setBorder(null);
		btnXuat.setBackground(new Color(51, 153, 153));
		jPanel4.setLayout(null);
		jPanel4.add(btnLamMoi);
		jPanel4.add(btnThem);
		jPanel4.add(btnSua);
		jPanel4.add(btnXoa);
		jPanel4.add(btnXuat);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(295, 10, 1225, 70);
		add(panel);

		JLabel tblTitle = new JLabel("QUẢN LÝ NHÀ XUẤT BẢN");
		tblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tblTitle.setForeground(new Color(51, 153, 153));
		tblTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
		tblTitle.setBounds(10, 0, 1205, 70);
		panel.add(tblTitle);
	}

	private void tableClick() {
		if (tblNXB.getSelectedRow() == -1)
			return;
		btnThem.setEnabled(false);
		btnSua.setEnabled(true);
		btnXoa.setEnabled(true);
		int row = tblNXB.getSelectedRow();
		txtMa.setText(tblNXB.getValueAt(row, 0).toString());
		txtTen.setText(tblNXB.getValueAt(row, 1).toString());
		txtDiaChi.setText(tblNXB.getValueAt(row, 2).toString());
		txtDienThoai.setText(tblNXB.getValueAt(row, 3).toString());
		txtEmail.setText(tblNXB.getValueAt(row, 4).toString());
	}

	private void btnThem() {
		NhaXuatBan data = new NhaXuatBan();
		if (txtMa.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Mã Nhà Xuất Bản trống!");
			return;
		}
		data.setMaNXB(txtMa.getText());
		if (txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tên Nhà Xuất Bản trống!");
			return;
		}
		data.setTenNXB(txtTen.getText());
		if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Địa chỉ trống!");
			return;
		}
		data.setDiaChi(txtDiaChi.getText());
		if (txtDienThoai.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Điện thoại trống!");
			return;
		}
		data.setDienThoai(txtDienThoai.getText());
		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Email thoại trống!");
			return;
		}
		if (kiemTraSDT(txtDienThoai.getText()) == false) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải có 10 số và bắt đầu là 0");
		} else {
			data.setEmail(txtEmail.getText());
			if (JOptionPane.showConfirmDialog(this, "Bạn muốn thêm bản ghi?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (nxbdll.insertData(data)) {
					binData("", "", "");
					JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm mới thất bại!");
				}
				clearText();
			}
		}
	}

	private void btnSua() {
		int row = tblNXB.getSelectedRow();
		if (row >= 0) {
			String id = tblNXB.getValueAt(row, 0).toString();
			NhaXuatBan data = new NhaXuatBan();
			if (txtTen.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Tên Nhà Xuất Bản trống!");
				return;
			}
			data.setTenNXB(txtTen.getText());
			if (txtDienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Điện thoại trống!");
				return;
			}
			data.setDiaChi(txtDiaChi.getText());
			if (txtDienThoai.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Điện thoại trống!");
				return;
			}
			data.setDienThoai(txtDienThoai.getText());
			if (txtEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Email thoại trống!");
				return;
			}
			data.setEmail(txtEmail.getText());
			data.setMaNXB(id);
			if (JOptionPane.showConfirmDialog(this, "Bạn muốn thêm bản ghi?", "Thông báo!!!",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (nxbdll.updateData(data)) {
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

	private void btnXoa() {
		int row = tblNXB.getSelectedRow();
		if (row >= 0) {
			String id = tblNXB.getValueAt(row, 0).toString();
			int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa bản ghi?", "Cảnh báo",
					JOptionPane.YES_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {
				try {
					if (nxbdll.deleteData(id)) {
						binData("", "", "");
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
					} else {

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Xóa không thành công!\n" + e);
				}

			}
		} else {
			JOptionPane.showMessageDialog(this, "Chọn bạn ghi cần xóa trước");
		}
		clearText();
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
				toExcel(tblNXB, new File(file));
				JOptionPane.showMessageDialog(this, "Xuất file thành công!");
			} catch (IOException ex) {
				// Logger.getLogger(frmSach.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
			}
		}
	}

	public static void toExcel(JTable table, File file) throws IOException {
		String sheetName = "Sheet1";// name of sheet
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

	private void btnLamMoi() {
		binData("", "", "");
		clearText();
		btnSua.setEnabled(false);
		btnThem.setEnabled(true);
		btnXoa.setEnabled(false);
	}

	private void clearText() {
		txtDiaChi.setText("");
		txtMa.setText("");
		txtTen.setText("");
		txtDienThoai.setText("");
		txtEmail.setText("");
	}

	public void binData(String t, String w, String o) {
		lst = nxbdll.getAll(t, w, o);
		Vector col = new Vector();
		col.add("Mã NXB");
		col.add("Tên NXB");
		col.add("Địa chỉ");
		col.add("Điện thoại");
		col.add("Email");

		Vector data = new Vector();
		for (NhaXuatBan i : lst) {
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

	private boolean kiemTraSDT(String sdt) {
		String reg = "^(0){1}[1-9]{1}[0-9]{8}$";
		boolean kt = sdt.matches(reg);
		if (kt == false) {
			return false;
		} else {
			return true;
		}
	}
}
